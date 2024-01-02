package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class DialogLanguage implements ActionListener {
	public final void actionPerformed(ActionEvent event) {
		label31:
		{
			boolean var4 = Preferences.dialogVisible;
			int var2 = event.getID();
			if (0 != var2 || var4) {
				if (var2 != 1) {
					return;
				}

				if (!var4) {
					break label31;
				}
			}

			if (-1 < ~appletviewer.a((int) 113)) {
				return;
			}

			DialogMessage.showMessage(0, appletviewer.c(1555, "changes_on_restart"));
			if (!var4) {
				return;
			}
		}

		appletviewer.c((byte) -90);
	}
}
