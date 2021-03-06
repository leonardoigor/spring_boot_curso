package com.igor.igor.resources;

import com.igor.igor.domain.Pedido;
import com.igor.igor.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    @Autowired
    private PedidoService service;


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Optional<Pedido> category = service.findById(id);

        return ResponseEntity.ok().body(category);
    }
}