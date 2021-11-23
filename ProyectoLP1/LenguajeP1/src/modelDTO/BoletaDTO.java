package modelDTO;

import java.sql.Date;

public class BoletaDTO {
	
	private String id,idEmp;
	private Date fecha;
	private String ruc,tipoPago;
	
	public BoletaDTO() {
		
	}
	
	public BoletaDTO(String id, String idEmp, Date fecha, String ruc, String tipoPago) {
		super();
		this.id = id;
		this.idEmp = idEmp;
		this.fecha = fecha;
		this.ruc = ruc;
		this.tipoPago = tipoPago;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(String idEmp) {
		this.idEmp = idEmp;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	
	@Override
	public String toString() {
		return getId()+";"+getIdEmp()+";"+getFecha()+";"+getRuc()+";"+getTipoPago();
	}
	

}
