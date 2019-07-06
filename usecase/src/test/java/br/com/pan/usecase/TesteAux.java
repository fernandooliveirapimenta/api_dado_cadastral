package br.com.pan.usecase;

import br.com.pan.domain.Cliente;
import br.com.pan.domain.Endereco;

public class TesteAux {

    public static Cliente cliente(String id, String cpf, String nome, String bairro, String num, String cep) {

        return Cliente.ClienteBuilder.aCliente()
                .withCpf(cpf)
                .withId(id)
                .withNome(nome)
                .withEndereco(endereco(id, bairro, num, cep)).build();
    }

    public static Endereco endereco(String id, String bairro, String num, String cep) {
        return Endereco.EnderecoBuilder.anEndereco()
                .withId(id)
                .withBairro(bairro)
                .withNumero(num)
                .withCep(cep)
                .withLocalidade("São Paulo")
                .withLogradouro("Panorama")
                .withUf("SP")
                .build();
    }
}
