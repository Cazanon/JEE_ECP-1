package persistence.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import persistence.models.utils.NivelEstudios;

@Entity
public class Voto {

	@Id
	@GeneratedValue
	private Integer id;

	private int escala;

	private String ipUsuario;

	@Enumerated(EnumType.STRING)
	private NivelEstudios nivelEstudios;

	// Relación unidireccional: 0..*:1
	// relación mapeada aqui
	// Se aplica cascada
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private User user;

	// Relación unidireccional: 0..*:1
	// relación mapeada aqui
	// Se aplica cascada
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Tema tema;

	public Voto(int escala, String ipUsuario, NivelEstudios nivelEstudios) {
		this.escala = escala;
		this.ipUsuario = ipUsuario;
		this.nivelEstudios = nivelEstudios;
	}

	public Voto() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getEscala() {
		return escala;
	}

	public void setEscala(int escala) {
		this.escala = escala;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
}
