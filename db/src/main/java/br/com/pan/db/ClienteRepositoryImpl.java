package br.com.pan.db;

import br.com.pan.domain.Cliente;
import br.com.pan.domain.Endereco;
import br.com.pan.usecase.port.ClienteRepositoryInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ClienteRepositoryImpl implements ClienteRepositoryInterface {

    private static Map<String, Cliente> memoria = new HashMap<>();

    static {

        popular( "43743772809", "Fernando P" , "Jardim Sto eduaro", "203", "06823250");
        popular( "7458546685", "Ana F" , "Vila Olimpia", "500", "5555806");
        popular( "1458546685", "Bruna M" , "Santo Amaro", "590", "5555806");
        popular( "4458546685", "Luiz M" , "Vila Olimpia", "580", "5555806");
        popular( "2458546685", "Guilherme O" , "Ibirapuera", "508", "5555806");
        popular( "3458546685", "Eduardo P" , "Vila Olimpia", "502", "5555806");
        popular( "5458546685", "Mario Batista" , "Capao Redondo", "800", "5555806");
        popular( "6458546685", "Erick k" , "Vila Olimpia", "500", "5555806");
    }

    private static void popular(String cpf, String nome, String bairro, String num, String cep) {

        String uuid = uuid();
        Cliente cliente = Cliente.ClienteBuilder.aCliente()
                .withCpf(cpf)
                .withId(uuid)
                .withNome(nome)
                .withEndereco(Endereco.EnderecoBuilder.anEndereco()
                        .withId(uuid())
                        .withBairro(bairro)
                        .withNumero(num)
                        .withCep(cep)
                        .build()).build();

        memoria.put(uuid, cliente);
    }


    private static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public Cliente consultarCliente(String cpf) {
        return memoria.values().stream().filter(c -> c.getCpf().equalsIgnoreCase(cpf)).findFirst().orElse(null);
    }

    @Override
    public void alterarEndereco(Cliente cliente) {
        memoria.put(cliente.getId(), cliente);

    }
}
