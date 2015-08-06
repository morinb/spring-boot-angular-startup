package com.github.morinb.services;

import com.github.morinb.dtos.ExampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Baptiste on 06/08/2015.
 */
@Component
public class ExampleService {

    @Autowired
    EntityManager em;

    @SuppressWarnings("unchecked")
    public List<ExampleData> getExampleDatas() {
        Query findAll = em.createNamedQuery("ExampleData.findAll");

        List<ExampleData> resultList = (List<ExampleData>) findAll.getResultList();
        return resultList;
    }
}
