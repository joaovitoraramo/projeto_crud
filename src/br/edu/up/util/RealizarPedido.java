package br.edu.up.util;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.ItemPrato;
import br.edu.up.dominio.ItemBebida;
import br.edu.up.dominio.ItemVinho;

public class RealizarPedido {
	
	public static int Prato(Scanner leitor, int contP, int[] op1, List<ItemPrato> listaDePratos) {
		int i = 1, cont = 0, cont1 = 0; contP = 0;
		char Escolha = 0;
		
		System.out.println("-------------------Cardápio------------------");
		System.out.println("Escolha a opção de prato: ");
		do {
			for(ItemPrato prato : listaDePratos) {
				System.out.println("(" + i + ")" + prato.getNomePrato() + "\t" + prato.getValorPrato());
				i++;
			}
			System.out.println("(0)Nenhuma das opções Anteriores");
			op1[cont] = leitor.nextInt();
			if(op1[cont] <= -1 || op1[cont] > listaDePratos.size()) {
				cls.limpar();
				System.out.println("Escolha de Prato incorreto");
				System.out.println("Escolha Novamente: ");
				}else {
				contP++;
			}
		}while(op1[cont] <= -1 || op1[cont] > listaDePratos.size());	
	
		do {
			if(op1[0] != 0) {
				System.out.println("Gostaria de mais algum prato? (S)Sim (N)Não: ");
				Escolha = leitor.next().charAt(0);
				do {
					cont1 = 0;
					if (Escolha == 'S' || Escolha == 's'|| Escolha == 'N' || Escolha == 'n') {
						cont1 = 1;
						cont++;
					}else{
						System.out.println("Opção invalida, escolha novamente.");
						System.out.println("Gostaria de mais algum prato? (S)Sim (N)Não: ");
						Escolha = leitor.next().charAt(0);
					}
				}while(cont1 == 0);
				leitor.nextLine();
				if(Escolha == 'S' || Escolha == 's') {
					cls.limpar();
					i = 1;
					System.out.println("-------------------Cardápio------------------");
					System.out.println("Escolha a opção de prato: ");
					do {
						for(ItemPrato prato : listaDePratos) {
							System.out.println("(" + i + ")" + prato.getNomePrato() + "\t" + prato.getValorPrato());
							i++;
						}
						System.out.println("(0)Nenhuma das opções Anteriores");
						op1[cont] = leitor.nextInt();
						if(op1[cont] <= -1 || op1[cont] > listaDePratos.size()) {
							cls.limpar();
							System.out.println("Escolha de Prato incorreto");
							System.out.println("Escolha Novamente: ");	
						}else {
							contP++;
						}
					}while(op1[cont] <= -1 || op1[cont] > listaDePratos.size());
				}
			}
		}while(Escolha == 'S' || Escolha == 's');
		return contP;
	}
	
