package ru.itis.main.dao;

import ru.itis.main.models.Auto;

import java.util.List;


public interface AutoDao extends BaseCrudDao<Auto>{
    List<Auto> findAllByUsed();

}
