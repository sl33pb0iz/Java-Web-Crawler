package src.scripts.models;

import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {
    Definition,
    Fact,
    NewsArticle,
    Job,
    Other;

    public static CategoryEnum CategoryClassify(String value) {
        if (value == null || value.isEmpty()) {
            return Other;
        }

        value = value.toLowerCase();

        Map<CategoryEnum, Integer> categoryCounts = new HashMap<>();
        categoryCounts.put(Definition, 0);
        categoryCounts.put(Fact, 0);
        categoryCounts.put(NewsArticle, 0);
        categoryCounts.put(Job, 0);

        Map<String, CategoryEnum> keywordsMap = new HashMap<>();
        keywordsMap.put(" definition ", Definition);
        keywordsMap.put(" distributed ", Definition);
        keywordsMap.put(" ledger ", Definition);
        keywordsMap.put(" fact ", Fact);
        keywordsMap.put(" hash ", Fact);
        keywordsMap.put(" mining ", Fact);
        keywordsMap.put(" news ", NewsArticle);
        keywordsMap.put(" announcement ", NewsArticle);
        keywordsMap.put(" release ", NewsArticle);
        keywordsMap.put(" career ", Job);
        keywordsMap.put(" job ", Job);
        keywordsMap.put(" position ", Job);
        keywordsMap.put(" hiring ", Job);

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
