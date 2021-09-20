package lp1;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPrincipalProbando extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/**
     * Launch the application.
     */ 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	MenuPrincipalProbando frame = new MenuPrincipalProbando();
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
    
    public MenuPrincipalProbando() {
    	//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 544, 439);
       
        this.setContentPane(fondo);
        
    }
    
    class FondoPanel extends JPanel{
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
    
}