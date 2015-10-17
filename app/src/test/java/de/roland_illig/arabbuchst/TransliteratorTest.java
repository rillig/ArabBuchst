package de.roland_illig.arabbuchst;

import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TransliteratorTest {

    @Test
    public void transliterateEverything() throws IOException {
        List<TrainingData.WordPair> wordPairs = new TrainingData().loadWordPairs();
        Iterator<TrainingData.WordPair> it = wordPairs.iterator();
        if(false){
        PrintWriter wr = new PrintWriter(new OutputStreamWriter(new FileOutputStream("translit.txt"), StandardCharsets.UTF_8));
        while (it.hasNext()) {
            String ar = it.next().ar;
            wr.println(Transliterator.arabicToLatin(ar));
        }
        wr.close();}
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "qāmūs");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ʾālū");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "masāʾ");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ʾālmānyā");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "miṣr");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "bayt");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "maktab");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ʾārnab");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ʾāsad");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "tyn");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "jamal");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ḥalyb");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "khubz");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "dibk");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "dhahab");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "rādyū");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "zaytūn");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "samak");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "shams");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ṣābūn");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ḍabāb");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ṭālib");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ẓarf");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ʿyd");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "ġāly");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "fyl");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "qalam");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "kitāb");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "lybyā");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "maktab");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "nūr");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "hāl");
        assertEquals(Transliterator.arabicToLatin(it.next().ar), "yāsmyn");
        assertEquals(it.hasNext(), false);
   }
}
