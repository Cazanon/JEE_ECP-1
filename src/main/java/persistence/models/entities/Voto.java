package persistence.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import persistence.models.utils.NivelEstudios;

@Entity
public class Voto {

	@Id
	@GeneratedValue
	private Integer id;

	private int valoracion;

	private String ipUsuario;

	@Enumerated(EnumType.STRING)
	private NivelEstudios nivelEstudios;

	public Voto(int valoracion, String ipUsuario, NivelEstudios nivelEstudios) {
		this.valoracion = valoracion;
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

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int escala) {
		this.valoracion = escala;
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
	
}
