package kata.spring.boot.PP_311.service;



import kata.spring.boot.PP_311.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAllUsers();
    void saveUser(UserModel user);
    UserModel getUserById(long id);
    void deleteUserById(long id);
    void updateUser(UserModel user);
}
