package br.com.pan.http.controller;

import br.com.pan.domain.Endereco;
import br.com.pan.domain.Estado;
import br.com.pan.domain.Municipio;
import br.com.pan.usecase.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@RestController
public class GeografiaController {

    private final ConsultarCep consultarCep;
    private final ConsultarEstados consultarEstados;
    private final ConsultarMunicipios consultarMunicipios;

    public GeografiaController(ConsultarCep consultarCep,
                               ConsultarEstados consultarEstados,
                               ConsultarMunicipios consultarMunicipios ) {
        this.consultarCep = consultarCep;
        this.consultarEstados = consultarEstados;
        this.consultarMunicipios = consultarMunicipios;
    }

    @GetMapping(path = "/cep/{cep}")
    public Endereco consultarCep(@PathVariable final String cep) throws HttpStatusCodeException {
        return consultarCep.consultarCep(cep);
    }

    @GetMapping(path = "/estados")
    public TreeSet<Estado> estados() {
       return consultarEstados.estados();
    }

    @GetMapping(path = "/estados/{id}/municipios")
    public List<Municipio> municipios(@PathVariable final String id) {
        return consultarMunicipios.municipios(id);
    }

    @GetMapping
    public String helth() {
        return "No Ar: " + new Date();
    }
}
