package vista;

import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JpanelMenu extends JPanel implements ActionListener,MouseListener {
	JButton empezar;
	JButton controles;
	JButton salir;

	public JpanelMenu() {
		botonesMenu();
		botoncontrol();
		botonSalir();
	}

	@Override
	public void paint(Graphics g) {

		Dimension dimension = this.getSize();
		ImageIcon icon = new ImageIcon(getClass().getResource("/recursos/FONDOMENU.png"));
		g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
		setOpaque(false);
		super.paintChildren(g);
	}

	public void botonesMenu() {
		ImageIcon botonempezar = new ImageIcon(getClass().getResource("/recursos/EMPEZAR.png"));
		Image imagen=botonempezar.getImage().getScaledInstance(350, 200,50);	
		empezar = new JButton(new ImageIcon(imagen)); // instanciamos boton
		empezar.setBorderPainted(true);
		empezar.setContentAreaFilled(false);
		empezar.setFocusPainted(false);
		empezar.addMouseListener(this);
		empezar.setLayout(null);
		empezar.setBounds(390,350,0,0);

		add(empezar);
		empezar.addActionListener(this);
	}
	public void botoncontrol() {
		ImageIcon botoncontrol=new ImageIcon(getClass().getResource("/recursos/CONTROLES.png"));
		Image imgc=botoncontrol.getImage().getScaledInstance(350, 200, 50);
		controles=new JButton(new ImageIcon(imgc));
		controles.setBorderPainted(true);
		controles.setContentAreaFilled(false);
		controles.setFocusPainted(false);
		controles.addMouseListener(this);
		controles.setLayout(null);
		controles.setBounds(150,250,0,0);
		add(controles);
		controles.addActionListener(this);
	
	}
	public void botonSalir() {
		ImageIcon botonSalir=new ImageIcon(getClass().getResource("/recursos/SALIR.png"));
		Image imgc=botonSalir.getImage().getScaledInstance(350, 200, 50);
		salir=new JButton(new ImageIcon(imgc));
		salir.setBorderPainted(true);
		salir.setContentAreaFilled(false);
		salir.setFocusPainted(false);
		salir.addMouseListener(this);
		salir.setLayout(null);
		salir.setBounds(100,150,0,0);
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
