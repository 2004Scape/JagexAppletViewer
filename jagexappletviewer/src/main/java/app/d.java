package app;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class d implements ActionListener {
	private Dialog a;

	public final void actionPerformed(ActionEvent var1) {
		this.a.setVisible(false);
	}

	d() {
		this.a = DialogMessage.a;
	}
}
