package Lesson2;
import java.util.Random;

class MainArray {
    public static void main(String[] args) {
        String[][] arrayInput = new String[4][4];

        // проверка размерности массива (перехват исключений)
        ArraySize(arrayInput);

        // заполнение массива элементами
        for (int i = 0; i < arrayInput.length; i++) {
            for (int j = 0; j < arrayInput.length; j++) {
                arrayInput[i][j] = RndSymb();
                System.out.print(arrayInput[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        // проверка корректности типов элементов в массиве
        // подсчёт суммы элементов (перехват исключений)
        try {
            ArraySymbol(arrayInput);
        } catch (MyArrayDataEcxeption myArrayDataEcxeption) {
            myArrayDataEcxeption.printStackTrace();
        }
    }

    // генератор различных типов элементов массива
    public static String RndSymb() {
        String DataSymb = "0123456789X";
        Random rnd = new Random();
        StringBuilder SB = new StringBuilder(DataSymb.length());
        SB.append(DataSymb.charAt(rnd.nextInt(DataSymb.length())));
        return SB.toString();
    }

    public static void ArraySize(String[][] arrayInput) {
        if (arrayInput.length > 3) try {
            throw new MyArraySizeException("Превышен размер массива");
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    public static void ArraySymbol(String[][] arrayInput) throws MyArrayDataEcxeption {
        int x = 0;
        for (int i = 0; i < arrayInput.length; i++) {
            for (int j = 0; j < arrayInput.length; j++) {
                try {
                    x += Integer.parseInt(arrayInput[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataEcxeption("Неверный символ в массиве. " + "Столбец " + j + " Строка " + i);
                }
            }
        }
        System.out.println("Сумма элементов в массиве = " + x);
    }
}
