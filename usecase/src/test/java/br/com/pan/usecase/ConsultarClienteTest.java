package br.com.pan.usecase;

import br.com.pan.usecase.port.ClienteRepositoryInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConsultarClienteTest {

    @Mock
    private ClienteRepositoryInterface clienteRepositoryInterface;

    @InjectMocks
    private ConsultarCliente consultarCliente;

    @Test
    public void consultarClienteCpfInvalido() {

        Assert.assertNull(consultarCliente.consultarCliente(null));
        Assert.assertNull(consultarCliente.consultarCliente(""));

    }


    @Test
    public void consultarCliente() {
        consultarCliente.consultarCliente("43743772809");
        Mockito.verify(clienteRepositoryInterface, Mockito.times(1)).consultarCliente("43743772809");

    }
}