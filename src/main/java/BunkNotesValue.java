import java.util.Map;
import java.util.TreeMap;

public class BunkNotesValue {
    Map<Bunknotes, Integer> bunkNotes = new TreeMap<>();

    {
        bunkNotes.put(Bunknotes.BUNKNOTES_50, 50);
        bunkNotes.put(Bunknotes.BUNKNOTES_100, 100);
        bunkNotes.put(Bunknotes.BUNKNOTES_200, 200);
        bunkNotes.put(Bunknotes.BUNKNOTES_500, 500);
        bunkNotes.put(Bunknotes.BUNKNOTES_1000, 1000);
        bunkNotes.put(Bunknotes.BUNKNOTES_2000, 2000);
        bunkNotes.put(Bunknotes.BUNKNOTES_5000, 5000);
    }

    public Map<Bunknotes, Integer> getBunkNotes() {
        return bunkNotes;
    }
}
