import java.util.Map;
import java.util.TreeMap;

public class CountImpl implements Count {
    private Integer count = 0; // счет
    private Map<Bunknotes, Integer> countEveryBunknote = new TreeMap<>(); // Наименование банкнот к их количеству в банкомате
    private BunkNotesValue bunknotesValue = new BunkNotesValue();

    private void setCountAddMoney(Integer bunknoteCount, Integer valueBunknote) {
        this.count += bunknoteCount * valueBunknote;
    }

    private void setCountDeleteMoney(Integer bunknoteCount, Integer valueBunknote) {
        this.count -= bunknoteCount * valueBunknote;
    }

    @Override
    public void putMoney(Map<Bunknotes, Integer> bundleOfBanknotes) {
        for (Map.Entry<Bunknotes, Integer> entryBunkNotes : bunknotesValue.getBunkNotes().entrySet()) {
            for (Map.Entry<Bunknotes, Integer> entryBundleOfBanknotes : bundleOfBanknotes.entrySet()) {
                if (entryBunkNotes.getKey().equals(entryBundleOfBanknotes.getKey())) {
                    setCountAddMoney(entryBunkNotes.getValue(), entryBundleOfBanknotes.getValue());
                    countEveryBunknote.put(entryBunkNotes.getKey(), entryBundleOfBanknotes.getValue());
                }
            }
        }
        // вывод банкнот
        countEveryBunknote.forEach((key, value) -> System.out.println("you put " + key + " : " + value));
    }

    @Override
    public void getMoney(Double sum) {
        Double dSum = sum;
        Map<Bunknotes, Integer> countBunkNote = new TreeMap<>(); // банкноты и их количество, которое необходимо вернуть
/*
    150 : 1*100 + 1*50 / 3*50
    200 : 2*100 / 1*100 + 2*50 / 4*50
    300 : 3*100 / 2*100 + 2*50/ 1*100 + 4*50
    350 : 1*200 + 1*100 + 1*50 / 1*200 + 3*50 / 3*100 + 1*50 / 7*50
    Алгоритм не реализован!
 */
        if (dSum % 50 == 0 && countEveryBunknote.containsKey(Bunknotes.BUNKNOTES_50)) {
            for (Map.Entry<Bunknotes, Integer> entry : bunknotesValue.getBunkNotes().entrySet()) {
                int ii = (int) (dSum / entry.getValue());
                if (ii > 0) {
                    try {
                        if (countEveryBunknote.get(entry.getKey()) != null && countEveryBunknote.get(entry.getKey()) >= ii) {
                            dSum = dSum - Double.valueOf(entry.getValue()) * ii;
                            countBunkNote.put(entry.getKey(), ii); // Количество банконот
                        } else if (sum <= count) {
                            ii = countEveryBunknote.get(entry.getKey());
                            dSum = dSum - Double.valueOf(entry.getValue()) * ii;
                            countBunkNote.put(entry.getKey(), ii); // Количество банконот
                        } else {
                            System.out.println("На счету не достаточно средств");
                            break;
                        }
                    } catch (NullPointerException e) {
                        e.getMessage();
                    }
                }
            }
            // вычетание денег со счета
            for (Map.Entry<Bunknotes, Integer> entryCount : countBunkNote.entrySet()) {
                for (Map.Entry<Bunknotes, Integer> entryVal : bunknotesValue.getBunkNotes().entrySet()) {
                    if (entryCount.getKey().equals(entryVal.getKey())) {
                        setCountDeleteMoney(entryCount.getValue(), entryVal.getValue());
                    }
                }
            }

        } else {
            System.out.println("Введите другое значение!");
        }
        countBunkNote.forEach((k, v) -> System.out.println(k + " " + v));
    }

    // Получение счета
    public Integer getCount() {
        System.out.println("На счету : " + count);
        return count;
    }
}
