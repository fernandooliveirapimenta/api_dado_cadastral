package br.com.pan.domain;

public class Estado implements Comparable<Estado> {

    private String id;
    private String sigla;
    private String nome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado)) return false;

        Estado estado = (Estado) o;

        return getId() != null ? getId().equals(estado.getId()) : estado.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }


    @Override
    public int compareTo(Estado o) {
        if(sigla.equalsIgnoreCase("RJ"))
            return -1000;
        if(sigla.equalsIgnoreCase("SP"))
            return Integer.MIN_VALUE;
        return nome.compareTo( o.getNome());
    }
}
