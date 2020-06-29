package org.example;

import org.json.simple.JSONObject;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Environment {
    private static Environment instance = new Environment();

    private DocumentContext  jsonContext;

    private Environment(){
        try (InputStream inputStream = new FileInputStream("config.json")){
            Reader fileReader = new InputStreamReader(inputStream);
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(fileReader);
            jsonContext = JsonPath.parse(jsonObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Environment getInstance(){
        return instance;
    }

    public String getValue(String keyJsonPath){
        return jsonContext.read(keyJsonPath);
    }

}
