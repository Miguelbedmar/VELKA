package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

public class JFramePrincipal extends JFrame {

	JpanelMenu panel = new JpanelMenu();

	public JFramePrincipal() {
		this.setTitle("VELKA");
		this.setSize(new Dimension(700, 700));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel, BorderLayout.CENTER);
	}

}
