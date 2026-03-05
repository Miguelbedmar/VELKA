package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JpanelMenu extends JPanel {
	private ImageIcon fondo;

	public JpanelMenu(String rutaImagen) {
		fondo = new ImageIcon(rutaImagen);
	}

	@Override
	public void paint(Graphics g) {

		Dimension di = getSize();
		g.drawImage(fondo.getImage(), 0, 0, di.width, di.height, null);
		setOpaque(false);
		super.paintChildren(g);

	}

}
