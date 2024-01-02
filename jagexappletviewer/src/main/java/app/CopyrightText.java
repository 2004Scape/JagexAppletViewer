package app;

final class CopyrightText {
	CopyrightLink a = null;
	String b;

	CopyrightText(String var1) {
		this.b = var1;
	}

	CopyrightText(String var1, String var2) {
		this.b = var1;
		this.a = new CopyrightLink(var2);
	}
}
