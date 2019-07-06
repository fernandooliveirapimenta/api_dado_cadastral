package br.com.pan.usecase.port;

import br.com.pan.domain.Cliente;

public interface ClienteRepositoryInterface {

    /**
     * Cenário 1 - Consultar Cliente
     * Dado que o cliente deseja consultar o seu cadastro.
     * Criar endpoint para consulta dos dados cadastrais utlizando CPF como parâmetro.
     */
    Cliente consultarCliente(String cpf);

    /**
     * Cenário 5 – Alterar endereço
     * Dado que o cliente deseja alterar o seu endereço.
     * Criar endpoint para alterar o endereço do cliente.
     */
    void alterarEndereco(Cliente cliente);
}
