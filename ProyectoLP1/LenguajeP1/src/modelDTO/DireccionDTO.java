package modelDTO;

public class DireccionDTO {

	private String id,pais;
	
	public DireccionDTO() {
		
	}

	public DireccionDTO(String id,  String pais) {
		super();
		this.id = id;
		this.pais = pais;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
