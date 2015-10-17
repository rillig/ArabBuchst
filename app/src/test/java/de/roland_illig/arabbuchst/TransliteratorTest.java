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
            wr.println(Transliterator.arlat(ar));
        }
        wr.close();}
        assertEquals(Transliterator.arlat(it.next().ar), "qāmūs");
        assertEquals(Transliterator.arlat(it.next().ar), "ʾālū");
        assertEquals(Transliterator.arlat(it.next().ar), "masāʾ");
        assertEquals(Transliterator.arlat(it.next().ar), "ʾālmānyā");
        assertEquals(Transliterator.arlat(it.next().ar), "miṣr");
        assertEquals(Transliterator.arlat(it.next().ar), "bayt");
        assertEquals(Transliterator.arlat(it.next().ar), "maktab");
        assertEquals(Transliterator.arlat(it.next().ar), "ʾārnab");
        assertEquals(Transliterator.arlat(it.next().ar), "ʾāsad");
        assertEquals(Transliterator.arlat(it.next().ar), "tyn");
        assertEquals(Transliterator.arlat(it.next().ar), "jamal");
        assertEquals(Transliterator.arlat(it.next().ar), "ḥalyb");
        assertEquals(Transliterator.arlat(it.next().ar), "khubz");
        assertEquals(Transliterator.arlat(it.next().ar), "dibk");
        assertEquals(Transliterator.arlat(it.next().ar), "dhahab");
        assertEquals(Transliterator.arlat(it.next().ar), "rādyū");
        assertEquals(Transliterator.arlat(it.next().ar), "zaytūn");
        assertEquals(Transliterator.arlat(it.next().ar), "samak");
        assertEquals(Transliterator.arlat(it.next().ar), "shams");
        assertEquals(Transliterator.arlat(it.next().ar), "ṣābūn");
        assertEquals(Transliterator.arlat(it.next().ar), "ḍabāb");
        assertEquals(Transliterator.arlat(it.next().ar), "ṭālib");
        assertEquals(Transliterator.arlat(it.next().ar), "ẓarf");
        assertEquals(Transliterator.arlat(it.next().ar), "ʿyd");
        assertEquals(Transliterator.arlat(it.next().ar), "ġāly");
        assertEquals(Transliterator.arlat(it.next().ar), "fyl");
        assertEquals(Transliterator.arlat(it.next().ar), "qalam");
        assertEquals(Transliterator.arlat(it.next().ar), "kitāb");
        assertEquals(Transliterator.arlat(it.next().ar), "lybyā");
        assertEquals(Transliterator.arlat(it.next().ar), "maktab");
        assertEquals(Transliterator.arlat(it.next().ar), "nūr");
        assertEquals(Transliterator.arlat(it.next().ar), "hāl");
        assertEquals(Transliterator.arlat(it.next().ar), "yāsmyn");
        assertEquals(it.hasNext(), false);
   }
}
