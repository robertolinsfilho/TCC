package br.edu.unipe.tcc.dev.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private String professor;
	
	private int anoDisciplina;
	
	private String codigoInstituicao;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getAnoDisciplina() {
		return anoDisciplina;
	}
	public void setAnoDisciplina(int anoDisciplina) {
		this.anoDisciplina = anoDisciplina;
	}
	public String getCodigoInstituicao() {
		return codigoInstituicao;
	}
	public void setCodigoInstituicao(String codigoInstituicao) {
		this.codigoInstituicao = codigoInstituicao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Disciplina() {
		super();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Disciplina that = (Disciplina) o;
		return anoDisciplina == that.anoDisciplina &&
				Objects.equals(id, that.id) &&
				Objects.equals(nome, that.nome) &&
				Objects.equals(descricao, that.descricao) &&
				Objects.equals(professor, that.professor) &&
				Objects.equals(codigoInstituicao, that.codigoInstituicao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, descricao, professor, anoDisciplina, codigoInstituicao);
	}
}
