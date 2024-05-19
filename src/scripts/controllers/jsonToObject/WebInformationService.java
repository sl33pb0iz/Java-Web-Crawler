package src.scripts.controllers.jsonToObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import src.scripts.models.WebsiteInformation;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class WebInformationService {
    public void readDataFromJsonFile() throws IOException {
        File file = new File("C:\\Users\\Hung PC\\Java-Web-Crawler\\src\\datas\\jsonData\\Other");

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        List<String> Json = new ArrayList<>();

        try (br) {
            String line;
            while ((line = br.readLine()) != null) {
                Json.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<WebsiteInformation> webLish = new ArrayList<WebsiteInformation>();
        for (String js : Json) {
            Type WebListType = new TypeToken<WebsiteInformation>() {}.getType();
            WebsiteInformation web = new Gson().fromJson(js,WebListType);
            webLish.add(web);
        }
        for (WebsiteInformation web : webLish) {
            System.out.println(web.getTitle());
        }
    }
}
