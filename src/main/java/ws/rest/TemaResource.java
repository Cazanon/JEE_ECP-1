package ws.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	
}
