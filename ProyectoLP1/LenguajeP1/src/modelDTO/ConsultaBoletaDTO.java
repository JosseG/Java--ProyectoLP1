package modelDTO;

import java.sql.Date;

public class ConsultaBoletaDTO {

	private int idBol;
	private String nomEmp,nomCli;
	private Date fechaBol;
	private String rucBol,tipoPago;
	private int nDias;
	private double precioDia;
	private double precioTotal;
	
	public ConsultaBoletaDTO() {
		
	}
	
	public ConsultaBoletaDTO(int idBol, String nomEmp, String nomCli, Date fechaBol, String rucBol, String tipoPago,
			int nDias, double precioDia, double precioTotal) {
		super();
		this.idBol = idBol;
		this.nomEmp = nomEmp;
		this.nomCli = nomCli;
		this.fechaBol = fechaBol;
		this.rucBol = rucBol;
		this.tipoPago = tipoPago;
		this.nDias = nDias;
		this.precioDia = precioDia;
		this.precioTotal = precioTotal;
	}

	public int getIdBol() {
		return idBol;
	}

	public void setIdBol(int idBol) {
		this.idBol = idBol;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public Date getFechaBol() {
		return fechaBol;
	}

	public void setFechaBol(Date fechaBol) {
		this.fechaBol = fechaBol;
	}

	public String getRucBol() {
		return rucBol;
	}

	public void setRucBol(String rucBol) {
		this.rucBol = rucBol;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public int getnDias() {
		return nDias;
	}

	public void setnDias(int nDias) {
		this.nDias = nDias;
	}

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	@Override
	public String toString() {
		return getIdBol()+";"+getNomEmp()+";"+getNomCli()+";"+getFechaBol()+";"+getRucBol()+";"+getTipoPago()+";"+getnDias()+";"+getPrecioDia()+";"+getPrecioTotal();
	}
	
	
	
	
}
