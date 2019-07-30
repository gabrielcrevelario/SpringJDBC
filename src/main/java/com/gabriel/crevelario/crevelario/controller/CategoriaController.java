package com.gabriel.crevelario.crevelario.controller;

import com.gabriel.crevelario.crevelario.models.Categoria;
import org.springframework.beans.factory.annotation.Value;
import com.gabriel.crevelario.crevelario.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.MailSender;
import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

    @Autowired
    private MailSender mailSender;
    @Value ("${spring.mail.properties.mail.smtp.socketFactory.port }")
    private static int PORT;
    @Value("${spring.mail.properties.mail.smtp.socketFactory.class}" )
    private static String SOCKET_FACTORY;
    @Value("${spring.mail.properties.mail.smtp.socketFactory.fallback}")
    private static boolean FALLBACK;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private static boolean ENABLE;
    @Value("${spring.mail.properties.mail.smtp.ssl.enable}")
    private static boolean SSL;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Categoria> listar() {
       return categoriaRepository.findAll();
    };


    @GetMapping("/id/{id}")
    public Categoria getById(@PathVariable long id) {

        Categoria categoria = categoriaRepository.getById(id);
        return categoria;
    }



}
