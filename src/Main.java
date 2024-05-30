import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Calculation calculation = new Calculation();
        System.out.println("Введите пример: ");
        String example = scanner.nextLine();
        System.out.println("Ответ: ");
        calculation.calculateExpression(example);
    }
}
