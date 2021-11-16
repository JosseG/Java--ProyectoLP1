package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class FConsultaBoleta extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblIdCliente;
	private JTextField txtBusqueda;
	private JScrollPane scrollPane;
	private JTable miTabla;
	private DefaultTableModel tabla;
	private String Columnas[] = {"ID","NOMBRE-EMPLEADO","NOMBRE-CLIENTE","FECHA","RUC","TIPO DE PAGO","N° DIAS","PRECIO-HABITACION","PRECIO TOTAL"};
	private JButton btnBuscar;
	
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
		setBounds(100, 100, 720, 491);
		getContentPane().setLayout(null);
		//Color fondo
		getContentPane().setBackground(new Color( 32, 18, 58 ));
		
		lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setForeground(Color.WHITE);
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdCliente.setBounds(173, 93, 79, 14);
		getContentPane().add(lblIdCliente);	
		
		txtBusqueda = new JTextField();
		txtBusqueda.setColumns(10);
		txtBusqueda.setBackground(new Color(204, 204, 204));
		txtBusqueda.setBounds(316, 92, 200, 22);
		getContentPane().add(txtBusqueda);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 160, 606, 228);
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
		CargarTabla();
		tamanoColumnas();
		scrollPane.setViewportView(miTabla);
		
		
		
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBackground(new Color(130, 73, 229));
		btnBuscar.setBounds(296, 24, 110, 43);
		getContentPane().add(btnBuscar);
		
		
	}
	
	private void tamanoColumnas() {
		
		int [] tamanio= {5,50,20,20,80,90,50};
		
		for(int i=0;i<tamanio.length;i++) {
			miTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			miTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas());
		}
		
		
	}
}

