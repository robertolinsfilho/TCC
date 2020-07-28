package br.edu.unipe.tcc.dev.web.repository;

import java.util.List;

import br.edu.unipe.tcc.dev.web.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

	//select * from Disciplina where professor='Fujioka'
	List<Disciplina> findDisciplinaByProfessor(String professor);
	
	//select * from Disciplina where nome='java' and professor='Fujioka' 
	List<Disciplina> findDisciplinaByNomeAndProfessor(String nome, String professor);
	
	List<Disciplina> findDisciplinaByAnoDisciplinaBetween(int anoInicial, int anoFinal);
	
	List<Disciplina> findByAnoDisciplinaBetween(int anoInicial, int anoFinal);
	
}
