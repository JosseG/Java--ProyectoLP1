package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionEvent;

public class AMenuPrincipal extends JFrame implements ActionListener,ComponentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmSalir;
	private JMenuItem mntmReservHabita;
	private JMenuItem mntmRegistCliente;
	private JMenuItem mntmConsultHabita;
	private JMenuItem mntmConsultaBoleta;
	private JMenuItem mntmDatosHabita;
	private JMenuItem mntmDatosCliente;
	private JMenuItem mntmDatosEmplea;
	

	/**
	 * Launch the application.
	 */


	//Creando el fondo
		FondoPanel fondo1=new FondoPanel();
		private JMenuItem mntmRegistEmplea;
		
		//Lo de arriba
	/**
	 * Create the frame.
	 */

	public AMenuPrincipal() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Men\u00FA Principal");
		addComponentListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(1200,800);
		setLocationRelativeTo(null);
				
		fondo1.repaint();
		//Configurando fondo
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnRegistro = new JMenu("Mantenimiento");
		menuBar.add(mnRegistro);
		
		mntmReservHabita = new JMenuItem("Reserva de Habitaci\u00F3n");
		mntmReservHabita.addActionListener(this);
		mnRegistro.add(mntmReservHabita);
		
		mntmRegistCliente = new JMenuItem("Registro del Cliente");
		mntmRegistCliente.addActionListener(this);
		mnRegistro.add(mntmRegistCliente);
		
		mntmRegistEmplea = new JMenuItem("Registro del Empleado");
		mntmRegistEmplea.addActionListener(this);
		mnRegistro.add(mntmRegistEmplea);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mntmConsultHabita = new JMenuItem("Consulta Habitaci\u00F3n");
		mntmConsultHabita.addActionListener(this);
		mnConsulta.add(mntmConsultHabita);
		
		mntmConsultaBoleta = new JMenuItem("Consulta Boleta");
		mntmConsultaBoleta.addActionListener(this);
		mnConsulta.add(mntmConsultaBoleta);
		
		mnTransaccion = new JMenu("Transacci\u00F3n");
		menuBar.add(mnTransaccion);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmDatosCliente = new JMenuItem("Datos del cliente");
		mntmDatosCliente.addActionListener(this);
		mnReporte.add(mntmDatosCliente);
		
		mntmDatosHabita = new JMenuItem("Datos de las Habitaciones");
		mntmDatosHabita.addActionListener(this);
		mnReporte.add(mntmDatosHabita);
		
		mntmDatosEmplea = new JMenuItem("Datos del Empleado");
		mntmDatosEmplea.addActionListener(this);
		mnReporte.add(mntmDatosEmplea);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(fondo1);
		setContentPane(contentPane);
		
	}


	//Poner imagen de fondo en Responsive
    class FondoPanel extends JDesktopPane{
		private static final long serialVersionUID = 1L;
		private Image imagen;		
    	
    	public void paintComponent(Graphics g) {
    		
    		super.paintComponent(g);
    		imagen = new ImageIcon(getClass().getResource("/img/img_banner.jpg")).getImage();
    		 g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
             
             setOpaque(false);
          
    	}
    }
    //Lo de arriba
    
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmDatosEmplea) {
			actionPerformedMntmDatosEmplea(e);
		}
		if (e.getSource() == mntmDatosHabita) {
			actionPerformedMntmDatosHabita(e);
		}
		if (e.getSource() == mntmDatosCliente) {
			actionPerformedMntmDatosCliente(e);
		}
		if (e.getSource() == mntmConsultaBoleta) {
			actionPerformedMntmConsultaRecibo(e);
		}
		if (e.getSource() == mntmConsultHabita) {
			actionPerformedMntmConsultHabita(e);
		}
		if (e.getSource() == mntmRegistEmplea) {
			actionPerformedMntmRegistEmplea(e);
		}
		if (e.getSource() == mntmRegistCliente) {
			actionPerformedMntmRegistCliente(e);
		}
		if (e.getSource() == mntmReservHabita) {
			actionPerformedMntmReservHabita(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	
	protected void actionPerformedMntmSalir(ActionEvent e) {
		int msj = JOptionPane.showConfirmDialog(null, "Desea salir del sistema?", "Alerta!", JOptionPane.YES_NO_OPTION);

		if (msj == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	BReservaHabitacion Res11 = new BReservaHabitacion();
	protected void actionPerformedMntmReservHabita(ActionEvent e) {
		
		Res11.setLocation((contentPane.getWidth()-720)/2,(contentPane.getHeight()-491)/2);
		fondo1.add(Res11);
		Res11.setVisible(true);		
	}


	
	CRegistroCliente Res12 = new CRegistroCliente();	
	protected void actionPerformedMntmRegistCliente(ActionEvent e) {
			
		fondo1.add(Res12);
		Res12.setVisible(true);	
	}
	
	
	
	DRegistroEmpleado Res13 = new DRegistroEmpleado();		
	protected void actionPerformedMntmRegistEmplea(ActionEvent e) {
		
		fondo1.add(Res13);
		Res13.setVisible(true);	
	}
	
	
	EConsultaHabitacion Con21 = new EConsultaHabitacion();
	private JMenu mnTransaccion;
	protected void actionPerformedMntmConsultHabita(ActionEvent e) {
		Con21.setLocation((contentPane.getWidth()-720)/2,(contentPane.getHeight()-491)/2);
		fondo1.add(Con21);
		Con21.setVisible(true);	
	}
	
	FConsultaBoleta Con22 = new FConsultaBoleta();
	protected void actionPerformedMntmConsultaRecibo(ActionEvent e) {
		Con22.setLocation((contentPane.getWidth()-1100)/2,(contentPane.getHeight()-700)/2);
		fondo1.add(Con22);
		Con22.setVisible(true);	
	}
	
	GDatosCliente Rep31 = new GDatosCliente();
	protected void actionPerformedMntmDatosCliente(ActionEvent e) {		
		fondo1.add(Rep31);
		Rep31.setVisible(true);
	}
	
	
	HDatosHabitaciones Rep32 = new HDatosHabitaciones();
	protected void actionPerformedMntmDatosHabita(ActionEvent e) {
				
		fondo1.add(Rep32);
		Rep32.setVisible(true);
	}
	
	
	IDatosEmpleados Rep33 = new IDatosEmpleados();
	protected void actionPerformedMntmDatosEmplea(ActionEvent e) {
				
		fondo1.add(Rep33);
		Rep33.setVisible(true);
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
		Res11.setLocation((contentPane.getWidth()-720)/2,(contentPane.getHeight()-491)/2);
		Res12.setLocation((contentPane.getWidth()-720)/2,(contentPane.getHeight()-491)/2);
		Res13.setLocation((contentPane.getWidth()-720)/2,(contentPane.getHeight()-491)/2);
		
		Con21.setLocation((contentPane.getWidth()-720)/2,(contentPane.getHeight()-491)/2);
		Con22.setLocation((contentPane.getWidth()-1100)/2,(contentPane.getHeight()-700)/2);
		
		Rep31.setLocation((contentPane.getWidth()-720)/2,(contentPane.getHeight()-491)/2);
		Rep32.setLocation((contentPane.getWidth()-720)/2,(contentPane.getHeight()-491)/2);
		Rep33.setLocation((contentPane.getWidth()-720)/2,(contentPane.getHeight()-491)/2);
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
}
