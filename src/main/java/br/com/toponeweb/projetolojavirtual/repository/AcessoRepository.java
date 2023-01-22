package br.com.toponeweb.projetolojavirtual.repository;

import br.com.toponeweb.projetolojavirtual.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long> {

    @Query("select a from Acesso a WHERE upper(trim(a.descricao)) like %?1%")
    List<Acesso> buscarAcessoDesc(String desc);

}
