package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelMenu extends JPanel {
	public Dimension dimension;

	@Override
	public void paint(Graphics g) {
		dimension.getSize();
		ImageIcon fondo = new ImageIcon(getClass().getResource("/recursos/FONDOMENU.png"));
		g.drawImage(fondo.getImage(), 0, 0, dimension.width, dimension.height, null);
		setOpaque(false);
		super.paintChildren(g);
	}

}
