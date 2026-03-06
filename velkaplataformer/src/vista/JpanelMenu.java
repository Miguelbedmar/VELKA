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
		Image imagen=botonempezar.getImage().getScaledInstance(500, 400,50);	
		empezar = new JButton(new ImageIcon(imagen)); // instanciamos boton
		empezar.setBorderPainted(false);
		empezar.setContentAreaFilled(false);
		empezar.setFocusPainted(false);
		empezar.addMouseListener(this);
		empezar.setLayout(null);
		empezar.setBounds(200,150,250,80);

		add(empezar);
		empezar.addActionListener(this);
	}
	public void botoncontrol() {
		ImageIcon botoncontrol=new ImageIcon(getClass().getResource("/recursos/CONTROLES.png"));
		Image imgc=botoncontrol.getImage().getScaledInstance(500, 400, 300);
		
	
	
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==empezar) {
			
		}
		
	}

}
