package modelDTO;

public class ConsultaHabitacionDTO {

	private String codCliente;
	private String nombreCliente;
	private String apellidCliente;
	private String idHab;
	private String descripcionHab;
	private char tipoHab;
	
	public ConsultaHabitacionDTO() {
		
	}
	

	public ConsultaHabitacionDTO(String codCliente, String nombreCliente, String apellidCliente, String idHab ,String descripcionHab,
			char tipoHab) {
		super();
		this.codCliente = codCliente;
		this.nombreCliente = nombreCliente;
		this.apellidCliente = apellidCliente;
		this.idHab = idHab;
		this.descripcionHab = descripcionHab;
		this.tipoHab = tipoHab;
	}


	public String getCodCliente() {
		return codCliente;
	}


	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}




	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}




	public String getApellidCliente() {
		return apellidCliente;
	}




	public void setApellidCliente(String apellidCliente) {
		this.apellidCliente = apellidCliente;
	}




	public String getDescripcionHab() {
		return descripcionHab;
	}


	public void setDescripcionHab(String descripcionHab) {
		this.descripcionHab = descripcionHab;
	}
	

	public char getTipoHab() {
		return tipoHab;
	}




	public void setTipoHab(char tipoHab) {
		this.tipoHab = tipoHab;
	}






	public String getIdHab() {
		return idHab;
	}


	public void setIdHab(String idHab) {
		this.idHab = idHab;
	}
	
	public String toString() {
		return getCodCliente()+";"+getNombreCliente()+";"+getApellidCliente()+";"+getIdHab()+";"+getDescripcionHab()+";"+getTipoHab();
	}

	
	
}
