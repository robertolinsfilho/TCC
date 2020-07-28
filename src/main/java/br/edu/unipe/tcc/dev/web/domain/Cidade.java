package br.edu.unipe.tcc.dev.web.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CIDADE")
    private long id;

    public String getCod_cidade() {
        return cod_cidade;
    }

    public void setCod_cidade(String cod_cidade) {
        this.cod_cidade = cod_cidade;
    }

    @JoinColumn(name = "COD_CIDADE_IBGE")
    private String  cod_cidade;


    @NotBlank
    @Column(name="NOM_CIDADE",nullable = false, length = 100)
    private String cidade;

    @NotBlank
    @Column(name="ID_ESTADO",nullable = false)
    private long id_estado;


    @NotBlank
    @Column(name="COD",nullable = false, length = 50)
    private String cod;

    @NotBlank
    @Column(name="ID_PAIS",nullable = false, length = 50)
    private String pais;

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

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getId_estado() {
        return id_estado;
    }

    public void setId_estado(long id_estado) {
        this.id_estado = id_estado;
    }



    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
        Cidade cidade = (Cidade) o;
        return id == cidade.id &&
                Objects.equals(cidade, cidade.cidade) &&
                Objects.equals(cod_cidade, cidade.cod_cidade) &&
                Objects.equals(cod, cidade.cod) &&
                Objects.equals(dataCriacao, cidade.dataCriacao) &&
                Objects.equals(dataAlteracao, cidade.dataAlteracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cidade, cod_cidade, cod, dataCriacao, dataAlteracao);
    }


}
