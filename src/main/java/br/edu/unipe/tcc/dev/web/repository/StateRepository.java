package br.edu.unipe.tcc.dev.web.repository;

import br.edu.unipe.tcc.dev.web.domain.Quarentena;
import br.edu.unipe.tcc.dev.web.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository <State, Long> {

    public List<State> findStateByCountry(String country);


}
