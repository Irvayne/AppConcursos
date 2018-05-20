package br.com.wolfes.appconcursos.modelo;

import java.io.Serializable;

public class Estado implements Serializable{

    private String sigla;
    private String nome;

    public Estado(String sigla, String nome) {
        super();
        this.sigla = sigla;
        this.nome = nome;
    }
    public Estado() {
        super();
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + " - "+sigla.toUpperCase();
    }
}