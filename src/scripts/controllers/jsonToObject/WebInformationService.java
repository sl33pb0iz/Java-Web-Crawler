package src.scripts.controllers.jsonToObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.scripts.entities.WebsiteInformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class WebInformationService {
    public ArrayList<WebsiteInformation> webList = new ArrayList<WebsiteInformation>();

    public void readDataFromFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    try {
                        readDataFromJsonFile(file.getAbsolutePath());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("The folder path is not valid or an I/O error occurred.");
        }
    }

    private void readDataFromJsonFile(String fileDes) throws IOException {
        File file = new File(fileDes);

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
        for (String js : Json) {
            Type WebListType = new TypeToken<WebsiteInformation>() {}.getType();
            WebsiteInformation web = new Gson().fromJson(js,WebListType);
            webList.add(web);
        }
    }
}
