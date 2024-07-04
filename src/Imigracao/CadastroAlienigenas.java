package Imigracao;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class CadastroAlienigenas {
    private ArrayList<Alienigena> alienigenasNaTerra;

    public CadastroAlienigenas() {
        alienigenasNaTerra = new ArrayList<Alienigena>();
    }

    public ArrayList<Alienigena> getAlienigenasNaTerra() {
        return alienigenasNaTerra;
    }

    public void setAlienigenasNaTerra(ArrayList<Alienigena> alienigenasNaTerra) {
        this.alienigenasNaTerra = alienigenasNaTerra;
    }

    public ArrayList<Alienigena> getAlienigenas() {
        return this.alienigenasNaTerra;
    }

    public void addAlienigena(Alienigena alienigena) {

        if (alienigenasNaTerra.size() != 0)
        {
            alienigena.setId(alienigenasNaTerra.get(alienigenasNaTerra.size()-1).getId() + 1);
        } else {
            alienigena.setId(0);
        }

        alienigenasNaTerra.add(alienigena);
    }

    public void removeAlienigena(Alienigena alienigena) {
        alienigenasNaTerra.remove(alienigena);
    }

    public void rankingAlienigenas() {
        System.out.println("\nRANKING ALIENÍGENAS PERICULOSIDADE");

        ArrayList<Alienigena> sortedArrayList = new ArrayList<Alienigena>(alienigenasNaTerra);
        Collections.sort(sortedArrayList, Comparator.comparingInt(Alienigena::getNivelPericulosidade).reversed());

        int numeroRanking = 0;
        for (Alienigena alienigena : sortedArrayList) {
            System.out.print("RK :" + ++numeroRanking + "º ");
            alienigena.exibirDetalhes();
        }
    }

    public void planetasEspeciesAlienigenas() {
        System.out.println("\nPLANETAS ESPECIES ALIENIGENAS");

        ArrayList<String> planetas = new ArrayList<String>();
        ArrayList<String> especies = new ArrayList<String>();
        ArrayList<String> alienigenas = new ArrayList<String>();

        for (Alienigena alienigena : alienigenasNaTerra) {
            if (planetas.indexOf(alienigena.getPlanetaNatal()) == -1)
                planetas.add(alienigena.getPlanetaNatal());

            if (especies.indexOf(alienigena.getNomeEspecie()) == -1)
                especies.add(alienigena.getNomeEspecie());

            if (alienigenas.indexOf(alienigena.getNome()) == -1)
                alienigenas.add(alienigena.getNome());
        }

        System.out.println("\nPlanetas:");
        for (String planeta : planetas) {
            System.out.println(planeta);
        }

        System.out.println("\nEspecies:");
        for (String especie : especies) {
            System.out.println(especie);
        }

        System.out.println("\nAlienigenas:");
        for (String alienigena : alienigenas) {
            System.out.println(alienigena);
        }
    }

    public void alienigenasQuarentenados()
    {
        System.out.println("\nALIENÍGENAS QUARENTENADOS");

        for (Alienigena alienigena : alienigenasNaTerra)
        {
            if (alienigena.isQuarentenado())
                alienigena.exibirDetalhes();
        }
    }

    public void mostrarAlienigenasPorEspecie(String especie)
    {
        System.out.println("\nALIENÍGENAS POR ESPECIE (" + especie + ")");

        for (Alienigena alienigena : alienigenasNaTerra)
        {
            if (alienigena.getNomeEspecie().equals(especie))
                alienigena.exibirDetalhes();
        }
    }

    public void alienigenasUltimosSeisMeses()
    {
        System.out.println("\nALIENÍGENAS REGISTRADOS NOS ÚLTIMOS 6 MESES");

        LocalDateTime dataAtual = LocalDateTime.now();
        Duration diff;

        for (Alienigena alienigena : alienigenasNaTerra)
        {
            diff = Duration.between(alienigena.getDataHoraEntrada(), dataAtual);
            if (diff.toDays() / 30.4375 <= 6.0)
                alienigena.exibirDetalhes();
        }
    }

    public void exibirAlienigenas()
    {
        for (Alienigena alienigena : alienigenasNaTerra)
            alienigena.exibirDetalhes();
    }

    public void editAlienigena(int id, Alienigena novoAlienigena)
    {
        for (Alienigena alienigena : alienigenasNaTerra)
        {
            if (alienigena.getId() == id)
            {
                alienigenasNaTerra.set(alienigenasNaTerra.indexOf(alienigena), novoAlienigena);
            }
        }
    }
}
