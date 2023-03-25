package br.edu.infnet.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.clients.IEnderecoClient;
import br.edu.infnet.petshop.model.domain.Endereco;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoClient enderecoClient;
    
    public Endereco buscaCEP(String cep) {
        return enderecoClient.buscaCEP(cep);
    }
}
