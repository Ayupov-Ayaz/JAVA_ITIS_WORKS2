package ru.itis.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ru.itis.models.FrendsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 04.06.2017
 * MainController @author Ayupov Ayaz (First Software Engineering Platform)
 *
 * @version v1.0 /
 */

public class MainController {

    @FXML
    private ListView listView;

    @FXML
    private Button button;

    @FXML
    TextField textFieldForId;

    @FXML
    TextField textFieldForCount;

    @FXML
    public void initialize(){
       button.setOnAction(event -> {
           RestTemplate restTemplate = new RestTemplate();
           List<HttpMessageConverter<?>> converters = new ArrayList<>();
           converters.add(new MappingJackson2HttpMessageConverter());
           restTemplate.setMessageConverters(converters);
           String id = textFieldForId.getText();
           String count = textFieldForCount.getText();
           FrendsResponse response = restTemplate.getForObject("https://api.vk.com/method/friends.get?user_id="
                           + id +"&fields=nickname&count="+count, FrendsResponse.class);
           listView.getItems().clear();
           for(int i = 0; i < response.getResponse().size(); i++ ){
               listView.getItems().addAll(response.getResponse().get(i).getFirst_name()+" "+response.getResponse().get(i).getLast_name());
           }
           //https://api.vk.com/method/friends.get?user_id=75065616&fields=nickname&count=200
       });
    }
}
