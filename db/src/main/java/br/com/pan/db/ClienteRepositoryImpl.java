package br.com.pan.db;

import br.com.pan.domain.Cliente;
import br.com.pan.usecase.port.ClienteRepositoryInterface;

public class ClienteRepositoryImpl implements ClienteRepositoryInterface {

    @Override
    public Cliente consultarCliente(String cpf) {
        return null;
    }

    @Override
    public void alterarEndereco(Cliente cliente) {

    }
}
