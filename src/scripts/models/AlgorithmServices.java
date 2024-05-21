package src.scripts.models;

import src.scripts.action.IHandleAlgorithm;
import src.scripts.entities.WebsiteInformation;

import java.util.ArrayList;

public class AlgorithmServices {
    private ArrayList<IHandleAlgorithm> algorithms = new ArrayList<>();

    public IHandleAlgorithm getLastAlgorithm(){
        return algorithms.get(algorithms.size() - 1);
    }

    public IHandleAlgorithm getFirstAlgorithm(){
        return algorithms.get(0);
    }

    public AlgorithmServices(){
        IHandleAlgorithm linkHandler = new LinkAlgorithmHandler();

        algorithms.add(linkHandler);

        for (int index = 0; index < algorithms.size() - 1; index++) {
            IHandleAlgorithm currentHandler = algorithms.get(index);
            IHandleAlgorithm nextHandler = algorithms.get(index + 1);
            currentHandler.setNextHandler(nextHandler);
        }

        if (!algorithms.isEmpty()) {
            IHandleAlgorithm lastHandler = algorithms.get(algorithms.size() - 1);
            lastHandler.setNextHandler(null);
        }
    }

    public ArrayList<WebsiteInformation> processList(String input, ArrayList<WebsiteInformation> initialList) {
        if (!algorithms.isEmpty()) {
            for (var algorithm: algorithms) {
                algorithm.convertInput(input);
            }

            IHandleAlgorithm firstHandler = algorithms.get(0);
            firstHandler.setListNeedHandle(initialList);
            firstHandler.handleList();

            IHandleAlgorithm lastHandler = algorithms.get(algorithms.size() - 1);
            return lastHandler.getList();
        }
        return null;
    }
}
