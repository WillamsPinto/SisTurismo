package br.ufpb.sisturismo;

public class Endereco {
	private String logradouro;
	private String numero;
	private String bairro;

	public Endereco(String logradouro, String numero, String bairro) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.logradouro = bairro;
	}

	public String toString() {
		return "Logradouro: " + logradouro + "\nNumero:" + numero + "\nBairro:" + bairro;
	}

}
