package view;

import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class BReservaHabitacion extends JInternalFrame implements ActionListener {
	private JLabel lblTipoHabitacin;
	private JLabel lblFechaReserva;
	private JLabel lblNumeroDeDias;
	private JLabel lblDescripcion;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JTextPane txts;
	private JComboBox comboBox;
	private JTextField txtDescripcion;
	private JLabel lblCodigoHabitacion;
	private JTextField txtCodigoHabitacion;
	private JTextField txtFechaReserva;
	private JTextField txtNumeroDias;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	private JTextField txtTipoPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BReservaHabitacion frame = new BReservaHabitacion();
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
	public BReservaHabitacion() {
		setClosable(true);
		setTitle("Reserva de Habitaci\u00F3n");
		setBounds(100, 100, 720, 491);
		getContentPane().setLayout(null);
		setBackground(new Color( 32, 18, 58 ));
		
		lblTipoHabitacin = new JLabel("Tipo de habitaci\u00F3n");
		lblTipoHabitacin.setForeground(Color.WHITE);
		lblTipoHabitacin.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblTipoHabitacin.setBounds(38, 114, 119, 16);
		getContentPane().add(lblTipoHabitacin);
		
		lblFechaReserva = new JLabel("Fecha de reserva");
		lblFechaReserva.setForeground(Color.WHITE);
		lblFechaReserva.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblFechaReserva.setBounds(38, 167, 110, 16);
		getContentPane().add(lblFechaReserva);
		
		lblNumeroDeDias = new JLabel("N\u00FAmero de dias");
		lblNumeroDeDias.setForeground(Color.WHITE);
		lblNumeroDeDias.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNumeroDeDias.setBounds(38, 209, 102, 16);
		getContentPane().add(lblNumeroDeDias);
		
		lblDescripcion = new JLabel("Descripci\u00F2n");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblDescripcion.setBounds(38, 252, 171, 16);
		getContentPane().add(lblDescripcion);
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.addActionListener(this);
		btnAnadir.setForeground(Color.WHITE);
		btnAnadir.setBackground(new Color(130, 73, 229));
		btnAnadir.setBounds(38, 362, 89, 23);
		getContentPane().add(btnAnadir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(130, 73, 229));
		btnModificar.setBounds(159, 363, 89, 23);
		getContentPane().add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(130, 73, 229));
		btnConsultar.setBounds(283, 362, 89, 23);
		getContentPane().add(btnConsultar);
		
		txts = new JTextPane();
		txts.setBackground(new Color(239, 238, 208));
		txts.setBounds(420, 43, 254, 363);
		getContentPane().add(txts);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Una persona", "Dos personas", "Matrimonial"}));
		comboBox.setBounds(253, 113, 119, 21);
		getContentPane().add(comboBox);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(253, 252, 96, 19);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		lblCodigoHabitacion = new JLabel("C\u00F2digo de habitaci\u00F2n");
		lblCodigoHabitacion.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCodigoHabitacion.setForeground(Color.WHITE);
		lblCodigoHabitacion.setBounds(38, 53, 137, 16);
		getContentPane().add(lblCodigoHabitacion);
		
		txtCodigoHabitacion = new JTextField();
		txtCodigoHabitacion.setBounds(253, 53, 96, 19);
		getContentPane().add(txtCodigoHabitacion);
		txtCodigoHabitacion.setColumns(10);
		
		txtFechaReserva = new JTextField();
		txtFechaReserva.setColumns(10);
		txtFechaReserva.setBounds(253, 167, 96, 19);
		getContentPane().add(txtFechaReserva);
		
		txtNumeroDias = new JTextField();
		txtNumeroDias.setColumns(10);
		txtNumeroDias.setBounds(253, 209, 96, 19);
		getContentPane().add(txtNumeroDias);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBorder(new LineBorder(new Color(252, 80, 156), 1, true));
		btnEliminar.setBackground(new Color(130, 73, 229));
		btnEliminar.setBounds(159, 396, 89, 23);
		getContentPane().add(btnEliminar);
		
		lblNewLabel = new JLabel("Tipo de pago");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 292, 83, 16);
		getContentPane().add(lblNewLabel);
		
		txtTipoPago = new JTextField();
		txtTipoPago.setBounds(253, 292, 96, 19);
		getContentPane().add(txtTipoPago);
		txtTipoPago.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAnadir) {
			actionPerformedBtnNuevo(arg0);
		}
		// TODO Auto-generated method stub
		
		
		
	}
	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		
	}
}
