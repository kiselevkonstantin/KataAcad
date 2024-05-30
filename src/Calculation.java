public class Calculation {
   public void calculateExpression(String str) throws Exception {
        String[] elements;

        if (str.contains(" + ")) {
            elements = str.split(" \\+ ");
            if (!elements[0].contains("\"") || !elements[1].contains("\""))
                throw new Exception("Первым и вторым аргументом должна быть строка");
            removeQuotes(elements);
            if (elements[0].length() > 10 || elements[1].length() > 10)
                throw new Exception("Не больше 10 символов");
            System.out.println("\"" + elements[0].concat(elements[1]) + "\"");

        } else if  (str.contains(" - ")){
            elements = str.split(" - ");
            if (!elements[0].contains("\"") || !elements[1].contains("\""))
                throw new Exception("Первым и вторым аргументом должна быть строка");
            removeQuotes(elements);
            if (elements[0].length() > 10 || elements[1].length() > 10)
                throw new Exception("Не больше 10 символов");
            if (!elements[0].contains(elements[1])) {
                System.out.println(elements[0]);
            } else {
                int point = elements[0].indexOf(elements[1]);
                String line = elements[0].substring(0, point);
                System.out.println("\"" + line + "\"");
            }

        } else if (str.contains(" * ")) {
            elements = str.split(" \\* ");
            if (!elements[0].contains("\""))
                throw new Exception("Первым аргументом должна быть строка");
            if (elements[0].length() > 10 || elements[1].length() > 10)
                throw new Exception("Не больше 10 символов");
            if (elements[1].contains("\""))
                throw new Exception("Неверный множитель");
            String output = "";
            int number = Integer.parseInt(elements[1]);
            if (number < 1 || number > 10)
                throw new Exception("Только множители от 1 до 10");
            removeQuotes(elements);
            for (int i = 0; i < number; i++) {
                output = output.concat(elements[0]);
            }
            if (output.length() > 40) {
                System.out.println("\"" + output.substring(0, 40) + "..." + "\"");
            } else System.out.println("\"" + output + "\"");


       } else if (str.contains(" / ")) {
            elements = str.split(" / ");
            if (!elements[0].contains("\"")) throw new Exception("Первым аргументом должна быть строка");
            removeQuotes(elements);
            if (elements[0].length() > 10 || elements[1].length() > 10) throw new Exception("Не больше 10 символов");
            if (elements[1].contains("\"")) throw new Exception("Неверный делитель");
            int number = Integer.parseInt(elements[1]);
            if (number < 1 || number > 10) throw new Exception("Только делители от 1 до 10");
            int point = elements[0].length() / Integer.parseInt(elements[1]);
            String output = elements[0].substring(0, point);
            System.out.println("\"" + output + "\"");

        } else throw new Exception("Неверный арифметический знак");

   }

    private void removeQuotes(String[] elements) {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = elements[i].replace("\"", "").replace(" ", "");
        }
    }
}
