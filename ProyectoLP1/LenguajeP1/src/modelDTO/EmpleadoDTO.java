package modelDTO;

import java.sql.Date;
import java.util.List;

import modelDAO.EmpleadoDAO;

public class EmpleadoDTO {

	private String id,idRol,di,nombre,apellidos,telefono,correo;

	public EmpleadoDTO() {
		
	}
	
	public EmpleadoDTO(String id, String idRol, String di, String nombre, String apellidos, String telefono,
			String correo) {
		super();
		this.id = id;
		this.idRol = idRol;
		this.di = di;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public void setIdRol(String idRol) {
		this.idRol=idRol;
	}
	public String getIdRol() {
		return idRol;
	}
	public String getDi() {
		return di;
	}
	public void setDi(String di) {
		this.di = di;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}


	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + ";" + getIdRol()+";" + getDi() + ";" + getNombre() + ";" + getApellidos() + ";" + getTelefono() + ";" +getCorreo();
	}

	
}
