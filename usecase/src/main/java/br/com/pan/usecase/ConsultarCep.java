package br.com.pan.usecase;

import br.com.pan.domain.Endereco;
import br.com.pan.usecase.exception.RegraDeNegocioExeption;
import br.com.pan.usecase.port.ApiGeografiaInterface;
import static br.com.pan.usecase.util.StringUtil.normalize;

public class ConsultarCep {

    private final ApiGeografiaInterface apiGeografiaInterface;

    public ConsultarCep(ApiGeografiaInterface apiGeografiaInterface) {
        this.apiGeografiaInterface = apiGeografiaInterface;
    }

    public Endereco consultarCep(String cep) {
        if(cep == null || validar(normalize(cep)) ) {
            throw new RegraDeNegocioExeption(String.format("Cep inválido: %s", cep));
        }
        return  apiGeografiaInterface.consultarCep(normalize(cep));
    }

    private boolean validar(String cep) {
        return cep.length() != 8;
    }
}
