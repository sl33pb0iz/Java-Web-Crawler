package src.scripts.controllers;

import src.scripts.action.IAction;
import src.scripts.controllers.jsonToObject.WebInformationService;
import src.scripts.entities.WebsiteInformation;
import src.scripts.models.AlgorithmServices;
import src.scripts.views.crawlDataView.CrawlDataView;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlDataController {
    private WebInformationService webInformationService;
    private AlgorithmServices algorithmServices;
    private CrawlDataView view;

    private ArrayList<WebsiteInformation> webList = new ArrayList<WebsiteInformation>();

    public CrawlDataController(CrawlDataView view, WebInformationService webInformationService, AlgorithmServices algorithmServices){
        this.webInformationService = webInformationService;
        this.algorithmServices = algorithmServices;
        this.view = view;

        IAction onClickedCrawlDataButton = () -> onClickedCrawlDataButton();
        IAction onClickedSearchButton = () -> onClickedSearchButton();
        view.onClickedCrawlDataButton = onClickedCrawlDataButton;
        view.onClickedSearchButton = onClickedSearchButton;
    }

    public void initialize(){

    }

    public void onClickedCrawlDataButton() throws IOException {
        webInformationService.readDataFromFolder("D:\\Java\\New folder\\Java-Web-Crawler\\src\\datas\\jsonData");
        webList = webInformationService.webList;
        view.fetchAndDisplay(webList);
    }

    public void onClickedSearchButton(){
        webList = algorithmServices.processList(view.fieldSearch.getText(), webList);
        view.fetchAndDisplay(webList);
    }
}
