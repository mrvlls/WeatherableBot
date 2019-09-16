import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

class Weather {

    //21bc167ace402d13246dfe70e594189d
    static String getWeather(String message, Model model, String lg) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=" + message + "&units=metric&" + "lang=" + lg + "&appid=21bc167ace402d13246dfe70e594189d");

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);
        JSONObject city = object.getJSONObject("city");
        model.setName(city.getString("name"));

        JSONArray list = object.getJSONArray("list");
        for (int i = 0; i < list.length(); i++) {
            JSONObject obj = list.getJSONObject(i);
            JSONObject main = obj.getJSONObject("main");
            model.setTemp(main.getDouble("temp"));
            model.setHumidity(main.getDouble("humidity"));
        }

        for (int i = 0; i < list.length(); i++) {
            JSONObject obj = list.getJSONObject(i);
            JSONArray weather = obj.getJSONArray("weather");
            for (int v = 0; v < weather.length(); v++) {
                JSONObject obj1 = weather.getJSONObject(v);
                model.setIcon((String) obj1.get("icon"));
                model.setMain((String) obj1.get("description"));
            }
        }

        String emodji = "";
        switch (model.getIcon()) {
            case "01d":
                model.setIcon("☀️️");
                break;
            case "01n":
                model.setIcon("\uD83C\uDF15");
                break;
            case "02d":
            case "02n":
                model.setIcon("\uD83C\uDF24");
                break;
            case "03d":
            case "03n":
                model.setIcon("\uD83C\uDF25");
                break;
            case "04d":
            case "04n":
                model.setIcon("☁️");
                break;
            case "09d":
            case "09n":
                model.setIcon("\uD83C\uDF27");
                break;
            case "10d":
            case "10n":
                model.setIcon("\uD83C\uDF26");
                break;
            case "11d":
            case "11n":
                model.setIcon("\uD83C\uDF29");
                break;
            case "13d":
            case "13n":
                model.setIcon("❄️");
                break;
            case "50d":
            case "50n":
                model.setIcon("\uD83C\uDF2B");
                break;
            default:
                break;
        }

        String finalResult = "";
        switch (lg) {
            case "ru":
                finalResult = "Город: " + model.getName() + "\n" +
                "Погода: " + model.getMain() + model.getIcon() + "\n" +
                "Температура: " + model.getTemp() + "C" + "\n" +
                "Влажность: " + model.getHumidity() + "%" + "\n";
                break;
            default:
                finalResult = "City: " + model.getName() + "\n" +
                "Condition: " + model.getMain() + model.getIcon() + "\n" +
                "Temperature: " + model.getTemp() + "C" + "\n" +
                "Humidity: " + model.getHumidity() + "%" + "\n";
                break;
        }

        return finalResult;
    }
}

