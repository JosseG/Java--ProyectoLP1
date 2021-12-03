package util;

import javax.swing.*;




public class Carga extends Thread {
	
	JProgressBar barraProgreso;

	
	
	
	public Carga(JProgressBar a) {
		this.barraProgreso=a;

	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			barraProgreso.setVisible(true);
			Thread.sleep(1000);
			for(int i=1;i<=100;i++) {
				barraProgreso.setValue(i);
				Thread.sleep(50);
				System.out.println("a");
			}
			JOptionPane.showMessageDialog(null, "Completado");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
