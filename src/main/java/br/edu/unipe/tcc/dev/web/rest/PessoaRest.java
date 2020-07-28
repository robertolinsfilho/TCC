package br.edu.unipe.tcc.dev.web.rest;

import br.edu.unipe.tcc.dev.web.domain.Pessoa;
import br.edu.unipe.tcc.dev.web.domain.State;
import br.edu.unipe.tcc.dev.web.service.PessoaService;
import br.edu.unipe.tcc.dev.web.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api")
public class PessoaRest {
    @Autowired
    private PessoaService pessoaService;


    @GetMapping("/pessoa/{estado}")
    public ResponseEntity<List<Pessoa>> getPessoa(@PathVariable String nome) {
        return ResponseEntity.ok(pessoaService.getPessoaByNome(nome));
    }

    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa> salvar(@RequestBody @Valid Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        return ResponseEntity.ok().body(pessoaSalva);
    }

    @GetMapping("/pessoa")
    public ResponseEntity<List<Pessoa>> getPessoa() {
        return ResponseEntity.ok(pessoaService.getPessoa());
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(pessoaService.getPessoaById(id));

        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }

    }




    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            pessoaService.deletePessoaById(id);
        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }


}


