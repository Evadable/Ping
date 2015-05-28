package tutorial.generic;

import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class yes extends Gui {

	static ArrayList<Object> yea = new ArrayList<Object>();

	@SubscribeEvent
	public void render(RenderGameOverlayEvent.Post event) throws IOException {
		try {

			if (event.type == ElementType.TEXT && yea.size() != 0) {
				String j = ((String) yea.get(yea.size() - 1)).replace("ms", "");
				String str = j.replace("time=", "");
				String str2 = str.split("ms")[0];
				String str3 = str2.replace("bytes" + "=32", "");
				String stra = (str3.substring(str3.indexOf(":") + 1));
				drawString(
						FMLClientHandler.instance().getClient().fontRendererObj,
						stra + "ms", 40, 40, 0xffffff);
			}
		} finally {
		}
	}
	Thread thread = new Thread() {
		public void run() {
			java.lang.Process p;
			try {
				final java.lang.Runtime run = java.lang.Runtime.getRuntime();
				p = run.exec("ping eu.badlion.net -t");
				int x = 1;
				while (x != 0) {
					java.io.BufferedReader Buffer = new java.io.BufferedReader(
							new java.io.InputStreamReader(p.getInputStream()));
					yea.add(Buffer.readLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	{
		thread.start();
	}
}
