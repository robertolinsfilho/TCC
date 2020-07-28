package br.edu.unipe.tcc.dev.web.service;
import javax.persistence.Entity;
import br.edu.unipe.tcc.dev.web.domain.Produto;
import br.edu.unipe.tcc.dev.web.domain.State;
import br.edu.unipe.tcc.dev.web.repository.ProdutoRepository;
import br.edu.unipe.tcc.dev.web.repository.StateRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){

        if(produto.getMarca().equals("brasil")){
            throw new RuntimeException("Pais não possui teste");

        }
        return  produtoRepository.save(produto);
    }
    public List<Produto> getProdutoByMarca(String marca) { return produtoRepository.findProdutoByMarca("marca");
    }

    public List<Produto> getProduto() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Long id) throws NotFoundException {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (!produto.isPresent()) {
            throw new NotFoundException("state não localizada");
        }
        return produto.get();
    }




    public void deleteProdutoById(Long id) throws NotFoundException {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (!produto.isPresent()) {
            throw new NotFoundException("Quarentena não localizada");
        }
        produtoRepository.delete(produto.get());
    }


}

