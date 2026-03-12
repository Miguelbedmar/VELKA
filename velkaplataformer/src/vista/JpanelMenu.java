package vista;

import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JpanelMenu extends JPanel implements ActionListener,MouseListener {
	JButton empezar;
	JButton controles;
	JButton salir;
	JPanell1Juego juego;
	 // Constructor de clase en donde se indica que el layout será nulo y se llaman alos metodos de la clase
	public JpanelMenu() { 
		setLayout(null); 
		botonesMenu(); 
		botoncontrol(); 
		botonSalir();
		tituloJuego();
	}

	@Override
	public void paint(Graphics g) {  // El metodo paint es un metodo de la clase JPanel que se encarga de pintar la imagen sobre el panel 

		Dimension dimension = this.getSize();
		ImageIcon icon = new ImageIcon(getClass().getResource("/recursos/FONDOMENU.png")); // Indicamos la ruta de la imagen ya que si no  saltara error ya que dectara que es nulo
		g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
		setOpaque(false); 
		super.paintChildren(g);
	}
	public void tituloJuego() { 
		/* El metodo titulo juego es recoger la ruta de imagen del titulo de velka
		 *parsear dicha imagen a tipo image para escalar la instancia  pegar la imagen a un 
		 *JLabel para luego indiar  X Y ancho y alto y por último añadimos el titulo */
		ImageIcon tituloMenu=new ImageIcon(getClass().getResource("/recursos/TITULOVELKA.png"));			
		Image imagetitu=tituloMenu.getImage().getScaledInstance(250, 200, 0);
		JLabel titulo =new JLabel(new ImageIcon(imagetitu));
		titulo.setBounds(255,2,250,200);
		add(titulo);
	}
	/* Los metodos botonesMenu,botoncontrol y botonSalir se encargan de 
	 * 1. Recoger la ruta de la imagen correspondiente a cada botón
	 * 2. parsear esa imagen de imagenIcon a tipo Image para así
	 * jugar con su escala es decir su ancho y su alto
	 * 3.Instanciar un boton que tendra la imagen 
	 * 4.deshabilitar los bordes del botón por estética
	 * 5.deshabilitar  que automáticamente se rellene el area del botón para
	 * dar ese efecto
	 * */

	public void botonesMenu() {
		
		ImageIcon botonempezar = new ImageIcon(getClass().getResource("/recursos/EMPEZAR.png"));
		Image imagen=botonempezar.getImage().getScaledInstance(350, 200,50);	
		empezar = new JButton(new ImageIcon(imagen)); // instanciamos boton
		empezar.setBorderPainted(false);
		empezar.setContentAreaFilled(false);
		empezar.setFocusPainted(false);
		empezar.addMouseListener(this);
		empezar.setBounds(200,200,350,100);
		add(empezar);
		empezar.addActionListener(this);
	}
	public void botoncontrol() {
		ImageIcon botoncontrol=new ImageIcon(getClass().getResource("/recursos/CONTROLES.png"));
		Image imgc=botoncontrol.getImage().getScaledInstance(350, 200, 50);
		controles=new JButton(new ImageIcon(imgc));
		controles.setBorderPainted(false);
		controles.setContentAreaFilled(false);
		controles.setFocusPainted(false);
		controles.addMouseListener(this);
		controles.setBounds(200,350,350,100);
		add(controles);
		controles.addActionListener(this);
	
	}
	public void botonSalir() {
		ImageIcon botonSalir=new ImageIcon(getClass().getResource("/recursos/SALIR.png"));
		Image imgc=botonSalir.getImage().getScaledInstance(350, 200, 50);
		salir=new JButton(new ImageIcon(imgc));
		salir.setBorderPainted(false);
		salir.setContentAreaFilled(false);
		salir.setFocusPainted(false);
		salir.addMouseListener(this);
		salir.setBounds(200,490,350,100);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==empezar) {
			try {
				juego = new JPanell1Juego();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==controles) {
			
		}if(e.getSource()==salir) {
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==empezar) {
			
		}if(e.getSource()==controles) {
			
		}if(e.getSource()==salir) {
			
		}
		
	}

}
