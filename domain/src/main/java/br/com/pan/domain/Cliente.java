package br.com.pan.domain;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String id;
    private String cpf;
    private String nome;
    private Endereco endereco;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public static final class ClienteBuilder {
        private Cliente cliente;

        private ClienteBuilder() {
            cliente = new Cliente();
        }

        public static ClienteBuilder aCliente() {
            return new ClienteBuilder();
        }

        public ClienteBuilder withId(String id) {
            cliente.setId(id);
            return this;
        }

        public ClienteBuilder withCpf(String cpf) {
            cliente.setCpf(cpf);
            return this;
        }

        public ClienteBuilder withNome(String nome) {
            cliente.setNome(nome);
            return this;
        }

        public ClienteBuilder withEndereco(Endereco endereco) {
            cliente.setEndereco(endereco);
            return this;
        }

        public Cliente build() {
            return cliente;
        }
    }
}
