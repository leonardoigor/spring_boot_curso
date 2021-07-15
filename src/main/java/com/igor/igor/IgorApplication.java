package com.igor.igor;

import com.igor.igor.domain.Category;
import com.igor.igor.domain.City;
import com.igor.igor.domain.Product;
import com.igor.igor.domain.State;
import com.igor.igor.repositories.CategoriaRepository;
import com.igor.igor.repositories.CityRepository;
import com.igor.igor.repositories.ProductRepository;
import com.igor.igor.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class IgorApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;

    public static void main(String[] args) {
        SpringApplication.run(IgorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Teste");
        Category cat2 = new Category(null, "Teste2");

        Product p1 = new Product(null, "test", 2030);
        Product p2 = new Product(null, "test", 2001);
        Product p3 = new Product(null, "tested", 2020);

        State s1 = new State(null, "Minas");
        State s2 = new State(null, "Sao");

        City c = new City(null, "UberLandia", s1);
        City c2 = new City(null, "Sao Paulo", s2);


        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().addAll(Arrays.asList(p2));

        p1.getCategories().addAll(Arrays.asList(cat1, cat2));
        p2.getCategories().addAll(Arrays.asList(cat2));
        s1.getCities().addAll(Arrays.asList(c, c2));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
        stateRepository.saveAll(Arrays.asList(s1, s2));
        cityRepository.saveAll(Arrays.asList(c, c2));

    }
}