	public static int Bebida(Scanner leitor, int contB, int[] op2, List<ItemBebida> listaDeBebidas) {
		int i = 1, cont = 0, cont1 = 0; contB = 0;
		char Escolha = 0;
		
		System.out.println("-------------------Cardápio------------------");
		System.out.println("Escolha a opção de bebida: ");
		
		do {
			for(ItemBebida bebida : listaDeBebidas) {
				System.out.println("(" + i + ")" + bebida.getNomeBebida() + "\t" + bebida.getValorBebida());
				i++;
			}
			System.out.println("(0)Nenhuma das opções Anteriores");
			op2[cont] = leitor.nextInt();
			if(op2[cont] <= -1 || op2[cont] > listaDeBebidas.size()) {
				cls.limpar();
				System.out.println("Escolha de Bebida incorreto");
				System.out.println("Escolha Novamente: ");
				}else {
				contB++;
			}
		}while(op2[cont] <= -1 || op2[cont] > listaDeBebidas.size());	
	
		do {
			if(op2[0] != 0) {
				System.out.println("Gostaria de mais alguma bebida? (S)Sim (N)Não: ");
				Escolha = leitor.next().charAt(0);
				do {
					cont1 = 0;
					if (Escolha == 'S' || Escolha == 's'|| Escolha == 'N' || Escolha == 'n') {
						cont1 = 1;
						cont++;
					}else{
						System.out.println("Opção invalida, escolha novamente.");
						System.out.println("Gostaria de mais alguma bebida? (S)Sim (N)Não: ");
						Escolha = leitor.next().charAt(0);
					}
				}while(cont1 == 0);
				leitor.nextLine();
				if(Escolha == 'S' || Escolha == 's') {
					cls.limpar();
					i = 1;
					System.out.println("-------------------Cardápio------------------");
					System.out.println("Escolha a opção de bebida: ");
					do {
						for(ItemBebida bebida : listaDeBebidas) {
							System.out.println("(" + i + ")" + bebida.getNomeBebida() + "\t" + bebida.getValorBebida());
							i++;
						}
						System.out.println("(0)Nenhuma das opções Anteriores");
						op2[cont] = leitor.nextInt();
						if(op2[cont] <= -1 || op2[cont] > listaDeBebidas.size()) {
							cls.limpar();
							System.out.println("Escolha de bebida incorreto");
							System.out.println("Escolha Novamente: ");	
						}else {
							contB++;
						}
					}while(op2[cont] <= -1 || op2[cont] > listaDeBebidas.size());
				}
			}
		}while(Escolha == 'S' || Escolha == 's');
		return contB;
	}
	
	public static int Vinho(Scanner leitor, int contV, int[] op3, List<ItemVinho> listaDeVinhos) {
		int i = 1, cont = 0, cont1 = 0; contV = 0;
		char Escolha = 0;
		
		System.out.println("-------------------Cardápio------------------");
		System.out.println("Escolha a opção de vinho: ");
		
		do {
			for(ItemVinho vinho : listaDeVinhos) {
				System.out.println("(" + i + ")" + vinho.getNomeVinho() + "\t" + vinho.getValorVinho());
				i++;
			}
			System.out.println("(0)Nenhuma das opções Anteriores");
			op3[cont] = leitor.nextInt();
			if(op3[cont] <= -1 || op3[cont] > listaDeVinhos.size()) {
				cls.limpar();
				System.out.println("Escolha de vinho incorreto");
				System.out.println("Escolha Novamente: ");
				}else {
				contV++;
			}
		}while(op3[cont] <= -1 || op3[cont] > listaDeVinhos.size());	
	
		do {
			if(op3[0] != 0) {
				System.out.println("Gostaria de escolher mais algum vinho? (S)Sim (N)Não: ");
				Escolha = leitor.next().charAt(0);
				do {
					cont1 = 0;
					if (Escolha == 'S' || Escolha == 's'|| Escolha == 'N' || Escolha == 'n') {
						cont1 = 1;
						cont++;
					}else{
						System.out.println("Opção invalida, escolha novamente.");
						System.out.println("Gostaria de escolher mais algum vinho? (S)Sim (N)Não: ");
						Escolha = leitor.next().charAt(0);
					}
				}while(cont1 == 0);
				leitor.nextLine();
				if(Escolha == 'S' || Escolha == 's') {
					cls.limpar();
					i = 1;
					System.out.println("-------------------Cardápio------------------");
					System.out.println("Escolha a opção de vinho: ");
					do {
						for(ItemVinho vinho : listaDeVinhos) {
							System.out.println("(" + i + ")" + vinho.getNomeVinho() + "\t" + vinho.getValorVinho());
							i++;
						}
						System.out.println("(0)Nenhuma das opções Anteriores");
						op3[cont] = leitor.nextInt();
						if(op3[cont] <= -1 || op3[cont] > listaDeVinhos.size()) {
							cls.limpar();
							System.out.println("Escolha de Vinho incorreto");
							System.out.println("Escolha Novamente: ");	
						}else {
							contV++;
						}
					}while(op3[cont] <= -1 || op3[cont] > listaDeVinhos.size());
				}
			}
		}while(Escolha == 'S' || Escolha == 's');
		return contV;
	}
}