/**
 * Represents a tariff focused on internet services with a defined data limit.
 */
public class InternetTariff extends Tariff {
    private double internetLimitMb;

    /**
     * Constructs an InternetTariff.
     *
     * @param name the name of the tariff
     * @param rate the monthly rate in hryvnas
     * @param numberOfClients the number of clients using this tariff
     * @param internetLimitMb the maximum internet usage limit in Mb
     */
    public InternetTariff(String name, double rate, int numberOfClients, double internetLimitMb) {
        super(name, rate, numberOfClients);
        this.internetLimitMb = internetLimitMb;
    }

    public double getInternetLimitMb() {
        return internetLimitMb;
    }
    public void setInternetLimitMb(double internetLimitMb) {
        this.internetLimitMb = internetLimitMb;
    }

    @Override
    public String toString() {
        return super.toString() + ", ліміт використання Інтернету: " + internetLimitMb + "Мб";
    }
}
