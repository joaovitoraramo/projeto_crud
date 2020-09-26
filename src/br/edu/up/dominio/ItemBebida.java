package br.edu.up.dominio;

public class ItemBebida {
	
	private String nomeBebida;
	private double valorBebida;
	
	public ItemBebida(String nomeBebida, double valorBebida) {
		this.nomeBebida = nomeBebida;
		this.valorBebida = valorBebida;
	}
	
	public ItemBebida(String valorBebida, String nomeBebida) {
		this.nomeBebida = nomeBebida;
		this.valorBebida = Double.parseDouble(valorBebida);
	}

	public String getNomeBebida() {
		return nomeBebida;
	}

	public void setNomeBebida(String nomeBebida) {
		this.nomeBebida = nomeBebida;
	}

	public double getValorBebida() {
		return valorBebida;
	}

	public void setValorBebida(double valorBebida) {
		this.valorBebida = valorBebida;
	}
	
	public String toString() {
		return valorBebida + "\t" + nomeBebida;
	}
}