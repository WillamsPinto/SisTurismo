package br.ufpb.sisturismo;

public class AtrativoNatural extends AtrativoTuristico {
	String perigoTubarao;
	String propriaParaBanho;
	String orla;
	
	public AtrativoNatural(String nome, double latitude, double longitude, String comoChegar, String site,
			String infoContato,String perigoTubarao ,String propriaParaBanho,String orla) {
		super(nome, latitude, longitude, comoChegar, site, infoContato);
		this.perigoTubarao = perigoTubarao;
		this.propriaParaBanho = propriaParaBanho;
		this.orla = orla;
	}
	
	public String getResultado() {
		return  super.getNome() + "\n"+ super.getLatitude() + "\n"+ super.getLongitude() + "\n"+ super.getComoChegar()  + "\n"+ super.getSite()+"\n"+super.getInfoContato()+"\n"+this.perigoTubarao+"\n"+this.propriaParaBanho+"\n"+this.orla+"\n";
	}
	public String getDescricao() {
		return "Atrativo natural de nome:" + super.getNome() + "\nlatitude:" + super.getLatitude() + "\nlongitude: "
				+ super.getLongitude() + "\nComo Chegar:" + super.getComoChegar() + "\nSite:" + super.getSite()+"\n Tem Algum Perigo:"+this.perigoTubarao+"\n É prorpio para banho: "+this.propriaParaBanho+"\n Possui Orla: "+this.orla;
	}

	
}