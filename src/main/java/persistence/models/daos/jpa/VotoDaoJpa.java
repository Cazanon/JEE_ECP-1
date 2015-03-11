package persistence.models.daos.jpa;

import persistence.models.daos.VotoDao;
import persistence.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto,Integer> implements VotoDao {

	public VotoDaoJpa() {
        super(Voto.class);
    }

}
