package store;

import java.util.InputMismatchException;
import java.util.Scanner;
import store.controller.StoreController;
import store.model.DetalheProduto;
import store.util.Cores;

public class Menu {

    public static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {

        StoreController plantas = new StoreController();

        int opcao, codigo;
        String nome, detalheTipo, nomeCientifico;
        float preco;

        while (true) {

            System.out.println("*****************************************************");
            System.out.println(Cores.TEXT_WHITE_BOLD + "            Botanic Garden - Floricultura            ");
            System.out.println("                                                     "  + Cores.TEXT_RESET );
            System.out.println("*****************************************************" );
            System.out.println(Cores.TEXT_GREEN_BOLD + "🍀🍂                                                     ");
            System.out.println("🌿          1 - Cadastrar Produto                    ");
            System.out.println("            2 - Listar todos os Produtos             ");
            System.out.println("            3 - Buscar Produto por Número            ");
            System.out.println("            4 - Adicionar Detalhes                   ");
            System.out.println("            5 - Atualizar Produtos                   ");
            System.out.println("            6 - Apagar Produto                       ");
            System.out.println("            7 - Sair                              🌿 ");
            System.out.println("                                                🍂🍀  " + Cores.TEXT_RESET);
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println(Cores.TEXT_WHITE_BOLD + "Entre com a opção desejada:                          ");
            System.out.println("                                                     ");

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

            switch (opcao) {
            case 1:
                System.out.println(Cores.TEXT_GREEN + "Criar Produto" + Cores.TEXT_RESET);
                System.out.println("\nDigite o Número da Planta: ");
                codigo = leia.nextInt();
                leia.nextLine();
                System.out.println("\nDigite o Nome da Planta: ");
                nome = leia.nextLine();
                while (true) {
                    System.out.println("\nDigite o Preço da Planta: ");
                    if (leia.hasNextFloat()) {
                        preco = leia.nextFloat();
                        break;
                    } else {
                        System.out.println(Cores.TEXT_RED_BOLD + "Por favor, insira um valor numérico para o preço." + Cores.TEXT_RESET);
                        leia.nextLine();
                    }
                }
                leia.nextLine();
                System.out.println("\nDigite o Tipo de Detalhe da Planta: ");
                detalheTipo = leia.nextLine();
                System.out.println("\nDigite o Nome Científico da Planta: ");
                nomeCientifico = leia.nextLine();
                plantas.cadastrar(new DetalheProduto(codigo, nome, preco, detalheTipo, nomeCientifico));
                break;
                case 2:
                    System.out.println(Cores.TEXT_GREEN + "Listar todos os Produtos" + Cores.TEXT_RESET );
                    plantas.listarTodas();
                    break;
                case 3:
                    System.out.println(Cores.TEXT_GREEN + "Buscar Produto por Número" + Cores.TEXT_RESET );
                    System.out.println("\nDigite o Número da Planta: ");
                    codigo = leia.nextInt();
                    plantas.buscarPorNumero(codigo);
                    break;
                case 4:
                    System.out.println(Cores.TEXT_GREEN + "Adicionar Detalhes" + Cores.TEXT_RESET );
                    System.out.println("\nDigite o Número da Planta: ");
                    codigo = leia.nextInt();
                    leia.nextLine();
                    System.out.println("\nDigite o Detalhe a ser Adicionado: " + Cores.TEXT_RESET );
                    detalheTipo = leia.nextLine();
                    plantas.adicionarDetalhes(codigo, detalheTipo);
                    break;
                case 5:
                    System.out.println(Cores.TEXT_GREEN + "Atualizar Produtos" + Cores.TEXT_RESET );
                    System.out.println("\nDigite o Número da Planta: ");
                    codigo = leia.nextInt();
                    leia.nextLine();

                    var buscaProduto = plantas.buscarPorNumero(codigo);

                    if (buscaProduto != null) {
                        System.out.println("\nDigite o Novo Nome da Planta: ");
                        nome = leia.nextLine();
                        System.out.println("\nDigite o Novo Preço da Planta: ");
                        preco = leia.nextFloat();
                        leia.nextLine();
                        System.out.println("\nDigite o Novo Tipo de Detalhe da Planta: ");
                        detalheTipo = leia.nextLine();
                        System.out.println("\nDigite o Novo Nome Científico da Planta: ");
                        nomeCientifico = leia.nextLine();

                        buscaProduto.setNome(nome);
                        buscaProduto.setPreco(preco);

                        if (buscaProduto instanceof DetalheProduto) {
                            DetalheProduto detalheProduto = (DetalheProduto) buscaProduto;
                            detalheProduto.setDetalheTipo(detalheTipo);
                            detalheProduto.setNomeCientifico(nomeCientifico);
                        } else {
                            System.out.println(Cores.TEXT_RED_BOLD + "Este produto não suporta detalhes adicionais." + Cores.TEXT_RESET );
                        }

                        plantas.atualizar(buscaProduto);
                        System.out.println(Cores.TEXT_GREEN_BOLD + "Produto atualizado com sucesso!" + Cores.TEXT_RESET );
                    } else {
                        System.out.println(Cores.TEXT_RED_BOLD + "Produto não encontrado." + Cores.TEXT_RESET );
                    }
                    break;
                case 6:
                    System.out.println("Apagar Produto  \n\n");
                    System.out.println("\nDigite o Número da Planta: ");
                    codigo = leia.nextInt();
                    plantas.deletar(codigo);
                    break;
                case 7:
                    System.out.println("\nBotanic Garden - Floricultura - Do verde a vida!");
                    leia.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n"+ Cores.TEXT_RESET);
                    break;
            }
        }
    }
}
