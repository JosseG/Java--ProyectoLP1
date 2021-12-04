package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import modelDAO.ClienteDAO;
import modelDTO.ClienteDTO;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PruebaReserva extends JInternalFrame implements ActionListener {
	private JTable jtTable;
	private JTextField txtCodigoCliente;
	private JTextField txtNombreCliente;
	private JTextField txtApellidos;
	private JTextField txtRUC;
	private JTextField txtNumero;
	private JTextField txtCodigoHab;
	private JTextField txtTipoHab;
	private JTextField txtDescripcionHab;
	private JButton btnNuevo;
	private JButton btnReservar;
	private JButton btnBuscarCliente;
	private JButton btnBuscarHabitación;
	private JButton btnAnadirHab;
	private JButton btnAnadirCliente;
	private JDesktopPane panels;
	private JComboBox comboBox;
	private JLabel lblFecha;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PruebaReserva(JDesktopPane paneln) {
		this.panels=paneln;
		setClosable(true);
		setBounds(100, 100, 708, 525);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel.setBounds(10, 22, 370, 139);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATOS DEL CLIENTE");
		lblNewLabel.setBounds(121, 11, 114, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre : ");
		lblNewLabel_1.setBounds(33, 73, 60, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos : ");
		lblNewLabel_2.setBounds(33, 98, 72, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("C\u00F3digo : ");
		lblNewLabel_3.setBounds(33, 48, 46, 14);
		panel.add(lblNewLabel_3);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(89, 42, 86, 20);
		panel.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setColumns(10);
		txtNombreCliente.setBounds(89, 70, 86, 20);
		panel.add(txtNombreCliente);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(89, 95, 148, 20);
		panel.add(txtApellidos);
		
		btnBuscarCliente = new JButton("BTN");
		btnBuscarCliente.addActionListener(this);
		btnBuscarCliente.setBounds(185, 40, 64, 23);
		panel.add(btnBuscarCliente);
		
		btnAnadirCliente = new JButton("A\u00F1adir");
		btnAnadirCliente.addActionListener(this);
		btnAnadirCliente.setBounds(259, 98, 89, 23);
		panel.add(btnAnadirCliente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_1.setBounds(450, 22, 234, 139);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRUC = new JLabel("RUC");
		lblRUC.setBounds(10, 33, 46, 14);
		panel_1.add(lblRUC);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(10, 66, 46, 14);
		panel_1.add(lblNumero);
		
		txtRUC = new JTextField();
		txtRUC.setBounds(66, 30, 136, 20);
		panel_1.add(txtRUC);
		txtRUC.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(66, 63, 136, 20);
		panel_1.add(txtNumero);
		
		lblFecha = new JLabel("11-11-2021");
		lblFecha.setBounds(92, 100, 69, 14);
		panel_1.add(lblFecha);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_2.setBounds(10, 185, 674, 89);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("DATOS DE LA HABITACI\u00D3N");
		lblNewLabel_5.setBounds(281, 11, 158, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("C\u00F3digo : ");
		lblNewLabel_6.setBounds(10, 34, 46, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo : ");
		lblNewLabel_7.setBounds(10, 64, 46, 14);
		panel_2.add(lblNewLabel_7);
		
		txtCodigoHab = new JTextField();
		txtCodigoHab.setBounds(64, 31, 170, 20);
		panel_2.add(txtCodigoHab);
		txtCodigoHab.setColumns(10);
		
		txtTipoHab = new JTextField();
		txtTipoHab.setBounds(66, 61, 86, 20);
		panel_2.add(txtTipoHab);
		txtTipoHab.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Descripci\u00F3n : ");
		lblNewLabel_8.setBounds(340, 37, 77, 14);
		panel_2.add(lblNewLabel_8);
		
		txtDescripcionHab = new JTextField();
		txtDescripcionHab.setBounds(415, 36, 143, 42);
		panel_2.add(txtDescripcionHab);
		txtDescripcionHab.setColumns(10);
		
		btnBuscarHabitación = new JButton("BTN");
		btnBuscarHabitación.addActionListener(this);
		btnBuscarHabitación.setBounds(244, 30, 64, 23);
		panel_2.add(btnBuscarHabitación);
		
		btnAnadirHab = new JButton("A\u00F1adir");
		btnAnadirHab.addActionListener(this);
		btnAnadirHab.setBounds(575, 60, 89, 23);
		panel_2.add(btnAnadirHab);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 285, 674, 159);
		getContentPane().add(scrollPane);
		
		jtTable = new JTable();
		scrollPane.setViewportView(jtTable);
		
		JLabel lblPago = new JLabel("Tipo de pago :");
		lblPago.setBounds(10, 470, 81, 14);
		getContentPane().add(lblPago);
		
		comboBox = new JComboBox();
		comboBox.setBounds(101, 466, 96, 18);
		getContentPane().add(comboBox);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(450, 466, 89, 23);
		getContentPane().add(btnNuevo);
		
		btnReservar = new JButton("RESERVAR");
		btnReservar.addActionListener(this);
		btnReservar.setBounds(562, 455, 122, 34);
		getContentPane().add(btnReservar);

	}




	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAnadirCliente) {
			actionPerformedBtnAnadirCliente(e);
		}
		if (e.getSource() == btnAnadirHab) {
			actionPerformedBtnAnadirHab(e);
		}
		if (e.getSource() == btnBuscarCliente) {
			actionPerformedBtnBuscarCliente(e);
		}
		if (e.getSource() == btnBuscarHabitación) {
			actionPerformedBtnBuscarHab(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnReservar) {
			actionPerformedBtnReservar(e);
		}
	}
	
	
	protected void actionPerformedBtnAnadirCliente(ActionEvent e) {
		
		CRegistroCliente Res1 = new CRegistroCliente();
		Res1.setLocation((panels.getWidth()-720)/2,(panels.getHeight()-491)/2);
		Res1.setVisible(true);
		panels.add(Res1);
		Res1.toFront();
		
	}
	protected void actionPerformedBtnAnadirHab(ActionEvent e) {
		
		BRegistroHabitacion Res2= new BRegistroHabitacion();
		Res2.setLocation((panels.getWidth()-720)/2,(panels.getHeight()-491)/2);
		Res2.setVisible(true);
		panels.add(Res2);
		Res2.toFront();
		
	}
	protected void actionPerformedBtnBuscarCliente(ActionEvent e) {
		try {
			
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Nombre incorreo");
		}
	}
	protected void actionPerformedBtnBuscarHab(ActionEvent e) {
		
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
	}
	protected void actionPerformedBtnReservar(ActionEvent e) {
		
	}
	
	
	List<ClienteDTO> listCli(int lado){
		ClienteDAO cldao=new ClienteDAO();
		List<ClienteDTO> listCliData =new ArrayList<ClienteDTO>();
		List<ClienteDTO> listCli=cldao.listar();
		
		for(ClienteDTO a :  listCli ) {
			if(a.getId()==lado) {
				listCliData.add(a);
				return listCli;
			}
		}
		
		return null;
	}
	
	
}
