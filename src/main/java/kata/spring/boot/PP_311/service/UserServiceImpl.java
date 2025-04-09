package kata.spring.boot.PP_311.service;

import kata.spring.boot.PP_311.dao.UserDao;
import kata.spring.boot.PP_311.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(UserModel user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public UserModel getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(UserModel user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }
}
