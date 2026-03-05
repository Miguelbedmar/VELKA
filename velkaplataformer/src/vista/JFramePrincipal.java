package vista;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFramePrincipal extends JFrame {

	public JFramePrincipal() {
		setTitle("VELKA"); // Cambiamos el titulo de la pestaña como VELKA
		setSize(700, 550); // Indicamos que anchura y altura tendra
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permite parar el programa cerrando la ventana
		setLocationRelativeTo(null);
		setResizable(false); // Eliminamos la posibilidad de que el usuario redimensione la ventana
		setVisible(true);
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/VELKAAA.png"));
		setIconImage(icono.getImage());
		JpanelMenu menu = new JpanelMenu("/recursos/FONDOMENU.png");
		menu.setLayout(new GridLayout(3, 2, 25, 25));
		
	}

}
