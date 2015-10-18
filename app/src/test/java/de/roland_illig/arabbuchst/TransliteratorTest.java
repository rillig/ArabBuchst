package de.roland_illig.arabbuchst;

import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.assertEquals;

public class TransliteratorTest {

    private Iterator<TrainingData.WordPair> it;

    // because of http://stackoverflow.com/questions/33184779/wrong-encoding-in-unit-test-output
    private static String showUnicode(String s) {
        String uni = "";
        for (char c : s.toCharArray()) {
            if (0x0020 <= c && c <= 0x007E) {
                uni += c;
            } else {
                uni += String.format("\\u%04X", (int) c);
            }
        }
        return uni;
    }

    @Test
    public void transliterateEverything() {
        it = new TrainingData().loadWordPairs().iterator();
        assertNext("qāmūs");
        assertNext("ʾālū");
        assertNext("masāʾ");
        assertNext("ʾālmānyā");
        assertNext("miṣr");
        assertNext("maktab");
        assertNext("ʾārnab");
        assertNext("ʾāsad");
        assertNext("bayt");
        assertNext("tyn");
        assertNext("jamal");
        assertNext("ḥalyb");
        assertNext("khubz");
        assertNext("dyk");
        assertNext("dhahab");
        assertNext("rādyū");
        assertNext("zaytūn");
        assertNext("samak");
        assertNext("shams");
        assertNext("ṣābūn");
        assertNext("ḍabāb");
        assertNext("ṭālib");
        assertNext("ẓarf");
        assertNext("ʿyd");
        assertNext("ġāly");
        assertNext("fyl");
        assertNext("qalam");
        assertNext("kitāb");
        assertNext("lybyā");
        assertNext("maktab");
        assertNext("nūr");
        assertNext("hāl");
        assertNext("yāsmyn");
        assertNext("bayrūt");
        assertNext("āithnān");
        assertNext("ʿishrūna");
        assertNext("ḍayif");
        assertNext("baġdād");
        assertNext("milḥ");
        assertEquals(it.hasNext(), false);
    }

    private void assertNext(String expected) {
        String transliterated = Transliterator.arabicToLatin(it.next().ar);
        assertEquals(showUnicode(transliterated.replaceAll("[ -~\u00C0-\u02FF\u1E00-\u1EFF]", "")), "", "Illegal chars");
        assertEquals(showUnicode(transliterated), showUnicode(expected));
    }
}
