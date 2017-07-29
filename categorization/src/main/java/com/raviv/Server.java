package com.raviv;


import com.google.gson.Gson;
import static spark.Spark.*;


public class Server {


    private static  Categories categories;

    public static void main(String[] args) {

        KeyWords keyWords =new FileKeyWordResource(new KeyWordFactoryImpl(),"keywords.csv").get();
        categories = new Categories(keyWords);
        Gson gson = new Gson();

        get("/categorize", (req, res) -> {
            String phrase = req.queryMap("phrase").value();
            return categories.execute(phrase);
        }, gson::toJson);

    }
}
