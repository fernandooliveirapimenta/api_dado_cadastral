package br.com.pan.http.controller;

import br.com.pan.domain.Endereco;
import br.com.pan.usecase.AlterarEndereco;
import br.com.pan.usecase.ConsultarCliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ClienteControllerTest {

    @Mock
    private ConsultarCliente consultarCliente;

    @Mock
    private AlterarEndereco alterarEndereco;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    public void consultarCliente() {
        clienteController.consultarCliente("43743772809");
        Mockito.verify(consultarCliente, Mockito.times(1)).consultarCliente("43743772809");
    }

    @Test
    public void alterarEndereco() {
        final String cpf = "43743772809";
        final Endereco endereco = new Endereco();
        clienteController.alterarEndereco(cpf, endereco);
        Mockito.verify(alterarEndereco, Mockito.times(1)).alterarEndereco(cpf, endereco);
    }
}