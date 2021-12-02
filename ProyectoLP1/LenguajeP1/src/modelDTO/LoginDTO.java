package modelDTO;

import java.sql.Date;

public class LoginDTO {

	private int id;
	private String idCuenta;
	private Date fecha;
	
	public LoginDTO() {
		
	}
	
	public LoginDTO(int id, String idCuenta, Date fecha) {
		super();
		this.id = id;
		this.idCuenta = idCuenta;
		this.fecha = fecha;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIdCuenta() {
		return idCuenta;
	}


	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	
}
