package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import modelDAO.BoletaDAO;
import modelDAO.ClienteDAO;
import modelDAO.ConsultaBoletaDAO;
import modelDAO.DetalleBoletaDAO;
import modelDAO.EmpleadoDAO;
import modelDAO.HabitacionDAO;
import modelDTO.BoletaDTO;
import modelDTO.ClienteDTO;
import modelDTO.ConsultaBoletaDTO;
import modelDTO.DetalleBoletaDTO;
import modelDTO.EmpleadoDTO;
import modelDTO.HabitacionDTO;
import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class FConsultaBoleta extends JInternalFrame implements ActionListener,KeyListener {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblIdCliente;
	private JTextField txtBusqueda;
	private JScrollPane scrollPane;
	private JTable miTabla;
	private DefaultTableModel tabla;
	private String Columnas[] = {"ID","NOMBRE-EMPLEADO","NOMBRE-CLIENTE","FECHA","RUC","TIPO DE PAGO","N° DIAS","PRECIO-HABITACION","PRECIO TOTAL"};
	private ButtonGroup grupoRadio;
	private JRadioButton rdbtnIdCliente;
	private JRadioButton rdbtnIdBoleta;
	private JPanel panel_1;
	
	//Cargar tabla
	private void CargarTabla() {
		tabla = new DefaultTableModel();
		for(int i=0; i<Columnas.length; i++)tabla.addColumn(Columnas[i]);
		miTabla.setModel(tabla);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FConsultaBoleta frame = new FConsultaBoleta();
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
	public FConsultaBoleta() {
	
		setTitle("Consulta Boleta");
		setClosable(true);
		setBounds(100, 100, 1083, 601);
		setBackground(new Color(128, 128, 128));
		getContentPane().setLayout(null);
		//Color fondo
		getContentPane().setBackground(new Color( 114, 173, 168  ));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 165, 1018, 331);
		getContentPane().add(scrollPane);
		
		miTabla = new JTable();
		miTabla.setDefaultEditor(Object.class, null);
		miTabla.setRowHeight(30);
		miTabla.getTableHeader().setReorderingAllowed(false);
		miTabla.getTableHeader().setResizingAllowed(false);
		miTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
		miTabla.setFillsViewportHeight(true);
		
		
		JTableHeader header=miTabla.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla(new Color(30,30,30)));
		miTabla.setTableHeader(header);

		scrollPane.setViewportView(miTabla);
		
		
		grupoRadio=new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(25, 60, 336, 73);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblIdCliente = new JLabel("Cliente");
		lblIdCliente.setBounds(20, 28, 47, 17);
		panel.add(lblIdCliente);
		lblIdCliente.setForeground(Color.BLACK);
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(104, 27, 200, 22);
		panel.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		txtBusqueda.addKeyListener(this);
		txtBusqueda.setBackground(new Color(204, 204, 204));
		
		panel_1 = new JPanel();
		panel_1.setBounds(431, 60, 138, 73);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		rdbtnIdCliente = new JRadioButton("Id-Cliente");
		rdbtnIdCliente.setBounds(27, 7, 83, 27);
		panel_1.add(rdbtnIdCliente);
		rdbtnIdCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		rdbtnIdCliente.setSelected(true);
		rdbtnIdCliente.addActionListener(this);
		rdbtnIdCliente.setForeground(SystemColor.desktop);
		rdbtnIdCliente.setContentAreaFilled(false);
		grupoRadio.add(rdbtnIdCliente);
		
		
		rdbtnIdBoleta = new JRadioButton("Id-Boleta");
		rdbtnIdBoleta.setBounds(27, 39, 81, 27);
		panel_1.add(rdbtnIdBoleta);
		rdbtnIdBoleta.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		rdbtnIdBoleta.setForeground(SystemColor.desktop);
		rdbtnIdBoleta.addActionListener(this);
		rdbtnIdBoleta.setContentAreaFilled(false);
		grupoRadio.add(rdbtnIdBoleta);
		
		
		CargarTabla();
		tamanoColumnas();
		listar();
	}
	
	private void tamanoColumnas() {
		
		int [] tamanio= {50,110,120,30,50,60,30,80,70};
		
		for(int i=0;i<tamanio.length;i++) {
			miTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			miTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if(e.getSource()==txtBusqueda)
			keyReleasedTxtBusqueda(e);
	}
	
	public void keyReleasedTxtBusqueda(KeyEvent e) {
		
		try {
			if(txtBusqueda.getText().isEmpty()) {
				listar();
			}else {
				if(rdbtnIdCliente.isSelected()) {
					filtrarIdCliente(txtBusqueda.getText());
				} else if (rdbtnIdBoleta.isSelected()) {
					filtrarIdBoleta(txtBusqueda.getText());
				}
				
			}
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Codigo incorrecto");
		}
		
	}
	
	protected void filtrarIdCliente(String a) {
		
		tabla.setRowCount(0);
		ConsultaBoletaDAO cb=new ConsultaBoletaDAO();
		List<ConsultaBoletaDTO> listCB=cb.filtrarIdCliente(a);
		recorrerList(listCB);
		
	}
	
	protected void filtrarIdBoleta(String a) {
		
		tabla.setRowCount(0);
		ConsultaBoletaDAO cb=new ConsultaBoletaDAO();	
		List<ConsultaBoletaDTO> listCB=cb.filtrarIdBoleta(a);
		recorrerList(listCB);
		
	}
	
	protected void listar() {
		
		tabla.setRowCount(0);
		ConsultaBoletaDAO cb=new ConsultaBoletaDAO();
		List<ConsultaBoletaDTO> listCB=cb.listar();
		recorrerList(listCB);
		
	}
	
	
	private void recorrerList(List<ConsultaBoletaDTO> a) {
		
		for(ConsultaBoletaDTO x:a) {
			Object[] o= x.toString().split(";");
			tabla.addRow(o);
		}
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
	
		
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

