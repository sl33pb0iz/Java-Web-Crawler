package src.scripts.views;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;
import src.scripts.action.IAction;
import src.scripts.entities.WebsiteInformation;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CrawlDataView {
    public IAction onClickedCrawlDataButton;
    public IAction onClickedSearchButton;

    public Text textNumberCategories;
    public Text textNumberResults;

    public Button searchButton;
    public TextField fieldSearch;

    @FXML private Button crawlDataButton;

    @FXML private TableView<WebsiteInformation> reportTableView;
    @FXML private TableColumn<WebsiteInformation, String> indexColumn;
    @FXML private TableColumn<WebsiteInformation, String> linkColumn;
    @FXML private TableColumn<WebsiteInformation, String> typeColumn;
    @FXML private TableColumn<WebsiteInformation, String> titleColumn;
    @FXML private TableColumn<WebsiteInformation, String> creationDateColumn;
    @FXML private TableColumn<WebsiteInformation, String> authorColumn;
    @FXML private TableColumn<WebsiteInformation, String> categoryColumn;

    public void initialize(){
        crawlDataButton.setOnAction(actionEvent -> {
            try {
                onClickedCrawlDataButton.onAction();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        searchButton.setOnAction(actionEvent -> {
            try {
                onClickedSearchButton.onAction();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Set columns
        setIndexColumn();
        setLinkColumn();
        setTypeColumn();
        setTitleColumn();
        setCreationDateColumn();
        setAuthorColumn();
        setCategoryColumn();
    }

    public void fetchAndDisplay(ArrayList<WebsiteInformation> websiteInformations){
        fetchAndDisplayTableData(websiteInformations);
        fetchAndDisplaySummaryData(websiteInformations);
    }

    private void fetchAndDisplayTableData(ArrayList<WebsiteInformation> websiteInformations){
        reportTableView.getItems().setAll(websiteInformations);
    }

    private void fetchAndDisplaySummaryData(ArrayList<WebsiteInformation> websiteInformations){
        setTextNumberCategories(websiteInformations);
        setTextNumberResults(websiteInformations);
    }

    private void setTextNumberCategories(ArrayList<WebsiteInformation> websiteInformations){
        Set<String> uniqueCategories = new HashSet<>();
        for (WebsiteInformation info : websiteInformations) {
            uniqueCategories.add(info.getCategory());
        }
        textNumberCategories.setText(String.valueOf(uniqueCategories.size()));
    }

    private void setTextNumberResults(ArrayList<WebsiteInformation> websiteInformations){
        textNumberResults.setText(String.valueOf(websiteInformations.size()));
    }

    private void setIndexColumn() {
        indexColumn.setCellFactory(col -> new TableCell<WebsiteInformation, String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(String.valueOf(getTableRow().getIndex() + 1));
                }
            }
        });
    }

    private void setLinkColumn() {
        linkColumn.setCellValueFactory(new PropertyValueFactory<>("link"));
        linkColumn.setCellFactory(new Callback<>() {
            @Override
            public TableCell<WebsiteInformation, String> call(TableColumn<WebsiteInformation, String> param) {
                return new TableCell<>() {
                    final Hyperlink hyperlink = new Hyperlink();

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setGraphic(null);
                        } else {
                            hyperlink.setText(item);
                            hyperlink.setOnAction(event -> {
                                try {
                                    Desktop.getDesktop().browse(new URI(item));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                            setGraphic(hyperlink);
                        }
                    }
                };
            }
        });
    }

    private void setTypeColumn() {
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    private void setTitleColumn() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    }

    private void setCreationDateColumn() {
        creationDateColumn.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
    }

    private void setAuthorColumn() {
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
    }

    private void setCategoryColumn() {
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    }


}
