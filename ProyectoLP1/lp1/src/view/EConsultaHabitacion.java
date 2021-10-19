package view;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelDAO.HabitacionDAO;
import modelDTO.HabitacionDTO;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EConsultaHabitacion extends JInternalFrame implements ActionListener {
	private JButton btnBuscar;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable miTabla;
	private DefaultTableModel tabla;
	private String Columnas[] = {"COD-CLIENTE","N�DIAS","CARACTERISTICAS","PISO","TIPO DE HABITACION","ESTADO", "PRECIO X D"};
	
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
					EConsultaHabitacion frame = new EConsultaHabitacion();
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
	public EConsultaHabitacion() {
		setClosable(true);
		setTitle("Consulta Habitaci\u00F3n");
		setBounds(100, 100, 720, 491);
		getContentPane().setLayout(null);
		//Color fondo
		getContentPane().setBackground(new Color( 32, 18, 58 ));
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBackground(new Color(130,73,229));
		btnBuscar.setBounds(131, 62, 110, 43);
		getContentPane().add(btnBuscar);
		
		lblNewLabel = new JLabel("BUSCAR");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(162, 151, 79, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(204, 204, 204));
		textField.setBounds(251, 148, 200, 22);
		getContentPane().add(textField);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(162, 65, 107));
		btnEliminar.setBounds(385, 62, 110, 43);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 241, 575, 147);
		getContentPane().add(scrollPane);
		
		miTabla = new JTable();
		miTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(miTabla);
		
		CargarTabla();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			
			listar();
			
			
			
		}
		
	}
	public void listar() {
		tabla.setRowCount(0);
		System.out.println("Llego");
		HabitacionDAO hab=new HabitacionDAO();
		for(HabitacionDTO b:hab.listar()) {

			Object [] o= {
					b.id_hab,
					b.disp_hab,
					b.descripcion_hab,
					b.tipo_hab
					
								};
			tabla.addRow(o);
			
			
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
