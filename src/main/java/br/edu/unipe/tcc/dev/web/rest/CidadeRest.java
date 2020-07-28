package br.edu.unipe.tcc.dev.web.rest;

import br.edu.unipe.tcc.dev.web.domain.Cidade;
import br.edu.unipe.tcc.dev.web.domain.Country;
import br.edu.unipe.tcc.dev.web.service.CidadeService;
import br.edu.unipe.tcc.dev.web.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CidadeRest {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Cidade>> getCidade(@PathVariable String cidade){
        return ResponseEntity.ok(cidadeService.getCidadeByCidade(cidade));
    }
    @PostMapping("/cidade")
    public ResponseEntity<Cidade> salvar(@RequestBody @Valid Cidade cidade) {
        Cidade cidadeSalva = cidadeService.salvar(cidade);
        return ResponseEntity.ok().body(cidadeSalva);
    }

    @GetMapping("/cidade")
    public ResponseEntity<List<Cidade>> getCidade() {

        return ResponseEntity.ok(cidadeService.getCidade());
    }

    @GetMapping("/cidade/{id}")
    public ResponseEntity<Cidade> getCidadeById(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(cidadeService.getCidadeById(id));

        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/cidade/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            cidadeService.deleteCidadeById(id);
        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}
