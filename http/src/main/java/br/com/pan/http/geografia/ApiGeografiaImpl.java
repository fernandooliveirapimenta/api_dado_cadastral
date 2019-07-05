package br.com.pan.http.geografia;

import br.com.pan.domain.Endereco;
import br.com.pan.domain.Estado;
import br.com.pan.domain.Municipio;
import br.com.pan.usecase.port.ApiGeografiaInterface;

import java.util.List;
import java.util.TreeSet;

public class ApiGeografiaImpl implements ApiGeografiaInterface {

    @Override
    public Endereco consultarCep(String cep) {
        return null;
    }

    @Override
    public TreeSet<Estado> estados() {
        return null;
    }

    @Override
    public List<Municipio> municipios(String estado) {
        return null;
    }
}
