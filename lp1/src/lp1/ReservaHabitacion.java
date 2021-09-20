package lp1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class ReservaHabitacion extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
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
					ReservaHabitacion frame = new ReservaHabitacion();
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
	public ReservaHabitacion() {
		setTitle("Reserva de habitaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color( 32, 18, 58 ));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipoDeHabitacin = new JLabel("Tipo de habitaci\u00F3n");
		lblTipoDeHabitacin.setForeground(Color.WHITE);
		lblTipoDeHabitacin.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblTipoDeHabitacin.setBounds(36, 79, 119, 16);
		contentPane.add(lblTipoDeHabitacin);
		
		lblFechaDeReserva = new JLabel("Fecha de reserva");
		lblFechaDeReserva.setForeground(Color.WHITE);
		lblFechaDeReserva.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblFechaDeReserva.setBounds(36, 135, 110, 16);
		contentPane.add(lblFechaDeReserva);
		
		lblNmeroDeDias = new JLabel("N\u00FAmero de dias");
		lblNmeroDeDias.setForeground(Color.WHITE);
		lblNmeroDeDias.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNmeroDeDias.setBounds(36, 194, 102, 16);
		contentPane.add(lblNmeroDeDias);
		
		lblNivelDePiso = new JLabel("Nivel de piso");
		lblNivelDePiso.setForeground(Color.WHITE);
		lblNivelDePiso.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblNivelDePiso.setBounds(36, 249, 83, 16);
		contentPane.add(lblNivelDePiso);
		
		lblCaracteristicasSolicitadas = new JLabel("Caracter\u00EDsticas solicitadas");
		lblCaracteristicasSolicitadas.setForeground(Color.WHITE);
		lblCaracteristicasSolicitadas.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		lblCaracteristicasSolicitadas.setBounds(36, 303, 171, 16);
		contentPane.add(lblCaracteristicasSolicitadas);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(new Color(130, 73, 229));
		btnNuevo.setBounds(36, 385, 89, 23);
		contentPane.add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(130, 73, 229));
		btnEditar.setBounds(157, 386, 89, 23);
		contentPane.add(btnEditar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(130, 73, 229));
		btnCancelar.setBounds(281, 385, 89, 23);
		contentPane.add(btnCancelar);
		
		txts = new JTextPane();
		txts.setBackground(new Color(239, 238, 208));
		txts.setBounds(418, 46, 254, 363);
		contentPane.add(txts);
		
		comboBox = new JComboBox();
		comboBox.setBounds(251, 74, 119, 21);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(251, 130, 119, 21);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(251, 189, 119, 21);
		contentPane.add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(251, 244, 119, 21);
		contentPane.add(comboBox_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(251, 298, 119, 21);
		contentPane.add(comboBox_4);
	}
}
