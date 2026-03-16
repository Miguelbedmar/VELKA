package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelFinJuego extends JLabel implements ActionListener {
	private JpanelMenu menu;
	private JButton volverMenu;
	private JButton salir;
	private JFrame principal;

	public JLabelFinJuego(JFrame principal) {
		this.principal = principal;
		setOpaque(false);
		setLayout(null);
		setText("FIN DE JUEGO");

		volverMenu = new JButton("MENU INICIO");
		setBounds(200, 350, 350, 100);

		salir = new JButton("SALIR DEL JUEGO ");
		setBounds(200, 350, 350, 100);
		add(menu);
		volverMenu.addActionListener(menu);
		add(salir);
		salir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == volverMenu) {
			menu = new JpanelMenu();

		}

		if (e.getSource() == salir) {
			System.exit(0);

		}

	}

}
