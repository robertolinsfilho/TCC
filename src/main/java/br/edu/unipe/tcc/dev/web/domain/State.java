package br.edu.unipe.tcc.dev.web.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "estados")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ESTADO")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS")
    private Country country;


    @NotBlank
    @Column(name="NOM_ESTADO",nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Column(name="COD_ESTADO",nullable = false)
    private long codigoEstado;


    @NotBlank
    @Column(name="SIGLA",nullable = false, length = 50)
    private String sigla;

    @NotBlank
    @CreationTimestamp
    @Column(name="DAT_CRIACAO",nullable = false, updatable = false)
    private Timestamp dataCriacao;

    @Column(name="DAT_ALTERACAO")
    private Timestamp dataAlteracao;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(long codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Timestamp getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Timestamp dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return id == state.id &&
                codigoEstado == state.codigoEstado &&
                Objects.equals(country, state.country) &&
                Objects.equals(nome, state.nome) &&
                Objects.equals(sigla, state.sigla) &&
                Objects.equals(dataCriacao, state.dataCriacao) &&
                Objects.equals(dataAlteracao, state.dataAlteracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, nome, codigoEstado, sigla, dataCriacao, dataAlteracao);
    }
}
