package br.com.toponeweb.projetolojavirtual.controller;

import br.com.toponeweb.projetolojavirtual.model.Acesso;
import br.com.toponeweb.projetolojavirtual.services.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @ResponseBody /*Retorno da API*/
    @PostMapping(value = "/salvarAcesso") /*Mapeamento da url*/
    public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso){
            Acesso acessoSalvo = acessoService.salvar(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);

    }


}
