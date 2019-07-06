package br.com.pan.domain;

public class Estado implements Comparable<Estado> {

    private String id;
    private String sigla;
    private String nome;

    public Estado() {

    }
    public Estado(String id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla != null ? sigla.toUpperCase() : null;
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
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        return sigla != null ? sigla.equals(estado.sigla) : estado.sigla == null;
    }

    @Override
    public int hashCode() {
        return sigla != null ? sigla.hashCode() : 0;
    }

    @Override
    public int compareTo(Estado o) {
        if(sigla.equalsIgnoreCase("SP") && o.getSigla().equalsIgnoreCase("SP"))
            return -10000;
        if(sigla.equalsIgnoreCase("RJ") && o.getSigla().equalsIgnoreCase("RJ"))
            return -1000;
        return nome.compareTo( o.getNome());
    }
}
