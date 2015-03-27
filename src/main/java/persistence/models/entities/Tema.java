package persistence.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tema {

	public static final String TABLE = "tema";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String PREGUNTA = "pregunta";

	@Id
    @GeneratedValue
    private Integer id;
	
	private String name;
	
	private String pregunta;
	
	// Relación unidireccional: 1:0..n
    // relación mapeada en una tabla de unión
    // Se aplica cascada
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Voto> votos;
    
    public Tema(String name, String pregunta, List<Voto> votos) {
		this.name = name;
		this.pregunta = pregunta;
		this.votos = votos;
	}
    
    public Tema(String name, String pregunta) {
		this.name = name;
		this.pregunta = pregunta;
		this.setVotos(new ArrayList<Voto>());
	}
    
    public Tema(){
    	this.setVotos(new ArrayList<Voto>());
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
	public void setVoto(Voto voto) {
		if(this.getVotos() == null) {
			this.setVotos(new ArrayList<Voto>());
		}
		this.getVotos().add(voto);
	}
	
	@Override
    public boolean equals(Object obj) {
		assert obj != null;
        Tema other = (Tema) obj;
        boolean result = id.equals(other.id) && name.equals(other.name)
                && pregunta.equals(other.pregunta);
        
        return result;
    }

    @Override
    public String toString() {
    	return "Tema [id=" + id + ", name=" + name + ", pregunta=" + pregunta 
    			+ ", votos=" + votos + "]";
    }

}
