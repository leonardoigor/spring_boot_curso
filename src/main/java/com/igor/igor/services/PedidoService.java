package com.igor.igor.services;

import com.igor.igor.domain.Pedido;
import com.igor.igor.repositories.PedidoRepository;
import com.igor.igor.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public List<Pedido> findAll() {
        return null;
    }


    public List<Pedido> findAllById(Integer iterable) {
        return null;
    }


    public void deleteById(Integer integer) {

    }


    public void delete(Pedido category) {

    }


    public Optional<Pedido> findById(Integer id) {

        Optional<Pedido> obj = repo.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Object não entcontrado! Id:" + id + " tipe: " + Pedido.class.getName());
        }
        return obj;

    }


    public <S extends Pedido> S save(S s) {
        return null;
    }


    public <S extends Pedido> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }


    public boolean existsById(Integer integer) {
        return false;
    }


    public <S extends Pedido> boolean exists(Example<S> example) {
        return false;
    }
}