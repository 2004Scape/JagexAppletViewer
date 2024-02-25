package app;

import java.util.Hashtable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/q")
public final class Language {

	@OriginalMember(owner = "jagexappletviewer!app/q", name = "a", descriptor = "(II)V")
	public static void load(@OriginalArg(0) int lang) {
		@Pc(3) Hashtable table = AppletViewer.localization;
		table.clear();

		if (lang == 0) {
			table.put("err_missing_config", "Missing com.jagex.config setting");
			table.put("err_invalid_config", "Invalid com.jagex.config setting");
			table.put("loading_config", "Loading configuration");
			table.put("err_load_config", "There was an error loading the game configuration from the website.\nIf you have a firewall, check that this program is allowed to access the Internet.");
			table.put("err_decode_config", "Error decoding configuration");
			table.put("loaderbox_initial", "Loading...");
			table.put("error", "Error");
			table.put("quit", "Quit");
		} else if (lang == 1) {
			table.put("err_missing_config", "Einstellung com.jagex.config fehlt");
			table.put("err_invalid_config", "Einstellung com.jagex.config ist ungültig");
			table.put("loading_config", "Lade Konfiguration");
			table.put("err_load_config", "Beim Laden der Spielkonfiguration von der Website ist ein Fehler aufgetreten.\nBitte überprüfen Sie Ihre Firewall-Einstellungen.");
			table.put("err_decode_config", "Fehler beim Entschlüsseln der Konfiguration");
			table.put("loaderbox_initial", "Lade...");
			table.put("error", "Fehler");
			table.put("quit", "Beenden");
		} else if (lang == 2) {
			table.put("err_missing_config", "Paramètre com.jagex.config manquant");
			table.put("err_invalid_config", "Paramètre com.jagex.config non valide");
			table.put("loading_config", "Chargement de la configuration");
			table.put("err_load_config", "Une erreur s'est produite lors du chargement de la configuration du jeu.\nSi un pare-feu est actif sur votre ordinateur, assurez-vous\nqu'il laisse ce programme accéder à internet.");
			table.put("err_decode_config", "Erreur de décodage de configuration");
			table.put("loaderbox_initial", "Chargement...");
			table.put("error", "Erreur");
			table.put("quit", "Quitter");
		} else if (lang == 3) {
			table.put("err_missing_config", "Faltando configuração de com.jagex.config");
			table.put("err_invalid_config", "Configuração inválida de com.jagex.config");
			table.put("loading_config", "Carregando configuração");
			table.put("err_load_config", "Houve um erro quando a configuração do jogo estava sendo carregada no site.\nSe você tiver firewall, verifique se o programa pode ter acesso à internet.");
			table.put("err_decode_config", "Erro ao decodificar configuração");
			table.put("loaderbox_initial", "Carregando...");
			table.put("error", "Erro");
			table.put("quit", "Fechar");
		} else if (lang == 4) {
			table.put("err_missing_config", "Missing com.jagex.config setting");
			table.put("err_invalid_config", "Invalid com.jagex.config setting");
			table.put("loading_config", "Loading config");
			table.put("err_load_config", "Error loading config");
			table.put("err_decode_config", "Error decoding config");
			table.put("loaderbox_initial", "Loading...");
			table.put("error", "Error");
			table.put("quit", "Quit");
		} else if (lang == 5) {
			table.put("err_missing_config", "Missing com.jagex.config setting");
			table.put("err_invalid_config", "Invalid com.jagex.config setting");
			table.put("loading_config", "Loading config");
			table.put("err_load_config", "Error loading config");
			table.put("err_decode_config", "Error decoding config");
			table.put("loaderbox_initial", "Loading...");
			table.put("error", "Error");
			table.put("quit", "Quit");
		}
	}
}
