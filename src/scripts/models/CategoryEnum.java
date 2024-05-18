package src.scripts.models;

import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {
    DefinitionOfBlockchain,
    FactsAboutBlockchain,
    NewsArticleBlockchain,
    BlockchainJobs,
    Other;

    public static CategoryEnum CategoryClassify(String value) {
        if (value == null || value.isEmpty()) {
            return Other;
        }

        value = value.toLowerCase();

        Map<CategoryEnum, Integer> categoryCounts = new HashMap<>();
        categoryCounts.put(DefinitionOfBlockchain, 0);
        categoryCounts.put(FactsAboutBlockchain, 0);
        categoryCounts.put(NewsArticleBlockchain, 0);
        categoryCounts.put(BlockchainJobs, 0);

        Map<String, CategoryEnum> keywordsMap = new HashMap<>();
        keywordsMap.put(" definition ", DefinitionOfBlockchain);
        keywordsMap.put(" distributed ", DefinitionOfBlockchain);
        keywordsMap.put(" ledger ", DefinitionOfBlockchain);
        keywordsMap.put(" fact ", FactsAboutBlockchain);
        keywordsMap.put(" hash ", FactsAboutBlockchain);
        keywordsMap.put(" mining ", FactsAboutBlockchain);
        keywordsMap.put(" news ", NewsArticleBlockchain);
        keywordsMap.put(" announcement ", NewsArticleBlockchain);
        keywordsMap.put(" release ", NewsArticleBlockchain);
        keywordsMap.put(" career ", BlockchainJobs);
        keywordsMap.put(" job ", BlockchainJobs);
        keywordsMap.put(" position ", BlockchainJobs);
        keywordsMap.put(" hiring ", BlockchainJobs);

        for (Map.Entry<String, CategoryEnum> entry : keywordsMap.entrySet()) {
            if (value.contains(entry.getKey())) {
                categoryCounts.put(entry.getValue(), categoryCounts.get(entry.getValue()) + 1);
            }
        }

        CategoryEnum mostFrequentCategory = Other;
        int maxCount = 0;
        for (Map.Entry<CategoryEnum, Integer> countEntry : categoryCounts.entrySet()) {
            if (countEntry.getValue() > maxCount) {
                maxCount = countEntry.getValue();
                mostFrequentCategory = countEntry.getKey();
            }
        }

        return mostFrequentCategory;
    }
}
