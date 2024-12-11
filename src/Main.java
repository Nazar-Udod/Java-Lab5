import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main.java: Entry point for the application. Provides an interactive menu for users
 * to manage a list of tariffs, calculate client totals, sort tariffs, and search by rate range.
 */
public class Main {
    public static void main(String[] args) {
        List<Tariff> tariffs = new ArrayList<Tariff>();
        tariffs.add(new BasicTariff("Basic", 100, 100, 100));
        tariffs.add(new BasicTariff("Advanced", 200, 50, 200));
        tariffs.add(new BasicTariff("SuperCalling", 300, 40, 500));
        tariffs.add(new InternetTariff("BasicInternet", 100, 110, 2048));
        tariffs.add(new InternetTariff("AdvancedInternet", 200, 70, 4096));
        tariffs.add(new InternetTariff("SuperInternet", 300, 50, 8192));
        tariffs.add(new InternetTariff("UltraInternet", 350, 10, 16384));
        tariffs.add(new SMSTariff("BasicSMS", 100, 100, 100));
        tariffs.add(new SMSTariff("AdvancedSMS", 150, 90, 200));
        tariffs.add(new SMSTariff("SuperSMS", 250, 15, 300));
        TariffsList tariffsList = new TariffsList(tariffs);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Виберіть бажану дію:\n"
                    + "1: порахувати загальну кількість клієнтів\n"
                    + "2: посортувати усі тарифи за ціною\n"
                    + "3: знайти тариф за ціною\n"
                    + "4: вихід");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println(tariffsList.countAllCients());
                    break;
                case 2:
                    for (Tariff tariff : tariffsList.sortTariffsByRate()) {
                        System.out.println(tariff);
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Введіть мінімальну ціну");
                        double minRate = scanner.nextDouble();
                        System.out.println("Введіть максимальну ціну");
                        double maxRate = scanner.nextDouble();
                        Tariff tariff = tariffsList.findTariffByRateRange(minRate, maxRate);
                        if (tariff != null) {
                            System.out.println("Перший знайдений тариф:");
                            System.out.println(tariff);
                        }
                        else {
                            System.out.println("Тариф не знайдено");
                        }
                    }
                    catch (Exception e) {
                        System.out.println("Невірні дані");
                        scanner.next();
                    }
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Невірні дані, спробуйте ще раз");
            }
        }
    }
}