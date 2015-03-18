package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.VotoDao;
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
        dao = DaoFactory.getFactory().getVotoDao();
        dao.create(voto);
    }

    @Test
    public void testRead() {
        assertEquals(voto, dao.read(voto.getId()));
    }

    @Test
    public void testUpdateCategory() {
        voto.setValoracion(6);
        voto.setIpUsuario("other");
        voto.setNivelEstudios(NivelEstudios.SECUNDARIOS);
        dao.update(voto);
        assertEquals(voto, dao.read(voto.getId()));
    }

    @Test
    public void testDeleteByID() {
        dao.deleteById(voto.getId());
        assertNull(dao.read(voto.getId()));
    }

    @Test
    public void testFindAll() {        
        this.voto = new Voto(8, "ipUsuario2", NivelEstudios.UNIVERSITARIOS);
        dao = DaoFactory.getFactory().getVotoDao();
        dao.create(voto);
        assertEquals(2, dao.findAll().size());
    }

    @After
    public void after() {
        DaoJpaFactory.dropAndCreateTables();
    }

}
