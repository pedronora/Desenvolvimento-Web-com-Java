package br.edu.infnet.petshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Banho;
import br.edu.infnet.petshop.repository.BanhoRepository;

@Service
public class BanhoService {

    @Autowired
    BanhoRepository banhoRepository;

    public Boolean create(Banho banho) {
        return banhoRepository.create(banho);
    }

    public Banho getById(Integer id) {
        return banhoRepository.getById(id);
    }

    public Boolean update(Banho banho) {
        return banhoRepository.update(banho);
    }

    public Banho delete(Integer id) {
        return banhoRepository.delete(id);
    }

    public Collection<Banho> getAll() {
        return banhoRepository.getAll();
    }
}
