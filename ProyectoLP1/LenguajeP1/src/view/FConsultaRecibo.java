package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class FConsultaRecibo extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblIdCliente;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable miTabla;
	private DefaultTableModel tabla;
	private String Columnas[] = {"COD-CLIENTE","N�DIAS","CARACTERISTICAS","PISO","TIPO DE HABITACION","ESTADO", "PRECIO X D"};
	private JButton btnBuscar;
	private JButton btnEliminar;
	
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
					FConsultaRecibo frame = new FConsultaRecibo();
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
	public FConsultaRecibo() {
		setTitle("Consulta Recibo");
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(204, 204, 204));
		textField.setBounds(316, 92, 200, 22);
		getContentPane().add(textField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 160, 606, 228);
		getContentPane().add(scrollPane);
		
		miTabla = new JTable();
		miTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(miTabla);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBackground(new Color(130, 73, 229));
		btnBuscar.setBounds(152, 29, 110, 43);
		getContentPane().add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(162, 65, 107));
		btnEliminar.setBounds(406, 29, 110, 43);
		getContentPane().add(btnEliminar);
		
		CargarTabla();
	}
}