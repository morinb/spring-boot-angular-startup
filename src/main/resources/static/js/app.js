(function () {
    'use strict';

    var app = angular.module('example', ['nvd3']);

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

         $http.get(HttpConfig.url + 'exampleData').success(function(data) {
             $scope.data = data;
        });
    })
})();