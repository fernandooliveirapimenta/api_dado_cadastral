package br.com.pan.usecase;

import br.com.pan.domain.Cliente;
import br.com.pan.usecase.port.ClienteRepositoryInterface;
import static br.com.pan.usecase.util.StringUtil.*;

public class ConsultarCliente {

    private final ClienteRepositoryInterface clienteRepositoryInterface;

    public ConsultarCliente(ClienteRepositoryInterface clienteRepositoryInterface) {
        this.clienteRepositoryInterface = clienteRepositoryInterface;
    }

    public Cliente consultarCliente(String cpf) {
        if(cpf == null || cpf.isEmpty()) {
          return null;
        }
       return clienteRepositoryInterface.consultarCliente(normalize(cpf));
    }
}
