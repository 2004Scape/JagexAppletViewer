package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class s implements ActionListener {
	public final void actionPerformed(ActionEvent var1) {
		label31:
		{
			boolean var4 = ca.c;
			int var2 = var1.getID();
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

			e.b(0, appletviewer.c(1555, "changes_on_restart"));
			if (!var4) {
				return;
			}
		}

		appletviewer.c((byte) -90);
	}
}
