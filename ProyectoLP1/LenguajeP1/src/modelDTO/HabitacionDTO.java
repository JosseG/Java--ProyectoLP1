package modelDTO;

import java.sql.Date;
import java.util.List;

import modelDAO.HabitacionDAO;

public class HabitacionDTO {

	public String id;
	public char tipo;
	public String descripcion;
	
	
	

	public HabitacionDTO(String id, char tipo, String descripcion) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public char getTipo() {
		return tipo;
	}




	public void setTipo(char tipo) {
		this.tipo = tipo;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	@Override
	public String toString() {
		return getId()+";"+getTipo()+";"+getDescripcion();
	}
	
}
