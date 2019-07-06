package br.com.pan.usecase;

import br.com.pan.domain.Cliente;
import br.com.pan.domain.Endereco;
import br.com.pan.usecase.exception.RegraDeNegocioExeption;
import br.com.pan.usecase.port.ClienteRepositoryInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AlterarEnderecoTest {

    @Mock
    private ClienteRepositoryInterface clienteRepositoryInterface;

    @InjectMocks
    private AlterarEndereco alterarEndereco;

    @Test
    public void alterarEndereco() {

        final Cliente cliente = Mockito.spy(TesteAux.cliente(
                "1",
                "43743772809",
                "Fernando",
                "Jd Santo Eduardo",
                "203",
                "06823250"));

        Mockito.when(clienteRepositoryInterface.consultarCliente(cliente.getCpf())).thenReturn(cliente);

        final Endereco endereco = TesteAux.endereco("1", "Jd Santo Eduardo", "2008", "06823250");

        alterarEndereco.alterarEndereco(cliente.getCpf(), endereco);

        Mockito.verify(cliente, Mockito.times(1)).setEndereco(endereco);
        Assert.assertEquals("2008", cliente.getEndereco().getNumero());
    }

    @Test(expected = RegraDeNegocioExeption.class)
    public void alterarEnderecoCpfNull() {
        alterarEndereco.alterarEndereco(null, new Endereco());

    }

    @Test(expected = RegraDeNegocioExeption.class)
    public void alterarEnderecoCpfEnderecoNull() {
        alterarEndereco.alterarEndereco("43743772809", null);

    }
    @Test(expected = RegraDeNegocioExeption.class)
    public void alterarEnderecoComCamposNull() {

        alterarEndereco.alterarEndereco("43743772809", new Endereco());

    }
}