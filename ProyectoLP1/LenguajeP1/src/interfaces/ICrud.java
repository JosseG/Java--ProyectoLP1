package interfaces;

import java.util.List;

public interface ICrud<Clase> {
	
	List<Clase> listar();
	boolean insertar(Clase c);
	boolean actualizar(Clase c);
	boolean eliminar(String s);
	

}
