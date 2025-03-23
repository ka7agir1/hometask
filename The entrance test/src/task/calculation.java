package task;

import java.util.Scanner;

class calculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение: ");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        input = input.trim();

        if (!input.matches("\\d+\\s*[+\\-*/]\\s*\\d+")) {
            throw new Exception("Некорректный формат выражения");
        }

        String[] parts = input.split("\\s*[+\\-*/]\\s*");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Операнды должны быть в диапазоне от 1 до 10 включительно");
        }

        char operator = input.replaceAll("[\\d\\s]", "").charAt(0);

        int result = switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new Exception("Деление на ноль");
                yield a / b;
            }
            default -> throw new Exception("Неподдерживаемая операция");
        };

        return String.valueOf(result);
    }
}