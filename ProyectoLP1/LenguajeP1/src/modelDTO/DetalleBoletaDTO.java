package modelDTO;

public class DetalleBoletaDTO {

	private String id;
	private int idCliente;
	private String idHab;
	private double precio;
	private double precioExtra;
	
	public DetalleBoletaDTO() {
		
	}

	public DetalleBoletaDTO(String id, int idCliente, String idHab, double precio, double precioExtra) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idHab = idHab;
		this.precio = precio;
		this.precioExtra = precioExtra;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdHab() {
		return idHab;
	}

	public void setIdHab(String idHab) {
		this.idHab = idHab;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecioExtra() {
		return precioExtra;
	}

	public void setPrecioExtra(double precioExtra) {
		this.precioExtra = precioExtra;
	}

	@Override
	public String toString() {
		return getId()+";"+getIdCliente()+";"+getIdHab()+";"+getPrecio()+";"+getPrecioExtra();
	}

	
}
