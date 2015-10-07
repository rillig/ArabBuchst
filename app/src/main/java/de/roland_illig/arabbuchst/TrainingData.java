package de.roland_illig.arabbuchst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainingData {

    public List<WordPair> loadWordPairs() {
        List<String> pairs = Arrays.asList(
                "قاموس=Wörterbuch",
                "آلو=Hallo (am Telefon)",
                "مساء=Abend",
                "حصان=Pferd",
                "ألمانيا=Deutschland",
                "مصر=Ägypten",
                "ارنب=Hase",
                "بيت=Haus",
                "خمل=Kamel",
                "مكتب=Büro/Schreibtisch",
                "ياسمين=Yasmin"
        );
        List<WordPair> result = new ArrayList<>();
        for (String pair : pairs) {
            String[] parts = pair.split("=");
            result.add(new WordPair(parts[0], parts[1]));
        }
        return result;
    }

    public static final class WordPair {
        public final String ar;
        public final String de;

        public WordPair(String ar, String de) {
            this.ar = ar;
            this.de = de;
        }
    }
}
