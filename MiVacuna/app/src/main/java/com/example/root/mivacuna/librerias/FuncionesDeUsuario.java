package com.example.root.mivacuna.librerias;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by root on 05/05/16.
 */
public class FuncionesDeUsuario {
    private JSONparser jsonParser;
    //URLS
    private static String loginURL = "http://192.168.0.101:8000/api/v1/iniciarSesion";
    private static String CreateURL = "http://192.168.0.101:8000/api/v1/crearUser";

    public FuncionesDeUsuario() {
        this.jsonParser = new JSONparser();
    }



    public JSONObject loginUser(String email, String password) throws JSONException {
        // Building Parameters
        // List params = new ArrayList();
        JSONObject json1 = new JSONObject();
        json1.accumulate("email", email);
        json1.accumulate("password", password);
        JSONObject json = jsonParser.getJSON(loginURL, json1);
        //jsonParser.post(loginURL,json1);
        // Log.i("LoginActivity","Json= "+json1.toString());
        return json;
    }
 public JSONObject registroUser(String name,String email, String password) throws JSONException {
        // Building Parameters
        // List params = new ArrayList();
        JSONObject json1 = new JSONObject();
        json1.accumulate("name", name);
        json1.accumulate("email", email);
        json1.accumulate("password", password);
        JSONObject json = jsonParser.getJSON(CreateURL, json1);
        //jsonParser.post(loginURL,json1);
        // Log.i("LoginActivity","Json= "+json1.toString());
        return json;
    }

}
