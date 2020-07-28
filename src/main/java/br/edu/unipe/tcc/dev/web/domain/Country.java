package br.edu.unipe.tcc.dev.web.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pais")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PAIS")
    private long id;

    @NotBlank
    @Column(name="NOM_PAIS",nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Column(name="SIGLA",nullable = false, length = 50)
    private String sigla;

    @NotBlank
    @Column(name="COD_ONU",nullable = false, length = 50)
    private String codigoOnu;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCodigoOnu() {
        return codigoOnu;
    }

    public void setCodigoOnu(String codigoOnu) {
        this.codigoOnu = codigoOnu;
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
        Country country = (Country) o;
        return id == country.id &&
                Objects.equals(nome, country.nome) &&
                Objects.equals(sigla, country.sigla) &&
                Objects.equals(codigoOnu, country.codigoOnu) &&
                Objects.equals(dataCriacao, country.dataCriacao) &&
                Objects.equals(dataAlteracao, country.dataAlteracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sigla, codigoOnu, dataCriacao, dataAlteracao);
    }
}
