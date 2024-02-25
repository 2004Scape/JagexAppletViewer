package app;

import java.util.Hashtable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("jagexappletviewer!app/q")
public final class Class11 {

	@OriginalMember(owner = "jagexappletviewer!app/q", name = "a", descriptor = "(II)V")
	public static void method41(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(3) Hashtable local3 = appletviewer.aHashtable3;
		if (arg1 != -11712) {
			return;
		}
		local3.clear();
		if (arg0 == 0) {
			local3.put("err_missing_config", "Missing com.jagex.config setting");
			local3.put("err_invalid_config", "Invalid com.jagex.config setting");
			local3.put("loading_config", "Loading configuration");
			local3.put("err_load_config", "There was an error loading the game configuration from the website.\nIf you have a firewall, check that this program is allowed to access the Internet.");
			local3.put("err_decode_config", "Error decoding configuration");
			local3.put("loaderbox_initial", "Loading...");
			local3.put("error", "Error");
			local3.put("quit", "Quit");
		} else if (arg0 == 1) {
			local3.put("err_missing_config", "Einstellung com.jagex.config fehlt");
			local3.put("err_invalid_config", "Einstellung com.jagex.config ist ungültig");
			local3.put("loading_config", "Lade Konfiguration");
			local3.put("err_load_config", "Beim Laden der Spielkonfiguration von der Website ist ein Fehler aufgetreten.\nBitte überprüfen Sie Ihre Firewall-Einstellungen.");
			local3.put("err_decode_config", "Fehler beim Entschlüsseln der Konfiguration");
			local3.put("loaderbox_initial", "Lade...");
			local3.put("error", "Fehler");
			local3.put("quit", "Beenden");
		} else if (arg0 == 2) {
			local3.put("err_missing_config", "Paramètre com.jagex.config manquant");
			local3.put("err_invalid_config", "Paramètre com.jagex.config non valide");
			local3.put("loading_config", "Chargement de la configuration");
			local3.put("err_load_config", "Une erreur s'est produite lors du chargement de la configuration du jeu.\nSi un pare-feu est actif sur votre ordinateur, assurez-vous\nqu'il laisse ce programme accéder à internet.");
			local3.put("err_decode_config", "Erreur de décodage de configuration");
			local3.put("loaderbox_initial", "Chargement...");
			local3.put("error", "Erreur");
			local3.put("quit", "Quitter");
		} else if (arg0 == 3) {
			local3.put("err_missing_config", "Faltando configuração de com.jagex.config");
			local3.put("err_invalid_config", "Configuração inválida de com.jagex.config");
			local3.put("loading_config", "Carregando configuração");
			local3.put("err_load_config", "Houve um erro quando a configuração do jogo estava sendo carregada no site.\nSe você tiver firewall, verifique se o programa pode ter acesso à internet.");
			local3.put("err_decode_config", "Erro ao decodificar configuração");
			local3.put("loaderbox_initial", "Carregando...");
			local3.put("error", "Erro");
			local3.put("quit", "Fechar");
		} else if (arg0 == 4) {
			local3.put("err_missing_config", "Missing com.jagex.config setting");
			local3.put("err_invalid_config", "Invalid com.jagex.config setting");
			local3.put("loading_config", "Loading config");
			local3.put("err_load_config", "Error loading config");
			local3.put("err_decode_config", "Error decoding config");
			local3.put("loaderbox_initial", "Loading...");
			local3.put("error", "Error");
			local3.put("quit", "Quit");
		} else if (arg0 == 5) {
			local3.put("err_missing_config", "Missing com.jagex.config setting");
			local3.put("err_invalid_config", "Invalid com.jagex.config setting");
			local3.put("loading_config", "Loading config");
			local3.put("err_load_config", "Error loading config");
			local3.put("err_decode_config", "Error decoding config");
			local3.put("loaderbox_initial", "Loading...");
			local3.put("error", "Error");
			local3.put("quit", "Quit");
		}
	}
}
