import java.lang.runtime.TemplateRuntime;
import java.util.Arrays;

public class Project_4 {
    public static void main(String[] args) {
        String test2 = "s an example. The letter ?e? appears nine times.This i";
        String unitTest1 = encrypt("Secret Message: Doritos > Lays", 29375336);
        System.out.println(unitTest1);
        String unitTest2 = encrypt("Secret Message: Doritos > Lays", 1097592579);
        System.out.println(unitTest2);
        String unitTest3 = encrypt("shhhhhhh", 1234);
        System.out.println(unitTest3);
        String unitTest4 = encrypt("Where art thou Romeo", 999999999);
        System.out.println(unitTest4);

    }

    public static String encrypt(String input, int key) {
        int[] binary = findBinary(key);
        int rep = 255;
        // System.out.println(Arrays.toString(binary));
        while (binary[rep] != 1) {
            rep--;
        }
        // int maxLength = rep;
        // rep = 0;
        String tempString = new String();
        while (rep != -1) {
            if (binary[rep] == 1) {
                tempString = shuffle(input);
                input = tempString;
                // System.out.println("shuffled");
            }
            if (binary[rep] == 0) {
                tempString = riffle(input);
                input = tempString;
                // System.out.println("riffled");

            }
            rep--;
        }
        return input;
    }

    public static int[] findBinary(int key) {
        int[] binary = new int[256];
        int rep = 0;
        while (key != 0) {
            binary[rep++] = key & 1;
            key = key >> 1;
        }
        return binary;
    }

    public static String reverseRiffle(String input) {
        String riffledString;
        int commonLetter = mostCommonLetter(input);
        int totalLength = input.length();
        int shift = totalLength / commonLetter;
        String tempS1 = input.substring(0, (totalLength - shift));
        String tempS2 = input.substring((totalLength - shift), totalLength);
        riffledString = (tempS2 + tempS1 + "");
        return riffledString;
    }

    public static String riffle(String input) {
        String riffledString;
        int commonLetter = mostCommonLetter(input);
        int totalLength = input.length();
        int shift = totalLength / commonLetter;
        String tempS1 = input.substring(0, shift);
        String tempS2 = input.substring(shift, totalLength);
        riffledString = (tempS2 + tempS1 + "");
        return riffledString;
    }

    public static int mostCommonLetter(String input) {
        char[] letters = input.toCharArray();
        int commonLetter = 0;
        int rep = 0;
        char letter;
        int finalCount = 0;
        int count = 0;
        letter = letters[count];
        int truLength = letters.length;
        while (count != truLength && rep != truLength) {
            letter = letters[0];
            while (rep != truLength) {
                if (letters[rep++] == letter) {
                    commonLetter++;
                }

                if (rep == truLength) {
                    rep = count;
                    count++;
                    if (count >= truLength) {
                        count = truLength;
                    }
                    if (commonLetter > finalCount) {
                        finalCount = commonLetter;
                    }
                    commonLetter = 0;

                    if (count >= truLength) {

                        return finalCount;
                    }

                    letter = letters[count];

                }
            }
        }

        return finalCount;
    }

    public static String shuffle(String input) {
        char[] tempCharArray = input.toCharArray();
        int rep;
        for (rep = 0; rep != tempCharArray.length; rep++) {
            if (tempCharArray[rep] != ' ') {
                tempCharArray[rep] = (char) findNewValue(rep, tempCharArray);

            }

        }
        String returnValue = new String(tempCharArray);

        return returnValue;
    }

    public static int rshuffle() {
        int value;
        for (value = 33; value != 127; value++) {
            if (111 == (value + 294) % 94 + 33) {
                return value;
            }
        }
        return value;
    }

    public static int findNewValue(int valueChanged, char[] tempCharacters) {
        // Value changed is the first value added together
        int value = 0;
        int newValue = 0;
        int rep = 0;
        int intialValue = (int) tempCharacters[valueChanged++];
        while (rep != 3) {
            if (valueChanged == tempCharacters.length) {
                valueChanged = 0;
            }
            // System.out.println(value + " is the Value");

            if (tempCharacters[valueChanged] == ' ') {

                value = value + (int) tempCharacters[valueChanged];
                valueChanged++;
                rep--;
                value = value - 32;

            } else {

                value = value + (int) tempCharacters[valueChanged];
                valueChanged++;

            }

            rep++;
        }
        // Example Way
        newValue = ((value + intialValue) % 94) + 33;

        // Written Instructions
        // newValue = ((value) % 94) + 33;
        // newValue = (newValue + intialValue) % 126;
        // if (newValue < 33) {
        // newValue = newValue + 33;
        // }

        // Paper Instructions
        // newValue = ((value) % 89) + 33;
        // newValue = (newValue + intialValue) % 122;
        // if (newValue < 33) {
        // newValue = newValue + 33;
        // }

        // System.out.println("Letter value " + oldLetter + "next three " + value + "New
        // Value " + newValue);

        return newValue;
    }

}