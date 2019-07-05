package br.com.pan.usecase;

import br.com.pan.domain.Estado;
import br.com.pan.usecase.port.ApiGeografiaInterface;

import java.util.TreeSet;

public class ConsultarEstados {

    private final ApiGeografiaInterface apiGeografiaInterface;

    public ConsultarEstados(ApiGeografiaInterface apiGeografiaInterface) {
        this.apiGeografiaInterface = apiGeografiaInterface;
    }

    public TreeSet<Estado> estados() {
        return  apiGeografiaInterface.estados();
        // todo ordenar sp e rj
    }
}
