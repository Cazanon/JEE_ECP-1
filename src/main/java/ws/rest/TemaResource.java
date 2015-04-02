package ws.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import ws.TemaUris;

@Path(TemaUris.PATH_TEMAS)
public class TemaResource {

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response create(Tema tema) {
		Response result;
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoFactory.getFactory().getTemaDao().create(tema);
		result = Response.created(URI.create(TemaUris.PATH_TEMAS + "/" + tema.getId()))
				.entity(String.valueOf(tema.getId())).build();
		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Tema> obtenerListaTemas() {
		DaoFactory.setFactory(new DaoJpaFactory());
		List<Tema> listaTemas = DaoFactory.getFactory().getTemaDao().findAll();
		return listaTemas;
	}

	@DELETE
	@Path(TemaUris.PATH_ID_PARAM)
	public void delete(@PathParam("id") Integer id) {
		DaoFactory.setFactory(new DaoJpaFactory());
    	DaoFactory.getFactory().getTemaDao().deleteById(id);
	}

}
