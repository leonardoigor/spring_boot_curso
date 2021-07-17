package com.igor.igor.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.igor.igor.domain.enums.TypeClient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpf_cnpj;
    private Integer typeClient;

    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<Address>();
    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    @JsonManagedReference
    private Set<String> fones = new HashSet<String>();

    @JsonBackReference
    @OneToMany(mappedBy = "client")
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Client() {
    }

    public Client(Integer id, String name, String email, String cpf_cnpj, TypeClient typeClient) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf_cnpj = cpf_cnpj;
        this.typeClient = typeClient.getCod();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setTypeClient(Integer typeClient) {
        this.typeClient = typeClient;
    }

    public Set<String> getFones() {
        return fones;
    }

    public void setFones(Set<String> fones) {
        this.fones = fones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public TypeClient getTypeClient() {
        return TypeClient.toEnum(this.typeClient);
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}