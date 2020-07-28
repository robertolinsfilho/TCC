package br.edu.unipe.tcc.dev.web.repository;

import br.edu.unipe.tcc.dev.web.domain.Country;
import br.edu.unipe.tcc.dev.web.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    public List<Country> findCountryByNome(String nome);

    public List<Country> findCountryBySigla(String sigla);

    public List<Country> findCountryByCodigoOnu(String codigoOnu);

    public List<Country> findCountryById(Long id);



}
