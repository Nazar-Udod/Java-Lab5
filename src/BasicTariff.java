/**
 * Represents a tariff focused on call services with a defined call limit.
 */
public class BasicTariff extends Tariff {
    private double callsLimitMin;

    /**
     * Constructs a BasicTariff.
     *
     * @param name the name of the tariff
     * @param rate the monthly rate in hryvnas
     * @param numberOfClients the number of clients using this tariff
     * @param callsLimitMin the maximum number of call minutes included
     */
    public BasicTariff(String name, double rate, int numberOfClients, double callsLimitMin) {
        super(name, rate, numberOfClients);
        this.callsLimitMin = callsLimitMin;
    }

    public double getCallsLimitMin() {
        return callsLimitMin;
    }
    public void setCallsLimitMin(double callsLimitMin) {
        this.callsLimitMin = callsLimitMin;
    }

    @Override
    public String toString() {
        return super.toString() + ", ліміт дзвінків: " + callsLimitMin + " хв.";
    }
}
