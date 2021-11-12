package modelDTO;

import java.sql.Date;

public class EmpleadoDTO {

	private String id,idRol,di,nombre,apellidos,telefono,correo;
	private Date fechaIngreso;
	
	public EmpleadoDTO() {
		
	}
	
	public EmpleadoDTO(String id, String idRol, String di, String nombre, String apellidos, String telefono,
			String correo, Date fechaIngreso) {
		super();
		this.id = id;
		this.idRol = idRol;
		this.di = di;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaIngreso = fechaIngreso;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdRol() {
		return idRol;
	}
	public void setIdRol(String idRol) {
		this.idRol = idRol;
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
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
	
	
	
	
}
