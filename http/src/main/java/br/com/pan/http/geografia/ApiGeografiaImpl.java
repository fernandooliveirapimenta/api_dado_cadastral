package br.com.pan.http.geografia;

import br.com.pan.domain.Endereco;
import br.com.pan.domain.Estado;
import br.com.pan.domain.Municipio;
import br.com.pan.usecase.port.ApiGeografiaInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.TreeSet;

@Component(value = "apiGeografia")
public class ApiGeografiaImpl implements ApiGeografiaInterface {

    private final RestTemplate viacep;

    public ApiGeografiaImpl(@Qualifier(value = "viacep") RestTemplate viacep) {
        this.viacep = viacep;
    }

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
