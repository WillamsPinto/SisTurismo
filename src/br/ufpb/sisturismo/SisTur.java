package br.ufpb.sisturismo;

import br.ufpb.sisturismo.Menus;

public class SisTur {
	public static void main(String[] args) {
		
		boolean sair = false;
		while (!sair) {
			int escolha = Menus.menu();
			switch (escolha) {
			case 1:// Cadastrar
				Menus.menuCadastrar();
				break;
			case 2:// Listar
				Menus.menuListar();
				break;
			case 3:// Recuperar
				Menus.menuRecuperar();
				break;
			case 4:// Sair
				Menus.sair();
				sair = true;
				break;
			}
		}
	}
}
