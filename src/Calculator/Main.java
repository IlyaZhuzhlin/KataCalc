package Calculator;

import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n1, n2;
    static char operation;
    static int result;

    public static void main(String[] args) throws Exception {
        String enter = sc.nextLine();

        char[] charArray = new char[10];
        for (int i = 0; i < enter.length(); i++) {
            charArray[i] = enter.charAt(i);
            if (charArray[i] == '+') {
                operation = '+';
            }
            if (charArray[i] == '-') {
                operation = '-';
            }
            if (charArray[i] == '*') {
                operation = '*';
            }
            if (charArray[i] == '/') {
                operation = '/';
            }
        }


        String massCharString = String.valueOf(charArray);
        String[] stringArray = massCharString.split("[+-/*]");

        if (stringArray.length < 2) {
            throw new Exception("строка не является математической операцией");
        }
        if (stringArray.length > 2) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }


        String left = stringArray[0].trim();
        String right = stringArray[1].trim();


        n1 = romanToArabian(left);
        n2 = romanToArabian(right);

        if (n1 == -1 && n2 > -1 || n2 == -1 && n1 > -1) {
            throw new Exception("используются одновременно разные системы счисления");
        }
        if (n1 < 0 && n2 < 0) {
            result = 0;
        } else {
            result = calculated(n1, n2, operation);
            if (result < 0) {
                throw new Exception("в римской системе нет отрицательных чисел");
            }
            String resultRoman = convertNumToRoman(result);
            System.out.println(resultRoman);
            return;
        }


        n1 = Integer.parseInt(left);
        n2 = Integer.parseInt(right);
        if ((n1 < 1) || (10 < n1) || (n2 < 1) || (10 < n2)) {
            throw new Exception("Ввод цифр только от 1 до 10");
        } else {
            result = calculated(n1, n2, operation);
            System.out.println(result);
        }
    }


     static int romanToArabian(String romanNum)  {

        if (romanNum.equals("I")) {
            return 1;
        } else if (romanNum.equals("II")) {
            return 2;
        } else if (romanNum.equals("III")) {
            return 3;
        } else if (romanNum.equals("IV")) {
            return 4;
        } else if (romanNum.equals("V")) {
            return 5;
        } else if (romanNum.equals("VI")) {
            return 6;
        } else if (romanNum.equals("VII")) {
            return 7;
        } else if (romanNum.equals("VIII")) {
            return 8;
        } else if (romanNum.equals("IX")) {
            return 9;
        } else if (romanNum.equals("X")) {
            return 10;
        }
        return -1;
    }

     static String convertNumToRoman(int numArab) {
        String[] roman = new String[]{"пусто, нуля римляне не придумали...","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String s = roman[numArab];
        return s;
    }

     static int calculated(int num1, int num2, char operator){
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':

                break;
        }
        return result;
    }
}