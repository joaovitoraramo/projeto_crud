package br.edu.up.dominio;

public class ItemPrato {
	
	private String nomePrato;
	private double valorPrato;
	
	public ItemPrato(String nomePrato, double valorPrato) {
		this.nomePrato = nomePrato;
		this.valorPrato = valorPrato;
	}
	
	public ItemPrato(String nomePrato, String valorPrato) {
		this.nomePrato = nomePrato;
		this.valorPrato = Double.parseDouble(valorPrato);
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public double getValorPrato() {
		return valorPrato;
	}

	public void setValorPrato(double valorPrato) {
		this.valorPrato = valorPrato;
	}
	
	public String toString() {
		return nomePrato + ";" + valorPrato;
	}
}