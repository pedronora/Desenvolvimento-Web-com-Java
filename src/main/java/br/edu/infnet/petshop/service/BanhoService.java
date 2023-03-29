package br.edu.infnet.petshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Banho;
import br.edu.infnet.petshop.repository.BanhoRepository;

@Service
public class BanhoService {

    @Autowired
    BanhoRepository banhoRepository;

    public Banho create(Banho banho) {
        return banhoRepository.save(banho);
    }

    public Banho getById(Integer id) {
        return banhoRepository.findById(id).orElse(null);
    }

    public Banho update(Banho banho) {
        return banhoRepository.save(banho);
    }

    public void delete(Integer id) {
        banhoRepository.deleteById(id);
    }

    public Collection<Banho> getAll() {
        return (Collection<Banho>) banhoRepository.findAll();
    }

    public Collection<Banho> getAllByUsuario(Integer id) {
        return (Collection<Banho>) banhoRepository.findAllByUsuario(id, Sort.by(Direction.DESC, "nome"));
    }

    public long count() {
        return banhoRepository.count();
    }
}
