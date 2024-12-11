/**
 * Abstract class representing a general tariff.
 */
public abstract class Tariff {
    private String name;
    private double rate;
    private int numberOfClients;

    /**
     * Constructs a new Tariff.
     *
     * @param name the name of the tariff
     * @param rate the monthly rate in hryvnas
     * @param numberOfClients the number of clients using this tariff
     */
    public Tariff(String name, double rate, int numberOfClients) {
        this.name = name;
        this.rate = rate;
        this.numberOfClients = numberOfClients;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public int getNumberOfClients() {
        return numberOfClients;
    }
    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    @Override
    public String toString() {
        return "Назва: " + name + ", місячна вартість: "
                + rate + " грн., кількість клієнтів: " + numberOfClients;
    }
}
