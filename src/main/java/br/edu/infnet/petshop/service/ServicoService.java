package br.edu.infnet.petshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Servico;
import br.edu.infnet.petshop.repository.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    ServicoRepository servicoRepository;

    public Servico create(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico getById(Integer id) {
        return servicoRepository.findById(id).orElse(null);
    }

    public Servico update(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void delete(Integer id) {
        servicoRepository.deleteById(id);
    }

    public Collection<Servico> getAll() {
        return (Collection<Servico>) servicoRepository.findAll();
    }

    public Collection<Servico> getAllByUsuario(Integer id) {
        return (Collection<Servico>) servicoRepository.findAllByUsuario(id, Sort.by(Direction.DESC, "nome"));
    }

    public long count() {
        return servicoRepository.count();
    }
}
