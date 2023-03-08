package br.edu.infnet.petshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Vacina;
import br.edu.infnet.petshop.repository.VacinaRepository;

@Service
public class VacinaService {

    @Autowired
    VacinaRepository vacinaRepository;

    public Boolean create(Vacina vacina) {
        return vacinaRepository.create(vacina);
    }

    public Vacina getById(Integer id) {
        return vacinaRepository.getById(id);
    }

    public Boolean update(Vacina vacina) {
        return vacinaRepository.update(vacina);
    }

    public Vacina delete(Integer id) {
        return vacinaRepository.delete(id);
    }

    public Collection<Vacina> getAll() {
        return vacinaRepository.getAll();
    }
}
