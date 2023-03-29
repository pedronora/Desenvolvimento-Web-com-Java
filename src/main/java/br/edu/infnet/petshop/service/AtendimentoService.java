package br.edu.infnet.petshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Atendimento;
import br.edu.infnet.petshop.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
    
    @Autowired
    AtendimentoRepository atendimentoRepository;

    public Atendimento create(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento getById(Integer id) {
        return atendimentoRepository.findById(id).orElse(null);
    }

    public Atendimento update(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public void delete(Integer id) {
        atendimentoRepository.deleteById(id);
    }

    public Collection<Atendimento> getAll() {
        return (Collection<Atendimento>) atendimentoRepository.findAll();
    }

    public Collection<Atendimento> getAllByUsuario(Integer id) {
        return (Collection<Atendimento>) atendimentoRepository.findAllByUsuario(id,  Sort.by(Direction.ASC, "pet.nome"));
    }

    public long count() {
        return atendimentoRepository.count();
    }
}
