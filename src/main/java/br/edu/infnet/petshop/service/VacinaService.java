package br.edu.infnet.petshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.petshop.model.domain.Vacina;
import br.edu.infnet.petshop.repository.VacinaRepository;

@Service
public class VacinaService {

    @Autowired
    VacinaRepository vacinaRepository;

    public Vacina create(Vacina vacina) {
        return vacinaRepository.save(vacina);
    }

    public Vacina getById(Integer id) {
        return vacinaRepository.findById(id).orElse(null);
    }

    public Vacina update(Vacina vacina) {
        return vacinaRepository.save(vacina);
    }

    public void delete(Integer id) {
        vacinaRepository.deleteById(id);
    }

    public Collection<Vacina> getAll() {
        return (Collection<Vacina>) vacinaRepository.findAll();
    }

    public Collection<Vacina> getAllByUsuario(Integer id) {
        return vacinaRepository.findAllByUsuario(id, Sort.by(Direction.DESC, "nome"));
    }

    public long count() {
        return vacinaRepository.count();
    }
}
