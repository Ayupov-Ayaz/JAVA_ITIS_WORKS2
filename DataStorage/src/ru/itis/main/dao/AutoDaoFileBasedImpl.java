package ru.itis.main.dao;

import ru.itis.main.exception.AutoNotFoundException;
import ru.itis.main.generators.SimpleIdGenerator;
import ru.itis.main.mapper.RowMapper;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;
import ru.itis.main.utils.FileDaoQueryTemplate;
import ru.itis.main.utils.FileDaoQueryTemplateImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class AutoDaoFileBasedImpl implements AutoDao {
    private String fileName;
    private FileDaoQueryTemplate template;

    public AutoDaoFileBasedImpl(String fileName, FileDaoQueryTemplate template) {
        this.fileName = fileName;
        this.template = template;
    }

    private RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        @Override
        public Auto mapRow(String row) {
            String autoDataAsArray[] = row.split(" ");
            Auto auto = new Auto(Integer.parseInt(autoDataAsArray[0]),
                    autoDataAsArray[1],
                    autoDataAsArray[2],
                    Double.parseDouble(autoDataAsArray[3]),
                    Boolean.valueOf(autoDataAsArray[4]),
                    Integer.parseInt(autoDataAsArray[5]));
            return auto;
        }
    };

    @Override
    public Auto find(int id) {
        List<Auto> autos = template.findByValue(fileName, autoRowMapper, 0, id);
        if (autos.size() == 0) {
            throw new AutoNotFoundException("Auto not found");
        } else {
            return autos.get(0);
        }
    }

    @Override
    public int save(Auto auto) {
        String query = "INSERT INTO auto (model, color, carmileage, used, owner_id) VALUES ('"
                + auto.getModel() + "','"
                + auto.getColor() + "',"
                + auto.getCarMileage() + ","
                + auto.isUsed() + ","
                + auto.getIdOwner() + ");";
        return template.save(query);
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM auto WHERE id=" + id + ";";
        template.sqlQuery(query);
    }

    @Override
    public void update(Auto auto) {
        String query = "UPDATE  auto SET" +
                " model ='" + auto.getModel() + "',"
                + " color ='" + auto.getColor() + "',"
                + " carmileage =" + auto.getCarMileage() + ","
                + " used =" + auto.isUsed() + ","
                + " owner_id =" + auto.getIdOwner()
                + " WHERE id =" + auto.getId() + ";";
        template.update(query);

    }

    @Override
    public List<Auto> findAll() {
        return template.findAll(fileName, autoRowMapper);
    }

    @Override
    public List<Auto> findAllByUsed() {
        List<Auto> autos = template.findAll(fileName, autoRowMapper);
        List<Auto> usedAutos = new ArrayList<>();
        for (int i = 0; i < autos.size(); i++) {
            if (autos.get(i).isUsed() || autos.get(i).getCarMileage() > 10) {
                usedAutos.add(autos.get(i));
            }
        }
        return usedAutos;
    }

    @Override
    public List<Auto> findAllAutoByOwner(User user) {
        int idUser = user.getId();
        List<Auto> autos = template.findByValue(fileName, autoRowMapper, 5, idUser);
        if (autos.size() > 0) {
            return autos;
        }
        throw new AutoNotFoundException("Auto not found");
    }
}
