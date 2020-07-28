package br.edu.unipe.tcc.dev.web.service;
import br.edu.unipe.tcc.dev.web.service.CityService;
import br.edu.unipe.tcc.dev.web.domain.City;
import br.edu.unipe.tcc.dev.web.domain.City;
import br.edu.unipe.tcc.dev.web.domain.Country;
import br.edu.unipe.tcc.dev.web.repository.CityRepository;
import br.edu.unipe.tcc.dev.web.repository.CountryRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    public City salvar(City city){

        if(city.getNome().equalsIgnoreCase("brasil")){
            throw new RuntimeException("Pais não possui teste");

        }
        return  cityRepository.save(city);
    }

    public List<City> getCityByNome(String nome) { return cityRepository.findCityByNome(nome); }

    public List<City> getCity() { return cityRepository.findAll(); }

    public City getCityById(Long id) throws NotFoundException {
        Optional<City> city = cityRepository.findById(id);
        if (!city.isPresent()) {
            throw new NotFoundException("Quarentena não localizada");
        }
        return city.get();
    }
    public void deleteCityById(Long id) throws NotFoundException {
        Optional<City> city = cityRepository.findById(id);
        if (!city.isPresent()) {
            throw new NotFoundException("Quarentena não localizada");
        }
        cityRepository.delete(city.get());
    }
}
