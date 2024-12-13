import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main.java: Entry point for the application. Provides an interactive menu for users
 * to manage a list of tariffs, calculate client totals, sort tariffs, and search by rate range.
 * Also allows managing a custom set of tariffs.
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
        TariffSet<Tariff> tariffSet = new TariffSet<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Виберіть бажану дію:\n"
                    + "1: вивести список тарифів\n"
                    + "2: порахувати загальну кількість клієнтів\n"
                    + "3: посортувати усі тарифи за ціною\n"
                    + "4: знайти тариф за ціною\n"
                    + "5: додати тариф до типізованої колекції\n"
                    + "6: видалити тариф із типізованої колекції\n"
                    + "7: вивести типізовану колекцію\n"
                    + "8: вихід");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    for (Tariff tariff : tariffs) {
                        System.out.println(tariff);
                    }
                    break;
                case 2:
                    System.out.println(tariffsList.countAllCients());
                    break;
                case 3:
                    for (Tariff tariff : tariffsList.sortTariffsByRate()) {
                        System.out.println(tariff);
                    }
                    break;
                case 4:
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
                case 5:
                    System.out.println("Введіть назву тарифу:");
                    scanner.nextLine();
                    String addedTariffName = scanner.nextLine();
                    Tariff addedTariff = tariffs.stream().filter(t -> t.getName().equalsIgnoreCase(addedTariffName)).findFirst().orElse(null);
                    if (addedTariff != null) {
                        if (tariffSet.add(addedTariff)) {
                            System.out.println("Тариф додано");
                        } else {
                            System.out.println("Тариф уже існує у колекції");
                        }
                    } else {
                        System.out.println("Тариф не знайдено у початковому списку");
                    }
                    break;
                case 6:
                    System.out.println("Введіть назву тарифу:");
                    scanner.nextLine();
                    String removedTariffName = scanner.nextLine();
                    Tariff removedTariff = tariffs.stream().filter(t -> t.getName().equalsIgnoreCase(removedTariffName)).findFirst().orElse(null);
                    if (removedTariff != null) {
                        if (tariffSet.remove(removedTariff)) {
                            System.out.println("Тариф видалено");
                        } else {
                            System.out.println("Тариф не знайдено у типізованій колекції");
                        }
                    } else {
                        System.out.println("Тариф не знайдено у початковому списку");
                    }
                    break;
                case 7:
                    if (tariffSet.isEmpty()) {
                        System.out.println("Типізована колекція не містить елементів");
                    } else {
                        for (Tariff tariff : tariffSet) {
                            System.out.println(tariff);
                        }
                    }
                    break;
                case 8:
                    scanner.close();
                    return;
                default:
                    System.out.println("Невірні дані, спробуйте ще раз");
            }
        }
    }
}