package br.edu.unipe.tcc.dev.web.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cidades")
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CIDADE")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO")
    private State state;


    @NotBlank
    @Column(name="NOM_CIDADE",nullable = false, length = 200)
    private String nome;

    @NotBlank
    @Column(name="COD_CIDADE_IBGE",nullable = false)
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
        City city = (City) o;
        return id == city.id &&
                codigoEstado == city.codigoEstado &&
                Objects.equals(state, city.state) &&
                Objects.equals(nome, city.nome) &&
                Objects.equals(sigla, city.sigla) &&
                Objects.equals(dataCriacao, city.dataCriacao) &&
                Objects.equals(dataAlteracao, city.dataAlteracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, nome, codigoEstado, sigla, dataCriacao, dataAlteracao);
    }
}
