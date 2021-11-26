package modelDTO;

public class ClienteDTO {

	private int id;
	private String di,nombre,apellidos,telefono,correo,idDireccion;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(int id, String di, String nombre, String apellidos, String telefono, String correo,
			String idDireccion) {
		super();
		this.id = id;
		this.di = di;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.idDireccion = idDireccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}
	
	@Override
	public String toString() {
		return getId()+";"+getDi()+";"+getNombre()+";"+getApellidos()+";"+getTelefono()+";"+getCorreo()+";"+getIdDireccion();
	}
	
	
}
