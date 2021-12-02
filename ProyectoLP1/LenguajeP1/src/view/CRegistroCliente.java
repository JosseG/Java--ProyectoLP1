package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import modelDAO.ClienteDAO;
import modelDAO.ConsultaBoletaDAO;
import modelDAO.ConsultaHabitacionDAO;
import modelDAO.DireccionDAO;
import modelDTO.ClienteDTO;
import modelDTO.ConsultaBoletaDTO;
import modelDTO.ConsultaHabitacionDTO;
import modelDTO.DireccionDTO;
import modelDTO.LoginDTO;
import util.Carga;
import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JTextPane;
import java.awt.event.*;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JProgressBar;

public class CRegistroCliente extends JInternalFrame implements ActionListener,MouseListener {
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDocIdentidad;
	private JButton btnanadir;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDocIdentidad;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblCelular;
	private JLabel lblCorreo;
	private JTextField txtCelular;
	private JTextField txtCorreoElectronico;
	private JLabel lblPais;
	private JTextField txtPais;
	private JScrollPane scrollPane;
	private JTable jTabla;
	private DefaultTableModel tabla;

	private String Columnas[] = {"CODIGO","NOMBRE","APELLIDOS","DOCUMENTO IDENTIDAD", "TELEFONO", "CORREO","DIRECCION"};
	private JTextField txtBuscar;
	private JButton btnBuscar;
	
	JTableHeader header;
	private JButton btnCancel;
	private JProgressBar pbCarga;
	
