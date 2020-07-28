package br.edu.unipe.tcc.dev.web.rest;

import br.edu.unipe.tcc.dev.web.domain.Country;
import br.edu.unipe.tcc.dev.web.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryRest {
    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{nome}")
    public ResponseEntity<List<Country>> getCountry(@PathVariable String nome){
        return ResponseEntity.ok(countryService.getCountryByNome(nome));
    }
    @PostMapping("/country")
    public ResponseEntity<Country> salvar(@RequestBody @Valid Country country) {
        Country countrySalva = countryService.salvar(country);
        return ResponseEntity.ok().body(countrySalva);
    }

    @GetMapping("/country")
    public ResponseEntity<List<Country>> getCountry() {

        return ResponseEntity.ok(countryService.getCountry());
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(countryService.getCountryById(id));

        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/country/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            countryService.deleteCountryById(id);
        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }


}
