package com.github.morinb;

import com.github.morinb.dtos.ExampleData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    private EntityManagerFactory emf;

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Creating sample datas ...");
        final EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ExampleData ed1 = new ExampleData("One"  ,1 << 4);
        ExampleData ed2 = new ExampleData("Two"  ,1 << 5);
        ExampleData ed3 = new ExampleData("Three",1 << 2);
        ExampleData ed4 = new ExampleData("Four" ,1 << 7);
        ExampleData ed5 = new ExampleData("Five" ,1 << 3);
        ExampleData ed6 = new ExampleData("Six"  ,1 << 6);
        ExampleData ed7 = new ExampleData("Seven",1 << 1);

        em.persist(ed1);
        em.persist(ed2);
        em.persist(ed3);
        em.persist(ed4);
        em.persist(ed5);
        em.persist(ed6);
        em.persist(ed7);

        em.getTransaction().commit();
        LOG.info("Sample datas created.");
    }
}
