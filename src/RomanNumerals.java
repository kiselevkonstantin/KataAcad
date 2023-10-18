public class RomanNumerals {
    static String [] numerals = new String[] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI"};
    
    public static boolean isRoman(String number){
        for (int i = 0; i < numerals.length; i++) {
            if(number.equals(numerals[i])) {
                return true;
            }
        }
        return false;
    }
    public static int writeOnArabic (String number){
        for (int i = 0; i < numerals.length; i++) {
            if(number.equals(numerals[i])){
                return i;
            }
        }
        return 0;
    }

    public static String writeOnRoman (int number){
        return numerals[number];
    }

}
