import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String message = "";
        String key = "";

        System.out.println(encryptWithVigenere(message, key));
    }


    static String createFrequenzy(String message) {
        int[] r = new int[26];
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while (!Arrays.toString(r).contains("50")) {
            char c = message.toLowerCase().charAt(j);
            if (Character.isLetter(c)) {
                r[c - 'a']++;
            }
            j++;
        }

        for (int i = 0; i < 26; i++) {
            sb.append((char) (i + 'a')).append(": ").append(r[i]).append("\n");
        }

        return sb.toString();
    }

    public static String encrypt(String message, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (char character : message.toCharArray()) {

            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) ((character - base + shift) % 26 + base);
            }
            encrypted.append(character);
        }

        return encrypted.toString();
    }


    public static String decrypt(String encryptedMessage, int shift) {
        StringBuilder decrypted = new StringBuilder();

        for (char character : encryptedMessage.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) ((character - base - shift + 26) % 26 + base);
            }
            decrypted.append(character);
        }

        return decrypted.toString();
    }




    public static String encryptWithVigenere(String message, String key) {
        StringBuilder encrypted = new StringBuilder();
        key = key.toUpperCase();
        int keyLength = key.length(), keyIndex = 0;

        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                int base = Character.isLowerCase(character) ? 'a' : 'A',
                        shift = key.charAt(keyIndex % keyLength) - 'A';
                character = (char) ((character - base + shift) % 26 + base);
                keyIndex++;
            }
            encrypted.append(character);
        }

        return encrypted.toString();
    }


}
