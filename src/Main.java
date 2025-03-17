import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException {
        Scanner sc = new Scanner(System.in);
        Converter converter = new Converter();

        while(true) {
            System.out.println("Введите выражение из 2 целых чисел (1-10)");
            String formula = sc.nextLine();
            String[] formula_parts = formula.split(" ");

            if (formula_parts.length != 3) {
                throw new ScannerException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            String[] operators = {"+", "-", "*", "/"};

            if (!Arrays.asList(operators).contains(formula_parts[1])) {
                throw new ScannerException("Недопустимый оператор");
            }

            if (converter.isRoman(formula_parts[0]) == converter.isRoman(formula_parts[2])) {
                int a,b;

                boolean isRoman = converter.isRoman(formula_parts[0]);

                if (isRoman) {
                    a = converter.romanToInt(formula_parts[0]);
                    b = converter.romanToInt(formula_parts[2]);
                } else {
                    a = Integer.parseInt(formula_parts[0]);
                    b = Integer.parseInt(formula_parts[2]);
                }

                if (a < 1 || a > 10 || b < 1 || b > 10) {
                    throw new ScannerException("Операнды должны быть в диапазоне 1-10");
                }

                char operator = formula_parts[1].charAt(0);

                int result = switch (operator) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    default -> a / b;
                };

                if (isRoman) {
                    if (result <= 0) {
                        throw new ScannerException("В римской сиситеме счисления нет отрицательных чисел");
                    }
                    System.out.println(converter.intToRoman(result));
                } else {
                    System.out.println(result);
                }

            } else {
                throw new ScannerException("Оба операнда должны быть в единой системе счисления");
            }
        }
    }

}