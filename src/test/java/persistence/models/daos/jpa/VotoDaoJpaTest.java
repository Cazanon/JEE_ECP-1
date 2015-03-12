package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.VotoDao;
import persistence.models.entities.Tema;
import persistence.models.entities.User;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;

public class VotoDaoJpaTest {
    private VotoDao dao;

    private Voto voto;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.voto = new Voto(5, "ipUsuario", NivelEstudios.PRIMARIOS);
        this.voto.setUser(new User("user","pass"));
        this.voto.setTema(new Tema("name"));
        dao = DaoFactory.getFactory().getVotoDao();
        dao.create(voto);
    }

    @Test
    public void testRead() {
        assertEquals(voto, dao.read(voto.getId()));
    }

    @Test
    public void testUpdateCategory() {
        voto.setEscala(6);
        voto.setIpUsuario("other");
        voto.setNivelEstudios(NivelEstudios.SECUNDARIOS);
        voto.getUser().setName("other");
        voto.getUser().setPassword("other");
        voto.getTema().setName("other");
        dao.update(voto);
        assertEquals(voto, dao.read(voto.getId()));
    }

    @Test
    public void testDeleteByID() {
        dao.deleteById(voto.getId());
        assertNull(dao.read(voto.getId()));
        assertNull(DaoFactory.getFactory().getUserDao().read(voto.getUser().getId()));
        assertNull(DaoFactory.getFactory().getTemaDao().read(voto.getTema().getId()));
    }

    @Test
    public void testFindAll() {        
        this.voto = new Voto(8, "ipUsuario2", NivelEstudios.UNIVERSITARIOS);
        this.voto.setUser(new User("user2","pass2"));
        this.voto.setTema(new Tema("name2"));
        dao = DaoFactory.getFactory().getVotoDao();
        dao.create(voto);
        assertEquals(2, dao.findAll().size());
    }

    @After
    public void after() {
        DaoJpaFactory.dropAndCreateTables();
    }

}
