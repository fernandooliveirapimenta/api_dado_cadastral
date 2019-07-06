package br.com.pan.domain;

import java.io.Serializable;

public class Municipio implements Serializable {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
