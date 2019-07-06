package br.com.pan.usecase;

import br.com.pan.usecase.exception.RegraDeNegocioExeption;
import br.com.pan.usecase.port.ApiGeografiaInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConsultarMunicipiosTest {

    @Mock
    private ApiGeografiaInterface apiGeografiaInterface;

    @InjectMocks
    private ConsultarMunicipios consultarMunicipios;

    @Test(expected = RegraDeNegocioExeption.class)
    public void municipiosInvalido() {
        consultarMunicipios.municipios(null);
    }

    @Test(expected = RegraDeNegocioExeption.class)
    public void municipiosVazio() {
        consultarMunicipios.municipios("");
    }


    @Test
    public void municipios() {
        consultarMunicipios.municipios("11");
        Mockito.verify(apiGeografiaInterface, Mockito.times(1)).municipios("11");
    }
}