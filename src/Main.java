import Imigracao.Alienigena;
import Imigracao.CadastroAlienigenas;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcaoUsuario;

        CadastroAlienigenas alienigenasCadastro = new CadastroAlienigenas();
        alienigenasCadastro.addAlienigena(new Alienigena(
                "Zerg",
                "Marte",
                "Piolhao"
        ));
        alienigenasCadastro.addAlienigena(new Alienigena(
                "Zyon",
                "Venus",
                "Baratao"
        ));
        alienigenasCadastro.addAlienigena(new Alienigena(
                "Gazoo",
                "Theia",
                "Jacare"
        ));
        alienigenasCadastro.addAlienigena(new Alienigena(
                "Gazoo",
                "Theia",
                "PrimoDoJacare"
        ));

        alienigenasCadastro.rankingAlienigenas();



        do{
            System.out.println("\nO que você deseja fazer?");
            System.out.println("[0] Adicionar alienígena");
            System.out.println("[1] Exibir todos os alienígenas");
            System.out.println("[2] Editar alienígena");
            System.out.println("[3] Remover alienígena");
            System.out.println("[4] Mais opções");
            System.out.println("[5] Sair");
            System.out.print(">");

            opcaoUsuario = Integer.parseInt(sc.next());

            switch (opcaoUsuario) {
                case 0:
                    String nomeEspecie;
                    String planetaNatal;
                    String nomeDoAlienigena;

                    System.out.print("Espécie do alienígena (Mais comuns \"Zerg\", \"Zyon\", \"Gazoo\"): ");
                    nomeEspecie = sc.next();
                    System.out.print("Planeta natal do alienígena (Mais comuns \"Marte\", \"Venus\", \"Theia\"): ");
                    planetaNatal = sc.next();
                    System.out.print("Nome do alienígena: ");
                    nomeDoAlienigena = sc.next();

                    alienigenasCadastro.addAlienigena(new Alienigena(
                            nomeEspecie,
                            planetaNatal,
                            nomeDoAlienigena
                    ));
                    break;
                case 1:
                    alienigenasCadastro.exibirAlienigenas();

                    break;
                case 2:
                    System.out.print("Id do alienígena a editar: ");
                    int idAlienigena = Integer.parseInt(sc.next());

                    for (Alienigena alienigena : alienigenasCadastro.getAlienigenas()) {
                        if (alienigena.getId() == idAlienigena) {
                            alienigena.exibirDetalhes();
                            System.out.print("Espécie do alienígena (Mais comuns \"Zerg\", \"Zyon\", \"Gazoo\"): ");
                            nomeEspecie = sc.next();
                            System.out.print("Planeta natal do alienígena (Mais comuns \"Marte\", \"Venus\", \"Theia\"): ");
                            planetaNatal = sc.next();
                            System.out.print("Nome do alienígena: ");
                            nomeDoAlienigena = sc.next();

                            alienigenasCadastro.editAlienigena(idAlienigena, alienigena = new Alienigena(
                                    nomeEspecie,
                                    planetaNatal,
                                    nomeDoAlienigena
                            ));
                        }
                    }

                    break;
                case 3:
                    int idDoAlienigenaARemover = Integer.parseInt(sc.next());
                    System.out.print("Id do alienígena a remover: ");

                    for (Alienigena alienigena : alienigenasCadastro.getAlienigenas()) {
                        if (alienigena.getId() == idDoAlienigenaARemover) {
                            alienigenasCadastro.removeAlienigena(alienigena);
                        }
                    }

                    break;
                case 4:
                    int opcaoUsuario2;
                    do{
                        System.out.println("\nMais opções");
                        System.out.println("[0] Exibir Ranking periculosidade");
                        System.out.println("[1] Exibir todos os planetas, especies e aliens");
                        System.out.println("[2] Exibir aliens em quarentena");
                        System.out.println("[3] Pesquisar alienigenas por espécie");
                        System.out.println("[4] Mostrar novos cadastros nos últimos 6 meses");
                        System.out.println("[5] Voltar");
                        System.out.print(">");

                        opcaoUsuario2 = Integer.parseInt(sc.next());
                        switch (opcaoUsuario2) {
                            case 0:
                                alienigenasCadastro.rankingAlienigenas();
                                break;
                            case 1:
                                alienigenasCadastro.planetasEspeciesAlienigenas();
                                break;
                            case 2:
                                alienigenasCadastro.alienigenasQuarentenados();
                                break;
                            case 3:
                                System.out.println("Qual espécie deseja pesquisar? ");
                                alienigenasCadastro.mostrarAlienigenasPorEspecie(sc.next());
                                break;
                            case 4:
                                alienigenasCadastro.alienigenasUltimosSeisMeses();
                        }

                    }while (opcaoUsuario2 != 5);
            }
        } while (opcaoUsuario != 5);
    }
}