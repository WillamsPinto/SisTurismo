package br.ufpb.sisturismo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufpb.sisturismo.Exception.AtrativoNaoExisteException;
import br.ufpb.sisturismo.Exception.AtrativoJaExisteException;

public class Municipio {
	private String nome;
	private int populacao;
	private List<AtrativoTuristico> atrativoTuristicos;
	private List<MeioDeHospedagem> meioDeHospedagem;
	private double latitude;
	private double longitude;
	private String estado;
	private String site;
	
	
	
	public Municipio(String nome, String estado, String site, double longitude, double latitude, int populacao) {
		this.nome = nome;
		this.populacao = populacao;
		this.latitude = latitude;
		this.longitude = longitude;
		this.estado = estado;
		this.site = site;
		this.atrativoTuristicos = new ArrayList();
		this.meioDeHospedagem = new ArrayList();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;;
	}
	
	public int getPopulacao() {
		return this.populacao;
	}
	
	public void setPopulacao(int populacao) {
		this.populacao = populacao;;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(int latitude) {
		this.latitude = latitude;;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(int longitude) {
		this.longitude = longitude;;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;;
	}
	
	public String getSite() {
		return this.site;
	}
	
	public void setSite(String site) {
		this.site = site;;
	}
	
	public List<AtrativoTuristico> getAtrativosTuristicos(){
		return this.atrativoTuristicos;
		
	}
	
	public List<MeioDeHospedagem> getMeioDeHospedagem(){
		return this.meioDeHospedagem;
		
	}
	
	public String getDescricao(){
		return "\nNome: "+this.getNome()+"\nEstado: "+this.getEstado()+"\nSite: "+this.getSite()+"\nLongitude: "+this.getLongitude()+"\nLatitude: "+this.getLatitude()+"\nPopulação: "+this.getPopulacao();
	
	}
	
	public AtrativoTuristico pesquisaAtrativoTuristico(String nomeAtrativo) throws AtrativoNaoExisteException{
		boolean existe = false;
		for(AtrativoTuristico a: this.atrativoTuristicos) {
			if(a.getNome().equals(nomeAtrativo)) {
				existe = true;
				if(!existe){
					return a;
				}else{
					JOptionPane.showMessageDialog(null,"Atrativo"+nomeAtrativo+"não existe");
			}
			break;
		}
	}
	return null;
}
	
	public void cadastrarAtrativoTuristico(AtrativoTuristico atrativo) throws AtrativoJaExisteException{
		boolean existe = false;
		for(AtrativoTuristico a: this.atrativoTuristicos){
			if(a.getNome().equals(atrativo.getNome())){
				existe = true;
				break;
			}
		}
		if(!existe){
			this.atrativoTuristicos.add(atrativo);
		}else{
			JOptionPane.showMessageDialog(null, "Já existe o atrativo "+atrativo.getNome());
		}
	}
	
	public void cadastrarMeioDeHospedagem(MeioDeHospedagem hospedagem) throws AtrativoJaExisteException{
		boolean existe = false;
		for(AtrativoTuristico a: this.atrativoTuristicos){
			if(a.getNome().equals(hospedagem.getNome())){
				existe = true;
				break;
			}
		}
		if(!existe){
			this.meioDeHospedagem.add(hospedagem);
		}else{
			JOptionPane.showMessageDialog(null, "Já existe o atrativo "+hospedagem.getNome());
		}
	}
}