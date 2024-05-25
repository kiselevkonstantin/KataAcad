import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пример: ");
        String arithExample = scanner.nextLine();
        System.out.println("Ответ: ");
        calc(arithExample);
    }
    public static void calc(String arithExample) throws Exception {
        int total;
        boolean romanNumber;
        String result;
        int first;
        int second;
        String operator;
        String[] firstAndSecond;
        //делим строку на отдельные значения String
        firstAndSecond = arithExample.split("[+\\-*/]");
        //находим арифметический знак
        operator = searchOperator(arithExample);

        if(firstAndSecond.length != 2) throw new Exception("Укажите 2 цифры или верный арифметический знак");

        if(operator == null) throw new Exception("Неверный арифметический знак");

        if (RomanNumerals.isRoman(firstAndSecond[0]) && RomanNumerals.isRoman(firstAndSecond[1])) {
            romanNumber = true;
            first = RomanNumerals.writeOnArabic(firstAndSecond[0]);
            second = RomanNumerals.writeOnArabic(firstAndSecond[1]);
        } else if (!RomanNumerals.isRoman(firstAndSecond[0]) && !RomanNumerals.isRoman(firstAndSecond[1])) {
            romanNumber = false;
            first = Integer.parseInt(firstAndSecond[0]);
            second = Integer.parseInt(firstAndSecond[1]);

        } else throw new Exception("Вы ввели значения разного формата");

        if (first > 10 || second > 10) throw new Exception("Введите число от 1 до 10");

        total = calculate(first, second, operator);

        if ((romanNumber) && (total <= 0)) {
            System.out.println("Римские числа должны быть больше 0 и сумма выражения должна быть положительной");
        } else if ((romanNumber) && (total > 0)) {
            result = RomanNumerals.writeOnRoman(total);
            System.out.println(result);
        } else {
            result = String.valueOf(total);
            System.out.println(result);
        }
    }


    public static String searchOperator (String example) {
        if (example.contains("+")) {
            return "+";
        } else if (example.contains("-")) {
            return "-";
        } else if (example.contains("/")) {
            return "/";
        } else if (example.contains("*")) {
            return "*";
        } else return null;
    }
    public static int calculate (int a, int b, String c) {
        if(c.equals("+"))
            return a + b;
        if(c.equals("-"))
            return a - b;
        if(c.equals("*"))
            return a * b;
        else
            return a / b;
    }

}
