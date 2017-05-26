package ru.itis.main.dao.jdbc;


import ru.itis.main.dao.UsersDao;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
=======
import java.sql.*;
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
public class UsersDaoJdbcImpl implements UsersDao{
=======
public class UsersDaoJdbcImpl implements UsersDao {
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191

    private Connection connection;

    //language=SQL
    private final String SQL_INSERT_USER
            = "INSERT INTO group_user (login,password,name,age) VALUES (?,?,?,?)";
    //language=SQL
    private final String SQL_SELECT_USERS_BY_AGE
            = "SELECT * FROM group_user WHERE age=?";
    //language=SQL
    private final String SQL_SELECT_USERS_BY_NAME
            = "SELECT * FROM group_user WHERE name=?";
    //language=SQL
    private final String SQL_SELECT_USER_BY_ID
            = "SELECT * FROM group_user WHERE id=?";
    //language=SQL
    private final String SQL_DELETE_USER_BY_ID
            = "DELETE FROM group_user WHERE id=?";
    //language=SQL
    private final String SQL_UPDATE_USER_BY_ID
            = "UPDATE group_user SET login=?,password=?,name=?,age=? WHERE id=?";
    //language=SQL
    private final String SQL_SELECT_ALL_USERS_JOIN
            = "SELECT * FROM group_user u LEFT JOIN auto a ON u.id = a.owner_id";

    public UsersDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User find(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
<<<<<<< HEAD
            preparedStatement.setInt(1,id);
=======
            preparedStatement.setInt(1, id);
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            User user = new User.Builder()
                    .id(resultSet.getInt("id"))
                    .login(resultSet.getString("login"))
                    .password(resultSet.getString("password"))
                    .name(resultSet.getString("name"))
                    .age(resultSet.getInt("age"))
                    .build();
            return user;
        } catch (SQLException e) {
            System.err.println("SQL Exception");
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int save(User model) {
<<<<<<< HEAD
        return 0;
=======
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, model.getLogin());
            preparedStatement.setString(2, model.getPassword());
            preparedStatement.setString(3, model.getName());
            preparedStatement.setInt(4, model.getAge());

            int addRowsCount = preparedStatement.executeUpdate();

            if(addRowsCount == 0){
                throw new IllegalArgumentException("not insert user in sql");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            return generatedKeys.getInt(1);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
<<<<<<< HEAD
            preparedStatement.setInt(1,id);
=======
            preparedStatement.setInt(1, id);
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(User model) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER_BY_ID);
<<<<<<< HEAD
            preparedStatement.setString(1,model.getLogin());
            preparedStatement.setString(2,model.getPassword());
            preparedStatement.setString(3,model.getName());
            preparedStatement.setInt(4,model.getAge());
            preparedStatement.setInt(5,model.getId());
=======
            preparedStatement.setString(1, model.getLogin());
            preparedStatement.setString(2, model.getPassword());
            preparedStatement.setString(3, model.getName());
            preparedStatement.setInt(4, model.getAge());
            preparedStatement.setInt(5, model.getId());
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USERS_JOIN);
            ResultSet result = preparedStatement.executeQuery();
<<<<<<< HEAD
            Map<Integer,User> usersMap = new HashMap<>();
            while(result.next()){
                int userId = result.getInt(1);
                if(usersMap.get(userId) == null){
=======
            Map<Integer, User> usersMap = new HashMap<>();
            while (result.next()) {
                int userId = result.getInt(1);
                if (usersMap.get(userId) == null) {
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
                    User user = new User.Builder()
                            .id(result.getInt(1))
                            .login(result.getString("login"))
                            .password(result.getString("password"))
                            .name(result.getString("name"))
                            .age(result.getInt("age"))
<<<<<<< HEAD
                            .build();
                    usersMap.put(user.getId(),user);
=======
                            .autos(new ArrayList<>())
                            .build();
                    usersMap.put(user.getId(), user);
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
                }
                Auto auto = new Auto.Builder()
                        .id(result.getInt(6))
                        .model(result.getString("model"))
                        .color(result.getString("color"))
                        .carMileage(result.getDouble("carmileage"))
                        .used(result.getBoolean("used"))
                        .idOwner(result.getInt("owner_id"))
                        .build();
                usersMap.get(userId).getAutos().add(auto);
            }
            return new ArrayList<>(usersMap.values());
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<User> findAllByAge(int age) {
        try {
            ArrayList<User> users = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USERS_BY_AGE);
<<<<<<< HEAD
            preparedStatement.setInt(1,age);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
=======
            preparedStatement.setInt(1, age);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
                User currentUser = new User.Builder()
                        .id(result.getInt("id"))
                        .login(result.getString("login"))
                        .password(result.getString("password"))
                        .name(result.getString("name"))
                        .age(result.getInt("age"))
                        .build();
                users.add(currentUser);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<User> findAllByName(String name) {
        try {
<<<<<<< HEAD
            List<User> users =new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USERS_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
=======
            List<User> users = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USERS_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
                User currentUser = new User.Builder()
                        .id(result.getInt("id"))
                        .login(result.getString("login"))
                        .password(result.getString("password"))
                        .name(result.getString("name"))
                        .age(result.getInt("age"))
                        .build();
                users.add(currentUser);
            }
            return users;
        } catch (SQLException e) {
<<<<<<< HEAD
           throw new IllegalArgumentException(e);
=======
            throw new IllegalArgumentException(e);
>>>>>>> cd6eea201533e405763a0929f6ab748a41d95191
        }
    }
}
