package org.longbox.persistence.dao;

import org.longbox.businesslogic.exception.UserNameDoesNotExistException;
import org.longbox.businesslogic.exception.UsernameExistsException;
import org.longbox.persistence.entity.User;

public interface UserDao {

    User getUserById(long id);

    User getUserByUserName(String userName) throws UserNameDoesNotExistException;

    void saveUser(User user) throws UsernameExistsException;

    boolean deleteUser(User user);

    boolean modifyUser(User user);

}
