package br.com.toponeweb.projetolojavirtual.controller;

import br.com.toponeweb.projetolojavirtual.model.Acesso;
import br.com.toponeweb.projetolojavirtual.repository.AcessoRepository;
import br.com.toponeweb.projetolojavirtual.services.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class AcessoController {

    @Autowired
    private AcessoService acessoService;
    @Autowired
    private AcessoRepository acessoRepository;

    @ResponseBody /*Retorno da API*/
    @PostMapping(value = "/salvarAcesso") /*Mapeamento da url*/
    public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso){
            Acesso acessoSalvo = acessoService.salvar(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);

    }
    @ResponseBody /*Retorno da API*/
    @PostMapping(value = "/deleteAcesso") /*Mapeamento da url*/
    public ResponseEntity<Acesso> deleteAcesso(@RequestBody Acesso acesso) {
        acessoRepository.deleteById(acesso.getId());
        return new ResponseEntity("Acesso Removido", HttpStatus.OK);

    }

}
