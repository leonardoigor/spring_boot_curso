package com.igor.igor;

import com.igor.igor.domain.*;
import com.igor.igor.domain.enums.PaymentState;
import com.igor.igor.domain.enums.TypeClient;
import com.igor.igor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.text.SimpleDateFormat;
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
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PaymentRepository paymentRepository;

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

        Client cli1 = new Client(null, "Maria", "@naub", "32564164564", TypeClient.PESOALJURIDICA);
        cli1.getFones().addAll(Arrays.asList("444646611", "54454784684"));

        Address adresse = new Address(null, "Rua", "300", "4864s", "!a5a45", "5545445", cli1, c);

        cli1.getAddresses().addAll(Arrays.asList(adresse));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));
        stateRepository.saveAll(Arrays.asList(s1, s2));
        cityRepository.saveAll(Arrays.asList(c, c2));
        clientRepository.saveAll(Arrays.asList(cli1));
        adressRepository.saveAll(Arrays.asList(adresse));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, adresse);

        Payment pagto1 = new CartaoPayment(null, PaymentState.QUITADO, ped1, 6);
        ped1.setPayment(pagto1);

        cli1.getPedidos().addAll(Arrays.asList(ped1));

        pedidoRepository.saveAll(Arrays.asList(ped1));
        paymentRepository.saveAll(Arrays.asList(pagto1));

    }
}