package br.com.pan.http.config;

import br.com.pan.db.ClienteRepositoryImpl;
import br.com.pan.http.geografia.ApiGeografiaImpl;
import br.com.pan.usecase.*;
import br.com.pan.usecase.port.ApiGeografiaInterface;
import br.com.pan.usecase.port.ClienteRepositoryInterface;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracao {

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
    public ConsultarCep consultarCep() {
        return new ConsultarCep(getApiGeografiaInterface());
    }

    @Bean
    public ConsultarCliente consultarCliente() {
        return new ConsultarCliente(getClienteRepositoryInterface());
    }

    @Bean
    public ConsultarEstados consultarEstados() {
        return new ConsultarEstados(getApiGeografiaInterface());
    }

    @Bean
    public ConsultarMunicipios consultarMunicipios() {
        return new ConsultarMunicipios(getApiGeografiaInterface());
    }

    private ClienteRepositoryInterface getClienteRepositoryInterface() {
        return new ClienteRepositoryImpl();
    }
    private ApiGeografiaInterface getApiGeografiaInterface() {
        return new ApiGeografiaImpl();
    }
}
