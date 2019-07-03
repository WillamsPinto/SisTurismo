package br.ufpb.sisturismo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufpb.sisturismo.Exception.AtrativoJaExisteException;
import br.ufpb.sisturismo.Exception.MunicipiosJaExisteException;
import br.ufpb.sisturismo.Exception.MunicipiosNaoExisteException;

public class AreaDeInteresseTuristico {
	List<Municipio> municipios;
	private String nome;
	
	public AreaDeInteresseTuristico(String nome, List<Municipio> municipios) {
		this.nome = nome;
		this.municipios = municipios;
	}
	
	public AreaDeInteresseTuristico(String nome) {
		this(nome, new ArrayList<Municipio>());
	}
	
	public AreaDeInteresseTuristico() {
		this("");
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void cadastrarMunicipio(Municipio mun) throws MunicipiosJaExisteException{
		boolean existe = false;
		for(Municipio m: this.municipios){
			if(m.getNome().equals(mun.getNome())){
				existe = true;
				break;
			}
		}
		if(!existe){
			this.municipios.add(mun);
		}else{
			JOptionPane.showMessageDialog(null, "Já existe o municipio "+mun.getNome());
		}
		
	}
	
	public List<Municipio> getMunicipios(){
		return this.municipios;
	}
	
	public Municipio pesquisaMunicipio(String nomeMunicipio) {
		for(Municipio m: this.municipios) {
			if(m.getNome().equals(nomeMunicipio)) {
				return m;
			}
		}
		return null;
	}
	
	
	public void cadastrarAtrativoTuristico(AtrativoTuristico atrativo, String nomeMunicipio, String estadoMunicipio) throws MunicipiosNaoExisteException, AtrativoJaExisteException {
		boolean existeMuni = false;
		boolean existeAtrativo = false;
		for(Municipio m: this.municipios) {
			if(m.getNome().equals(nomeMunicipio)) {
				existeMuni = true;
				existeAtrativo = true;
				if((existeMuni == true) && (existeAtrativo == true)){
					m.cadastrarAtrativoTuristico(atrativo);
				}else if(existeMuni == false){
					JOptionPane.showMessageDialog(null, "Municipio Não existe");
				}else if(existeAtrativo == false) {
					JOptionPane.showMessageDialog(null, "Evento Já existe");
				}
				break;
			}
			
		}
		
	}
	
	public List<AtrativoTuristico> getAtrativosTuristicosDoMunicipio(String nomeMunicipio, String estadoMunicipio) throws MunicipiosNaoExisteException{
		boolean existeMuni = false;
		for(Municipio m: this.municipios) {
			if(m.getNome().equals(nomeMunicipio)) {
				existeMuni = true;
				break;
			}
		}
		if(existeMuni == true) {
			return pesquisaMunicipio(nomeMunicipio).getAtrativosTuristicos();
		}else {
			JOptionPane.showMessageDialog(null, "Municipio não existe!");
			return null;
		}
	}
	
	public void cadastrarMeioDeHospedagem(MeioDeHospedagem hospedagem, String nomeMunicipio, String estadoMunicipio) throws MunicipiosNaoExisteException, AtrativoJaExisteException {
		boolean existeMuni = false;
		boolean existeAtrativo = false;
		for(Municipio m: this.municipios) {
			if(m.getNome().equals(nomeMunicipio)) {
				existeMuni = true;
				existeAtrativo = true;
				if((existeMuni == true) && (existeAtrativo == true)){
					m.cadastrarMeioDeHospedagem(hospedagem);
				}else if(existeMuni == false){
					JOptionPane.showMessageDialog(null, "Municipio Não existe");
				}else if(existeAtrativo == false) {
					JOptionPane.showMessageDialog(null, "Evento Já existe");
				}
				break;
			}
			
		}
	}
	
	public List<MeioDeHospedagem> getMeioDeHospedagemDoMunicipio(String nomeMunicipio, String estadoMunicipio) throws MunicipiosNaoExisteException{
		boolean existeMuni = false;
		for(Municipio m: this.municipios) {
			if(m.getNome().equals(nomeMunicipio)) {
				existeMuni = true;
				break;
			}
		}
		if(existeMuni == true) {
			return pesquisaMunicipio(nomeMunicipio).getMeioDeHospedagem();
		}else {
			JOptionPane.showMessageDialog(null, "Municipio não existe!");
			return null;
		}
	}
}