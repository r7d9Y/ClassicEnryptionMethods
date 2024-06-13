import java.util.*;

public class vigenereDecrypter {

    private static final char[][] vigenereSquare = {
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
            {'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A'},
            {'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B'},
            {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C'},
            {'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D'},
            {'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E'},
            {'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F'},
            {'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G'},
            {'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'},
            {'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'},
            {'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'},
            {'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'},
            {'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'},
            {'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'},
            {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'},
            {'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'},
            {'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'},
            {'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q'},
            {'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R'},
            {'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S'},
            {'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'},
            {'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'},
            {'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V'},
            {'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'},
            {'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'},
            {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'}
    };

    public static void main(String[] args) {
        String ciphertext = "";
        int keyLength = findKeyLength(ciphertext);
        String key = "";
        System.out.println("Key: " + key + "\nKeyLength: " + keyLength);
        String plaintext = decrypt(ciphertext, key);
        System.out.println("Plaintext: " + plaintext);
    }

    private static int findKeyLength(String text) {
        int[] distances = findRepeatedSequencesSpacings(text);
        return findMostCommonFactor(distances);
    }

    private static int[] findRepeatedSequencesSpacings(String text) {
        Map<String, List<Integer>> sequences = new HashMap<>();
        for (int i = 0; i < text.length() - 3; i++) {
            String sequence = text.substring(i, i + 3);
            if (!sequences.containsKey(sequence)) {
                sequences.put(sequence, new ArrayList<>());
            }
            sequences.get(sequence).add(i);
        }
        List<Integer> distances = new ArrayList<>();
        for (List<Integer> positions : sequences.values()) {
            if (positions.size() > 1) {
                for (int i = 1; i < positions.size(); i++) {
                    distances.add(positions.get(i) - positions.get(i - 1));
                }
            }
        }
        return distances.stream().mapToInt(i -> i).toArray();
    }

    private static int findMostCommonFactor(int[] distances) {
        Map<Integer, Integer> factorCounts = new HashMap<>();
        for (int distance : distances) {
            for (int factor = 2; factor <= distance; factor++) {
                if (distance % factor == 0) {
                    factorCounts.put(factor, factorCounts.getOrDefault(factor, 0) + 1);
                }
            }
        }
        return Collections.max(factorCounts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String findKey(String text, int keyLength) {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < keyLength; i++) {
            String segment = extractSegment(text, i, keyLength);
            char keyChar = findMostLikelyKeyChar(segment);
            key.append(keyChar);
        }
        return key.toString();
    }

    private static String extractSegment(String text, int start, int step) {
        StringBuilder segment = new StringBuilder();
        for (int i = start; i < text.length(); i += step) {
            segment.append(text.charAt(i));
        }
        return segment.toString();
    }

    private static char findMostLikelyKeyChar(String segment) {
        int[] freq = new int[26];
        for (char c : segment.toCharArray()) {
            freq[c - 'A']++;
        }
        double[] englishFreq = {
                0.082, 0.015, 0.028, 0.043, 0.127, 0.022, 0.020, 0.061, 0.070, 0.002,
                0.008, 0.040, 0.024, 0.067, 0.075, 0.019, 0.001, 0.060, 0.063, 0.091,
                0.028, 0.010, 0.023, 0.001, 0.020, 0.001
        };
        double minChiSquare = Double.MAX_VALUE;
        char bestChar = 'A';
        for (int shift = 0; shift < 26; shift++) {
            double chiSquare = 0.0;
            for (int i = 0; i < 26; i++) {
                int expected = (int) (englishFreq[i] * segment.length());
                int observed = freq[(i + shift) % 26];
                chiSquare += Math.pow(observed - expected, 2.0) / expected;
            }
            if (chiSquare < minChiSquare) {
                minChiSquare = chiSquare;
                bestChar = (char) ('A' + shift);
            }
        }
        return bestChar;
    }

    private static String decrypt(String text, String key) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char cipherChar = text.charAt(i);
            char keyChar = key.charAt(i % key.length());
            int row = keyChar - 'A';
            int col = 0;
            for (int j = 0; j < 26; j++) {
                if (vigenereSquare[row][j] == cipherChar) {
                    col = j;
                    break;
                }
            }
            plaintext.append(vigenereSquare[0][col]);
        }
        return plaintext.toString();
    }
}
