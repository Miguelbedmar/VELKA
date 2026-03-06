package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

public class JFramePrincipal extends JFrame {

	JpanelMenu panel = new JpanelMenu();
	
	public JFramePrincipal() {
		setTitle("VELKA");
		setSize(new Dimension(700, 700));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel, BorderLayout.CENTER);
		ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/VELKAAA.png"));
		setIconImage(icono.getImage());
		
	
	}

}
