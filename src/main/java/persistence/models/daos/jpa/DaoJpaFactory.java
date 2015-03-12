package persistence.models.daos.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import persistence.models.daos.VotoDao;
import persistence.models.daos.TemaDao;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.UserDao;

public class DaoJpaFactory extends DaoFactory {
	private static final String PERSISTENCE_UNIT = "tictactoe";

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public DaoJpaFactory() {
		LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
	}

	public static void dropAndCreateTables() {
		Map<String, String> properties = new HashMap<>();
		properties.put(PersistenceUnitProperties.DDL_GENERATION,
				PersistenceUnitProperties.DROP_AND_CREATE);
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
		LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@Override
	public UserDao getUserDao() {
		return new UserDaoJpa();
	}

	@Override
	public TemaDao getTemaDao() {
		return new TemaDaoJpa();
	}

	@Override
	public VotoDao getVotoDao() {
		return new VotoDaoJpa();
	}

}