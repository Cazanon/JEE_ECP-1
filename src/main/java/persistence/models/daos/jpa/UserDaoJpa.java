package persistence.models.daos.jpa;

import persistence.models.daos.UserDao;
import persistence.models.entities.User;

public class UserDaoJpa extends GenericDaoJpa<User,Integer>implements UserDao {

    public UserDaoJpa() {
        super(User.class);
    }

 }
