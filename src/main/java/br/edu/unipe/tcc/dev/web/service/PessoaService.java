package br.edu.unipe.tcc.dev.web.service;

import br.edu.unipe.tcc.dev.web.domain.Pessoa;
import br.edu.unipe.tcc.dev.web.domain.State;
import br.edu.unipe.tcc.dev.web.repository.PessoaRepository;
import br.edu.unipe.tcc.dev.web.repository.StateRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa){

        if(pessoa.getNome().equals("brasil")){
            throw new RuntimeException("Pais não possui teste");

        }
        return  pessoaRepository.save(pessoa);
    }
    public List<Pessoa> getPessoaByNome(String nome) { return pessoaRepository.findPessoaByNome("nome");
    }

    public List<Pessoa> getPessoa() { return pessoaRepository.findAll();
    }

    public Pessoa getPessoaById(Long id) throws NotFoundException {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (!pessoa.isPresent()) {
            throw new NotFoundException("state não localizada");
        }
        return pessoa.get();
    }




    public void deletePessoaById(Long id) throws NotFoundException {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (!pessoa.isPresent()) {
            throw new NotFoundException("Quarentena não localizada");
        }
        pessoaRepository.delete(pessoa.get());
    }


}


