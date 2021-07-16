package com.igor.igor.services;

import com.igor.igor.domain.Client;
import com.igor.igor.repositories.ClientRepository;
import com.igor.igor.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public List<Client> findAll() {
        return null;
    }


    public List<Client> findAllById(Integer iterable) {
        return null;
    }


    public void deleteById(Integer integer) {

    }


    public void delete(Client category) {

    }


    public Optional<Client> findById(Integer id) {

        Optional<Client> obj = repo.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Object não entcontrado! Id:" + id + " tipe: " + Client.class.getName());
        }
        return obj;

    }


    public <S extends Client> S save(S s) {
        return null;
    }


    public <S extends Client> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }


    public boolean existsById(Integer integer) {
        return false;
    }


    public <S extends Client> boolean exists(Example<S> example) {
        return false;
    }
}