/**
 * Represents a tariff focused on SMS services with a defined message limit.
 */
public class SMSTariff extends Tariff {
    private int numberOfMessages;

    /**
     * Constructs an SMSTariff.
     *
     * @param name the name of the tariff
     * @param rate the monthly rate in hryvnas
     * @param numberOfClients the number of clients using this tariff
     * @param numberOfMessages the maximum number of SMS messages included
     */
    public SMSTariff(String name, double rate, int numberOfClients, int numberOfMessages) {
        super(name, rate, numberOfClients);
        this.numberOfMessages = numberOfMessages;
    }

    public int getNumberOfMessages() {
        return numberOfMessages;
    }
    public void setNumberOfMessages(int numberOfMessages) {
        this.numberOfMessages = numberOfMessages;
    }

    @Override
    public String toString() {
        return super.toString() + ", ліміт повідомлень: " + numberOfMessages;
    }
}
