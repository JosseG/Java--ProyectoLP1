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

public class BReservaHabitacion extends JInternalFrame implements ActionListener {
	private JLabel lblTipoDeHabitacin;
	private JLabel lblFechaDeReserva;
	private JLabel lblNmeroDeDias;
	private JLabel lblNivelDePiso;
	private JLabel lblCaracteristicasSolicitadas;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnCancelar;
	private JTextPane txts;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;

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
		
		lblTipoDeHabitacin = new JLabel("Tipo de habitaci\u00F3n");
		lblTipoDeHabitacin.setForeground(Color.WHITE);
		lblTipoDeHabitacin.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblTipoDeHabitacin.setBounds(38, 76, 119, 16);
		getContentPane().add(lblTipoDeHabitacin);
		
		lblFechaDeReserva = new JLabel("Fecha de reserva");
		lblFechaDeReserva.setForeground(Color.WHITE);
		lblFechaDeReserva.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblFechaDeReserva.setBounds(38, 132, 110, 16);
		getContentPane().add(lblFechaDeReserva);
		
		lblNmeroDeDias = new JLabel("N\u00FAmero de dias");
		lblNmeroDeDias.setForeground(Color.WHITE);
		lblNmeroDeDias.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNmeroDeDias.setBounds(38, 191, 102, 16);
		getContentPane().add(lblNmeroDeDias);
		
		lblNivelDePiso = new JLabel("Nivel de piso");
		lblNivelDePiso.setForeground(Color.WHITE);
		lblNivelDePiso.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNivelDePiso.setBounds(38, 246, 83, 16);
		getContentPane().add(lblNivelDePiso);
		
		lblCaracteristicasSolicitadas = new JLabel("Caracter\u00EDsticas solicitadas");
		lblCaracteristicasSolicitadas.setForeground(Color.WHITE);
		lblCaracteristicasSolicitadas.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCaracteristicasSolicitadas.setBounds(38, 300, 171, 16);
		getContentPane().add(lblCaracteristicasSolicitadas);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(new Color(130, 73, 229));
		btnNuevo.setBounds(38, 382, 89, 23);
		getContentPane().add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(130, 73, 229));
		btnEditar.setBounds(159, 383, 89, 23);
		getContentPane().add(btnEditar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(130, 73, 229));
		btnCancelar.setBounds(283, 382, 89, 23);
		getContentPane().add(btnCancelar);
		
		txts = new JTextPane();
		txts.setBackground(new Color(239, 238, 208));
		txts.setBounds(420, 43, 254, 363);
		getContentPane().add(txts);
		
		comboBox = new JComboBox();
		comboBox.setBounds(253, 71, 119, 21);
		getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(253, 127, 119, 21);
		getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(253, 186, 119, 21);
		getContentPane().add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(253, 241, 119, 21);
		getContentPane().add(comboBox_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(253, 295, 119, 21);
		getContentPane().add(comboBox_4);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}
}
