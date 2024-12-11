import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Manages a collection of Tariff objects and provides utility methods for analysis.
 */
public class TariffsList {
    private List<Tariff> tariffs;

    /**
     * Constructs a new TariffsList.
     *
     * @param tariffs the list of tariffs to manage
     */
    public TariffsList(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }
    public void setTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    /**
     * Calculates the total number of clients across all tariffs.
     *
     * @return the total number of clients
     */
    public int countAllCients() {
        if (tariffs.isEmpty()) {
            return 0;
        }
        else {
            return tariffs.stream().mapToInt(Tariff::getNumberOfClients).sum();
        }
    }

    /**
     * Sorts the list of tariffs by their monthly rate in ascending order.
     *
     * @return a sorted list of tariffs
     */
    public List<Tariff> sortTariffsByRate() {
        List<Tariff> sortedTariffs = new ArrayList<Tariff>(tariffs);
        sortedTariffs.sort(Comparator.comparingDouble(Tariff::getRate));
        return sortedTariffs;
    }

    /**
     * Finds the first tariff within a specified price range.
     *
     * @param minRate the minimum rate to search for
     * @param maxRate the maximum rate to search for
     * @return the first tariff within the range, or null if none are found
     */
    public Tariff findTariffByRateRange(double minRate, double maxRate) {
        return tariffs.stream()
                .filter(tariff -> tariff.getRate() >= minRate && tariff.getRate() <= maxRate)
                .findFirst()
                .orElse(null);
    }
}
