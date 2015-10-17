package de.roland_illig.arabbuchst;

public class ArStringUtils {

    private static final String RE_TASHKIL = "[\u0618\u0619\u061A\u064E\u064F\u0650\u0652]";

    static int[] determineWrongPart(String ar, String answer) {
        int startAr = 0;
        int startAnswer = 0;
        int endAr = ar.length();
        int endAnswer = answer.length();
        while (startAr < endAr && startAnswer < endAnswer && ar.charAt(startAr) == answer.charAt(startAnswer)) {
            startAr++;
            startAnswer++;
            while (startAr < endAr && isTashkil(ar.charAt(startAr)))
                startAr++;
            while (startAnswer < endAnswer && isTashkil(answer.charAt(startAnswer)))
                startAnswer++;
        }
        while (endAr > startAr && endAnswer > startAnswer) {
            while (endAr > startAr && isTashkil(ar.charAt(endAr - 1)))
                endAr--;
            while (endAnswer > startAnswer && isTashkil(answer.charAt(endAnswer - 1)))
                endAnswer--;
            if (ar.charAt(endAr - 1) != answer.charAt(endAnswer - 1))
                break;
            endAr--;
            endAnswer--;
        }
        return new int[]{startAr, endAr};
    }

    private static boolean isTashkil(char ch) {
        return String.valueOf(ch).matches(RE_TASHKIL);
    }

    static String withoutTashkil(String s) {
        return s.replaceAll(RE_TASHKIL, "");
    }
}
