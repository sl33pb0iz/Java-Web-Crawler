package src.scripts.models;

import src.scripts.action.IHandleAlgorithm;
import src.scripts.entities.WebsiteInformation;

import java.util.ArrayList;

public class LinkAlgorithmHandler implements IHandleAlgorithm {
    private IHandleAlgorithm nextHandler;
    private ArrayList<WebsiteInformation> websiteInformations;
    private String input;

    @Override
    public void setNextHandler(IHandleAlgorithm nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void setListNeedHandle(ArrayList<WebsiteInformation> websiteInformations) {
        this.websiteInformations = websiteInformations;
    }

    @Override
    public void convertInput(String input) {
        this.input = input;
    }

    @Override
    public void handleList() {
        if (websiteInformations != null && input != null) {
            ArrayList<WebsiteInformation> filteredList = new ArrayList<>();
            for (WebsiteInformation info : websiteInformations) {
                if (info.getLink() != null && info.getLink().contains(input)) {
                    filteredList.add(info);
                }
            }
            websiteInformations = filteredList;
        }

        if (nextHandler != null) {
            nextHandler.setListNeedHandle(websiteInformations);
            nextHandler.handleList();
        }
    }

    @Override
    public ArrayList<WebsiteInformation> getList() {
        return websiteInformations;
    }
}
