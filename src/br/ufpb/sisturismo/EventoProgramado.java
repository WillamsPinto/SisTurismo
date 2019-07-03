package br.ufpb.sisturismo;

public class EventoProgramado extends AtrativoTuristico{
	private String dataInicio;
	private String dataFim;
	private String tipo;
	private Endereco endereco;
	
	public EventoProgramado(String nome, double latitude, double longitude, String comoChegar, String site, String infoContato,String dataInicio, String dataFim, String tipo, Endereco endereco) {
		super(nome, latitude, longitude, comoChegar, site, infoContato);
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipo = tipo;
		this.endereco = endereco;


	}
	
	public EventoProgramado(String nome, double latitude, double longitude, String comoChegar, String site, String infoContato,String dataInicio, String dataFim, String tipo) {
		super(nome, latitude, longitude, comoChegar, site, infoContato);
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.tipo = tipo;


	}

	public String getDataInicio() {
		return this.dataInicio;
	}
	
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getDataFim() {
		return this.dataFim;
	}
	
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Endereco getEndereco(){
		return this.endereco;
	}
	
	public String getDescricao(){
		return "Evendo de nome:"+super.getNome()+"\nSite: "+super.getSite()+"\nComo chegar:"+super.getComoChegar()+"\nInfo Contato:"+super.getInfoContato()/*+"\nEndereco: "+this.endereco.toString()*/;
	}
	
}
