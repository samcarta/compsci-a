import java.lang.runtime.TemplateRuntime;

public class Project_4 {
    public static void main(String[] args) {
        String test2 = "s an example. The letter ?e? appears nine times.This i";

        System.out.println(shuffle("the cat"));
        System.out.println(rshuffle());
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
        String tempS2 = input.substring((shift), totalLength);
        riffledString = (tempS1 + tempS2 + "");
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
        char value;
        for (rep = 0; rep != tempCharArray.length; rep++) {
            if (tempCharArray[rep] != ' ') {
                value = (char) findNewValue(rep, tempCharArray);
                tempCharArray[rep] = value;
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
        while (rep <= 3) {
            if (valueChanged >= tempCharacters.length) {
                valueChanged = 0;
            }
            // System.out.println(value + " is the Value");
            if (tempCharacters[valueChanged] == ' ') {
                valueChanged++;
                value += tempCharacters[valueChanged++];
            } else {
                value += tempCharacters[valueChanged++];
            }
            rep++;
        }

        newValue = ((value) % 94) + 33;
        // System.out.println("Letter value " + oldLetter + "next three " + value + "New
        // Value " + newValue);
        return newValue;
    }

}