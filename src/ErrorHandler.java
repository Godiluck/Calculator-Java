import java.util.Arrays;

public class ErrorHandler {
    static Converter converter = new Converter();
    public static void checkFormulaFormat(String[] formulaParts) throws ScannerException {
        if (formulaParts.length != 3) {
            throw new ScannerException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
    public static void checkOperator(String[] operators, String[] formulaParts) throws ScannerException {
        if (!Arrays.asList(operators).contains(formulaParts[1])) {
            throw new ScannerException("Недопустимый оператор");
        };
    }
    public static void checkRoman(String[] formulaParts) throws ScannerException {
        if (converter.isRoman(formulaParts[0]) != converter.isRoman(formulaParts[2])) {
            throw new ScannerException("Оба операнда должны быть в единой системе счисления");
        }
    }
    public static void checkOperandRange(Integer firstOperand, Integer secondOperand) throws ScannerException {
        if (firstOperand < 1 || firstOperand > 10 || secondOperand < 1 || secondOperand > 10) {
            throw new ScannerException("Операнды должны быть в диапазоне 1-10");
        }
    }
    public static void checkNegativeRomanResult(Integer result) throws DolboebException {
        if (result <= 0) {
            throw new DolboebException("в римской сиситеме счисления нет отрицательных чисел");
        }
    }
}
