(function () {
    'use strict';

    function string2json(str) {
        return eval("(" + str + ")");
    }

    function callSync(method, url, defaultValue) {
        var request = new XMLHttpRequest();
        request.open(method, url, false);
        request.send(null);

        if (request.status === 200) {
            return string2json(request.response);
        }
        return defaultValue;
    }

    var app = angular.module('example', ['nvd3', 'angularGrid']);

    app.constant('HttpConfig', {
        url: 'http://localhost:9880/'
    });

    app.controller('PieChartController', function ($scope, $http, HttpConfig) {
        console.log(HttpConfig.url + 'exampleData');
        $scope.options = {
            chart: {
                type: 'pieChart',
                height: 500,
                x: function (data) {
                    return data.key;
                },
                y: function (data) {
                    return data.value;
                },
                showLabels: true,
                labelsOutside: true,
                transitionDuration: 1500,
                labelThreshold: 0.01,
                legend: {
                    margin: {
                        top: 5,
                        right: 35,
                        bottom: 5,
                        left: 0
                    }
                }
            }
        };

        $http.get(HttpConfig.url + 'exampleData').success(function (data) {
            $scope.data = data;
        });
    });

    app.controller('RosterController', function ($scope, $http, HttpConfig) {

        function getHeaderName(params) {
            console.log(params.colDef.headerName);

            var model = callSync('GET', HttpConfig.url + 'rosterModel/' + params.colDef.headerName, params.colDef);

            return model.headerName;
        }

        var columnDefs = [
            {headerName: "0", field: "make", headerValueGetter: getHeaderName},
            {headerName: "1", field: "model", headerValueGetter: getHeaderName},
            {headerName: "2", field: "price", headerValueGetter: getHeaderName}
        ];

        $scope.gridOptions = {
            columnDefs: columnDefs,
            rowData: null,
            dontUseScrolls: true // because so little data, no need to use scrollbars.

        };
        /* $http.get(HttpConfig.url + "rosterModel").then(function (model) {
         $scope.gridOptions.columnDefs = model.data;
         $scope.gridOptions.api.refreshHeader();
         }
         );*/
        $http.get(HttpConfig.url + "rosterDatas").then(function (rows) {
            $scope.gridOptions.rowData = rows.data;
            $scope.gridOptions.api.onNewRows();
        });


    });

})();