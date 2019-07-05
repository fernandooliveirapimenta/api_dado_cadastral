package br.com.pan.http.controller;

import br.com.pan.domain.Cliente;
import br.com.pan.domain.Endereco;
import br.com.pan.usecase.AlterarEndereco;
import br.com.pan.usecase.ConsultarCliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ConsultarCliente consultarCliente;
    private final AlterarEndereco alterarEndereco;

    public ClienteController(ConsultarCliente consultarCliente, AlterarEndereco alterarEndereco) {
        this.consultarCliente = consultarCliente;
        this.alterarEndereco = alterarEndereco;
    }

    @GetMapping(path = "/{cpf}")
    public Cliente consultarCliente(@PathVariable String cpf) {
        return consultarCliente.consultarCliente(cpf);
    }

    @PutMapping(path = "/{cpf}")
    public void alterarEndereco(@PathVariable String cpf, @RequestBody Endereco endereco) {
       alterarEndereco.alterarEndereco(cpf, endereco);
    }
}
