package br.com.pan.http.config;

import br.com.pan.db.ClienteRepositoryImpl;
import br.com.pan.http.geografia.ApiGeografiaImpl;
import br.com.pan.usecase.*;
import br.com.pan.usecase.port.ApiGeografiaInterface;
import br.com.pan.usecase.port.ClienteRepositoryInterface;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configuracao {

    @Value( "${app.api.viacep}" )
    private String viacep;

    @Value( "${app.api.ibge}" )
    private String ibge;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Bean
    public AlterarEndereco alterarEndereco() {
        return new AlterarEndereco(getClienteRepositoryInterface());
    }

    @Bean
    public ConsultarCliente consultarCliente() {
        return new ConsultarCliente(getClienteRepositoryInterface());
    }

    @Bean
    public ConsultarCep consultarCep(@Qualifier(value = "apiGeografia") ApiGeografiaInterface apiGeografia) {
        return new ConsultarCep(apiGeografia);
    }

    @Bean
    public ConsultarEstados consultarEstados(@Qualifier(value = "apiGeografia") ApiGeografiaInterface apiGeografia) {
        return new ConsultarEstados(apiGeografia);
    }

    @Bean
    public ConsultarMunicipios consultarMunicipios(@Qualifier(value = "apiGeografia") ApiGeografiaInterface apiGeografia) {
        return new ConsultarMunicipios(apiGeografia);
    }

    @Bean(name = "viacep")
    public RestTemplate viacep() {
        return new RestTemplateBuilder().rootUri(viacep).build();
    }

    @Bean(name = "ibge")
    public RestTemplate ibge() {
        return new RestTemplateBuilder().rootUri(ibge).build();
    }

    private ClienteRepositoryInterface getClienteRepositoryInterface() {
        return new ClienteRepositoryImpl();
    }
}
