package br.edu.unipe.tcc.dev.web.repository;

import br.edu.unipe.tcc.dev.web.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findPessoaByNome(String nome);
}
