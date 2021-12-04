package util;

import javax.swing.*;




public class Carga extends Thread {
	
	JProgressBar barraProgreso;

	public Carga(JProgressBar a) {
		this.barraProgreso=a;

	}
	
	@Override
	public void run() {
		try {
			barraProgreso.setVisible(true);
			barraProgreso.setValue(0);
			for(int i=1;i<=100;i++) {
				barraProgreso.setValue(i);
				Thread.sleep(10);
			}
			barraProgreso.setVisible(false);
			JOptionPane.showMessageDialog(null, "Completado");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
