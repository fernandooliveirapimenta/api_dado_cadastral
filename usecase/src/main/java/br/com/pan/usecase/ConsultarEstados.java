package br.com.pan.usecase;

import br.com.pan.domain.Estado;
import br.com.pan.usecase.port.ApiGeografiaInterface;

import java.util.List;
import java.util.TreeSet;

public class ConsultarEstados {

    private final ApiGeografiaInterface apiGeografiaInterface;

    public ConsultarEstados(ApiGeografiaInterface apiGeografiaInterface) {
        this.apiGeografiaInterface = apiGeografiaInterface;
    }

    public TreeSet<Estado> estados() {

        List<Estado> estados = apiGeografiaInterface.estados();

        //Ordenando com prioridade
        return new TreeSet<>(estados);

    }
}
