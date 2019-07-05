package br.com.pan.usecase.port;

import br.com.pan.domain.Endereco;
import br.com.pan.domain.Estado;
import br.com.pan.domain.Municipio;

import java.util.List;
import java.util.TreeSet;

public interface ApiGeografiaInterface {

    /**
     * Cenário 2 - Consultar CEP
     * Dado que o cliente deseja consultar o seu endereço pelo CEP.
     * Criar endpoint para consulta de endereço utlizando CEP como parâmetro.
     */
    Endereco consultarCep(String cep);

    /**
     * Cenário 3
     * Acessa uma api de terceiro para listar todos estados do BR
     * • O primeiro e o segundo estado devem ser São Paulo e Rio de Janeiro,
     *   respectivamente;
     * • Os demais estados devem estar ordenados em ordem alfabética.
     */
    List<Estado> estados();

    /**
     * Cenário 4 – Consultar Municípios
     * Dado que o cliente deseja escolher o seu município.
     * Criar endpoint para consulta de municípios com base no estado.
     */
    List<Municipio> municipios(String estado);
}
