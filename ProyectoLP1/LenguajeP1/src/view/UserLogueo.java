package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class UserLogueo extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblUsuario;
	private JLabel lblContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogueo frame = new UserLogueo();
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
	public UserLogueo() {
		setTitle("IngresoLogueo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Acceso");
		btnNewButton.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		btnNewButton.setBounds(379, 81, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		btnNewButton_1.setBounds(379, 127, 85, 21);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(183, 82, 122, 19);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(183, 128, 122, 19);
		contentPane.add(textField_1);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setIcon(new ImageIcon(UserLogueo.class.getResource("/img/iconuser.png")));
		lblUsuario.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBounds(37, 79, 78, 24);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setIcon(new ImageIcon(UserLogueo.class.getResource("/img/iconcontrasena.png")));
		lblContrasea.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasea.setBounds(37, 125, 100, 24);
		contentPane.add(lblContrasea);
	}
}
