package br.ufpb.sisturismo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeAtrativoNatural {
	public void gravaAtrativoNatural(List<AtrativoNatural> eventos, String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			gravador.write(eventos.size() + "\n");
			for (AtrativoNatural ev : eventos) {
				gravador.write(ev.getResultado());
			}
		} finally {
			if (gravador != null) {
				gravador.close(); // fecha o stream(fluxo) de escrita
			}
		}
	}

	public List<AtrativoNatural> recuperaAtrativoNatural(String nomeArquivo) throws IOException {
		BufferedReader leitor = null;
		List<AtrativoNatural> atrativosNaturaisLidos = new ArrayList<AtrativoNatural>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine(); // lê a próxima linha do arquivo
				if (texto != null) {
					int quantidadeEventos = Integer.parseInt(texto);
					for (int i = 0; i < quantidadeEventos; i++) {
						String nome = leitor.readLine();
						double latitude = Double.parseDouble(leitor.readLine());
						double longitude = Double.parseDouble(leitor.readLine());
						String comoChegar = leitor.readLine();
						String site = leitor.readLine();
						String infoContato = leitor.readLine();
						String perigoTubarao = leitor.readLine();
						String propriaParaBanho = leitor.readLine();
						String orla = leitor.readLine();
						AtrativoNatural atra = new AtrativoNatural(nome, latitude, longitude, comoChegar, site,
								infoContato,  perigoTubarao , propriaParaBanho, orla);

						atrativosNaturaisLidos.add(atra);
					}
				}
			} while (texto != null); // vai ser null quando chegar no fim do
										// arquivo
		} finally {
			if (leitor != null) {
				leitor.close(); // fecha o stream(fluxo) de leitura
			}
		}
		return atrativosNaturaisLidos;
	}
}