package com.github.morinb.controllers;

import com.github.morinb.dtos.ExampleData;
import com.github.morinb.roster.ColumnModel;
import com.github.morinb.roster.RowData;
import com.github.morinb.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExampleController {
    private List<ColumnModel> model = new ArrayList<>();

    ExampleController() {
        model.add(new ColumnModel() {
                      @Override
                      public String getHeaderName() {
                          return "Make";
                      }

                      @Override
                      public String getField() {
                          return "make";
                      }
                  }
        );

        model.add(new ColumnModel() {
                      @Override
                      public String getHeaderName() {
                          return "Model";
                      }

                      @Override
                      public String getField() {
                          return "model";
                      }
                  }
        );

        model.add(new ColumnModel() {
                      @Override
                      public String getHeaderName() {
                          return "Price";
                      }

                      @Override
                      public String getField() {
                          return "price";
                      }
                  }
        );
    }


    @Autowired
    private ExampleService service;

    @RequestMapping("/exampleData")
    public List<ExampleData> example() {
        return service.getExampleDatas();
    }

    @RequestMapping("/rosterModel/{columnId}")
    public ColumnModel getRosterModel(@PathVariable int columnId) {

        return model.get(columnId);
    }

    @RequestMapping("/rosterDatas")
    public List<RowData> getRosterDatas() {
        List<RowData> rowDatas = new ArrayList<>();

        rowDatas.add(getRow("Toyota", "Celica", 35000));
        rowDatas.add(getRow("Ford", "Mondeo", 32000));
        rowDatas.add(getRow("Porsche", "Boxter", 72000));

        return rowDatas;
    }

    private RowData getRow(String make, String model, int price) {
        RowData row = new RowData();

        row.put("make", make);
        row.put("model", model);
        row.put("price", price);

        return row;
    }
}
