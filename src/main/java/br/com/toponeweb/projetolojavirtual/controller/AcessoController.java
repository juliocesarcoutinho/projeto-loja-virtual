package br.com.toponeweb.projetolojavirtual.controller;

import br.com.toponeweb.projetolojavirtual.model.Acesso;
import br.com.toponeweb.projetolojavirtual.services.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @PostMapping("/salvarAcesso")
    public Acesso salvarAcesso(Acesso acesso){

        return acessoService.salvar(acesso);

    }


}
