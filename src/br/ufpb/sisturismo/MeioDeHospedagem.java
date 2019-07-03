package br.ufpb.sisturismo;

public class MeioDeHospedagem {
	private String nome;
	private String site;
	private double latitude;
	private double longitude;
	private String infoContato;
	private String tipoHospedagem;
	private Endereco endereco;

	public MeioDeHospedagem(String nome,String site, double latitude, double longitude, String infoContato, String tipoHospedagem,
			Endereco endereco) {
		super();
		this.nome = nome;
		this.site = site;
		this.latitude = latitude;
		this.longitude = longitude;
		this.infoContato = infoContato;
		this.tipoHospedagem = tipoHospedagem;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSite() {
		
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getInfoContato() {
		return infoContato;
	}

	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}

	public String getTipoHospedagem() {
		return tipoHospedagem;
	}

	public void setTipoHospedagem(String tipoHospedagem) {
		this.tipoHospedagem = tipoHospedagem;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getDescricao() {
		
		return "Evendo de nome:"+getNome()+"\nSite: "+getSite()+"\nInfo Contato:"+getInfoContato()+"\nEndereco: \n"+this.endereco.toString();
	}

}