import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        // кладу в банкомат пачку купюр
        Map<Bunknotes, Integer> bundleOfBanknotes = new TreeMap<>();
        bundleOfBanknotes.put(Bunknotes.BUNKNOTES_50, 4);
        bundleOfBanknotes.put(Bunknotes.BUNKNOTES_100, 2);
        bundleOfBanknotes.put(Bunknotes.BUNKNOTES_200, 5);
        bundleOfBanknotes.put(Bunknotes.BUNKNOTES_500, 3);
        bundleOfBanknotes.put(Bunknotes.BUNKNOTES_1000, 3);
        bundleOfBanknotes.put(Bunknotes.BUNKNOTES_2000, 2);
        bundleOfBanknotes.put(Bunknotes.BUNKNOTES_5000, 1);

        CountImpl count = new CountImpl();
        count.putMoney(bundleOfBanknotes);

        count.getCount();

        count.getMoney(4900d);

        count.getCount();
    }

}
