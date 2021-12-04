package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelDAO.EmpleadoDAO;
import modelDTO.EmpleadoDTO;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

public class IDatosEmpleados extends JInternalFrame {
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
					IDatosEmpleados frame = new IDatosEmpleados();
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
	public IDatosEmpleados() {
		setClosable(true);
		setBounds(100, 100, 720, 491);
		getContentPane().setLayout(null);
		setTitle("Datos de los Empleados");
		//Color fondo
		getContentPane().setBackground(new Color( 32, 18, 58 ));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 101, 603, 328);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblDatosDeLas = new JLabel("DATOS DE LOS EMPLEADOS");
		lblDatosDeLas.setForeground(Color.WHITE);
		lblDatosDeLas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDatosDeLas.setBounds(30, 32, 339, 25);
		getContentPane().add(lblDatosDeLas);
		
		mostrarDatos();
		
	}
	
	public void mostrarDatos() {
		EmpleadoDTO emp=new EmpleadoDTO();
		EmpleadoDAO empdao=new EmpleadoDAO();
		List<EmpleadoDTO> lisemp=empdao.listar();
		txtS.setFont(new Font("JetBrains Mono",3,15));
		txtS.setText("\t\t\tDATOS \n\n");
		for(EmpleadoDTO e: lisemp) {
			txtS.append(e.getNombre()+" ");
			txtS.append(e.getApellidos()+" ");
			txtS.append(e.getCorreo()+" ");
			txtS.append(e.getDi()+" ");
			txtS.append("\n");
		}
		
	}
}
