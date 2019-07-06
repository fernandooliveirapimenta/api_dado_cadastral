package br.com.pan.http.controller;

import br.com.pan.usecase.ConsultarCep;
import br.com.pan.usecase.ConsultarEstados;
import br.com.pan.usecase.ConsultarMunicipios;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GeografiaControllerTest {

    @Mock
    private ConsultarCep consultarCep;
    @Mock
    private ConsultarEstados consultarEstados;
    @Mock
    private ConsultarMunicipios consultarMunicipios;
    @InjectMocks
    private GeografiaController geografiaController;

    @Test
    public void consultarCep() {
        geografiaController.consultarCep("06823250");
        Mockito.verify(consultarCep, Mockito.times(1)).consultarCep("06823250");
    }

    @Test
    public void estados() {
        geografiaController.estados();
        Mockito.verify(consultarEstados, Mockito.times(1)).estados();
    }

    @Test
    public void municipios() {
        geografiaController.municipios(null);
        Mockito.verify(consultarMunicipios, Mockito.times(1)).municipios(null);
    }
}