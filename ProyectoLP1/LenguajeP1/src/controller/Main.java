package controller;

import java.awt.EventQueue;
import javax.swing.UIManager;


import modelDTO.EmpleadoDTO;
import modelDTO.HabitacionDTO;
import view.AMenuPrincipal;
import view.Prueba;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					
					//-------------------Diseño del S.O Windows----------------
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					AMenuPrincipal frame = new AMenuPrincipal();
					frame.setVisible(true);
					
				} catch(Exception e) {
					
					e.printStackTrace();
					
				} 
				
			}
		});
		
	}
	
}
