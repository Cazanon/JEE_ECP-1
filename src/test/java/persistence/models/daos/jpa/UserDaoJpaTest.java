package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.UserDao;
import persistence.models.entities.User;

public class UserDaoJpaTest {
    private UserDao dao;

    private User user;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.user = new User("user", "pass");
        dao = DaoFactory.getFactory().getUserDao();
        dao.create(user);
    }

    @Test
    public void testRead() {
        assertEquals(user, dao.read(user.getId()));
    }

    @Test
    public void testUpdateCategory() {
        user.setName("other");
        user.setPassword("other");
        dao.update(user);
        assertEquals(user, dao.read(user.getId()));
    }

    @Test
    public void testDeleteByID() {
        dao.deleteById(user.getId());
        assertNull(dao.read(user.getId()));
    }

    @Test
    public void testFindAll() {
        this.user = new User("user", "pass");
        dao = DaoFactory.getFactory().getUserDao();
        dao.create(user);
        assertEquals(2, dao.findAll().size());
    }

    @After
    public void after() {
        DaoJpaFactory.dropAndCreateTables();
    }

}
