public class Main {

    public static void main(String[] args) throws ScannerException, RomanNumeralsException {
        while (true) {
            Converter converter = new Converter();
            String[] operators = {"+", "-", "*", "/"};

            String[] formulaParts = ScannerInput.getScannerInput();

            ErrorHandler.checkFormulaFormat(formulaParts);

            ErrorHandler.checkOperator(operators, formulaParts);
            ErrorHandler.checkRoman(formulaParts);

            int firstOperand, secondOperand;
            boolean isRoman = converter.isRoman(formulaParts[0]);

            if (isRoman) {
                firstOperand = converter.romanToInt(formulaParts[0]);
                secondOperand = converter.romanToInt(formulaParts[2]);
            } else {
                firstOperand = Integer.parseInt(formulaParts[0]);
                secondOperand = Integer.parseInt(formulaParts[2]);
            }

            ErrorHandler.checkOperandRange(firstOperand, secondOperand);

            char operator = formulaParts[1].charAt(0);
            int result = defineOperator(firstOperand, secondOperand, operator);

            if (isRoman) {
                ErrorHandler.checkNegativeRomanResult(result);
                System.out.println(converter.intToRoman(result));
            } else {
                System.out.println(result);
            }
        }
    }

        static int defineOperator (Integer firstOperand, Integer secondOperand,char operator){
            return switch (operator) {
                case '+' -> firstOperand + secondOperand;
                case '-' -> firstOperand - secondOperand;
                case '*' -> firstOperand * secondOperand;
                default -> firstOperand / secondOperand;
            };
        }
}