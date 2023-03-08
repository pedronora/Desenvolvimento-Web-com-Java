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

    public Boolean create(Consulta consulta) {
        return consultaRepository.create(consulta);
    }

    public Consulta getById(Integer id) {
        return consultaRepository.getById(id);
    }

    public Boolean update(Consulta consulta) {
        return consultaRepository.update(consulta);
    }

    public Consulta delete(Integer id) {
        return consultaRepository.delete(id);
    }

    public Collection<Consulta> getAll() {
        return consultaRepository.getAll();
    }
}
