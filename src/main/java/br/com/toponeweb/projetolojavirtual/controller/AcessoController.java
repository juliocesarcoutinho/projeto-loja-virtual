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
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

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
    @ResponseBody
    @DeleteMapping(value = "/deleteAcessoPorId/{id}") /*Mapeamento da url*/
    public ResponseEntity<Acesso> deleteAcessoId(@PathVariable("id") Long id) {
        acessoRepository.deleteById(id);
        return new ResponseEntity("Acesso Removido", HttpStatus.OK);

    }
    @ResponseBody
    @GetMapping(value = "/listaPorId/{id}") /*Mapeamento da url*/
    public ResponseEntity<Acesso> listarAcessoId(@PathVariable("id") Long id) {
      Acesso acesso = acessoRepository.findById(id).get();
        return new ResponseEntity<Acesso>(acesso, HttpStatus.OK);

    }@ResponseBody
    @GetMapping(value = "/listaPorDesc/{desc}") /*Mapeamento da url*/
    public ResponseEntity<List<Acesso>> listarAcessoDesc(@PathVariable("desc") String desc) {
      List<Acesso> acesso = acessoRepository.buscarAcessoDesc(desc);
        return new ResponseEntity<List<Acesso>>(acesso, HttpStatus.OK);

    }

}
