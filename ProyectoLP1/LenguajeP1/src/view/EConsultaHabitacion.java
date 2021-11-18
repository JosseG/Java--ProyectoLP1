package view;

import java.awt.EventQueue;
import java.awt.event.*;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import modelDAO.HabitacionDAO;
import modelDTO.HabitacionDTO;
import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EConsultaHabitacion extends JInternalFrame implements ActionListener {
	private JButton btnBuscar;
	private JLabel lblNewLabel;
	private JTextField txtBusqueda;
	private JScrollPane scrollPane;
	private JTable miTabla;
	private DefaultTableModel tabla;
	private String Columnas[] = {"COD-CLIENTE","N°DIAS","DESCRIPCION","TIPO DE HABITACION", "PRECIO X D"};
	
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
		btnBuscar.setBounds(298, 52, 110, 43);
		getContentPane().add(btnBuscar);
		
		lblNewLabel = new JLabel("ID Habitaci\u00F3n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(131, 149, 86, 17);
		getContentPane().add(lblNewLabel);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setColumns(10);
		txtBusqueda.setBackground(new Color(204, 204, 204));
		txtBusqueda.setBounds(251, 148, 200, 22);
		getContentPane().add(txtBusqueda);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 241, 575, 147);
		getContentPane().add(scrollPane);
		
		miTabla = new JTable();
		miTabla.setDefaultEditor(Object.class, null);
		miTabla.setRowHeight(30);
		miTabla.getTableHeader().setReorderingAllowed(false);
		miTabla.getTableHeader().setResizingAllowed(false);
		miTabla.setFillsViewportHeight(true);
		
		
		JTableHeader header=miTabla.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla(new Color(55,55,0)));
		
		miTabla.setTableHeader(header);
		scrollPane.setViewportView(miTabla);
		
		CargarTabla();
		tamanoColumnas();


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
		
		List<HabitacionDTO> habit=hab.listar();
		System.out.println(habit.get(0).getFecha_reserva());
		for(HabitacionDTO b:habit) {
			System.out.println(b.getFecha_reserva()+"");
			Object [] o= {
					b.getId_hab(),
					b.getNum_dias(),
					b.getDescripcion_hab(),
					b.getTipo_hab(),
					b.getFecha_reserva()
					};
			tabla.addRow(o);

		}
		
	}
	
	private void tamanoColumnas() {
		
		int [] tamanio= {20,5,30,80,80};
		
		for(int i=0;i<5;i++) {
			miTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
			miTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			
		}
		
		
	}


	
}
