package Imigracao;

public abstract class Especie {
    protected String nomeEspecie;
    protected String planetaNatal;
    protected int nivelPericulosidade;

    public Especie(String nomeEspecie, String planetaNatal) {
        this.nomeEspecie = nomeEspecie;
        this.planetaNatal = planetaNatal;

        if (nomeEspecie == "Zerg" && planetaNatal == "Marte")
            this.nivelPericulosidade = 100;

        if (nomeEspecie == "Zyon" && planetaNatal == "Venus")
            this.nivelPericulosidade = 50;

        if (nomeEspecie == "Gazoo" && planetaNatal == "Theia")
            this.nivelPericulosidade = 0;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }

    public String getPlanetaNatal() {
        return planetaNatal;
    }

    public void setPlanetaNatal(String planetaNatal) {
        this.planetaNatal = planetaNatal;
    }

    public int getNivelPericulosidade() {
        return nivelPericulosidade;
    }

    public int setNivelPericulosidade(int nivelPericulosidade) {
        return this.nivelPericulosidade = nivelPericulosidade;
    }
}
