package br.edu.unipe.tcc.dev.web.service;

import br.edu.unipe.tcc.dev.web.domain.Cidade;
import br.edu.unipe.tcc.dev.web.domain.Country;
import br.edu.unipe.tcc.dev.web.repository.CidadeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;




    public Cidade salvar(Cidade cidade){

        if(cidade.getCidade().equalsIgnoreCase("brasil")){
            throw new RuntimeException("Pais não possui teste");

        }
        return (Cidade) cidadeRepository.save(cidade);
    }

    public List<Cidade> getCidadeByCidade(String cidade) { return cidadeRepository.findCidadeByCidade(cidade);
    }

    public List<Cidade> getCidade() { return cidadeRepository.findAll();
    }

    public Cidade getCidadeById(Long id) throws NotFoundException {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if (!cidade.isPresent()) {
            throw new NotFoundException("Quarentena não localizada");
        }
        return cidade.get();
    }
    public void deleteCidadeById(Long id) throws NotFoundException {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if (!cidade.isPresent()) {
            throw new NotFoundException("Quarentena não localizada");
        }
        cidadeRepository.delete(cidade.get());
    }

}
