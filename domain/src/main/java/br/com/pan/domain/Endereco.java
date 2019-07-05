package br.com.pan.domain;

import java.io.Serializable;

public class Endereco implements Serializable {

    private String id;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }


    public static final class EnderecoBuilder {
        private Endereco endereco;

        private EnderecoBuilder() {
            endereco = new Endereco();
        }

        public static EnderecoBuilder anEndereco() {
            return new EnderecoBuilder();
        }

        public EnderecoBuilder withId(String id) {
            endereco.setId(id);
            return this;
        }

        public EnderecoBuilder withLogradouro(String logradouro) {
            endereco.setLogradouro(logradouro);
            return this;
        }

        public EnderecoBuilder withBairro(String bairro) {
            endereco.setBairro(bairro);
            return this;
        }

        public EnderecoBuilder withLocalidade(String localidade) {
            endereco.setLocalidade(localidade);
            return this;
        }

        public EnderecoBuilder withUf(String uf) {
            endereco.setUf(uf);
            return this;
        }

        public Endereco build() {
            return endereco;
        }
    }
}
