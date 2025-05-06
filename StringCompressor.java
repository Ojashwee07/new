public class StringCompressor {

    public static int compress(char[] chars) {
        int write = 0;  // index to write chars
        int left = 0;   // start index of the group

        for (int read = 0; read < chars.length; read++) {
            // if end of group or last char, compress
            if (read == chars.length - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read]; // write the character

                int count = read - left + 1;
                if (count > 1) {
                    // write the count digits one by one
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[write++] = c;
                    }
                }
                left = read + 1; // move to next group
            }
        }

        return write;
    }

    public static void main(String[] args) {
        char[] input = {'a', 'a','a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = compress(input);
        System.out.print("Compressed string: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(input[i]);
        }
        System.out.println("\nNew length: " + newLength);
    }
}