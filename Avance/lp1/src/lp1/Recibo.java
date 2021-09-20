package lp1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class Recibo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recibo frame = new Recibo();
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
	public Recibo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID CLIENTES");
		lblNewLabel.setBounds(104, 46, 77, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(177, 43, 154, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setBackground(Color.LIGHT_GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, "", null},
			},
			new String[] {
				"COD-CLIENTE", "N\u00B0DIAS", "CARACTERISTICAS", "PISO", "TIPO DE HABITACION", "ESTADO", "PRECIO"
			}
		));
		table.setAutoCreateRowSorter(true);
		table.setBounds(10, 81, 525, 144);
		contentPane.add(table);
	}

}