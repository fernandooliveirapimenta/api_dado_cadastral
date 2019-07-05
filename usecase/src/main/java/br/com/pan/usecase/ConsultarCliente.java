package br.com.pan.usecase;

import br.com.pan.domain.Cliente;
import br.com.pan.usecase.port.ClienteRepositoryInterface;

public class ConsultarCliente {

    private final ClienteRepositoryInterface clienteRepositoryInterface;

    public ConsultarCliente(ClienteRepositoryInterface clienteRepositoryInterface) {
        this.clienteRepositoryInterface = clienteRepositoryInterface;
    }

    public Cliente consultarCliente(String cpf) {
        //todo validacao
       return clienteRepositoryInterface.consultarCliente(cpf);
    }
}
