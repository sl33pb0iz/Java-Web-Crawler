package src.scripts.action;

import src.scripts.entities.WebsiteInformation;

import java.util.ArrayList;

public interface IHandleAlgorithm {
    public void setNextHandler(IHandleAlgorithm nextHandler);
    public void setListNeedHandle(ArrayList<WebsiteInformation> websiteInformations);
    public void convertInput(String input);
    public void handleList();
    public ArrayList<WebsiteInformation> getList();
}
