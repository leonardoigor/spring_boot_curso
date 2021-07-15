package com.igor.igor.resources;

import java.util.Optional;

import com.igor.igor.domain.Category;

import com.igor.igor.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriesResource {
    @Autowired
    private CategoryService service;


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Optional<Category> category = service.findById(id);

        return ResponseEntity.ok().body(category);
    }
}