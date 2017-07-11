package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.itis.models.Role;

/**
 * 26.06.2017
 * RolesDao
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
public interface RolesDao extends JpaRepository<Role,Integer> {
}
