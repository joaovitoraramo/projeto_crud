package br.edu.up.sistema;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.ItemBebida;
import br.edu.up.dominio.ItemPrato;
import br.edu.up.dominio.ItemVinho;
import br.edu.up.util.ProcessadorDeArquivo;
import br.edu.up.util.Cardapio;
import br.edu.up.util.cls;

public class Programa {
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		char Escolha;
		int cont = 0;
		do {
			System.out.println("-------------------Cardápio------------------");
			System.out.println("Escolha a opção que deseja: ");
			System.out.println("(1) Incluir");
			System.out.println("(2) Listar");
			System.out.println("(3) Atualizar");
			System.out.println("(4) Excluir");
			System.out.println("(5) Realizar Pedido");
			int op = leitor.nextInt();
			
			switch(op) {
				case 1:
					cls.limpar();
					System.out.println("-------------------Incluir------------------");
					System.out.println("Em qual cardápio deseja INCLUIR o item?");
					System.out.println("(1) Prato");
					System.out.println("(2) Bebida");
					System.out.println("(3) Vinho");
					int opIncluir = leitor.nextInt();
					leitor.nextLine();
					if(opIncluir > 0 && opIncluir < 4) {
						if(opIncluir == 1) {
							System.out.println("Digite o nome do Prato que deseja adicionar: ");
							String nomePrato = leitor.nextLine();
							System.out.println("Digite o valor do Prato que deseja adicionar: ");
							String valorPrato2 = leitor.nextLine();
							double valorPrato = Double.parseDouble(valorPrato2);
							ItemPrato novoItemPrato = new ItemPrato(nomePrato, valorPrato);
							ProcessadorDeArquivo.incluirPrato(novoItemPrato);
							System.out.println("----------Incluido com Sucesso!---------------");
							leitor.nextLine();
							cls.limpar();
						}else if(opIncluir == 2) {
							System.out.println("Digite o nome do Bebida que deseja adicionar: ");
							String nomeBebida = leitor.nextLine();
							System.out.println("Digite o valor do Bebida que deseja adicionar: ");
							String valorBebida2 = leitor.nextLine();
							double valorBebida = Double.parseDouble(valorBebida2);
							ItemBebida novoItemBebida = new ItemBebida(nomeBebida, valorBebida);
							ProcessadorDeArquivo.incluirBebida(novoItemBebida);
							System.out.println("----------Incluido com Sucesso!---------------");
							leitor.nextLine();
							cls.limpar();
						}else{
							System.out.println("Digite o nome do Vinho que deseja adicionar: ");
							String nomeVinho = leitor.nextLine();
							System.out.println("Digite o valor do Vinho que deseja adicionar: ");
							String valorVinho2 = leitor.nextLine();
							double valorVinho = Double.parseDouble(valorVinho2);
							ItemVinho novoItemVinho = new ItemVinho(nomeVinho, valorVinho);
							ProcessadorDeArquivo.incluirVinho(novoItemVinho);
							System.out.println("----------Incluido com Sucesso!---------------");
							leitor.nextLine();
							cls.limpar();
						}
					}else {
						System.out.println("Opção inválida");
					}
					break;
					
				case 2:
					cls.limpar();
					System.out.println("-------------------Listar------------------");
					System.out.println("Em qual cardápio deseja LISTAR?");
					System.out.println("(1) Prato");
					System.out.println("(2) Bebida");
					System.out.println("(3) Vinho");
					int opListar = leitor.nextInt();
					leitor.nextLine();
					if(opListar > 0 && opListar < 4) {
						List<ItemPrato> listaDePratos = ProcessadorDeArquivo.listarPrato();
						List<ItemBebida> listaDeBebidas = ProcessadorDeArquivo.listarBebida();
						List<ItemVinho> listaDeVinhos = ProcessadorDeArquivo.listarVinho();
						if(opListar == 1) {
							cls.limpar();
							System.out.println("--------------Lista De Pratos------------------");
							System.out.println("Prato" + ";" + "Preço");
							for(ItemPrato itemPrato : listaDePratos) {
								System.out.println(itemPrato);
							}
						}else if(opListar == 2){
							cls.limpar();
							System.out.println("--------------Lista De Bebidas------------------");
							System.out.println("Preço" + "\t" + "Bebida");
							for(ItemBebida itemBebida : listaDeBebidas) {
								System.out.println(itemBebida);
							}
						}else {
							cls.limpar();
							System.out.println("--------------Lista De Vinhos------------------");
							System.out.println("Preço" + "\t" + "Vinho");
							for(ItemVinho itemVinho : listaDeVinhos) {
								System.out.println(itemVinho);
							}
						}
					}else {
						System.out.println("Opção inválida");
					}
					break;
					
				case 3:
					cls.limpar();
					System.out.println("-------------------Atualizar------------------");
					System.out.println("Em qual cardápio deseja ATUALIZAR o item?");
					System.out.println("(1) Prato");
					System.out.println("(2) Bebida");
					System.out.println("(3) Vinho");
					int opAtualizar = leitor.nextInt();
					leitor.nextLine();
					if(opAtualizar > 0 && opAtualizar < 4) {
						if(opAtualizar == 1) {
							System.out.println("Digite o nome do Prato que deseja atualizar: ");
							String nomePrato = leitor.nextLine();
							ItemPrato pratoRetornado = ProcessadorDeArquivo.buscarPorNomePrato(nomePrato);
							System.out.println("Prato: " + pratoRetornado);
							System.out.println("Digite o valor do Prato que deseja atualizar: ");
							String valorPrato2 = leitor.nextLine();
							double valorPrato = Double.parseDouble(valorPrato2);
							pratoRetornado.setValorPrato(valorPrato);
							ProcessadorDeArquivo.atualizarPrato(pratoRetornado);
							System.out.println("Prato atualizado: " + pratoRetornado.getNomePrato() + "\t" + pratoRetornado.getValorPrato());
							System.out.println("----------Atualizado com Sucesso!---------------");
							leitor.nextLine();
							cls.limpar();
						}else if(opAtualizar == 2) {
							System.out.println("Digite o nome da Bebida que deseja atualizar: ");
							String nomeBebida = leitor.nextLine();
							ItemBebida bebidaRetornado = ProcessadorDeArquivo.buscarPorNomeBebida(nomeBebida);
							System.out.println("Bebida: " + bebidaRetornado);
							System.out.println("Digite o valor da Bebida que deseja atualizar: ");
							String valorBebida2 = leitor.nextLine();
							double valorBebida = Double.parseDouble(valorBebida2);
							bebidaRetornado.setValorBebida(valorBebida);
							ProcessadorDeArquivo.atualizarBebida(bebidaRetornado);
							System.out.println("Bebida atualizado: " + bebidaRetornado.getNomeBebida() + "\t" + bebidaRetornado.getValorBebida());
							System.out.println("----------Atualizado com Sucesso!---------------");
							leitor.nextLine();
							cls.limpar();
						}else {
							System.out.println("Digite o nome do Vinho que deseja atualizar: ");
							String nomeVinho = leitor.nextLine();
							ItemVinho vinhoRetornado = ProcessadorDeArquivo.buscarPorNomeVinho(nomeVinho);
							System.out.println("Vinho: " + vinhoRetornado);
							System.out.println("Digite o valor do Vinho que deseja atualizar: ");
							String valorVinho2 = leitor.nextLine();
							double valorVinho = Double.parseDouble(valorVinho2);
							vinhoRetornado.setValorVinho(valorVinho);
							ProcessadorDeArquivo.atualizarVinho(vinhoRetornado);
							System.out.println("Vinho atualizado: " + vinhoRetornado.getNomeVinho() + "\t" + vinhoRetornado.getValorVinho());
							System.out.println("----------Atualizado com Sucesso!---------------");
							leitor.nextLine();
							cls.limpar();
						}
					}else {
						System.out.println("Opção inválida");
					}
					break;
					
				case 4:
					cls.limpar();
					System.out.println("-------------------Escluir------------------");
					System.out.println("Em qual cardápio deseja EXCLUIR o item?");
					System.out.println("(1) Prato");
					System.out.println("(2) Bebida");
					System.out.println("(3) Vinho");
					int opExcluir = leitor.nextInt();
					leitor.nextLine();
					if(opExcluir > 0 && opExcluir < 4) {
						if(opExcluir == 1) {
							System.out.println("Digite o nome do Prato que deseja remover: ");
							String nomePrato = leitor.nextLine();
							ItemPrato pratoRetornado = ProcessadorDeArquivo.buscarPorNomePrato(nomePrato);
							ProcessadorDeArquivo.excluirPrato(pratoRetornado);
							System.out.println("Prato excluido com sucesso: " + pratoRetornado.getNomePrato() + "\t" + pratoRetornado.getValorPrato());
							System.out.println("----------Excluído com Sucesso!---------------");
							leitor.nextLine();
							cls.limpar();
						}else if(opExcluir == 2) {
							System.out.println("Digite o nome do Bebida que deseja remover: ");
							String nomeBebida = leitor.nextLine();
							ItemBebida bebidaRetornado = ProcessadorDeArquivo.buscarPorNomeBebida(nomeBebida);
							ProcessadorDeArquivo.excluirBebida(bebidaRetornado);
							System.out.println("Bebida excluido com sucesso: " + bebidaRetornado.getNomeBebida() + "\t" + bebidaRetornado.getValorBebida());
							System.out.println("----------Excluído com Sucesso!---------------");
							leitor.nextLine();
							cls.limpar();
						}else{
							System.out.println("Digite o nome do Vinho que deseja remover: ");
							String nomeVinho = leitor.nextLine();
							ItemVinho vinhoRetornado = ProcessadorDeArquivo.buscarPorNomeVinho(nomeVinho);
							ProcessadorDeArquivo.excluirVinho(vinhoRetornado);
							System.out.println("Vinho excluido com sucesso: " + vinhoRetornado.getNomeVinho() + "\t" + vinhoRetornado.getValorVinho());
							System.out.println("----------Excluído com Sucesso!---------------");
							leitor.nextLine();
							cls.limpar();
						}
					}else {
						System.out.println("Opção inválida");
					}
					break;
					
				case 5:
					List<ItemPrato> listaDePratos = ProcessadorDeArquivo.listarPrato();
					List<ItemBebida> listaDeBebidas = ProcessadorDeArquivo.listarBebida();
					List<ItemVinho> listaDeVinhos = ProcessadorDeArquivo.listarVinho();
					cls.limpar();
					Cardapio.processar(leitor, listaDePratos, listaDeBebidas, listaDeVinhos);
					break;
				default:
					System.out.println("Escolha inválida");
			}
		
			do {
				System.out.println("Deseja continuar no cardápio? (S)Sim (N)Não");
				Escolha = leitor.next().charAt(0);
				if (Escolha == 'S' || Escolha == 's'|| Escolha == 'N' || Escolha == 'n') {
					cont = 1;
					cls.limpar();
				}else{
					System.out.println("Opção invalida, escolha novamente.");
				}
			}while(cont == 0);
		}while(Escolha == 'S' || Escolha == 's');
	leitor.close();
	}
}