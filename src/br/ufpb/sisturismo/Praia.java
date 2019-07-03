package br.ufpb.sisturismo;

public class Praia extends AtrativoNatural {
	private String perigoTubarao;
	private String propriaParaBanho;
	private String orla;

	
	public Praia(String nome, double latitude, double longitude, String comoChegar,String site, String perigoTubarao, String propriaParaBanho,String orla, String infoContato) {
		super(nome, latitude, longitude, comoChegar, site, infoContato, perigoTubarao, propriaParaBanho, orla);
		this.perigoTubarao = perigoTubarao;
		this.propriaParaBanho = propriaParaBanho;
		this.orla = orla;
		
	}
	
	public String getDescricao() {
		return "Praia de nome:" + super.getNome() +"\nlatitude:" + super.getLatitude() + "\nlongitude: "
				+ super.getLongitude() + "\nComo Chegar:" + super.getComoChegar()+"\nPerigo de Tubarão; "+this.perigoTubarao+"\nPropria para banho: "+this.propriaParaBanho+"\nOrla: "+this.orla;
	}

}