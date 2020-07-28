package br.edu.unipe.tcc.dev.web.repository;

import br.edu.unipe.tcc.dev.web.domain.Cidade;
import br.edu.unipe.tcc.dev.web.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findCidadeByCidade(String cidade);
}
