package br.edu.unipe.tcc.dev.web.repository;
import javax.persistence.Entity;
import br.edu.unipe.tcc.dev.web.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
   List<Produto> findProdutoByMarca(String marca);
}
