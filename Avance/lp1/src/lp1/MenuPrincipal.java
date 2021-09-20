package lp1;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lp1.MenuPrincipalProbando.FondoPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;

public class MenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	MenuPrincipal frame = new MenuPrincipal();
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
    
    public MenuPrincipal() {
    	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 544, 439);
        
        this.setContentPane(fondo);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Archivo");
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
        mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenu mnNewMenu_1 = new JMenu("Registro");
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reserva de Habitaci\u00F3n");
        mnNewMenu_1.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registro del Cliente");
        mnNewMenu_1.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Registro del Empleado");
        mnNewMenu_1.add(mntmNewMenuItem_3);
        
        JMenu mnNewMenu_2 = new JMenu("Reporte");
        menuBar.add(mnNewMenu_2);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Reporte de las Habitaciones");
        mnNewMenu_2.add(mntmNewMenuItem_4);
        
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Recibo");
        mnNewMenu_2.add(mntmNewMenuItem_5);
        
        JMenu mnNewMenu_3 = new JMenu("Consulta");
        menuBar.add(mnNewMenu_3);
        
        JMenuItem mntmNewMenuItem_6 = new JMenuItem("Datos del cliente");
        mnNewMenu_3.add(mntmNewMenuItem_6);
        
        JMenuItem mntmNewMenuItem_7 = new JMenuItem("Datos de las habitaciones");
        mnNewMenu_3.add(mntmNewMenuItem_7);
        
        JMenuItem mntmNewMenuItem_8 = new JMenuItem("Datos del empleado");
        mnNewMenu_3.add(mntmNewMenuItem_8);
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
    	//xd
    }
    }

    
