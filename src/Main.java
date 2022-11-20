import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] operation = {"Купить", "Показать", "Удалить", "Найти"};
        LinkedList<String> purchases = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int[] quantity = new int[3];
        int sumProducts = 0;
        while (true) {
            System.out.println("\nВыберите операцию:");
            for (int i = 0; i < operation.length; i++) {
                System.out.println(i + 1 + ". " + operation[i]);
            }
            String inputString = scanner.nextLine();
            switch (inputString) {
                case "1":
                    System.out.println("Какую покупку хотите добавить?");
                    inputString = scanner.nextLine();
                    purchases.add(inputString);
                    System.out.println("Итого в списке покупок:" + purchases.size());
                    break;
                case "2":
                    out(purchases);
                    break;
                case "3":
                    out(purchases);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    inputString = scanner.nextLine();
                    if (isInt(inputString)) {
                        int i = Integer.parseInt(inputString);
                        System.out.println("Покупка " + i + " удалина,");
                        purchases.remove(i - 1);
                        out(purchases);
                    } else {
                        purchases.remove(inputString);
                        System.out.println("Покупка " + inputString + " удалина,");
                        out(purchases);
                    }
                    break;
                case "4":
                    System.out.println("Введите текст для поиска:");
                    inputString = scanner.nextLine();
                    System.out.println("Найдено:");
                    for (int a = 0; a < purchases.size(); a++) {
                        String itemLower=purchases.get(a).toLowerCase();
                        String queryLower=inputString.toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println(+(a + 1) + ". " + purchases.get(a));
                        }
                    }
                    break;
            }
        }
    }

    public static void out(LinkedList<String> purchases) {
        System.out.println("Список покупок:");
        for (int a = 0; a < purchases.size(); a++) {
            System.out.println(+(a + 1) + ". " + purchases.get(a));
        }
    }

    private static boolean isInt(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

