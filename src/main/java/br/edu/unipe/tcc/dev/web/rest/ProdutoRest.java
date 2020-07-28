package br.edu.unipe.tcc.dev.web.rest;

import br.edu.unipe.tcc.dev.web.domain.Produto;
import br.edu.unipe.tcc.dev.web.domain.State;
import br.edu.unipe.tcc.dev.web.service.ProdutoService;
import br.edu.unipe.tcc.dev.web.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.Entity;
import javax.validation.Valid;
import java.util.List;
@RestController

@RequestMapping("/api")
public class ProdutoRest {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/produto/{estado}")
    public ResponseEntity<List<Produto>> getProduto(@PathVariable String marca) {
        return ResponseEntity.ok(produtoService.getProdutoByMarca(marca));
    }

    @PostMapping("/produto")
    public ResponseEntity<Produto> salvar(@RequestBody @Valid Produto produto) {
        Produto produtoSalva = produtoService.salvar(produto);
        return ResponseEntity.ok().body(produtoSalva);
    }

    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> getProduto() {
        return ResponseEntity.ok(produtoService.getProduto());
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(produtoService.getProdutoById(id));

        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }

    }




    @DeleteMapping("/produto/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            produtoService.deleteProdutoById(id);
        } catch (Exception e) {
            // FIXME INCLUIR LOGS
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }


}

