package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.models.User;

/**
 * 26.06.2017
 * UsersDao
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */

public interface UsersDao extends JpaRepository<User, Integer> {
    User findByToken(String token);
    User findByLogin(String login);
    User findByName(String name);
    @Modifying
    @Query("update User user set user.token = ?2 where user.id = ?1")
    void updateToke(int id, String token);

    @Query("select count(user) > 0 from User user where user.token = ?1")
    boolean isExistToken(String token);


}
