package br.edu.infnet.petshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Consulta;
import br.edu.infnet.petshop.repository.ConsultaRepository;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public Consulta create(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta getById(Integer id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public Consulta update(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void delete(Integer id) {
        consultaRepository.deleteById(id);
    }

    public Collection<Consulta> getAll() {
        return (Collection<Consulta>) consultaRepository.findAll();
    }
    public Collection<Consulta> getAllByUsuario(Integer id) {
        return (Collection<Consulta>) consultaRepository.findAllByUsuario(id);
    }
}
