package br.com.toponeweb.projetolojavirtual.services;

import br.com.toponeweb.projetolojavirtual.model.Acesso;
import br.com.toponeweb.projetolojavirtual.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acessoRepository;

    public Acesso salvar(Acesso acesso){

        return acessoRepository.save(acesso);

    }

}
