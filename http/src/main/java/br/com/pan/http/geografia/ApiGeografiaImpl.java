package br.com.pan.http.geografia;

import br.com.pan.domain.Endereco;
import br.com.pan.domain.Estado;
import br.com.pan.domain.Municipio;
import br.com.pan.usecase.port.ApiGeografiaInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Component(value = "apiGeografia")
public class ApiGeografiaImpl implements ApiGeografiaInterface {

    private final RestTemplate viacep;
    private final RestTemplate ibge;

    public ApiGeografiaImpl(@Qualifier(value = "viacep") RestTemplate viacep,
                            @Qualifier(value = "ibge") RestTemplate ibge) {
        this.viacep = viacep;
        this.ibge = ibge;
    }

    @Override
    public Endereco consultarCep(String cep) {
        ResponseEntity<Endereco> response = viacep.exchange(String.format("/%s/json",cep),  HttpMethod.GET, null, Endereco.class);
        return response.getBody();
    }

    @Override
    public List<Estado> estados() {

        ibge.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        ResponseEntity<List<Estado>> response = ibge.exchange("/localidades/estados/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Estado>>() { });

        return response.getBody();
    }


    @Override
    public List<Municipio> municipios(String estado) {

        ibge.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        ResponseEntity<List<Municipio>> response = ibge.exchange(String.format("/localidades/estados/%s/municipios",estado),
                    HttpMethod.GET,
                   null,
                    new ParameterizedTypeReference<List<Municipio>>() { });

        return response.getBody();
    }
}
