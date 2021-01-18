package com.example.HW4.controllers;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.tools.java.Environment;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;


@Controller
public class Main {

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(@RequestParam("name") String name) {
        ModelAndView mv = new ModelAndView("redirect:/");
        String weather = getWeather();
        try {
            JSONObject json = new JSONObject(weather);
            mv.addObject("name", json.getString("name"));
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
        return mv;
    }

    private String getWeather() {
        String url = "https://community-open-weather-map.p.rapidapi.com/weather?q=Houston%2Ctx&units=%22imperial%22abb073e6e6msh312690c7e21e200p14ed39jsn42968d0718f4";

        try {
            HttpResponse<String> response = Unirest.get(url).asString();
            String json = response.getBody().toString();
            JSONObject json1 = new JSONObject(json);

            JSONObject name = json1.getJSONObject("name");
            JSONObject main = json1.getJSONObject("main");
            String temperature = main.getString("temp");
            JSONArray array = view.getJSONArray("array");

            int numofapprovals = array.length();
            JSONObject first = array.getJSONObject(0);
            String state = first.getString("state");

            JSONObject submit = first.getJSONObject("submit");
            String submitname = submit.getString("username");
        } catch (Exception exception) {
        }
        return url;
    }
}
