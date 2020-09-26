package br.edu.up.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.dominio.ItemBebida;
import br.edu.up.dominio.ItemPrato;
import br.edu.up.dominio.ItemVinho;

public class ProcessadorDeArquivo {
	
	private static List<ItemPrato> ListaDePratos;
	private static List<ItemBebida> ListaDeBebidas;
	private static List<ItemVinho> ListaDeVinhos;
	
	private static String nomeArquivoPrato = "C:\\Users\\Rafael\\eclipse-workspace\\At05\\arquivos\\pratos.csv";
	private static String nomeArquivoBebida = "C:\\Users\\Rafael\\eclipse-workspace\\At05\\arquivos\\bebidas-tabuladas.txt";
	private static String nomeArquivoVinho = "C:\\Users\\Rafael\\eclipse-workspace\\At05\\arquivos\\vinhos-tabulados.txt";
	
	static {
		ListaDePratos = new ArrayList<ItemPrato>();
		ListaDePratos = carregarListaDePratos();
		ListaDeBebidas = new ArrayList<ItemBebida>();
		ListaDeBebidas = carregarListaDeBebidas();
		ListaDeVinhos = new ArrayList<ItemVinho>();
		ListaDeVinhos = carregarListaDeVinhos();
	}

	public static void incluirPrato(ItemPrato novoItemPrato) {
		ListaDePratos.add(novoItemPrato);
		incluirNoArquivoPrato(novoItemPrato);
	}
	
