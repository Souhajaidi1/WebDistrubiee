package tn.esprit.mspostcommentaire.interfaces;


import java.util.List;

import tn.esprit.mspostcommentaire.Entities.User;

public interface IUserService {


    List<User> getAllUsers();
    User getUserById(Long userId);
    User saveUser(User user);
    void deleteUser(Long userId);
    User updateUser(User user, Long userID);

}