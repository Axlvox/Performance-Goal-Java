package store;

import java.util.Scanner;
import store.controller.StoreController;
import store.model.DetalheProduto;
import store.model.Produto;


public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		StoreController plantas = new StoreController();

		int opcao, codigo;
		String nome, detalheTipo, nomeCientifico;
		float preco;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            Botanic Garden - Floricultura            ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por Número            ");
			System.out.println("            4 - Adicionar Detalhes                   ");
			System.out.println("            5 - Atualizar Produtos                   ");
			System.out.println("            6 - Apagar Produto                       ");
			System.out.println("            7 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 7) {
				System.out.println("\nBotanic Garden - Floricultura - Do verde a vida!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Produto \n\n");
				System.out.println("\nDigite o Número da Planta: ");
				codigo = leia.nextInt();
				leia.nextLine();
				System.out.println("\nDigite o Nome da Planta: ");
				nome = leia.nextLine();
				System.out.println("\nDigite o Preço da Planta: ");
				preco = leia.nextFloat();
				leia.nextLine();
				System.out.println("\nDigite o Tipo de Detalhe da Planta: ");
				detalheTipo = leia.nextLine();
				System.out.println("\nDigite o Nome Científico da Planta: ");
				nomeCientifico = leia.nextLine();
				plantas.cadastrar(new DetalheProduto(codigo, nome, preco, detalheTipo, nomeCientifico));
				break;
			case 2:
				System.out.println("Listar todos os Produtos \n\n");
				plantas.listarTodas();
				break;
			case 3:
				System.out.println("Buscar Produto por Número \n\n");
				System.out.println("\nDigite o Número da Planta: ");
				codigo = leia.nextInt();
				plantas.buscarPorNumero(codigo);
				break;
			case 4:
				System.out.println("Adicionar Detalhes \n\n");
				System.out.println("\nDigite o Número da Planta: ");
				codigo = leia.nextInt();
				leia.nextLine();
				System.out.println("\nDigite o Detalhe a ser Adicionado: ");
				detalheTipo = leia.nextLine();
				plantas.adicionarDetalhes(codigo, detalheTipo);
				break;
			case 5:
			    System.out.println("Atualizar Produtos \n\n");
			    System.out.println("\nDigite o Número da Planta: ");
			    codigo = leia.nextInt();

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
			            System.out.println("Este produto não suporta detalhes adicionais.");
			        }
			        
			        plantas.atualizar(buscaProduto);
			        System.out.println("Produto atualizado com sucesso!");
			    } else {
			        System.out.println("Produto não encontrado.");
			    }
			    break;


			case 6:
				System.out.println("Apagar Produto  \n\n");
				System.out.println("\nDigite o Número da Planta: ");
				codigo = leia.nextInt();

				plantas.deletar(codigo);
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}
}
