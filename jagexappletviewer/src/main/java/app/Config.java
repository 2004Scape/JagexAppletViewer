package app;

import java.util.Hashtable;

final class Config {
	Hashtable properties = new Hashtable();
	String name;
	Hashtable params = new Hashtable();
	Hashtable localization = new Hashtable();

	Config(String name) {
		this.name = name;
	}
}
