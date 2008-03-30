package util;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@Deprecated
public class Visualizar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4049376331876467051L;
	
	private final BufferedImage image;

	
	/**
	 * Construtor simples da classe.
	 * @param i a imagem
	 */
	public Visualizar(BufferedImage i) {
		super("imagem");
		this.image = i;
		this.addMouseListener(new MouseListener1());
//		coisa("texto");
	}
	
//	public void coisa(String s){
//		JTextField j = new JTextField();
//		j.setHorizontalAlignment(JTextField.CENTER);
//		j.setText(s);
//		this.add(j);
//	}
	
	/**
	 * Classe que responde ao click do mouse
	 * 
	* @author Carlos Trajano
	* @author Hamon Barros
	* @author Rodrigo Lopes
	* 
 	* @version 1.0
	*/
	public class MouseListener1 implements MouseListener{

		
		public void mouseClicked(MouseEvent e) {
			Graphics graficos = getGraphics();
			System.out.println(graficos);
			graficos.drawImage(image, 25, 25, null);
//			coisa("texto");
//			try {
//				ImageIO.write(image, "jpg", new File("senha.jpg"));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
