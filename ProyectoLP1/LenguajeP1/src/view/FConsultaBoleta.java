package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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

public class FConsultaBoleta extends JInternalFrame implements ActionListener,KeyListener {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblIdCliente;
	private JTextField txtBusqueda;
	private JScrollPane scrollPane;
	private JTable miTabla;
	private DefaultTableModel tabla;
	private String Columnas[] = {"ID","NOMBRE-EMPLEADO","NOMBRE-CLIENTE","FECHA","RUC","TIPO DE PAGO","N° DIAS","PRECIO-HABITACION","PRECIO TOTAL"};
	private JButton btnBuscar;
	private ButtonGroup grupoRadio;
	private JRadioButton rdbtnIdCliente;
	private JRadioButton rdbtnIdBoleta;
	
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
		setBounds(100, 100, 1100, 700);
		getContentPane().setLayout(null);
		//Color fondo
		getContentPane().setBackground(new Color( 32, 18, 58 ));
		
		lblIdCliente = new JLabel("Cliente");
		lblIdCliente.setForeground(Color.WHITE);
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdCliente.setBounds(269, 92, 47, 17);
		getContentPane().add(lblIdCliente);	
		
		txtBusqueda = new JTextField();
		txtBusqueda.setColumns(10);
		txtBusqueda.addKeyListener(this);
		txtBusqueda.setBackground(new Color(204, 204, 204));
		txtBusqueda.setBounds(367, 91, 200, 22);
		getContentPane().add(txtBusqueda);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 165, 1018, 331);
		getContentPane().add(scrollPane);
		
		miTabla = new JTable();
		miTabla.setDefaultEditor(Object.class, null);
		miTabla.setRowHeight(30);
		miTabla.getTableHeader().setReorderingAllowed(false);
		miTabla.getTableHeader().setResizingAllowed(false);
		miTabla.setFillsViewportHeight(true);
		
		
		JTableHeader header=miTabla.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla(new Color(30,30,30)));
		miTabla.setTableHeader(header);

		scrollPane.setViewportView(miTabla);
		

		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBackground(new Color(130, 73, 229));
		btnBuscar.setBounds(419, 25, 110, 43);
		getContentPane().add(btnBuscar);
		
		
		grupoRadio=new ButtonGroup();
		
		rdbtnIdCliente = new JRadioButton("Id-Cliente");
		rdbtnIdCliente.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		rdbtnIdCliente.setSelected(true);
		rdbtnIdCliente.addActionListener(this);
		rdbtnIdCliente.setForeground(Color.WHITE);
		rdbtnIdCliente.setContentAreaFilled(false);
		rdbtnIdCliente.setBounds(647, 87, 83, 27);
		
		
		rdbtnIdBoleta = new JRadioButton("Id-Boleta");
		rdbtnIdBoleta.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		rdbtnIdBoleta.setForeground(Color.WHITE);
		rdbtnIdBoleta.addActionListener(this);
		rdbtnIdBoleta.setContentAreaFilled(false);
		rdbtnIdBoleta.setBounds(736, 86, 81, 27);
		grupoRadio.add(rdbtnIdBoleta);
		grupoRadio.add(rdbtnIdCliente);
		getContentPane().add(rdbtnIdBoleta);
		getContentPane().add(rdbtnIdCliente);
		
		
		CargarTabla();
		tamanoColumnas();
	}
	
	private void tamanoColumnas() {
		
		int [] tamanio= {50,110,90,30,50,60,30,120,70};
		
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
		
		if(txtBusqueda.getText().isEmpty()) {
			listar();
		}else {
			if(rdbtnIdCliente.isSelected()) {
				filtrarIdCliente(txtBusqueda.getText());
			} else if (rdbtnIdBoleta.isSelected()) {
				filtrarIdBoleta(txtBusqueda.getText());
			}
			
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

