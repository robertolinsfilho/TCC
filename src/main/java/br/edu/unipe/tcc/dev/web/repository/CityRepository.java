package br.edu.unipe.tcc.dev.web.repository;

import br.edu.unipe.tcc.dev.web.domain.City;
import br.edu.unipe.tcc.dev.web.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    public List<City> findCityByNome(String nome);


}
