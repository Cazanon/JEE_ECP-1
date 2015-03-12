package persistence.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tema {
	
	public static final Object TABLE = null;

	@Id
    @GeneratedValue
    private Integer id;
	
	private String name;
	
	public Tema(String name) {
		this.name = name;
	}
	
	public Tema() {
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
	
	@Override
    public boolean equals(Object obj) {
        assert obj != null;
        Tema other = (Tema) obj;
        boolean result = id.equals(other.id) && name.equals(other.name);
        
        return result;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

}
