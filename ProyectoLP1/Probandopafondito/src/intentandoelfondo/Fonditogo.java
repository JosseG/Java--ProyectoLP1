package intentandoelfondo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Fonditogo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fonditogo frame = new Fonditogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	FondoPanel fondo = new FondoPanel();
	
	public Fonditogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		this.setContentPane(fondo);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	class FondoPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image imagen;
    	
    	@Override
    	public void paint(Graphics g) {
    		imagen = new ImageIcon(getClass().getResource("/img/img_banner.jpg")).getImage();
    		 g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
             
             setOpaque(false);
             
             super.paint(g);
    	}
    }
    //Lo de arriba
}
