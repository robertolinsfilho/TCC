package br.edu.unipe.tcc.dev.web.service;

import br.edu.unipe.tcc.dev.web.domain.Quarentena;
import br.edu.unipe.tcc.dev.web.domain.State;
import br.edu.unipe.tcc.dev.web.repository.StateRepository;
import br.edu.unipe.tcc.dev.web.service.dto.QuarentenaNomeCidadeDTO;
import javassist.NotFoundException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {


    @Autowired
    private  StateRepository stateRepository;

    public State salvar(State state){

        if(state.getCountry().equals("brasil")){
            throw new RuntimeException("Pais não possui teste");

        }
        return  stateRepository.save(state);
    }
    public List<State> getStateByCountry(String country) { return stateRepository.findStateByCountry("country");
    }

        public List<State> getState() {
        return stateRepository.findAll();
    }

    public State getStateById(Long id) throws NotFoundException {
        Optional<State> state = stateRepository.findById(id);
        if (!state.isPresent()) {
            throw new NotFoundException("state não localizada");
        }
        return state.get();
    }




    public void deleteStateById(Long id) throws NotFoundException {
        Optional<State> state = stateRepository.findById(id);
        if (!state.isPresent()) {
            throw new NotFoundException("Quarentena não localizada");
        }
        stateRepository.delete(state.get());
    }


}
