package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;

public class TemaDaoJpaTest {
    private TemaDao dao;

    private Tema tema;
    
    private Voto voto;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.tema = new Tema("tema","pregunta");
        this.voto = new Voto(4, "ip", NivelEstudios.PRIMARIOS);
        this.tema.setVoto(voto);
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
    }

    @Test
    public void testRead() {
        assertEquals(tema, dao.read(tema.getId()));
    }
    
    @Test
    public void testReadVotos() {
        assertEquals(tema.getVotos(), dao.read(tema.getId()).getVotos());
    }
    
    @Test
    public void testReadVoto() {        
        for(int i=0;i<tema.getVotos().size();i++) {
        	assertEquals(tema.getVotos().get(i), dao.read(tema.getId()).getVotos().get(i));
        }
    }

    @Test
    public void testUpdateTema() {
    	tema.setName("other");
    	tema.setPregunta("other");
        dao.update(tema);
        assertEquals(tema, dao.read(tema.getId()));
    }

    @Test
    public void testUpdateVoto() {
        for(int i=0;i<tema.getVotos().size();i++) {
        	tema.getVotos().get(i).setIpUsuario("otra ip");
        	tema.getVotos().get(i).setNivelEstudios(NivelEstudios.SECUNDARIOS);
        	tema.getVotos().get(i).setValoracion(15);
        	dao.update(tema);
        	assertEquals(tema.getVotos().get(i), dao.read(tema.getId()).getVotos().get(i));
        }
    }
    
    @Test
    public void testDeleteTemaByID() {
        dao.deleteById(tema.getId());
        assertNull(dao.read(tema.getId()));
    }
    
    @Test
    public void testDeleteVoto() {
    	for(int i=0;i<tema.getVotos().size();i++) {
    		tema.getVotos().remove(i);
    	}
    	dao.update(tema);
    	assertEquals(0, dao.read(tema.getId()).getVotos().size());
    }

    @Test
    public void testFindAll() {
        this.tema = new Tema("tema2","pregunta2");
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
        assertEquals(2, dao.findAll().size());
    }

    @After
    public void after() {
        DaoJpaFactory.dropAndCreateTables();
    }

}
