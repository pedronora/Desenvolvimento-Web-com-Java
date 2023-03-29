package br.edu.infnet.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.petshop.service.AtendimentoService;
import br.edu.infnet.petshop.service.BanhoService;
import br.edu.infnet.petshop.service.ConsultaService;
import br.edu.infnet.petshop.service.PetService;
import br.edu.infnet.petshop.service.ServicoService;
import br.edu.infnet.petshop.service.UsuarioService;
import br.edu.infnet.petshop.service.VacinaService;

@Controller
public class EstatisticaController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    PetService petService;
    
    @Autowired
    AtendimentoService atendimentoService;
    
    @Autowired
    ServicoService servicoService;

    @Autowired
    BanhoService banhoService;

    @Autowired
    ConsultaService consultaService;

    @Autowired
    VacinaService vacinaService;

    @GetMapping(value = "/estatisticas")
    public String estatisticas(Model model) {
        model.addAttribute("tUsuarios", usuarioService.count());
        model.addAttribute("tPets", petService.count());
        model.addAttribute("tAtendimentos", atendimentoService.count());
        model.addAttribute("tServicos", servicoService.count());
        model.addAttribute("tBanhos", banhoService.count());
        model.addAttribute("tConsultas", consultaService.count());
        model.addAttribute("tVacinas", vacinaService.count());
        return "estatisticas";    
    }
}
