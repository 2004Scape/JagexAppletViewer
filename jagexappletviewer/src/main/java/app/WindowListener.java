package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

final class WindowListener extends WindowAdapter implements ActionListener {
	private static WindowListener a;

	public final void windowClosing(WindowEvent event) {
		appletviewer.shutdown((int) 96);
	}

	static final WindowListener create(int flowObfuscator) {
		if (a == null) {
			a = new WindowListener();
		}

		if (flowObfuscator != -21945) {
			create(57);
		}

		return a;
	}

	public final void actionPerformed(ActionEvent event) {
		appletviewer.shutdown((int) 122);
	}

	private WindowListener() {
	}
}
