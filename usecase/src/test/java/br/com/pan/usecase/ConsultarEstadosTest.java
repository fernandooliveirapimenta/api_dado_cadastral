package br.com.pan.usecase;

import br.com.pan.domain.Estado;
import br.com.pan.usecase.port.ApiGeografiaInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsultarEstadosTest {
    @Mock
    private ApiGeografiaInterface apiGeografiaInterface;

    @InjectMocks
    private ConsultarEstados consultarEstados;

    @Test
    public void estadosComRetornoNull() {

        Mockito.when(apiGeografiaInterface.estados()).thenReturn(null);

        assertNull(consultarEstados.estados());
    }


    @Test
    public void estados() {

        Estado rj = new Estado("11", "RJ", "Rio de Janeiro");
        Estado sp = new Estado("12", "SP", "São Paulo");
        Estado ro = new Estado("13", "RO", "Rondonia");
        Estado ac = new Estado("13", "AC", "Acre");
        Estado am = new Estado("13", "AM", "Amazonia");

        List<Estado> estados = new ArrayList<>();
        estados.add(ro);
        estados.add(ac);
        estados.add(am);
        estados.add(sp);
        estados.add(rj);


        Mockito.when(apiGeografiaInterface.estados()).thenReturn(estados);

        final List<Estado> estadosRetorno = consultarEstados.estados();
        assertNotNull(estadosRetorno);
        assertEquals(5, estadosRetorno.size());
        assertEquals("SP", estadosRetorno.get(0).getSigla());
        assertEquals("RJ", estadosRetorno.get(1).getSigla());
        assertEquals("RO", estadosRetorno.get(4).getSigla());
    }
}