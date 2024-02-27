package store;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);

		int opcao;

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
			System.out.println("            4 - Atualizar Produtos                   ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println("\nBotanic Garden - Floricultura - Do verde a vida!");
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Criar Produto \n\n");

					break;
				case 2:
					System.out.println("Listar todos os Produtos \n\n");

					break;
				case 3:
					System.out.println("Buscar Produto por Número \n\n");

					break;
				case 4:
					System.out.println("Atualizar Produtos \n\n");

					break;
				case 5:
					System.out.println("Apagar Produto  \n\n");

					break;
				case 6:
					System.out.println("Sair \n\n");

					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					break;
			}
		}
	}
	}
