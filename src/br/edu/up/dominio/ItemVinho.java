package br.edu.up.dominio;

public class ItemVinho {
	
	private String nomeVinho;
	private double valorVinho;
	
	public ItemVinho(String nomeVinho, double valorVinho) {
		this.nomeVinho = nomeVinho;
		this.valorVinho = valorVinho;
	}
	
	public ItemVinho(String valorVinho, String nomeVinho) {
		this.nomeVinho = nomeVinho;
		this.valorVinho = Double.parseDouble(valorVinho);
	}

	public String getNomeVinho() {
		return nomeVinho;
	}

	public void setNomeVinho(String nomeVinho) {
		this.nomeVinho = nomeVinho;
	}

	public double getValorVinho() {
		return valorVinho;
	}

	public void setValorVinho(double valorVinho) {
		this.valorVinho = valorVinho;
	}
	
	public String toString() {
		return valorVinho + "\t" + nomeVinho;
	}
}