	private static void incluirNoArquivoPrato(ItemPrato novoItemPrato) {
		try {
			FileWriter arquivo = new FileWriter(nomeArquivoPrato, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println(novoItemPrato);
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			System.out.println("Erro na gravação do Arquivo!");
			//e.printStackTrace();
		}
	}
	
	public static void incluirBebida(ItemBebida novoItemBebida) {
		ListaDeBebidas.add(novoItemBebida);
		incluirNoArquivoBebida(novoItemBebida);
	}
	
	private static void incluirNoArquivoBebida(ItemBebida novoItemBebida) {
		try {
			FileWriter arquivo = new FileWriter(nomeArquivoBebida, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println(novoItemBebida);
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			System.out.println("Erro na gravação do Arquivo!");
			//e.printStackTrace();
		}
	}
	
	public static void incluirVinho(ItemVinho novoItemVinho) {
		ListaDeVinhos.add(novoItemVinho);
		incluirNoArquivoVinho(novoItemVinho);
	}
	
	private static void incluirNoArquivoVinho(ItemVinho novoItemVinho) {
		try {
			FileWriter arquivo = new FileWriter(nomeArquivoVinho, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println(novoItemVinho);
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			System.out.println("Erro na gravação do Arquivo!");
			//e.printStackTrace();
		}
	}
	
	private static List<ItemPrato> carregarListaDePratos() {
		List<ItemPrato> listaRetornoPrato = new ArrayList<>();
		
		try {
			File arquivo = new File(nomeArquivoPrato);
			Scanner leitor = new Scanner(new FileInputStream(arquivo), "UTF-8");
			leitor.nextLine();
			
			while(leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split(";");
				ItemPrato itemPrato = new ItemPrato(partes[0], partes[1]);
				listaRetornoPrato.add(itemPrato);
			}
			leitor.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro na leitura do arquivo");
			//e.printStackTrace();
		}
		return listaRetornoPrato;
	}
	
	private static List<ItemBebida> carregarListaDeBebidas() {
		List<ItemBebida> listaRetornoBebida = new ArrayList<>();
		
		try {
			File arquivo = new File(nomeArquivoBebida);
			Scanner leitor = new Scanner(new FileInputStream(arquivo), "UTF-8");
			leitor.nextLine();
			
			while(leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split("\t");
				ItemBebida itemBebida = new ItemBebida(partes[0].replaceAll(",", "."), partes[1]);
				listaRetornoBebida.add(itemBebida);
			}
			leitor.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro na leitura do arquivo");
			//e.printStackTrace();
		}
		return listaRetornoBebida;
	}
	
	private static List<ItemVinho> carregarListaDeVinhos() {
		List<ItemVinho> listaRetornoVinho = new ArrayList<>();
		
		try {
			File arquivo = new File(nomeArquivoVinho);
			Scanner leitor = new Scanner(new FileInputStream(arquivo), "UTF-8");
			leitor.nextLine();
			
			while(leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split("\t");
				ItemVinho itemVinho = new ItemVinho(partes[0], partes[1]);
				listaRetornoVinho.add(itemVinho);
			}
			leitor.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro na leitura do arquivo");
			//e.printStackTrace();
		}
		return listaRetornoVinho;
	}

	public static void excluirPrato(ItemPrato pratoRetornado) {
		ListaDePratos.remove(pratoRetornado);
		gravarListaAtualizadaPrato(ListaDePratos);
	}

	private static void gravarListaAtualizadaPrato(List<ItemPrato> ListaDePratos) {
		try {
			FileWriter arquivo = new FileWriter(nomeArquivoPrato);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("PRATO;PREÇO");
			for (ItemPrato itemPrato : ListaDePratos) {
				gravador.println(itemPrato);
			}
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			System.out.println("Erro na gravação do Arquivo!");
			//e.printStackTrace();
		}
	}
	
	public static void excluirBebida(ItemBebida bebidaRetornado) {
		ListaDeBebidas.remove(bebidaRetornado);
		gravarListaAtualizadaBebida(ListaDeBebidas);
	}

	private static void gravarListaAtualizadaBebida(List<ItemBebida> ListaDeBebidas) {
		try {
			FileWriter arquivo = new FileWriter(nomeArquivoBebida);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("PREÇO" + "\t" + "BEBIDA");
			for (ItemBebida itemBebida : ListaDeBebidas) {
				gravador.println(itemBebida);
			}
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			System.out.println("Erro na gravação do Arquivo!");
			//e.printStackTrace();
		}
	}
	
	public static void excluirVinho(ItemVinho vinhoRetornado) {
		ListaDeVinhos.remove(vinhoRetornado);
		gravarListaAtualizadaVinho(ListaDeVinhos);
	}

	private static void gravarListaAtualizadaVinho(List<ItemVinho> ListaDeVinhos) {
		try {
			FileWriter arquivo = new FileWriter(nomeArquivoVinho);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("PREÇO" + "\t" + "VINHO");
			for (ItemVinho itemVinho : ListaDeVinhos) {
				gravador.println(itemVinho);
			}
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			System.out.println("Erro na gravação do Arquivo!");
			//e.printStackTrace();
		}
	}

	public static ItemPrato buscarPorNomePrato(String nomePrato) {
		ItemPrato itemRetornar = null;
		for (ItemPrato itemPrato : ListaDePratos) {
			if(itemPrato.getNomePrato().contains(nomePrato)) {
				itemRetornar = itemPrato;
				break;
			}
		}
		return itemRetornar;
	}

	public static void atualizarPrato(ItemPrato pratoRetornado) {
		for (ItemPrato pratoAtualizar : ListaDePratos) {
			if(pratoAtualizar.getNomePrato().equals(pratoRetornado.getNomePrato())) {
				pratoAtualizar.setNomePrato(pratoRetornado.getNomePrato());
				pratoAtualizar.setValorPrato(pratoRetornado.getValorPrato());
				break;
			}
		}
		gravarListaAtualizadaPrato(ListaDePratos);
	}
	
	public static ItemBebida buscarPorNomeBebida(String nomeBebida) {
		ItemBebida itemRetornar = null;
		for (ItemBebida itemBebida : ListaDeBebidas) {
			if(itemBebida.getNomeBebida().contains(nomeBebida)) {
				itemRetornar = itemBebida;
				break;
			}
		}
		return itemRetornar;
	}

	public static void atualizarBebida(ItemBebida bebidaRetornado) {
		for (ItemBebida bebidaAtualizar : ListaDeBebidas) {
			if(bebidaAtualizar.getNomeBebida().equals(bebidaRetornado.getNomeBebida())) {
				bebidaAtualizar.setNomeBebida(bebidaRetornado.getNomeBebida());
				bebidaAtualizar.setValorBebida(bebidaRetornado.getValorBebida());
				break;
			}
		}
		gravarListaAtualizadaBebida(ListaDeBebidas);
	}
	
	public static ItemVinho buscarPorNomeVinho(String nomeVinho) {
		ItemVinho itemRetornar = null;
		for (ItemVinho itemVinho : ListaDeVinhos) {
			if(itemVinho.getNomeVinho().contains(nomeVinho)) {
				itemRetornar = itemVinho;
				break;
			}
		}
		return itemRetornar;
	}

	public static void atualizarVinho(ItemVinho vinhoRetornado) {
		for (ItemVinho vinhoAtualizar : ListaDeVinhos) {
			if(vinhoAtualizar.getNomeVinho().equals(vinhoRetornado.getNomeVinho())) {
				vinhoAtualizar.setNomeVinho(vinhoRetornado.getNomeVinho());
				vinhoAtualizar.setValorVinho(vinhoRetornado.getValorVinho());
				break;
			}
		}
		gravarListaAtualizadaVinho(ListaDeVinhos);
	}

	public static List<ItemPrato> listarPrato() {
		
		return carregarListaDePratos();
	}
	
	public static List<ItemBebida> listarBebida() {
		
		return carregarListaDeBebidas();
	}

	public static List<ItemVinho> listarVinho() {
	
		return carregarListaDeVinhos();
	}
}