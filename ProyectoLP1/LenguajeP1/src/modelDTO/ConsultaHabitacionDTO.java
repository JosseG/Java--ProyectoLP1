package modelDTO;

public class ConsultaHabitacionDTO {

	private String codCliente;
	private int nDias;
	private String descHab;
	private char tipoHab;
	private double precioDia;
	
	public ConsultaHabitacionDTO() {
		
	}
	public ConsultaHabitacionDTO(String codCliente, int nDias, String descHab, char tipoHab, double precioDia) {
		super();
		this.codCliente = codCliente;
		this.nDias = nDias;
		this.descHab = descHab;
		this.tipoHab = tipoHab;
		this.precioDia = precioDia;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public int getnDias() {
		return nDias;
	}

	public void setnDias(int nDias) {
		this.nDias = nDias;
	}

	public String getDescHab() {
		return descHab;
	}

	public void setDescHab(String descHab) {
		this.descHab = descHab;
	}

	public char getTipoHab() {
		return tipoHab;
	}

	public void setTipoHab(char tipoHab) {
		this.tipoHab = tipoHab;
	}

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}
	
	public String toString() {
		return getCodCliente()+";"+getnDias()+";"+getDescHab()+";"+getTipoHab()+";"+getPrecioDia();
	}
	
	
}
