package de.roland_illig.arabbuchst;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArStringUtilsTest {

    @Test
    public void testHighlightWrongPartGerman() {
        testHighlight(4, 4, "wort", "wort");
        testHighlight(3, 4, "wort", "wor");
        testHighlight(3, 3, "wor", "wort");
        testHighlight(0, 1, "wort", "ort");
        testHighlight(0, 0, "ort", "wort");
        testHighlight(1, 3, "wort", "wt");
        testHighlight(1, 1, "wt", "wort");
    }

    @Test
    public void testHighlightWrongPartTashkil() {
        testHighlight(5, 5, "wo\u0618rt", "wort");
        testHighlight(3, 4, "wort", "wo\u0618\u0618r");
    }

    private void testHighlight(int start, int end, String ar, String answer) {
        final int[] startEnd = ArStringUtils.determineWrongPart(ar, answer);
        assertEquals(startEnd[0] + "–" + startEnd[1], start + "–" + end, ar + " – " + answer);
    }
}