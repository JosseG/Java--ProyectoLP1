package modelDTO;

public class DireccionDTO {

	private String id,descripcion,pais;
	
	public DireccionDTO() {
		
	}

	public DireccionDTO(String id, String descripcion, String pais) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.pais = pais;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
