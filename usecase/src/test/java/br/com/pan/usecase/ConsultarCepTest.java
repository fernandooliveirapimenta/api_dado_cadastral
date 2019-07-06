package br.com.pan.usecase;

import br.com.pan.usecase.exception.RegraDeNegocioExeption;
import br.com.pan.usecase.port.ApiGeografiaInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConsultarCepTest {

    @Mock
    private ApiGeografiaInterface apiGeografiaInterface;

    @InjectMocks
    private ConsultarCep consultarCep;

    @Test(expected = RegraDeNegocioExeption.class)
    public void consultarCepComCepInvalido() {
        consultarCep.consultarCep("0682325000");
    }

    @Test
    public void consultarCep() {
        consultarCep.consultarCep("06823250");
        Mockito.verify(apiGeografiaInterface, Mockito.times(1)).consultarCep(Mockito.anyString());
    }

    @Test
    public void validarCep() {
        Assert.assertFalse(consultarCep.isCepValido("sdkgsgs"));
        Assert.assertTrue(consultarCep.isCepValido("06823250"));
        Assert.assertTrue(consultarCep.isCepValido("06823-250"));
        Assert.assertFalse(consultarCep.isCepValido("06823-2500"));
    }
}