package de.roland_illig.arabbuchst;

public class Transliterator {

    public static String arlat(String arabic) {
        StringBuilder sb = new StringBuilder();
        for (char c : arabic.toCharArray()) {
            sb.append(arlat(c));
        }
        return sb.toString();
    }

    private static String arlat(char arabic) {
        switch (arabic) {
            case '\u0621':
                return "ʼ";
            case '\u0623':
                return "ʼa";
            case '\u0627':
                return "ā";
            case '\u0628':
                return "b";
            case '\u062A':
                return "t";
            case '\u062B':
                return "th";
            case '\u062C':
                return "j";
            case '\u062D':
                return "ḥ";
            case '\u062E':
                return "kh";
            case '\u062F':
                return "d";
            case '\u0630':
                return "dh";
            case '\u0631':
                return "r";
            case '\u0632':
                return "z";
            case '\u0633':
                return "s";
            case '\u0634':
                return "sh";
            case '\u0635':
                return "ṣ";
            case '\u0636':
                return "ḍ";
            case '\u0637':
                return "ṭ";
            case '\u0638':
                return "ẓ";
            case '\u0639':
                return "ʻ";
            case '\u063A':
                return "gh";
            case '\u0641':
                return "f";
            case '\u0642':
                return "q";
            case '\u0643':
                return "k";
            case '\u0644':
                return "l";
            case '\u0645':
                return "m";
            case '\u0646':
                return "n";
            case '\u0647':
                return "h";
            case '\u0648':
                return "u";
            case '\u064A':
                return "y";
            case '\u0622':
                return "ʼā";
            case '\u0629':
                return "h";
            case '\u0649':
                return "á";
        }
        return String.valueOf(arabic);
    }
}
