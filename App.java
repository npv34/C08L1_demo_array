import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        int[] numbers = {1,2,4,2,1,6,4,1,4, 8};
        int len = numbers.length;
        int[] elementsDuplicates = new int[0];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (numbers[i] == numbers[j]) {
                    if (!checkElements(numbers[i], elementsDuplicates)) {
                        elementsDuplicates = add(elementsDuplicates, numbers[i]);
                    }
                }
             }
        }

        int[] newNumbers = new int[0];

        for (int number : numbers) {
            if (!checkElements(number, elementsDuplicates)) {
                newNumbers = add(newNumbers, number);
            }
        }

        int[] result = new int[newNumbers.length + elementsDuplicates.length];

        System.arraycopy(elementsDuplicates, 0, result, 0, elementsDuplicates.length);

        int index = 0;
        for (int j = elementsDuplicates.length; j < result.length; j++) {
            result[j] = newNumbers[index];
            index++;
        }

        System.out.println(Arrays.toString(result));
    }

    public static boolean checkElements(int value, int[] elements){
        for (int element : elements) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public static int[] add(int[] numbers, int value) {
        int len = numbers.length;
        int[] newNumbers = new int[len + 1];
        System.arraycopy(numbers, 0, newNumbers, 0, len);
        newNumbers[len] = value;
        return newNumbers;
    }

    public static int[] remove(int[] numbers, int index) {
        int len = numbers.length;
        int[] newNumbers = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            if (i < index) {
                newNumbers[i] = numbers[i];
            } else {
                newNumbers[index] = numbers[i + 1];
                index++;
            }
        }
        return newNumbers;
    }
}
