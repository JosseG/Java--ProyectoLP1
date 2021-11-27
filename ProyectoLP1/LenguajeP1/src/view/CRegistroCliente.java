package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import modelDAO.ClienteDAO;
import modelDAO.ConsultaHabitacionDAO;
import modelDAO.DireccionDAO;
import modelDTO.ClienteDTO;
import modelDTO.ConsultaHabitacionDTO;
import modelDTO.DireccionDTO;
import modelDTO.LoginDTO;
import util.GestionCeldas;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class CRegistroCliente extends JInternalFrame implements ActionListener {
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDocIdentidad;
	private JButton btnanadir;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDocIdentidad;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JLabel lblCelular;
	private JLabel lblCorreo;
	private JLabel lblIdDireccion;
	private JTextField txtCelular;
	private JTextField txtCorreoElectronico;
	private JTextField txtIdDireccion;
	private JLabel lblDireccion;
	private JLabel lblPais;
	private JTextField txtDireccion;
	private JTextField txtPais;
	private StyledDocument doc;
	private JScrollPane scrollPane;
	private JTable jTabla;
	private DefaultTableModel tabla;

	private String Columnas[] = {"CODIGO","DOCUMENTO IDENTIDAD","NOMBRE","APELLIDOS", "TELEFONO", "CORREO","DIRECCION"};
	private JTextField textField;
	private JButton btnBuscar;
	
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
		btnModificar.setBounds(576, 102, 89, 23);
		getContentPane().add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(130, 73, 229));
		btnConsultar.setBounds(576, 155, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		btnEliminar.setBounds(576, 208, 89, 23);
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
		
		lblIdDireccion = new JLabel("ID direcci\u00F3n");
		lblIdDireccion.setForeground(Color.WHITE);
		lblIdDireccion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblIdDireccion.setBounds(29, 180, 133, 16);
		getContentPane().add(lblIdDireccion);
		
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
		
		txtIdDireccion = new JTextField();
		txtIdDireccion.setColumns(10);
		txtIdDireccion.setBackground(new Color(206, 228, 190));
		txtIdDireccion.setBounds(177, 180, 170, 16);
		txtIdDireccion.setText(new DireccionDAO().generarCodigo());
		txtIdDireccion.setEditable(false);
		getContentPane().add(txtIdDireccion);
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setBounds(29, 211, 61, 16);
		getContentPane().add(lblDireccion);
		
		lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblPais.setForeground(Color.WHITE);
		lblPais.setBounds(29, 238, 28, 16);
		getContentPane().add(lblPais);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(new Color(206, 228, 190));
		txtDireccion.setBounds(177, 208, 170, 16);
		getContentPane().add(txtDireccion);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBackground(new Color(206, 228, 190));
		txtPais.setBounds(177, 239, 170, 16);
		getContentPane().add(txtPais);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 281, 644, 158);
		getContentPane().add(scrollPane);
		
		jTabla = new JTable();
		scrollPane.setViewportView(jTabla);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(452, 460, 89, 23);
		getContentPane().add(btnBuscar);
		
		textField = new JTextField();
		textField.setBounds(563, 461, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		CargarTabla();
		tamanoColumnas();
		listar();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnanadir) {
			actionPerformedBtnanadir(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
		
		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		
		
	}
	protected void actionPerformedBtnanadir(ActionEvent e) {
		ClienteDAO cldao=new ClienteDAO();
		DireccionDAO ddao=new DireccionDAO();
		ClienteDTO cldto=new ClienteDTO();
		DireccionDTO ddto=new DireccionDTO();
		try {
			
			cldto.setDi(txtDocIdentidad.getText());
			cldto.setNombre(txtNombres.getText());
			cldto.setApellidos(txtApellidos.getText());
			cldto.setTelefono(txtCelular.getText());
			cldto.setCorreo(txtCorreoElectronico.getText());
			cldto.setIdDireccion(txtDireccion.getText());
			ddto.setId(txtIdDireccion.getText());
			ddto.setDescripcion(txtDireccion.getText());
			ddto.setPais(txtPais.getText());
			
			cldao.insertar(cldto);
			ddao.insertar(ddto);
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	void listar() {
		tabla.setRowCount(0);
		ClienteDAO hab=new ClienteDAO();
		List<ClienteDTO> habit=hab.listar();
		recorrerList(habit);
	}
	
	private void recorrerList(List<ClienteDTO> a) {
		
		for(ClienteDTO b:a) {
			
			Object [] o = b.toString().split(";");
			
			tabla.addRow(o);
			
			
		}
		
	}
	
	private void tamanoColumnas() {
		
		int [] tamanio= {40,80,80,80,80,80,80};
		
		for(int i=0;i<tamanio.length;i++) {
			jTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
			jTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			
		}
		
		
	}
}
