package kata.spring.boot.PP_311.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kata.spring.boot.PP_311.model.UserModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserModel> getAllUsers() {
        return entityManager.createQuery("FROM UserModel", UserModel.class).getResultList();
    }

    @Override
    public void saveUser(UserModel user) {
        entityManager.merge(user);
    }

    @Override
    public UserModel getUserById(long id) {
            return entityManager.find(UserModel.class, id);
    }

    @Override
    public void updateUser(UserModel user) {
        entityManager.merge(user);
    }
    @Override
    public void deleteUserById(long id) {
        UserModel user = entityManager.find(UserModel.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }


}
