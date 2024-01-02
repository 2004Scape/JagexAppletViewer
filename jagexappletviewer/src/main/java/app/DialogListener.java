package app;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class DialogListener implements ActionListener {
	private Dialog dialog;

	public final void actionPerformed(ActionEvent event) {
		this.dialog.setVisible(false);
	}

	DialogListener() {
		this.dialog = DialogMessage.dialog;
	}
}
