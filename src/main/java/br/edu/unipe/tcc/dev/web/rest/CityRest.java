package br.edu.unipe.tcc.dev.web.rest;

import br.edu.unipe.tcc.dev.web.domain.City;
import br.edu.unipe.tcc.dev.web.domain.Country;
import br.edu.unipe.tcc.dev.web.service.CityService;
import br.edu.unipe.tcc.dev.web.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CityRest {
    @Autowired
    private CityService cityService;

    @GetMapping("/city/{nome}")
    public ResponseEntity<List<City>> getCity(@PathVariable String nome){
        return ResponseEntity.ok(cityService.getCityByNome(nome));
    }
    @PostMapping("/city")
    public ResponseEntity<City> salvar(@RequestBody @Valid City city) {
        City citySalva = cityService.salvar(city);
        return ResponseEntity.ok().body(citySalva);
    }

    @GetMapping("/city")
    public ResponseEntity<List<City>> getCity() {

        return ResponseEntity.ok(cityService.getCity());
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(cityService.getCityById(id));

        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/city/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            cityService.deleteCityById(id);
        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }


}
