package vista;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMenu extends JPanel implements ActionListener {
	JButton empezar;
	JButton controles;
	JButton salir;

	@Override
	public void paint(Graphics g) {
		Graphics2D gd2 = (Graphics2D) g;
		gd2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		Dimension dimension = this.getSize();
		ImageIcon icon = new ImageIcon(getClass().getResource("/recursos/FONDOMENU.png"));
		g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
		setOpaque(false);
		super.paintChildren(g);
	}

	public void botonesMenu() {
		empezar = new JButton(); // instanciamos boton
		empezar.setText("EMPEZAR");
		empezar.setBounds(10, 20, 150, 200); // Indicamos x y altura y anchura del boton
		empezar.add(empezar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
