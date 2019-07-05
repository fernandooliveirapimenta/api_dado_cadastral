package br.com.pan.usecase;

import br.com.pan.domain.Municipio;
import br.com.pan.usecase.port.ApiGeografiaInterface;

import java.util.List;

public class ConsultarMunicipios {

    private final ApiGeografiaInterface apiGeografiaInterface;

    public ConsultarMunicipios(ApiGeografiaInterface apiGeografiaInterface) {
        this.apiGeografiaInterface = apiGeografiaInterface;
    }

    public List<Municipio> municipios(String estado) {
        // todo validacao
        return  apiGeografiaInterface.municipios(estado);
    }
}
