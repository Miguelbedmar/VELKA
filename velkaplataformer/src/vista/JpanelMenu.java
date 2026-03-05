package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JpanelMenu extends JPanel {
	private Image fondo;

	@Override
	public void paint(Graphics g) {

		Dimension di = new Dimension().getSize();
		fondo = new ImageIcon(getClass().getResource("recursos/FONDOMENU.png")).getImage();
		g.drawImage(fondo, 0, 0, di.width, di.height, this);
		setOpaque(false);
		super.paint(g);

	}

}
