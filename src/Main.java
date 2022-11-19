import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] operation = {"Купить", "Показать", "Удалить","Найти"};
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < operation.length; i++) {
            System.out.println(i + 1 + ". "  + operation[i]);
        }
        int[] quantity = new int[3];
        int sumProducts = 0;
        while (true) {
            int productNumber = 0;
            int productCount = 0;
            System.out.println("Выберите операцию:");
            String inputString = scanner.nextLine();
            if (inputString.equals("end")) {
                break;
            }
            String[] parts = inputString.split(" ");
            if (parts.length != 2) {
                System.out.println("Должно быть 2 числа через пробел или end");
                continue;
            }
            try {
                productNumber = Integer.parseInt(parts[0]);
                productCount += Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Должны быть числа, попробуйте ещё раз");
            }
            if (productNumber < 1 | productNumber > 3) {
                System.out.println("В наличии товар от 1-3, попробуйте ещё раз");
                continue;
            }
            if (productCount < 1) {
                System.out.println("Количество тавара должго быть больше 0, попробуйте ещё раз");
                continue;
            }
            quantity[productNumber - 1] += productCount;
        }
/*        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (quantity[i] == 0) {
                continue;
            }
            System.out.println(products[i] + " " + quantity[i] + "шт " + prices[i] + " руб/шт " + prices[i] * quantity[i] + " руб в сумме");
            sumProducts += prices[i] * quantity[i];
        }*/
        System.out.println("Итого " + sumProducts + " руб");
    }
}

