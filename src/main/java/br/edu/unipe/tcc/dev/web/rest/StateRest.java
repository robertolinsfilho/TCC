package br.edu.unipe.tcc.dev.web.rest;

import br.edu.unipe.tcc.dev.web.domain.Quarentena;
import br.edu.unipe.tcc.dev.web.domain.State;
import br.edu.unipe.tcc.dev.web.service.QuarentenaService;
import br.edu.unipe.tcc.dev.web.service.StateService;
import br.edu.unipe.tcc.dev.web.service.dto.QuarentenaNomeCidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api")
public class StateRest {
    @Autowired
    private StateService stateService;


    @GetMapping("/state/{estado}")
    public ResponseEntity<List<State>> getState(@PathVariable String country) {
        return ResponseEntity.ok(stateService.getStateByCountry(country));
    }

    @PostMapping("/state")
    public ResponseEntity<State> salvar(@RequestBody @Valid State state) {
        State stateSalva = stateService.salvar(state);
        return ResponseEntity.ok().body(stateSalva);
    }

    @GetMapping("/state")
    public ResponseEntity<List<State>> getState() {
        return ResponseEntity.ok(stateService.getState());
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<State> getStateById(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(stateService.getStateById(id));

        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }

    }




    @DeleteMapping("/state/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            stateService.deleteStateById(id);
        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }


}
