import java.util.Scanner;

public class ScannerInput {
    public static String[] getScannerInput() throws ScannerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение из 2 целых чисел (1-10)");
        String formula = sc.nextLine();
        String[] formulaParts = formula.split(" ");

        ErrorHandler.checkFormulaFormat(formulaParts);

        return formulaParts;
    }
}
