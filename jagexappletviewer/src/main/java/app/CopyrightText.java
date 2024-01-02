package app;

final class CopyrightText {
	CopyrightLink link = null;
	String text;

	CopyrightText(String text) {
		this.text = text;
	}

	CopyrightText(String text, String link) {
		this.text = text;
		this.link = new CopyrightLink(link);
	}
}
