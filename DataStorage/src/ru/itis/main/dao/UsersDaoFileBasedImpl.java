package ru.itis.main.dao;

import ru.itis.main.exception.UserNotFoundException;
import ru.itis.main.generators.SimpleIdGenerator;
import ru.itis.main.mapper.RowMapper;
import ru.itis.main.models.User;
import ru.itis.main.utils.FileDaoQueryTemplate;
import ru.itis.main.utils.FileDaoQueryTemplateImpl;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class UsersDaoFileBasedImpl implements UsersDao {

    private String fileName;
    private FileDaoQueryTemplate template;

    public UsersDaoFileBasedImpl(String fileName, FileDaoQueryTemplate template) {
        this.fileName = fileName;
        this.template = template;
    }

    private RowMapper<User> userRowMapper = new RowMapper<User>(){

        @Override
        public User mapRow(String row) {
            String rowAsArray[] = row.split(" ");
            User user = new User(Integer.parseInt(rowAsArray[0]),
                                rowAsArray[1],
                                rowAsArray[2],
                                rowAsArray[3],
                                Integer.parseInt(rowAsArray[4]));
            return user;
        }
    };

    @Override
    public int save(User user) {
      String query = "INSERT INTO group_user (login, password, name, age) VALUES ('"
              +user.getLogin()+"','"
              +user.getPassword()+"','"
              +user.getName()+"',"
              +user.getAge()+");";
        return template.save(query);
    }

    // поиск объекта по id
    @Override
    public User find(int id) {

        List<User> users = template.findByValue(fileName,userRowMapper,0,id);

        if(users.size() == 0){
            throw new UserNotFoundException("User with id <"+id+"> not found");
        }else{
            return users.get(0);
        }
    }


    @Override
    public void delete(int id) {
        String query = "DELETE FROM group_user WHERE id="+id+";";
        template.sqlQuery(query);
    }

    @Override
    public void update(User user) {
        String query = "UPDATE  group_user SET" +
                " login ='"+user.getLogin()+"',"
                +" password ='"+user.getPassword()+"',"
                + " name ='"+user.getName()+"',"
                + " age ="+user.getAge()
                +"WHERE id ="+user.getId()+";";
        template.update(query);
    }

    @Override
    public List<User> findAll() {
        return  template.findAll(fileName,userRowMapper);
    }

    @Override
    public List<User> findAllByAge(int age) {
       return template.findByValue(fileName,userRowMapper,4,age);
    }

    @Override
    public List<User> findAllByName(String name){
       return template.findByValue(fileName,userRowMapper,3, name);
    }
}
