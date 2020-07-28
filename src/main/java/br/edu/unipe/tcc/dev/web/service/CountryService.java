package br.edu.unipe.tcc.dev.web.service;

import br.edu.unipe.tcc.dev.web.domain.Country;
import br.edu.unipe.tcc.dev.web.repository.CountryRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;


    public Country salvar(Country country){

        if(country.getNome().equalsIgnoreCase("brasil")){
            throw new RuntimeException("Pais não possui teste");

        }
        return (Country) countryRepository.save(country);
    }

    public List<Country> getCountryByNome(String nome) { return countryRepository.findCountryByNome(nome);
    }

    public List<Country> getCountry() { return countryRepository.findAll();
    }

    public Country getCountryById(Long id) throws NotFoundException {
        Optional<Country> country = countryRepository.findById(id);
        if (!country.isPresent()) {
            throw new NotFoundException("Quarentena não localizada");
        }
        return country.get();
    }
    public void deleteCountryById(Long id) throws NotFoundException {
        Optional<Country> country = countryRepository.findById(id);
        if (!country.isPresent()) {
            throw new NotFoundException("Quarentena não localizada");
        }
        countryRepository.delete(country.get());
    }

}

