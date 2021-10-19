package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class GDatosCliente extends JInternalFrame {
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
					GDatosCliente frame = new GDatosCliente();
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
	public GDatosCliente() {
		setClosable(true);
		setTitle("Datos del Cliente");
		setBounds(100, 100, 720, 491);
		getContentPane().setLayout(null);
		//Color fondo
		getContentPane().setBackground(new Color( 32, 18, 58 ));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 93, 615, 339);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblDatosDeLas = new JLabel("DATOS DEL CLIENTE:");
		lblDatosDeLas.setForeground(Color.WHITE);
		lblDatosDeLas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDatosDeLas.setBounds(29, 36, 339, 25);
		getContentPane().add(lblDatosDeLas);

	}
}
