package encryptdecrypt;


abstract public class BlackBox {

    abstract String encrypt(String input, int key);

    abstract String decrypt(String input, int key);
}

class BlackBoxShift extends BlackBox{

    String encrypt(String input, int key) {

        char a = 'a';
        char z = 'z';
        char A = 'A';
        char Z = 'Z';
        int size = 26;
        StringBuilder output = new StringBuilder();

        for (int ii = 0; ii < input.length(); ii++) {

            if (input.charAt(ii) >= a && input.charAt(ii) <= z) {
                char shiftItem = (char) (((input.charAt(ii) - a + key) % size) + a);
                output.append(shiftItem);
            } else if (input.charAt(ii) >= A && input.charAt(ii) <= Z) {
                char shiftItem = (char) (((input.charAt(ii) - A + key) % size) + A);
                output.append(shiftItem);
            } else {
                output.append(input.charAt(ii));
            }
        }
        return output.toString();
    }

    String decrypt(String input, int key) {

        char a = 'a';
        char z = 'z';
        char A = 'A';
        char Z = 'Z';
        int size = 26;
        String output = "";
        output = this.encrypt(input, size - key);
        return output;
    }
}

class BlackBoxUni extends BlackBox {

    String encrypt(String input, int key) {
        char outChar;
        StringBuilder output = new StringBuilder();
        for (int ii = 0; ii < input.length(); ii++) {
            outChar = (char) (input.charAt(ii) + key);
            //System.out.println(outChar);
            output.append(outChar);
        }
        return output.toString();
    }

    String decrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        char outChar = 0;

        for (int ii = 0; ii < input.length(); ii++) {
            outChar = (char) (input.charAt(ii) - key);
            //System.out.println(outChar);
            output.append(outChar);
        }
        return output.toString();
    }
}
