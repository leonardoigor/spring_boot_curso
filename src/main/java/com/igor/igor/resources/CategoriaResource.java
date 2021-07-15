package com.igor.igor.resources;

import java.util.ArrayList;
import java.util.List;

import com.igor.igor.domain.Category;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> listar() {

        Category cat1 = new Category(1, "Informatica");
        Category cat2 = new Category(2, "Escritorio");

        List<Category> lista = new ArrayList<Category>();
        lista.add(cat1);
        lista.add(cat2);
        return lista;
    }
}