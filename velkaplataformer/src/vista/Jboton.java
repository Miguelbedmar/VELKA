package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Jboton extends JPanel implements ActionListener {
	public JButton empezar;
	public JButton controles;
	public JButton salir;

	public void Jboton1configurar() {
		empezar = new JButton("EMPEZAR");
		empezar.setBounds(250, 200, 140, 300);
		add(empezar);
		empezar.addActionListener(this);
	}

	public void Jboton2configurar() {
		controles = new JButton("CONTROLES");
		controles.setBounds(250, 200, 140, 300);
		add(controles);
		controles.addActionListener(this);
	}

	public void Jboton3configurar() {
		salir = new JButton("SALIR");
		salir.setBounds(100, 200, 150, 50);
		add(salir);
		salir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == empezar) {
			
		}
		if (e.getSource() == controles) {

		}
		if (e.getSource() == salir) {
			System.exit(0);
		}
	}
}
