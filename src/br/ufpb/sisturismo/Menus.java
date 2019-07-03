package br.ufpb.sisturismo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufpb.sisturismo.Exception.AtrativoJaExisteException;
import br.ufpb.sisturismo.Exception.MunicipiosJaExisteException;
import br.ufpb.sisturismo.Exception.MunicipiosNaoExisteException;

public class Menus {
	private static AreaDeInteresseTuristico areDeInteresse = new AreaDeInteresseTuristico("A1");
	private static GravadorDeEventos gravadorEvento = new GravadorDeEventos();
	private static GravadorDeAtrativoNatural gravadorAtrativoNatural = new GravadorDeAtrativoNatural();

	public static int menu() {
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
				"----Sistema Turistico ---- \nEscolha:\n1 - Cadastrar \n2 - Listar \n3 - Recuperar \n4 -Sair"));
		return escolha;
	}

	public static void menuCadastrar(){
		int escolhaCadastrar = Integer.parseInt(JOptionPane.showInputDialog(null,
				"---- Cadastrar ---- \nEscolha:\n1 - Cadastrar Municipio \n2 - Cadastrar Meio De Hospedagem\n3 - Cadastrar Atrativo Turistico \n4 - Voltar"));
		switch (escolhaCadastrar) {
		case 1://Cadastrar Municipios

			String nomeMuni = JOptionPane.showInputDialog(null, "Digite o nome do Municipio:");

			String estadoMuni = JOptionPane.showInputDialog(null, "Digite o estado do Municipio:");

			String siteMuni = JOptionPane.showInputDialog(null, "Digite o site do Municipio:");

			double longiMuni = Double
					.parseDouble(JOptionPane.showInputDialog(null, "Digite a longitude do Municipio:"));

			double latiMuni = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a latitude do Municipio:"));

			int populacaoMuni = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a população do Municipio:"));

			Municipio mun = new Municipio(nomeMuni, estadoMuni, siteMuni, longiMuni, latiMuni, populacaoMuni);

			try {
				areDeInteresse.cadastrarMunicipio(mun);
				JOptionPane.showMessageDialog(null, "Municipio cadastrado com sucesso!");
			} catch (MunicipiosJaExisteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		case 2:// Cadastrar Meio De Hospedagem
			String nomeHospedagem = JOptionPane.showInputDialog("Digite o nome da Hospedagem:");

			double latiHospedagem = Double.parseDouble(JOptionPane.showInputDialog("Digite a latitude da Hospedagem:"));

			double longiHospedagem = Double
					.parseDouble(JOptionPane.showInputDialog("Digite a longitude da Hospedagem:"));

			String siteHospedagem = JOptionPane.showInputDialog("Digite o site da Hospedagem:");

			String infoContatoHospedagem = JOptionPane.showInputDialog("Digite a informação de contato da Hospedagem:");

			String logradouroHospedagem = JOptionPane.showInputDialog("Digite o logradouro da Hospedagem:");

			String numeroHospedagem = JOptionPane.showInputDialog("Digite o número da Hospedagem:");

			String bairroHospedagem = JOptionPane.showInputDialog("Digite o bairro da Hospedagem:");

			String nomeMunicipioHospedagem = JOptionPane.showInputDialog("Digite o municipio da Hospedagem:");

			String nomeEstadoHospedagem = JOptionPane.showInputDialog("Digite o estado da Hospedagem:");

			Endereco enderecoHospedagem = new Endereco(logradouroHospedagem, numeroHospedagem, bairroHospedagem);

			MeioDeHospedagem hospedagem = new MeioDeHospedagem(nomeHospedagem,siteHospedagem, latiHospedagem, longiHospedagem,
					siteHospedagem, infoContatoHospedagem, enderecoHospedagem);

			try {
				areDeInteresse.cadastrarMeioDeHospedagem(hospedagem, nomeMunicipioHospedagem, nomeEstadoHospedagem);
				JOptionPane.showMessageDialog(null, "Hospedagem cadastrada com sucesso!");
			} catch (AtrativoJaExisteException | MunicipiosNaoExisteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;

		case 3:// Cadastrar Atrativo Turistico
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"---- Cadastrar Atrativo Turistico ---- \nEscolha:\n1- Cadastrar Atrativo Natural \n2 - Evento Programado \n3 - Voltar"));
			
			switch(opcao){
			case 1:
				int opcao2 = Integer.parseInt(
						JOptionPane.showInputDialog("---- Atrativo Natural ---- \nEscolha: \n1 - Cadastrar Praia \n2 - Cadastrar Atrativo Natural Generico \n3 - Voltar"));
				switch(opcao2){
					case 1:
						String nomeAtra = JOptionPane.showInputDialog("Digite o nome da Praia:");

						double latiAtra = Integer.parseInt(JOptionPane.showInputDialog("Digite a latitude da Praia:"));

						double longiAtra = Double.parseDouble(JOptionPane.showInputDialog("Digite a longitude da Praia:"));
					
						String comoChegarAtra = JOptionPane.showInputDialog("Digite como chegar a Praia:");
						
						String site = JOptionPane.showInputDialog("Digite o site da Praia:");

						String perigoTubarao = JOptionPane.showInputDialog(null, "Possui Perigo de Tubarão na Praia:");
						
						String propriaParaBanho = JOptionPane.showInputDialog(null, "É propria para banho?:");
						
						String orla = JOptionPane.showInputDialog("Possui Tipo de orla da Praia:");
						
						String infoContatoAtra = JOptionPane.showInputDialog("Digite a informação de contato da Praia:");

						String nomeMunicipio = JOptionPane.showInputDialog("Digite o municipio da praia:");

						String nomeEstado = JOptionPane.showInputDialog("Digite o estado da praia:");

						AtrativoTuristico praia = new Praia(nomeAtra, latiAtra, longiAtra, comoChegarAtra,site, perigoTubarao, propriaParaBanho, orla,
								infoContatoAtra);

						try {
							areDeInteresse.cadastrarAtrativoTuristico(praia, nomeMunicipio, nomeEstado);
							JOptionPane.showMessageDialog(null, "Praia cadastrado com sucesso!");
						} catch (AtrativoJaExisteException | MunicipiosNaoExisteException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}

						break;
					case 2:
						String nomeAtraGenerico = JOptionPane.showInputDialog("Digite o nome do Atrativo:");

						double latiAtraGenerico = Integer.parseInt(JOptionPane.showInputDialog("Digite a latitude do Atrativo:"));

						double longiAtraGenerico = Double.parseDouble(JOptionPane.showInputDialog("Digite a longitude do Atrativo:"));
					
						String comoChegarAtraGenerico = JOptionPane.showInputDialog("Digite como chegar ao Atrativo:");
						
						String perigo = JOptionPane.showInputDialog("Possui algum perigo:");
						
						String propriaParaBanhoNatural = JOptionPane.showInputDialog("Propria para banho?");
						
						String tipoOrla = JOptionPane.showInputDialog("Tipo de Orla: ");

						String siteAtraGenerico = JOptionPane.showInputDialog("Digite o site do Atrativo:");

						String infoContatoAtraGenerico = JOptionPane.showInputDialog("Digite a informação de contato do Atrativo:");

						String nomeMunicipioGenerico = JOptionPane.showInputDialog("Digite o municipio do Atrativo:");

						String nomeEstadoGenerico = JOptionPane.showInputDialog("Digite o estado do Atrativo:");

						AtrativoTuristico atrativoNaturalGenerico = new AtrativoNatural(nomeAtraGenerico, latiAtraGenerico, longiAtraGenerico, comoChegarAtraGenerico, siteAtraGenerico,
								infoContatoAtraGenerico, perigo, propriaParaBanhoNatural, tipoOrla);

						try {
							areDeInteresse.cadastrarAtrativoTuristico(atrativoNaturalGenerico, nomeMunicipioGenerico, nomeEstadoGenerico);
							JOptionPane.showMessageDialog(null, "Praia cadastrado com sucesso!");
						} catch (AtrativoJaExisteException | MunicipiosNaoExisteException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
					case 3:
						menuCadastrar();
						break;
				}
				break;
			case 2:
				String nomeAtraEvento = JOptionPane.showInputDialog("Digite o nome do evento:");

				double latiAtraEvento = Double.parseDouble(JOptionPane.showInputDialog("Digite a latitude de evento:"));

				double longiAtraEvento = Double
						.parseDouble(JOptionPane.showInputDialog("Digite a longitude do evento:"));

				String comoChegarAtraEvento = JOptionPane.showInputDialog("Digite como chegar ao evento:");

				String siteAtraEvento = JOptionPane.showInputDialog("Digite o site do evento:");

				String infoContatoAtraEvento = JOptionPane.showInputDialog("Digite a informação de contato do evento:");

				String dataInicioEvento = JOptionPane.showInputDialog("Digite a data de Inicio do evento:");

				String dataFimEvento = JOptionPane.showInputDialog("Digite a data de Fim do evento:");

				String tipoEvento = JOptionPane.showInputDialog("Digite o tipo do evento:");

				String logradouroEvento = JOptionPane.showInputDialog("Digite o logradouro do evento:");

				String numeroEvento = JOptionPane.showInputDialog("Digite o número do evento:");

				String bairroEvento = JOptionPane.showInputDialog("Digite o bairro do evento:");

				String nomeMunicipio = JOptionPane.showInputDialog("Digite o municipio do evento:");

				String nomeEstado = JOptionPane.showInputDialog("Digite o estado do evento:");

				Endereco enderecoEvento = new Endereco(logradouroEvento, numeroEvento, bairroEvento);

				AtrativoTuristico evento = new EventoProgramado(nomeAtraEvento, latiAtraEvento, longiAtraEvento,
						comoChegarAtraEvento, siteAtraEvento, infoContatoAtraEvento, dataInicioEvento, dataFimEvento,
						tipoEvento, enderecoEvento);

				try {
					areDeInteresse.cadastrarAtrativoTuristico(evento, nomeMunicipio, nomeEstado);
					JOptionPane.showMessageDialog(null, "Evento cadastrado com sucesso!");
				} catch (AtrativoJaExisteException | MunicipiosNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			case 3:
				menu();
				break;
			}
		}
	}

	public static void menuListar() {
		int escolhaListar = Integer.parseInt(JOptionPane.showInputDialog(null,
				"---- Listar ---- \nEscolha:\n1 - Listar Municipios \n2 - Listar atrativo De Determinado Municipios \n3 - Listar Meio De Hospedagem De Determinado Municipio \n4 - Voltar"));

		switch (escolhaListar) {

		case 1:// Listar Municipios
			List<Municipio> listMuni = areDeInteresse.getMunicipios();
			int contMuni = 1;
			for (Municipio m : listMuni) {
				JOptionPane.showMessageDialog(null, "Municipio Nº : " + contMuni + m.getDescricao());
				contMuni += 1;
			}
			break;
		case 2:// Listar Atrativo De Determinado Municipio
			List<Municipio> listAtra = areDeInteresse.getMunicipios();

			String nomeMuniListarAtra = JOptionPane.showInputDialog("Digite o nome do Municipio a pesquisar:");

			for (Municipio m : listAtra) {
				if (m.getNome().equals(nomeMuniListarAtra)) {
					for (AtrativoTuristico atra : m.getAtrativosTuristicos()) {
						JOptionPane.showMessageDialog(null, atra.getDescricao());
					}
				}
			}
			break;
		case 3:// Listar Meio De Hospedagem de Determinado Municipio
			List<Municipio> listHospedagem = areDeInteresse.getMunicipios();

			String nomeMuniListarHospedagem = JOptionPane.showInputDialog("Digite o nome do Municipio a pesquisar:");

			for (Municipio m : listHospedagem) {
				if (m.getNome().equals(nomeMuniListarHospedagem)) {
					for (MeioDeHospedagem hospedagem : m.getMeioDeHospedagem()) {
						JOptionPane.showMessageDialog(null, hospedagem.getDescricao());
					}
				}
			}
			break;
		}
	}

	public static void menuRecuperar() {
		int escolhaRecuperar = Integer.parseInt(JOptionPane.showInputDialog(null,
				"---- Recuperar ---- \nEscolha:\n1 - Recuperar eventos cadastrados \n2 - Recuperar Atrativos Naturais \n3 - Voltar"));

		switch (escolhaRecuperar) {
		case 1:// Recuperar Eventos Programados
			String nomeEvento = JOptionPane.showInputDialog("Qual o evento a recuperar?");
			List<EventoProgramado> evento = null;
			try {
				evento = gravadorEvento.recuperaEventos(nomeEvento + ".txt");
				String muniPesq = JOptionPane.showInputDialog("Qual o municico a interligar");
				Municipio muni = areDeInteresse.pesquisaMunicipio(muniPesq);
				for (EventoProgramado eventoP : evento) {
					muni.cadastrarAtrativoTuristico(eventoP);
				}
				JOptionPane.showMessageDialog(null, "Recuperados com sucesso");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (AtrativoJaExisteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;

		case 2:// Recuperar Atrativos Turisticos
			String nomeAtrativoNatural = JOptionPane.showInputDialog("Qual o atrativo natural a recuperar?");
			List<AtrativoNatural> atrativoNaturalR = null;
			try {
				atrativoNaturalR = gravadorAtrativoNatural.recuperaAtrativoNatural(nomeAtrativoNatural + ".txt");
				String muniPesq = JOptionPane.showInputDialog("Qual o municico a interligar");
				Municipio muni = areDeInteresse.pesquisaMunicipio(muniPesq);
				for (AtrativoNatural atrativoN : atrativoNaturalR) {
					muni.cadastrarAtrativoTuristico(atrativoN);
				}
				JOptionPane.showMessageDialog(null, "Recuperados com sucesso");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (AtrativoJaExisteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			break;
		}
	}

	public static void sair() {
		JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema <3");
		List<Municipio> listaTodosMunicipios = areDeInteresse.getMunicipios();
		for (Municipio m : listaTodosMunicipios) {
			List<EventoProgramado> eventoProgramado = new ArrayList<EventoProgramado>();
			List<AtrativoNatural> atrativoNatural = new ArrayList<AtrativoNatural>();
			for (AtrativoTuristico at : m.getAtrativosTuristicos()) {
				if (at instanceof EventoProgramado) {
					eventoProgramado.add((EventoProgramado) at);
				}
			}

			for (AtrativoTuristico at : m.getAtrativosTuristicos()) {
				if (at instanceof AtrativoNatural) {
					atrativoNatural.add((AtrativoNatural) at);
				}
			}

			try {
				gravadorEvento.gravaEventos(eventoProgramado, "EventoProgramadoDe" + m.getNome() + ".txt");
				gravadorAtrativoNatural.gravaAtrativoNatural(atrativoNatural,
						"AtrativoNaturalDe" + m.getNome() + ".txt");
				JOptionPane.showMessageDialog(null, "Arquivos Gravados Com Sucesso" + m.getNome() + ".txt");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}
}
