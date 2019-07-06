package br.com.pan.domain;

import java.io.Serializable;

public class Endereco implements Serializable {

    private String id;
    private String logradouro; //rua
    private String bairro;
    private String localidade; //municipio
    private String uf;
    private String cep;
    private String numero;

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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isValido() {
        return logradouro != null && numero != null && uf != null && cep != null;
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

        public EnderecoBuilder withCep(String cep) {
            endereco.setCep(cep);
            return this;
        }

        public EnderecoBuilder withNumero(String numero) {
            endereco.setNumero(numero);
            return this;
        }

        public Endereco build() {
            return endereco;
        }
    }
}
