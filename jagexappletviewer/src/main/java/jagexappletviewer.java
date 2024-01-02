import app.appletviewer;

public class jagexappletviewer {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.exit(0);
		}

		appletviewer.b(65, args[0]);
	}
}
