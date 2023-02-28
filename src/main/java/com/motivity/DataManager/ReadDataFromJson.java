package com.motivity.DataManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


public class ReadDataFromJson {
    public void createJsonReader() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Bommu");
        jsonObject.put("mail", "tanuja@gmail.com");
        System.out.println(jsonObject);
    }

    public String readValueFromJson(String key) {
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("C:\\Users\\Lakshmi Tanju\\FrameworkAssignment\\src\\test\\TestData\\data.json"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;
        String value = jsonObject.get(key).toString();
        System.out.println(value);
        return value;
    }


}
