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
import util.ExpRegs;
import util.GestionCeldas;
import util.GestionEncabezadoTabla;

import javax.swing.JTextPane;
import java.awt.event.*;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class CRegistroCliente extends JInternalFrame implements ActionListener,MouseListener {
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDocIdentidad;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDocIdentidad;
	private JLabel lblCelular;
	private JLabel lblCorreo;
	private JTextField txtCelular;
	private JTextField txtCorreoElectronico;
	private JLabel lblPais;
	private JTextField txtPais;
	private JScrollPane scrollPane;
	private JTable jtTabla;
	private DefaultTableModel dtmTabla;

	private String Columnas[] = {"CODIGO","NOMBRE","APELLIDOS","DOCUMENTO IDENTIDAD", "TELEFONO", "CORREO","DIRECCION"};
	private JTextField txtBuscar;
	private JButton btnBuscar;
	
	private JTableHeader header;
	private JButton btnCancel;
	private JProgressBar pbCarga;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	
	private void CargarTabla() {
		dtmTabla = new DefaultTableModel();
		for(int i=0; i<Columnas.length; i++)dtmTabla.addColumn(Columnas[i]);
		jtTabla.setModel(dtmTabla);
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
		setBounds(100, 100, 804, 552);
		getContentPane().setLayout(null);
		//getContentPane().setBackground(new Color( 32, 18, 58 ));
		getContentPane().setBackground(new Color( 114, 173, 168  ));
		
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBackground(new Color(206, 228, 190));
		txtNombres.setBounds(186, 24, 340, 27);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(new Color(206, 228, 190));
		txtApellidos.setBounds(186, 64, 340, 27);
		getContentPane().add(txtApellidos);
		
		txtDocIdentidad = new JTextField();
		txtDocIdentidad.setColumns(10);
		txtDocIdentidad.setBackground(new Color(206, 228, 190));
		txtDocIdentidad.setBounds(186, 104, 170, 27);
		getContentPane().add(txtDocIdentidad);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNombres.setBounds(31, 24, 58, 16);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblApellidos.setBounds(31, 64, 60, 16);
		getContentPane().add(lblApellidos);
		
		lblDocIdentidad = new JLabel("Doc. Identidad");
		lblDocIdentidad.setForeground(Color.WHITE);
		lblDocIdentidad.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDocIdentidad.setBounds(31, 104, 94, 16);
		getContentPane().add(lblDocIdentidad);

		lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCelular.setBounds(31, 144, 46, 16);
		getContentPane().add(lblCelular);
		
		lblCorreo = new JLabel("Correo electronico");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCorreo.setBounds(29, 184, 118, 16);
		getContentPane().add(lblCorreo);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBackground(new Color(206, 228, 190));
		txtCelular.setBounds(186, 144, 170, 27);
		getContentPane().add(txtCelular);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setColumns(10);
		txtCorreoElectronico.setBackground(new Color(206, 228, 190));
		txtCorreoElectronico.setBounds(186, 184, 340, 27);
		getContentPane().add(txtCorreoElectronico);
		
		lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblPais.setForeground(Color.WHITE);
		lblPais.setBounds(31, 224, 28, 16);
		getContentPane().add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBackground(new Color(206, 228, 190));
		txtPais.setBounds(186, 224, 170, 27);
		getContentPane().add(txtPais);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 264, 729, 186);
		getContentPane().add(scrollPane);
		

		
		jtTabla = new JTable();
		jtTabla.getTableHeader().setReorderingAllowed(false);
		jtTabla.getTableHeader().setResizingAllowed(false);
		jtTabla.addMouseListener(this);
		jtTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		header=jtTabla.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla(new Color(35,200,70)));
		jtTabla.setTableHeader(header);
		scrollPane.setViewportView(jtTabla);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBounds(452, 460, 89, 28);
		getContentPane().add(btnBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(575, 460, 86, 28);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(335, 460, 89, 28);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnCancel);
		
		pbCarga = new JProgressBar();
		pbCarga.setForeground(new Color(50, 205, 50));
		pbCarga.setBounds(82, 474, 189, 14);
		getContentPane().add(pbCarga);
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadir.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		btnAnadir.addActionListener(this);
		btnAnadir.setForeground(Color.BLACK);
		btnAnadir.setEnabled(true);
		btnAnadir.setBackground(new Color(130, 73, 229));
		btnAnadir.setBounds(608, 80, 111, 28);
		getContentPane().add(btnAnadir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(this);
		btnModificar.setBackground(new Color(130, 73, 229));
		btnModificar.setBounds(608, 117, 111, 28);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(this);
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		btnEliminar.setBounds(608, 155, 111, 28);
		getContentPane().add(btnEliminar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CRegistroCliente.class.getResource("/img/add.png")));
		lblNewLabel.setBounds(736, 80, 24, 24);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CRegistroCliente.class.getResource("/img/iconmodify.png")));
		lblNewLabel_1.setBounds(736, 118, 24, 24);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(CRegistroCliente.class.getResource("/img/icondelete.png")));
		lblNewLabel_2.setBounds(736, 156, 24, 24);
		getContentPane().add(lblNewLabel_2);
		CargarTabla();
		tamanoColumnas();
		listar();
		limpiar();
		setEnabledBtn(false);
		pbCarga.setVisible(false);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		
		if(e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		
		if(e.getSource() == btnAnadir) {
			actionPerformedBtnanadir(e);
		}
		
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}

		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		
	}
	protected void actionPerformedBtnanadir(ActionEvent e) {
		ClienteDAO cldao=new ClienteDAO();
		ClienteDTO cldto=new ClienteDTO();
		try {
			if(txtNombres.getText().matches(ExpRegs.REGULAREXP_NOMBRE_APELLIDO)) {
				cldto.setNombre(txtNombres.getText());
				if(txtApellidos.getText().matches(ExpRegs.REGULAREXP_NOMBRE_APELLIDO)) {
					cldto.setApellidos(txtApellidos.getText());
					if(txtDocIdentidad.getText().matches(ExpRegs.REGULAREXP_DOCUMENTO)) {
						cldto.setDi(txtDocIdentidad.getText());
						if(txtCelular.getText().matches(ExpRegs.REGULAREXP_TELEFONO)) {
							cldto.setTelefono(txtCelular.getText());
							if(txtCorreoElectronico.getText().matches(ExpRegs.REGULAREXP_CORREO)) {
								cldto.setCorreo(txtCorreoElectronico.getText());

								cldto.setIdDireccion(encontrariPais(txtPais.getText()));
								cldao.insertar(cldto);
							}else {
								JOptionPane.showMessageDialog(null, "Correo incorrecto");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Telefono incorrecto");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Documento incorrecto");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Apellido incorrecto");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Nombre incorrecto");
			}


		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "");
		}

		listar();
		limpiar();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		if(!txtBuscar.getText().isEmpty()) {
			filtrarId(Integer.parseInt(txtBuscar.getText()));
		}else {
			JOptionPane.showMessageDialog(null, "Coloque un id");
		}
		
		
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {

		int row = jtTabla.getSelectedRow();
		int rpta=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar?");
		if(rpta==JOptionPane.OK_OPTION) {
			ClienteDAO cldao=new ClienteDAO();
			cldao.eliminar(dtmTabla.getValueAt(row, 0).toString());
			JOptionPane.showMessageDialog(null, "Correcto");
		}else {
			JOptionPane.showMessageDialog(null, "incorrecto");
		}
		limpiar();
		listar();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		Carga carga = new Carga(pbCarga);


		int row = jtTabla.getSelectedRow();
		ClienteDTO cldto=new ClienteDTO();
		ClienteDAO cldao=new ClienteDAO();
		carga.start();
		try {

			cldto.setId(Integer.parseInt(dtmTabla.getValueAt(row, 0).toString()));
			if(txtNombres.getText().matches(ExpRegs.REGULAREXP_NOMBRE_APELLIDO)) {
				cldto.setNombre(txtNombres.getText());
				if(txtApellidos.getText().matches(ExpRegs.REGULAREXP_NOMBRE_APELLIDO)) {
					cldto.setApellidos(txtApellidos.getText());
					if(txtDocIdentidad.getText().matches(ExpRegs.REGULAREXP_DOCUMENTO)) {
						cldto.setDi(txtDocIdentidad.getText());
						if(txtCelular.getText().matches(ExpRegs.REGULAREXP_TELEFONO)) {
							cldto.setTelefono(txtCelular.getText());
							if(txtCorreoElectronico.getText().matches(ExpRegs.REGULAREXP_CORREO)) {
								cldto.setCorreo(txtCorreoElectronico.getText());

								cldto.setIdDireccion(dtmTabla.getValueAt(row, 6).toString());
								cldao.actualizar(cldto);
							}else {
								JOptionPane.showMessageDialog(null, "Correo incorrecto");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Telefono incorrecto");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Documento incorrecto");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Apellido incorrecto");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Nombre incorrecto");
			}


		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Seleccione una fila");
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listar();
		limpiar();
		setEnabledBtn(false);

	}

	
	protected void btnCancelActionPerformed(ActionEvent e) {
		setEnabledBtn(false);
		limpiar();
		jtTabla.getSelectedRow();
		jtTabla.setRowSelectionAllowed(false);
		listar();
	}
	
	void listar() {
		dtmTabla.setRowCount(0);
		ClienteDAO hab=new ClienteDAO();
		List<ClienteDTO> habit=hab.listar();
		recorrerList(habit);
	}
	
	void filtrarId(int a) {
		dtmTabla.setRowCount(0);
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
			
			dtmTabla.addRow(o);
			
		}
		
	}
	
	private void tamanoColumnas() {
		
		int [] tamanio= {30,50,80,80,60,80,60};
		
		for(int i=0;i<tamanio.length;i++) {
			jtTabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
			jtTabla.getColumnModel().getColumn(i).setPreferredWidth(tamanio[i]);
			
		}
		
	}
	
	private void setEnabledBtn(boolean a) {
		btnEliminar.setEnabled(a);
		btnModificar.setEnabled(a);
		btnAnadir.setEnabled(!a);
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
		int row = jtTabla.rowAtPoint(e.getPoint());
		txtNombres.setText(dtmTabla.getValueAt(row, 1).toString());
		txtApellidos.setText(dtmTabla.getValueAt(row, 2).toString());
		txtDocIdentidad.setText(dtmTabla.getValueAt(row, 3).toString());
		txtCelular.setText(dtmTabla.getValueAt(row, 4).toString());
		txtCorreoElectronico.setText(dtmTabla.getValueAt(row, 5).toString());
		txtPais.setText(encontrarnPais(dtmTabla.getValueAt(row, 6).toString()));
		
		setEnabledBtn(true);
		jtTabla.setRowSelectionAllowed(true);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
