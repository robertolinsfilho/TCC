package br.edu.unipe.tcc.dev.web.repository;

import br.edu.unipe.tcc.dev.web.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    public List <State> findStateByCountry(String Country);

    public List <State> findStateByNomeAndCodigoEstado(String nome, Long codigoEstado);

    public List <State> findStateBySiglaAndCodigoEstado(String sigla, Long codigoEstado);
}
