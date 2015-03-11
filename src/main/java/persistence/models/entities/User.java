package persistence.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
    @GeneratedValue
    private Integer id;
	
	private String name;
	
	private String password;
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public User() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public boolean equals(Object obj) {
        assert obj != null;
        User other = (User) obj;
        boolean result = id.equals(other.id) && name.equals(other.name)
                && password.equals(other.password);
        
        return result;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
    }
	
}
