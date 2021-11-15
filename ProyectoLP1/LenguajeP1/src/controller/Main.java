package controller;

import java.awt.EventQueue;

import javax.swing.UIManager;

import modelDAO.HabitacionDAO;
import modelDTO.EmpleadoDTO;
import modelDTO.HabitacionDTO;
import view.AMenuPrincipal;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					
					//-------------------Diseño del S.O Windows----------------
					
					/*HabitacionDTO habDTO=new HabitacionDTO();
					EmpleadoDTO empDTO=new EmpleadoDTO();
					for(HabitacionDTO h:habDTO.listar()) {
						System.out.println(h.getId_hab()+"\t"+h.getTipo_hab()+"\t"+ h.getDisp_hab()+"\t"+ h.getDescripcion_hab());
					}
					for(EmpleadoDTO e:empDTO.listar()) {
						System.out.println(e.getId()+" \t| "+e.getNombre()+" \t| "+e.getApellidos()+" \t| "+ e.getCorreo()+" \t| "+ e.getDi()+" \t| "+e.getIdRol());
					}*/
					
					
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
					AMenuPrincipal frame = new AMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
