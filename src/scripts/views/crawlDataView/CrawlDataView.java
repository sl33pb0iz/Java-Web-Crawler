package src.scripts.views.crawlDataView;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import src.scripts.entities.WebsiteInformation;
import javafx.scene.control.TableColumn;

public class CrawlDataView {
    @FXML
    private TableView<WebsiteInformation> reportTableView;
    @FXML private TableColumn<WebsiteInformation, Integer> indexColumn;
    @FXML private TableColumn<WebsiteInformation, String> linkColumn;
    @FXML private TableColumn<WebsiteInformation, String> typeColumn;
    @FXML private TableColumn<WebsiteInformation, Float> titleColumn;
    @FXML private TableColumn<WebsiteInformation, Float> creationDateColumn;
    @FXML private TableColumn<WebsiteInformation, Float> authorColumn;
    @FXML private TableColumn<WebsiteInformation, Void> categoryColumn;

    private void initialize(){

    }

    private void fetchAndDisplaySummaryData(){

    }

    private void fetchAndDisplayTableData(){
        setIndexColumn();
        setLinkColumn();
        setTypeColumn();
        setTitleColumn();
        setCreationDateColumn();
        setAuthorColumn();
        setCategoryColumn();
    }

    // Set Column
    private void setIndexColumn() {

    }
    private void setLinkColumn() {

    }
    private void setTypeColumn() {

    }
    private void setTitleColumn() {

    }
    private void setCreationDateColumn() {

    }
    private void setAuthorColumn() {

    }
    private void setCategoryColumn() {

    }
}
