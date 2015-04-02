package persistence.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import persistence.models.utils.NivelEstudios;

@Entity
@XmlRootElement
public class Voto {

	public static final String TABLE = "voto";
	public static final String ID = "id";
	public static final String VALORACION = "valoracion";
	public static final String IPUSUARIO = "ipUsuario";
	public static final String NIVELESTUDIOS = "nivelEstudios";

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

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
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

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		Voto other = (Voto) obj;
		boolean result = id.equals(other.id) && valoracion == other.valoracion &&
				ipUsuario.equals(other.ipUsuario) && nivelEstudios.equals(other.nivelEstudios);

		return result;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", valoracion=" + valoracion + ", ipUsuario=" + ipUsuario + 
				"nivelEstudios=" + nivelEstudios + "]";
	}

}
