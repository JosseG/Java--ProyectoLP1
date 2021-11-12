package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class HDatosHabitaciones extends JInternalFrame {
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblDatosDeLas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HDatosHabitaciones frame = new HDatosHabitaciones();
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
	public HDatosHabitaciones() {
		setClosable(true);
		setBounds(100, 100, 720, 491);
		getContentPane().setLayout(null);
		setTitle("Datos de las Habitaciones");
		//Color fondo
		getContentPane().setBackground(new Color( 32, 18, 58 ));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 103, 601, 314);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblDatosDeLas = new JLabel("DATOS DE LAS HABITACIONES:");
		lblDatosDeLas.setForeground(Color.WHITE);
		lblDatosDeLas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDatosDeLas.setBounds(43, 42, 339, 25);
		getContentPane().add(lblDatosDeLas);
		

	}

}