	private void CargarTabla() {
		tabla = new DefaultTableModel();
		for(int i=0; i<Columnas.length; i++)tabla.addColumn(Columnas[i]);
		jTabla.setModel(tabla);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRegistroCliente frame = new CRegistroCliente();
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
	public CRegistroCliente() {
		setTitle("Registro del Cliente");
		setClosable(true);
		setBackground(new Color(128, 128, 128));
		setBounds(100, 100, 720, 524);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color( 32, 18, 58 ));
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBackground(new Color(206, 228, 190));
		txtNombres.setBounds(177, 51, 340, 16);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(new Color(206, 228, 190));
		txtApellidos.setBounds(177, 76, 340, 16);
		getContentPane().add(txtApellidos);
		
		txtDocIdentidad = new JTextField();
		txtDocIdentidad.setColumns(10);
		txtDocIdentidad.setBackground(new Color(206, 228, 190));
		txtDocIdentidad.setBounds(177, 102, 170, 16);
		getContentPane().add(txtDocIdentidad);
		
		btnanadir = new JButton("A\u00F1adir");
		btnanadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnanadir.addActionListener(this);
		btnanadir.setForeground(Color.WHITE);
		btnanadir.setBackground(new Color(130, 73, 229));
		btnanadir.setBounds(576, 49, 89, 23);
		getContentPane().add(btnanadir);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNombres.setBounds(29, 50, 58, 16);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblApellidos.setBounds(29, 76, 60, 16);
		getContentPane().add(lblApellidos);
		
		lblDocIdentidad = new JLabel("Doc. Identidad");
		lblDocIdentidad.setForeground(Color.WHITE);
		lblDocIdentidad.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDocIdentidad.setBounds(29, 102, 94, 16);
		getContentPane().add(lblDocIdentidad);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(130, 73, 229));
		btnModificar.setBounds(576, 99, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		btnEliminar.setBounds(576, 152, 89, 23);
		getContentPane().add(btnEliminar);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCelular.setBounds(29, 128, 46, 16);
		getContentPane().add(lblCelular);
		
		lblCorreo = new JLabel("Correo electronico");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCorreo.setBounds(29, 154, 118, 16);
		getContentPane().add(lblCorreo);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBackground(new Color(206, 228, 190));
		txtCelular.setBounds(177, 128, 170, 16);
		getContentPane().add(txtCelular);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setColumns(10);
		txtCorreoElectronico.setBackground(new Color(206, 228, 190));
		txtCorreoElectronico.setBounds(177, 154, 340, 16);
		getContentPane().add(txtCorreoElectronico);
		
		lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblPais.setForeground(Color.WHITE);
		lblPais.setBounds(29, 181, 28, 16);
		getContentPane().add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBackground(new Color(206, 228, 190));
		txtPais.setBounds(177, 181, 170, 16);
		getContentPane().add(txtPais);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 253, 644, 186);
		getContentPane().add(scrollPane);
		

		
		jTabla = new JTable();
		jTabla.getTableHeader().setReorderingAllowed(false);
		jTabla.getTableHeader().setResizingAllowed(false);
		jTabla.addMouseListener(this);
		jTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		header=jTabla.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla(new Color(35,200,70)));
		jTabla.setTableHeader(header);
		scrollPane.setViewportView(jTabla);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBounds(452, 460, 89, 23);
		getContentPane().add(btnBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(563, 461, 86, 20);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(335, 460, 89, 23);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnCancel);
		
		pbCarga = new JProgressBar();
		pbCarga.setForeground(new Color(50, 205, 50));
		pbCarga.setBounds(165, 469, 146, 14);
		getContentPane().add(pbCarga);
		CargarTabla();
		tamanoColumnas();
		listar();
		limpiar();
		setEnabledBtn(false);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		
		if (e.getSource() == btnanadir) {
			actionPerformedBtnanadir(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		
		if(e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		int row = jTabla.getSelectedRow();
		int rpta=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar?");
		if(rpta==JOptionPane.OK_OPTION) {
			ClienteDAO cldao=new ClienteDAO();
			cldao.eliminar(tabla.getValueAt(row, 0).toString());
			JOptionPane.showMessageDialog(null, "Correcto");
		}else {
			JOptionPane.showMessageDialog(null, "incorrecto");
		}
		limpiar();
		listar();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		pbCarga.setVisible(true);
		Carga carga=new Carga(pbCarga);
		
		int row = jTabla.getSelectedRow();
		ClienteDTO cldto=new ClienteDTO();
		ClienteDAO cldao=new ClienteDAO();
		
		try {
			
			cldto.setId(Integer.parseInt(tabla.getValueAt(row, 0).toString()));
			cldto.setNombre(txtNombres.getText());
			cldto.setApellidos(txtApellidos.getText());
			cldto.setDi(txtDocIdentidad.getText());
			cldto.setTelefono(txtCelular.getText());
			cldto.setCorreo(txtCorreoElectronico.getText());
			cldto.setIdDireccion(tabla.getValueAt(row, 6).toString());
			cldao.actualizar(cldto);
			carga.start();
			
			
			
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
		}
		
		listar();
		limpiar();
		setEnabledBtn(false);
		pbCarga.setVisible(false);
		
	}
	protected void actionPerformedBtnanadir(ActionEvent e) {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		ClienteDAO cldao=new ClienteDAO();
		ClienteDTO cldto=new ClienteDTO();
		try {
			
			cldto.setDi(txtDocIdentidad.getText());
			cldto.setNombre(txtNombres.getText());
			cldto.setApellidos(txtApellidos.getText());
			cldto.setTelefono(txtCelular.getText());
			cldto.setCorreo(txtCorreoElectronico.getText());
			cldto.setIdDireccion(encontrariPais(txtPais.getText()));
			cldao.insertar(cldto);
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage()+"aa");
			ex.printStackTrace();
		}
		listar();
		limpiar();
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		if(!txtBuscar.getText().isEmpty()) {
			filtrarId(Integer.parseInt(txtBuscar.getText()));
		}else {
			JOptionPane.showMessageDialog(null, "Coloque un id");
		}
		
		
	}
	
	protected void btnCancelActionPerformed(ActionEvent e) {
		setEnabledBtn(false);
		limpiar();
		jTabla.getSelectedRow();
		jTabla.setRowSelectionAllowed(false);
		listar();
	}
	
	void listar() {
		tabla.setRowCount(0);
		ClienteDAO hab=new ClienteDAO();
		List<ClienteDTO> habit=hab.listar();
		recorrerList(habit);
	}
	
	void filtrarId(int a) {
		tabla.setRowCount(0);
		ClienteDAO cb=new ClienteDAO();	
		List<ClienteDTO> listCB=cb.filtrarId(a);
		recorrerList(listCB);
	}
	String encontrariPais(String a) {
		
		String idpais=null;
		
		DireccionDAO ddao=new DireccionDAO();
		List<DireccionDTO> direc=ddao.listar();
		for(DireccionDTO c: direc) {
			if(c.getPais().equals(a)) {
				idpais=c.getId();
				break;
			}
	
		}
		
		return idpais;
	}
	
	String encontrarnPais(String a) {
		
		String npais=null;
		
		DireccionDAO ddao=new DireccionDAO();
		List<DireccionDTO> direc=ddao.listar();
		for(DireccionDTO c: direc) {
			if(c.getId().equals(a)) {
				npais=c.getPais();
				break;
			}
	
		}
		
		return npais;
	}
	
	private void recorrerList(List<ClienteDTO> a) {
		
		for(ClienteDTO b:a) {
			
			Object [] o = b.toString().split(";");
			
			tabla.addRow(o);
			
		}
		
	}
	
	private void tamanoColumnas() {
		
		int [] tamanio= {30,50,80,80,60,80,60};
		
		for(int i=0;i<tamanio.length;i++) {
			jTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
			jTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			
		}
		
	}
	
	private void setEnabledBtn(boolean a) {
		btnEliminar.setEnabled(a);
		btnModificar.setEnabled(a);
		btnanadir.setEnabled(!a);
		btnCancel.setVisible(a);
		
	}
	
	private void limpiar() {
		txtApellidos.setText("");
		txtNombres.setText("");
		txtCelular.setText("");
		txtCorreoElectronico.setText("");
		txtDocIdentidad.setText("");
		txtPais.setText("");
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
		int row = jTabla.rowAtPoint(e.getPoint());
		txtNombres.setText(tabla.getValueAt(row, 1).toString());
		txtApellidos.setText(tabla.getValueAt(row, 2).toString());
		txtDocIdentidad.setText(tabla.getValueAt(row, 3).toString());
		txtCelular.setText(tabla.getValueAt(row, 4).toString());
		txtCorreoElectronico.setText(tabla.getValueAt(row, 5).toString());
		txtPais.setText(encontrarnPais(tabla.getValueAt(row, 6).toString()));
		
		setEnabledBtn(true);
		jTabla.setRowSelectionAllowed(true);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
