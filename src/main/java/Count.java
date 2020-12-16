import java.util.Map;

public interface Count {
    void putMoney(Map<Bunknotes, Integer> coupleBunknotes);
    void getMoney(Double sum);
}
