package de.roland_illig.arabbuchst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainingData {

    public List<WordPair> loadWordPairs() {
        List<String> pairs = Arrays.asList(
                "قَامُوس=Wörterbuch",
                "أَلُو=Hallo (am Telefon)",
                "مَسَاء=Abend",
                "أَلمَانْيَا=Deutschland",
                "مِصْر=Ägypten",
                "مَكْتَب=Büro/Schreibtisch",
                "أَرْنَب=Hase",
                "أَسَد=Löwe",
                "بَيْت=Haus",
                "تِين=Feigen",
                "جَمَل=Kamel",
                "حَليْب=Milch",
                "خُبْز=Brot",
                "دِبك=Hahn",
                "ذَهَب=Gold",
                "رَاديُو=Radio",
                "زَيْتُون=Olive",
                "سَمَك=Fisch",
                "شَمْس=Sonne",
                "صَابُون=Seife",
                "ضَبَاب=Nebel",
                "طَالِب=Student",
                "ظَرْف=Briefumschlag",
                "عِيد=Fest",
                "غَالِي=teuer",
                "فِيل=Elefant",
                "قَلَم=Stift",
                "كِتَاب=Buch",
                "لِيبِيا=Libyen",
                "مَكْتَب=Büro/Schreibtisch",
                "نُور=Licht",
                "هَال=Kardamom",
                "يَاسْمِين=Jasmin",
                "بَيْرُوت=Beirut",
                "اِثْنَان=zwei",
                "عِشْرُونَ=zwanzig",
                "ضَيِف=Gast",
                "بَغْدَاد=Bagdad",
                "مِلْح=Salz");
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
