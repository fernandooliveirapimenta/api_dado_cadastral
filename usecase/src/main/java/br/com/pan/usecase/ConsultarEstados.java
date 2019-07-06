package br.com.pan.usecase;

import br.com.pan.domain.Estado;
import br.com.pan.usecase.port.ApiGeografiaInterface;

import java.util.*;
import java.util.stream.Collectors;

public class ConsultarEstados {

    private final ApiGeografiaInterface apiGeografiaInterface;

    public ConsultarEstados(ApiGeografiaInterface apiGeografiaInterface) {
        this.apiGeografiaInterface = apiGeografiaInterface;
    }

    public List<Estado> estados() {

        List<Estado> estados = apiGeografiaInterface.estados();

        if(estados == null) {
            return  null;
        }

        return ordenacaoComPrioridade(estados);

    }

   private  List<Estado> ordenacaoComPrioridade(List<Estado> estados) {
       //ordenando por nome
       estados.sort(Comparator.comparing(Estado::getNome));

       final Set<String> pri = new HashSet<>(Arrays.asList("SP", "RJ"));

        //Ordenando com prioridade
       List<Estado> retorno = estados
               .stream()
               .filter(e -> pri.contains(e.getSigla()))
               .sorted(Comparator.comparing(Estado::getNome).reversed())
               .collect(Collectors.toList());


       //Adicionando restante na lista
       retorno.addAll(estados.stream().filter(e -> !pri.contains(e.getSigla())).collect(Collectors.toList()));
       return retorno;
    }

}
