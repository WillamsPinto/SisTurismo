package br.ufpb.sisturismo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeEventos {
	public void gravaEventos(List<EventoProgramado> eventos, String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			gravador.write(eventos.size() + "\n");
			for (EventoProgramado ev : eventos) {
				gravador.write(ev.getNome() + "\n");
				gravador.write(ev.getLatitude() + "\n");
				gravador.write(ev.getLongitude() + "\n");
				gravador.write(ev.getComoChegar() + "\n");
				gravador.write(ev.getSite() + "\n");
				gravador.write(ev.getInfoContato() + "\n");
				gravador.write(ev.getDataInicio() + "\n");
				gravador.write(ev.getDataFim() + "\n");
				gravador.write(ev.getTipo() + "\n");

			}
		} finally {
			if (gravador != null) {
				gravador.close(); // fecha o stream(fluxo) de escrita
			}
		}
	}

	public List<EventoProgramado> recuperaEventos(String nomeArquivo) throws IOException {
		BufferedReader leitor = null;
		List<EventoProgramado> eventosLidos = new ArrayList<EventoProgramado>();
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
						String dataInicio = leitor.readLine();
						String dataFim = leitor.readLine();
						String tipo = leitor.readLine();
						EventoProgramado ev = new EventoProgramado(nome, latitude, longitude, comoChegar, site,
								infoContato, dataInicio, dataFim, tipo);

						eventosLidos.add(ev);
					}
				}
			} while (texto != null); // vai ser null quando chegar no fim do
										// arquivo
		} finally {
			if (leitor != null) {
				leitor.close(); // fecha o stream(fluxo) de leitura
			}
		}
		return eventosLidos;
	}
}