package br.com.pan.http.controller;

import br.com.pan.domain.Cliente;
import br.com.pan.domain.Endereco;
import br.com.pan.http.error.GlobalExceptionHandler;
import br.com.pan.usecase.AlterarEndereco;
import br.com.pan.usecase.ConsultarCliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ConsultarCliente consultarCliente;
    private final AlterarEndereco alterarEndereco;

    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

    public ClienteController(ConsultarCliente consultarCliente, AlterarEndereco alterarEndereco) {
        this.consultarCliente = consultarCliente;
        this.alterarEndereco = alterarEndereco;
    }

    @GetMapping(path = "/{cpf}")
    public Cliente consultarCliente(@PathVariable String cpf) {
        log.info(String.format("Consultado cliente com cpf: %s", cpf));
        return consultarCliente.consultarCliente(cpf);
    }

    @PutMapping(path = "/{cpf}/endereco")
    public void alterarEndereco(@PathVariable String cpf, @RequestBody Endereco endereco) {
       alterarEndereco.alterarEndereco(cpf, endereco);
    }
}
