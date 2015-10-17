package de.roland_illig.arabbuchst;

public class Transliterator {

    public static String arlat(String arabic) {
        StringBuilder sb = new StringBuilder();
        for (char c : arabic.toCharArray()) {
            sb.append(arlat(c));
        }
        return sb.toString().replace("āa","ā").replace("aā","ā").replace("uū","ū").replace("iy","y");
    }

    private static String arlat(char arabic) {
        switch (arabic) {
            case '،':
                return ",";
            case '\u061B':
                return ";";
            case '\u061F':
                return "?";

            case '\u0618':
            case '\u064E':
                return "a";
            case '\u0619':
            case '\u064F':
                return "u";
            case '\u061A':
            case '\u0650':
                return "i";
            case '\u0652':
                return "";

            case 'ء':
                return "ʾ";
            case 'آ':
                return "ʼā";
            case 'أ':
                return "ʾā";
            case 'ا':
                return "ā";
            case 'ب':
                return "b";
            case 'ة':
                return "h";
            case 'ت':
                return "t";
            case 'ث':
                return "th";
            case 'ج':
                return "j";
            case 'ح':
                return "ḥ";
            case 'خ':
                return "kh";
            case 'د':
                return "d";
            case 'ذ':
                return "dh";
            case 'ر':
                return "r";
            case 'ز':
                return "z";
            case 'س':
                return "s";
            case 'ش':
                return "sh";
            case 'ص':
                return "ṣ";
            case 'ض':
                return "ḍ";
            case 'ط':
                return "ṭ";
            case 'ظ':
                return "ẓ";
            case 'ع':
                return "ʿ";
            case 'غ':
                return "ġ";
            case 'ف':
                return "f";
            case 'ق':
                return "q";
            case 'ك':
                return "k";
            case 'ل':
                return "l";
            case 'م':
                return "m";
            case 'ن':
                return "n";
            case 'ه':
                return "h";
            case 'و':
                return "ū";
            case 'ى':
                return "á";
            case 'ي':
                return "y";
        }
        return String.valueOf(arabic);
    }
}
