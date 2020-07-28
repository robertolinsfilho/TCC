package br.edu.unipe.tcc.dev.web.service;

import java.util.List;
import java.util.Optional;

import br.edu.unipe.tcc.dev.web.domain.Disciplina;
import br.edu.unipe.tcc.dev.web.repository.DisciplinaRepository;
import br.edu.unipe.tcc.dev.web.service.dto.DisciplinaBuscaAnoDTO;
import br.edu.unipe.tcc.dev.web.service.dto.DisciplinaNomeProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	
	public List<Disciplina> getDisciplinaByNomeAndProfessor(String nome, String professor) {
		
		/*
		 * Set<Disciplina> lista = new
		 * HashSet<Disciplina>(disciplinaRepository.findDisciplinaByNomeAndProfessor(
		 * nome, professor));
		 */
				
		return disciplinaRepository.findDisciplinaByNomeAndProfessor(nome, professor);				
		
	}
	
	public List<Disciplina> getDisciplinaEntreAnos(DisciplinaBuscaAnoDTO dto) {
		 
		List<Disciplina> listaDisciplinas = 
				disciplinaRepository.findByAnoDisciplinaBetween(dto.getAnoInicial(), dto.getAnoFinal());				
		return listaDisciplinas;
		
	}
	
	public List<Disciplina> getDisciplinaEntreAnos(int anoInicial, int anoFinal)  {
		 
		List<Disciplina> listaDisciplinas = 
				disciplinaRepository.findByAnoDisciplinaBetween(anoInicial, anoFinal);			
		return listaDisciplinas;
		
	}
	
	
	
	public DisciplinaNomeProfessorDTO getDisciplinaPorId(Long id) throws NotFoundException {
		 Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		 if(!disciplina.isEmpty())
			 throw new NotFoundException("Disciplina não localizada");
		
		return new DisciplinaNomeProfessorDTO(disciplina.get());
		
	}
	
	public Disciplina salvar(Disciplina disciplina) {		
		return disciplinaRepository.save(disciplina);
	}
	
	public Disciplina consultaPorId(Long id) {
		return disciplinaRepository.findById(id).get();				
	}
	
	public void deletePorId(Long id) {
		disciplinaRepository.deleteById(id);
	}
	
	public List<Disciplina> listar(){
		return disciplinaRepository.findAll();
	}
	
	public Disciplina update(Disciplina disciplina) {
		if(disciplina!=null) {
			return disciplinaRepository.save(disciplina);
		}
		throw new RuntimeException("ID precisar ser informado");
	}
	

}
