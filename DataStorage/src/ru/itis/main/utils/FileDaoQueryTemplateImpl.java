package ru.itis.main.utils;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.mapper.RowMapper;
import ru.itis.main.models.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileDaoQueryTemplateImpl implements FileDaoQueryTemplate{
    IdGenerator idGenerator;

    public FileDaoQueryTemplateImpl(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public <T> List<T> findAll(String fileName, RowMapper<T> mapper) {
        try {
            ArrayList<T> models = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentModel = reader.readLine();
            while(currentModel != null){
                T model = mapper.mapRow(currentModel);
                models.add(model);
                currentModel = reader.readLine();
            }
            reader.close();
            return models;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return new ArrayList<T>();
    }

    @Override
    public <T> List<T> findByValue(String fileName, RowMapper<T> mapper, int valueColumn, Object value) {
        //TODO: Реализовать findByValue
       List<T> models = findAll(fileName,mapper);
       return models;
    }

    @Override
    public <T> int save(String fileName, T model) {
            if(model instanceof Model) {
                //Преобразуем нашу модель в интерфейс
                Model castedModel = (Model)model;
                castedModel.setId(idGenerator.generateId());
                String modelDataAsString = castedModel.toString();
                try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.write(modelDataAsString);
                writer.newLine();
                writer.close();
                return castedModel.getId();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
            }
        throw new IllegalArgumentException("Model is not implement Model interface");

    }

    @Override
    public <T> void update(String fileName, RowMapper<T> mapper, T model) {
        try {
            if(model instanceof Model) {
                Model  castedModel = (Model)model;
                int id = ((Model) model).getId();
                List<T> models = findAll(fileName, mapper);
                for (int i = 0; i < models.size(); i++) {
                   Model currentModel = (Model)models.get(i);
                   if(currentModel.getId() == id){
                       models.set(i,model);
                       break;
                   }
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for(int i = 0; i < models.size(); i++){
                    writer.write(models.get(i).toString());
                    writer.newLine();
                }
                writer.close();
            }else{
                throw new IllegalArgumentException("Model is not implement Model interface");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found ");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }

    @Override
    public <T> void deleteByValue(String fileName, int valueColumn, RowMapper<T> mapper, Object value) {
        //TODO: Реализовать deleteByValue

    }
}
