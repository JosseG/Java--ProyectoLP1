package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelDAO.ClienteDAO;
import modelDAO.EmpleadoDAO;
import modelDTO.ClienteDTO;
import modelDTO.EmpleadoDTO;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

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
		lblDatosDeLas.setBounds(50, 34, 339, 25);
		getContentPane().add(lblDatosDeLas);
		
		mostrarDatos();

	}
	
	
	public void mostrarDatos() {
		ClienteDTO emp=new ClienteDTO();
		ClienteDAO clientedao=new ClienteDAO();
		List<ClienteDTO> lisemp=clientedao.listar();
		txtS.setFont(new Font("JetBrains Mono",3,15));
		txtS.setText("\t\t\tDATOS \n\n");
		for(ClienteDTO e: lisemp) {
			txtS.append(e.getNombre()+" ");
			txtS.append(e.getApellidos()+" ");
			txtS.append(e.getCorreo()+" ");
			txtS.append(e.getDi()+" ");
			txtS.append("\n");
		}
	}
}
