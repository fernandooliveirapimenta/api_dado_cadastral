package br.com.pan.usecase;

import br.com.pan.domain.Cliente;
import br.com.pan.domain.Endereco;
import br.com.pan.usecase.exception.RegraDeNegocioExeption;
import br.com.pan.usecase.port.ClienteRepositoryInterface;

public class AlterarEndereco {

    private final ClienteRepositoryInterface clienteRepositoryInterface;

    public AlterarEndereco(ClienteRepositoryInterface clienteRepositoryInterface) {
        this.clienteRepositoryInterface = clienteRepositoryInterface;
    }

    public void alterarEndereco(String cpf, Endereco endereco){
        if(cpf == null) {
            throw new RegraDeNegocioExeption("Cpf obrigatório");
        } else if(endereco == null) {
            throw new RegraDeNegocioExeption("Endereco obrigatório");
        }
        Cliente cliente = clienteRepositoryInterface.consultarCliente(cpf);
        cliente.setEndereco(endereco);
        clienteRepositoryInterface.alterarEndereco(cliente);
    }
}
