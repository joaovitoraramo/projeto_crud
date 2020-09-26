package br.edu.up.util;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.ItemBebida;
import br.edu.up.dominio.ItemPrato;
import br.edu.up.dominio.ItemVinho;

public class Cardapio {
	
	public static void processar(Scanner leitor, List<ItemPrato> listaDePratos, List<ItemBebida> listaDeBebidas, List<ItemVinho> listaDeVinhos) {
		
		int [] op1 = new int [99]; 
		int [] op2 = new int [99]; 
		int [] op3 = new int [99];
		char Escolha = 0;
		String Obs = "", PedidoFinal = "", BebidaFinal = "", VinhoFinal = "";
		int i = 0, cont1 = 0, cont2 = 0, contP = 0, contB = 0, contV = 0;
		double ValorFinal = 0;
		do {
			
			contP = RealizarPedido.Prato(leitor, contP, op1, listaDePratos);
			
			cls.limpar();
			
			System.out.println("Gostaria de beber alguma coisa? (S)Sim (N)Não: ");
			Escolha = leitor.next().charAt(0);
			do {
				cont1 = 0;
				if (Escolha == 'S' || Escolha == 's'|| Escolha == 'N' || Escolha == 'n') {
					cont1 = 1;
				}else{
					System.out.println("Opção inválida, escolha novamente.");
					System.out.println("Gostaria de beber alguma coisa? (S)Sim (N)Não: ");
					Escolha = leitor.next().charAt(0);
				}
			}while(cont1 == 0);
			leitor.nextLine();
			cls.limpar();
			if(Escolha == 'S' || Escolha == 's') {
				contB = RealizarPedido.Bebida(leitor, contB, op2, listaDeBebidas);
			}
			
			cls.limpar();
			
			System.out.println("Gostaria de conhecer nossa carta de Vinhos? (S)Sim (N)Não: ");
			Escolha = leitor.next().charAt(0);
			do {
				cont1 = 0;
				if (Escolha == 'S' || Escolha == 's'|| Escolha == 'N' || Escolha == 'n') {
					cont1 = 1;
				}else{
					System.out.println("Opção inválida, escolha novamente.");
					System.out.println("Gostaria de conhecer nossa carta de Vinhos? (S)Sim (N)Não: ");
					Escolha = leitor.next().charAt(0);
				}
			}while(cont1 == 0);
			leitor.nextLine();
			cls.limpar();
			if(Escolha == 'S' || Escolha == 's') {
				contV = RealizarPedido.Vinho(leitor, contV, op3, listaDeVinhos);
			}
			
			if((op1[0] != 0) || (op2[0] != 0) || (op3[0] != 0)) {
				i = 0;
				for(ItemPrato prato : listaDePratos) {
					i++;
					for(int j = 0; j < contP; j++) {
						if(op1[j] > 0 && op1[j] == i) {
							PedidoFinal += prato.getNomePrato() + "\t" + prato.getValorPrato() + System.lineSeparator();
							ValorFinal += prato.getValorPrato();
						}
					}
				}
				
				i = 0;
				for(ItemBebida bebida : listaDeBebidas) {
					i++;
					for(int j = 0; j < contB; j++) {
						if(op2[j] > 0 && op2[j] == i) {
							PedidoFinal += bebida.getNomeBebida() + "\t" + bebida.getValorBebida() + System.lineSeparator();
							ValorFinal += bebida.getValorBebida();
						}
					}
				}
				
				i = 0;
				for(ItemVinho vinho : listaDeVinhos) {
					i++;
					for(int j = 0; j < contV; j++) {
						if(op3[j] > 0 && op3[j] == i) {
							PedidoFinal += vinho.getNomeVinho() + "\t" + vinho.getValorVinho() + System.lineSeparator();
							ValorFinal += vinho.getValorVinho();
						}
					}
				}
			}
			
			cls.limpar();
			
			System.out.println("Gostaria de adicionar algum comentário?");
			Obs = leitor.nextLine();
			
			cls.limpar();
		
			try {
				Impressora.imprimir(PedidoFinal, BebidaFinal, VinhoFinal, Obs, ValorFinal, cont2);
			} catch (IOException e) {
				System.out.println("Erro na impressão do pedido");
				//e.printStackTrace();
			}
		
			System.out.println("Gostaria de refazer seu pedido?");
			Escolha = leitor.next().charAt(0);
			do {
				cont1 = 0;
				if (Escolha == 'S' || Escolha == 's'|| Escolha == 'N' || Escolha == 'n') {
					cont1 = 1;
				}else{
					System.out.println("Opção inválida, escolha novamente.");
					System.out.println("Gostaria de refazer seu pedido? (S)Sim (N)Não: ");
					Escolha = leitor.next().charAt(0);
				}
			}while(cont1 == 0);
			leitor.nextLine();
			if(Escolha == 'N' || Escolha == 'n') {
				cont2 = 1;
				cls.limpar();
				try {
					Impressora.imprimir(PedidoFinal, BebidaFinal, VinhoFinal, Obs, ValorFinal, cont2);
				} catch (IOException e) {
					System.out.println("Erro na impressão do pedido");
					//e.printStackTrace();
				}
			}else {
				cls.limpar();
			}
		}while(cont2 == 0);	
	}
}