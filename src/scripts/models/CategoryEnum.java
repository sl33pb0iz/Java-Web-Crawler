package src.scripts.models;

public enum CategoryEnum {
    Definition,
    Fact,
    NewsArticle,
    Job,
    Other;

    public static CategoryEnum CategoryClassify(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Input value cannot be null or empty");
        }

        value = value.toLowerCase();

        String[] definitionKeywords = {"definition", "distributed", "ledger"};
        String[] factKeywords = {"transaction", "hash", "mining"};
        String[] newsArticleKeywords = {"news", "update", "announcement", "release", "market"};
        String[] jobKeywords = {"career", "job", "position", "hiring"};

        for (String keyword : definitionKeywords) {
            if (value.contains(keyword)) {
                return Definition;
            }
        }
        for (String keyword : factKeywords) {
            if (value.contains(keyword)) {
                return Fact;
            }
        }
        for (String keyword : newsArticleKeywords) {
            if (value.contains(keyword)) {
                return NewsArticle;
            }
        }
        for (String keyword : jobKeywords) {
            if (value.contains(keyword)) {
                return Job;
            }
        }

        return Other;
    }
}
