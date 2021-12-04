package view;

import java.awt.EventQueue;
import java.awt.event.*;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mxrck.autocompleter.TextAutoCompleter;

import modelDAO.ConsultaHabitacionDAO;
import modelDAO.HabitacionDAO;
import modelDTO.ConsultaHabitacionDTO;
import modelDTO.HabitacionDTO;
import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class EConsultaHabitacion extends JInternalFrame implements ActionListener,KeyListener {
	private JLabel lblNewLabel;
	private JTextField txtBusqueda;
	private JScrollPane scrollPane;
	private JTable miTabla;
	private DefaultTableModel tabla;
	private String Columnas[] = {"COD-CLIENTE","NOMBRES","APELLIDOS","COD_HAB","DESCRIPCION-HABITACION","TIPO DE HABITACION"};
	private ButtonGroup grupoRadio;
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnTipo;
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
		setBounds(100, 100, 738, 437);
		setBackground(new Color(128, 128, 128));
		getContentPane().setLayout(null);
		//Color fondo
		getContentPane().setBackground(new Color( 114, 173, 168  ));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 187, 630, 147);
		getContentPane().add(scrollPane);
		
		miTabla = new JTable();
		scrollPane.setViewportView(miTabla);
		miTabla.setDefaultEditor(Object.class, null);
		miTabla.setRowHeight(30);
		miTabla.getTableHeader().setReorderingAllowed(false);
		miTabla.getTableHeader().setResizingAllowed(false);
		miTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
		miTabla.setFillsViewportHeight(true);
		
		
		JTableHeader header=miTabla.getTableHeader();
		
		miTabla.setTableHeader(header);
		header.setDefaultRenderer(new GestionEncabezadoTabla(new Color(55,55,0)));
		
		grupoRadio=new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(46, 71, 220, 83);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("HABITACI\u00D3N");
		lblNewLabel.setBounds(64, 11, 91, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(10, 50, 200, 22);
		panel.add(txtBusqueda);
		
				txtBusqueda.setColumns(10);
				txtBusqueda.addKeyListener(this);
				txtBusqueda.setBackground(new Color(204, 204, 204));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(119, 136, 153), 2));
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBounds(330, 76, 93, 78);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		rdbtnTipo = new JRadioButton("Tipo");
		rdbtnTipo.setBounds(19, 40, 65, 23);
		panel_1.add(rdbtnTipo);
		rdbtnTipo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		rdbtnTipo.setForeground(Color.BLACK);
		rdbtnTipo.addActionListener(this);
		rdbtnTipo.setContentAreaFilled(false);
		grupoRadio.add(rdbtnTipo);
		
		rdbtnId = new JRadioButton("id");
		rdbtnId.setBounds(19, 14, 40, 23);
		panel_1.add(rdbtnId);
		rdbtnId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		rdbtnId.setSelected(true);
		rdbtnId.addActionListener(this);
		rdbtnId.setForeground(Color.BLACK);
		rdbtnId.setContentAreaFilled(false);
		grupoRadio.add(rdbtnId);
		
		CargarTabla();
		tamanoColumnas();


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rdbtnId)
			limpiar();
		if(e.getSource()==rdbtnTipo)
			limpiar();
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource()==txtBusqueda) {
			keyReleasedTxtBusqueda(e);
		}
	}

	public void keyReleasedTxtBusqueda(KeyEvent e) {
		
		if(txtBusqueda.getText().isEmpty()) {
			listar();
		}else {
			if(rdbtnId.isSelected()) {
				filtrarId(txtBusqueda.getText());
			} else if(rdbtnTipo.isSelected()) {
				filtrarTipo(txtBusqueda.getText());
			}
		}
		
	} 
	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	
	protected void filtrarId(String f) {
		tabla.setRowCount(0);
		ConsultaHabitacionDAO hab=new ConsultaHabitacionDAO();
		List<ConsultaHabitacionDTO> habit=hab.filtrarId(f);
		
		recorrerList(habit);
	}
	
	protected void filtrarTipo(String f) {
		tabla.setRowCount(0);
		ConsultaHabitacionDAO hab=new ConsultaHabitacionDAO();
		List<ConsultaHabitacionDTO> habit=hab.filtrarTipo(f);
		recorrerList(habit);
	}
	
	protected void listar() {
		tabla.setRowCount(0);
		ConsultaHabitacionDAO hab=new ConsultaHabitacionDAO();
		List<ConsultaHabitacionDTO> habit=hab.listar();
		recorrerList(habit);
		
	}
	
	private void limpiar() {
		txtBusqueda.setText("");
		txtBusqueda.requestFocus();
	}

	
	private void recorrerList(List<ConsultaHabitacionDTO> a) {
		
		for(ConsultaHabitacionDTO b:a) {
			
			Object [] o = b.toString().split(";");
			tabla.addRow(o);
			
		}
		
	}

	private void tamanoColumnas() {
		
		int [] tamanio= {40,50,10,80,80};
		
		for(int i=0;i<tamanio.length;i++) {
			miTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
			miTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			
		}
		
		
	}
}
