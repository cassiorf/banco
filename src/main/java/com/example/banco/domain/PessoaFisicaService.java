package com.example.banco.domain;

import com.example.banco.domain.exception.FormatoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository rep;

    public PessoaFisica insert(PessoaFisica pessoaFisica) throws FormatoInvalidoException {
        if (!pessoaFisica.isEmailValid())
            throw new FormatoInvalidoException("Email invalido: " + pessoaFisica.getEmail());

        if (!pessoaFisica.isCpfValid())
            throw new FormatoInvalidoException("CPF invalido: " + pessoaFisica.getCpf());

        return rep.save(pessoaFisica);
    }
}



