package com.igor.igor.services;

import com.igor.igor.domain.Category;
import com.igor.igor.repositories.CategoriaRepository;
import com.igor.igor.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoriaRepository repo;

    public List<Category> findAll() {
        return null;
    }


    public List<Category> findAllById(Integer iterable) {
        return null;
    }


    public void deleteById(Integer integer) {

    }


    public void delete(Category category) {

    }


    public Optional<Category> findById(Integer id) {

        Optional<Category> obj = repo.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Object não entcontrado! Id:" + id + " tipe: " + Category.class.getName());
        }
        return obj;

    }


    public <S extends Category> S save(S s) {
        return null;
    }


    public <S extends Category> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }


    public boolean existsById(Integer integer) {
        return false;
    }


    public <S extends Category> boolean exists(Example<S> example) {
        return false;
    }
}