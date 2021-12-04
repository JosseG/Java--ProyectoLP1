package view;

import java.awt.EventQueue;
import java.awt.event.*;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import modelDAO.HabitacionDAO;
import modelDTO.HabitacionDTO;
import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;

public class BRegistroHabitacion extends JInternalFrame implements ActionListener,MouseListener {
	private JLabel lblTipoHabitacin;
	private JLabel lblDescripcion;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JComboBox cboTipo;
	private JTextField txtDescripcion;
	private JLabel lblCodigoHabitacion;
	private JTextField txtCodigoHabitacion;
	private JButton btnEliminar;
	private JTextField txtBuscar;
	private JTable jtTabla;
	
	private String [] columnas = {"C�DIGO","TIPO","DESCRIPCI�N"};
	private DefaultTableModel dtmTabla;
	private JTableHeader header;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BRegistroHabitacion frame = new BRegistroHabitacion();
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
	public BRegistroHabitacion() {
		setClosable(true);
		setTitle("Reserva de Habitaci\u00F3n");
		setBounds(100, 100, 720, 507);
		getContentPane().setLayout(null);
		setBackground(new Color( 32, 18, 58 ));
		
		lblTipoHabitacin = new JLabel("Tipo de habitaci\u00F3n");
		lblTipoHabitacin.setForeground(Color.WHITE);
		lblTipoHabitacin.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblTipoHabitacin.setBounds(31, 110, 119, 16);
		getContentPane().add(lblTipoHabitacin);
		
		lblDescripcion = new JLabel("Descripci\u00F2n");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDescripcion.setBounds(31, 150, 125, 16);
		getContentPane().add(lblDescripcion);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(130, 73, 229));
		btnBuscar.setBounds(461, 419, 89, 23);
		getContentPane().add(btnBuscar);
		
		cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Una persona", "Dos personas", "Matrimonial"}));
		cboTipo.setBounds(246, 109, 119, 21);
		getContentPane().add(cboTipo);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(246, 150, 119, 19);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		lblCodigoHabitacion = new JLabel("C\u00F2digo de habitaci\u00F2n");
		lblCodigoHabitacion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCodigoHabitacion.setForeground(Color.WHITE);
		lblCodigoHabitacion.setBounds(31, 72, 137, 16);
		getContentPane().add(lblCodigoHabitacion);
		
		txtCodigoHabitacion = new JTextField();
		txtCodigoHabitacion.setBounds(246, 72, 96, 19);
		txtCodigoHabitacion.setColumns(10);
		txtCodigoHabitacion.setText(new HabitacionDAO().generarCodigo());
		txtCodigoHabitacion.setEditable(false);
		getContentPane().add(txtCodigoHabitacion);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(583, 420, 86, 20);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 203, 638, 191);
		getContentPane().add(scrollPane);
		
		dtmTabla=new DefaultTableModel(null,columnas);
		jtTabla = new JTable();
		jtTabla.setModel(dtmTabla);
		jtTabla.getTableHeader().setReorderingAllowed(false);
		jtTabla.getTableHeader().setResizingAllowed(false);
		jtTabla.addMouseListener(this);
		jtTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		header=jtTabla.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla(new Color(35,200,70)));
		jtTabla.setTableHeader(header);
		scrollPane.setViewportView(jtTabla);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(580, 143, 89, 23);
		getContentPane().add(btnEliminar);
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(580, 110, 89, 23);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(130, 73, 229));
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setBounds(580, 77, 89, 23);
		getContentPane().add(btnAnadir);
		btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadir.addActionListener(this);
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setBackground(new Color(130, 73, 229));
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(this);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(341, 419, 89, 23);
		getContentPane().add(btnCancel);
		
		tamanoColumnas();
		listar();
		limpiar();
		setEnabledBtn(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		
		if (e.getSource() == btnAnadir) {
			actionPerformedBtnAnadir(e);
		}
		
		if(e.getSource() == btnCancel) {
			actionPerformedBtnCancelar(e);
		}
		
	}
	protected void actionPerformedBtnAnadir(ActionEvent e) {
		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		setEnabledBtn(false);
		limpiar();
		jtTabla.getSelectedRow();
		jtTabla.setRowSelectionAllowed(false);
		listar();
	}
	
	private void tamanoColumnas() {
		
		int [] tamanio= {30,50,80};
		
		for(int i=0;i<tamanio.length;i++) {
			jtTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
			jtTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			
		}
		
	}
	
	void listar(){
		dtmTabla.setRowCount(0);
		HabitacionDAO habdao=new HabitacionDAO();
		List<HabitacionDTO> lhab=habdao.listar();
		
		for(HabitacionDTO h:lhab) {
			Object[] o = h.toString().split(";");
			dtmTabla.addRow(o);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jtTabla.rowAtPoint(e.getPoint());
		txtCodigoHabitacion.setText(dtmTabla.getValueAt(row, 0).toString());
		txtDescripcion.setText(dtmTabla.getValueAt(row, 2).toString());
		
		setEnabledBtn(true);
		jtTabla.setRowSelectionAllowed(true);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void setEnabledBtn(boolean a) {
		btnEliminar.setEnabled(a);
		btnModificar.setEnabled(a);
		btnAnadir.setEnabled(!a);
		btnCancel.setVisible(a);
		
	}
	
	private void limpiar() {
		txtCodigoHabitacion.setText("");
		txtDescripcion.setText("");
		txtBuscar.setText("");
	}
	
	
}