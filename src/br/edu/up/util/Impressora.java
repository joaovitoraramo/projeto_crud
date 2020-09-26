package br.edu.up.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Impressora {
	public static void imprimir(String PedidoFinal, String BebidaFinal, String VinhoFinal, String Obs, double ValorFinal, 
			int cont2) throws IOException {
		FileWriter arquivoDeSaida = new FileWriter("C:\\Users\\Rafael\\eclipse-workspace\\At05\\arquivos\\Pedido-Realizado.txt");
		PrintWriter gravador = new PrintWriter(arquivoDeSaida);
		
		System.out.println("---------------------Confirma��o do Pedido-----------------------------");
		System.out.println(PedidoFinal);
		System.out.println(BebidaFinal);
		System.out.println(VinhoFinal);
		System.out.println("Valor total do pedido: " + ValorFinal + System.lineSeparator());
		System.out.println("---------------------Observa��o-----------------------------");
		System.out.println(Obs);
		
		if(cont2 == 1) {
			gravador.println("---------------------Confirma��o do Pedido-----------------------------");
			gravador.println(PedidoFinal);
			gravador.println(BebidaFinal);
			gravador.println(VinhoFinal);
			gravador.println("Valor total do pedido: " + ValorFinal + System.lineSeparator());
			gravador.println("---------------------Observa��o-----------------------------");
			gravador.println(Obs);
			System.out.println("-----------------PEDIDO REALIZADO COM SUCESSO---------------");
		}
		
		gravador.close();
		arquivoDeSaida.close();
	}
}