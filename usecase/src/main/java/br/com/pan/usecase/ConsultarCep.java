package br.com.pan.usecase;

import br.com.pan.domain.Endereco;
import br.com.pan.usecase.port.ApiGeografiaInterface;

public class ConsultarCep {

    private final ApiGeografiaInterface apiGeografiaInterface;

    public ConsultarCep(ApiGeografiaInterface apiGeografiaInterface) {
        this.apiGeografiaInterface = apiGeografiaInterface;
    }

    public Endereco consultarCep(String cep) {
        //todo validar cep
        return  apiGeografiaInterface.consultarCep(cep);
    }
}
