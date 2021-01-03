package com.example.banco.api;

import com.example.banco.domain.PessoaFisica;
import com.example.banco.domain.PessoaFisicaService;
import com.example.banco.domain.exception.FormatoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService service;

    @PostMapping
    public ResponseEntity<PessoaFisica> post(@RequestBody PessoaFisica pessoaFisica) throws FormatoInvalidoException {
            PessoaFisica pf = service.insert(pessoaFisica);
            URI location = getUri(pf.getId());
            return ResponseEntity.created(location).build();
    }

    private URI getUri(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }
}


