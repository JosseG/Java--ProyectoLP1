package view;

import java.awt.EventQueue;
import java.awt.event.*;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import modelDAO.ClienteDAO;
import modelDAO.HabitacionDAO;
import modelDTO.ClienteDTO;
import modelDTO.HabitacionDTO;
import util.ExpRegs;
import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class BRegistroHabitacion extends JInternalFrame implements ActionListener,MouseListener {
	private JLabel lblTipoHabitacin;
	private JLabel lblDescripcion;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JComboBox<Object> cboTipo;
	private JTextField txtDescripcion;
	private JLabel lblCodigoHabitacion;
	private JTextField txtCodigoHabitacion;
	private JButton btnEliminar;
	private JTextField txtBuscar;
	private JTable jtTabla;
	
	private String [] columnas = {"CÓDIGO","TIPO","DESCRIPCIÓN"};
	private DefaultTableModel dtmTabla;
	private JTableHeader header;
	private JButton btnCancel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
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
		//setBackground(new Color( 32, 18, 58 ));
		setBackground(new Color( 114, 173, 168 ));
		getContentPane().setBackground(new Color( 114, 173, 168  ));
		
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
		cboTipo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Una persona", "Dos personas", "Matrimonial"}));
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
		btnEliminar.setBounds(538, 148, 111, 28);
		getContentPane().add(btnEliminar);
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(538, 110, 111, 28);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(130, 73, 229));
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setBounds(538, 73, 111, 28);
		getContentPane().add(btnAnadir);
		btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadir.addActionListener(this);
		btnAnadir.setForeground(Color.BLACK);
		btnAnadir.setBackground(new Color(130, 73, 229));
		
		btnCancel = new JButton("");
		btnCancel.setContentAreaFilled(false);
		btnCancel.setIcon(new ImageIcon(BRegistroHabitacion.class.getResource("/img/cancelar.png")));
		btnCancel.addActionListener(this);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setBounds(389, 419, 28, 28);
		getContentPane().add(btnCancel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BRegistroHabitacion.class.getResource("/img/add.png")));
		lblNewLabel.setBounds(660, 74, 24, 24);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BRegistroHabitacion.class.getResource("/img/iconmodify.png")));
		lblNewLabel_1.setBounds(660, 112, 24, 24);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(BRegistroHabitacion.class.getResource("/img/icondelete.png")));
		lblNewLabel_2.setBounds(660, 150, 24, 24);
		getContentPane().add(lblNewLabel_2);
		
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
		
		HabitacionDAO habdao=new HabitacionDAO();
		HabitacionDTO habdto=new HabitacionDTO();
		try {
			
			habdto.setId(txtCodigoHabitacion.getText());
			habdto.setTipo(String.valueOf(cboTipo.getSelectedIndex()).charAt(0));
			habdto.setDescripcion(txtDescripcion.getText());
			habdao.insertar(habdto);
			
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al añadir");
		}

		listar();
		limpiar();
		
		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		HabitacionDAO habdao=new HabitacionDAO();
		HabitacionDTO habdto=new HabitacionDTO();
		try {
			System.out.println(String.valueOf(cboTipo.getSelectedIndex()).charAt(0));
			habdto.setId(txtCodigoHabitacion.getText());
			habdto.setTipo(String.valueOf(cboTipo.getSelectedIndex()).charAt(0));
			habdto.setDescripcion(txtDescripcion.getText());
			habdao.actualizar(habdto);

		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al modificar");
		}

		listar();
		limpiar();
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		if(!txtBuscar.getText().isEmpty()) {
			filtrarId(txtBuscar.getText());
		}else {
			JOptionPane.showMessageDialog(null, "Coloque un id");
		}

	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int row = jtTabla.getSelectedRow();
		int rpta=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar?");
		if(rpta==JOptionPane.OK_OPTION) {
			HabitacionDAO habdao=new HabitacionDAO();
			habdao.eliminar(dtmTabla.getValueAt(row, 0).toString());
			JOptionPane.showMessageDialog(null, "Correcto");
		}else {
			JOptionPane.showMessageDialog(null, "incorrecto");
		}
		limpiar();
		listar();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		setEnabledBtn(false);
		
		jtTabla.getSelectedRow();
		jtTabla.setRowSelectionAllowed(false);
		limpiar();
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
		recorrerList(lhab);
		
	}
	
	void filtrarId(String a) {
		dtmTabla.setRowCount(0);
		HabitacionDAO habdao=new HabitacionDAO();	
		List<HabitacionDTO> listhab=habdao.filtrarId(a);
		recorrerList(listhab);
	}
	
	private void recorrerList(List<HabitacionDTO> a) {
		
		for(HabitacionDTO b:a) {
			
			Object [] o = b.toString().split(";");
			
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
		cboTipo.setSelectedIndex(Integer.parseInt(dtmTabla.getValueAt(row, 1).toString()));
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
		btnCancel.setEnabled(a);
	}
	
	private void limpiar() {
		txtCodigoHabitacion.setText(new HabitacionDAO().generarCodigo());
		txtDescripcion.setText("");
		txtBuscar.setText("");
	}
}
