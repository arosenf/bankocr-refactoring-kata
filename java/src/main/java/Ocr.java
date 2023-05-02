import java.util.List;
import java.util.ArrayList;

public class Ocr {

    private static final char[][][] NUMERALS = new char[][][] {
        {" _  ".toCharArray(),
         "| | ".toCharArray(),
         "|_| ".toCharArray(),
         "    ".toCharArray()},
        {"    ".toCharArray(),
         "  | ".toCharArray(),
         "  | ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         " _| ".toCharArray(),
         "|_  ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         " _| ".toCharArray(),
         " _| ".toCharArray(),
         "    ".toCharArray()},
        {"    ".toCharArray(),
         "|_| ".toCharArray(),
         "  | ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "|_  ".toCharArray(),
         " _| ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "|_  ".toCharArray(),
         "|_| ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "  | ".toCharArray(),
         "  | ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "|_| ".toCharArray(),
         "|_| ".toCharArray(),
         "    ".toCharArray()},
        {" _  ".toCharArray(),
         "|_| ".toCharArray(),
         " _| ".toCharArray(),
         "    ".toCharArray()}};

    public static List<String> parse(String... lines) {
        final List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.length; i += 4) {
            AccountNumber accountNumber = new AccountNumber();
            for (int pos = 0; pos < 9; ++pos) {
                boolean got1 = false;
                for (int numeral = 0; numeral <= 9; ++numeral) {
                    List<String> digit = new ArrayList<>();
                    for (int row = 0; row < 4; ++row) {
                        char[] digitLine = new char[4];
                        for (int col = 0; col < 4; ++col) {
                            char dot = lines[i + row].charAt(4 * pos + col);
                            digitLine[col] = dot;
                        }
                        digit.add(new String(digitLine));
                    }

                    got1 = accountNumber.parse(pos, digit.toArray(new String[0]));
                    if (got1) {
                        break;
                    }
                }
                if (!got1) {
                    accountNumber.setILL();
                }
            }
            result.add(accountNumber.toString());
        }
        return result;
    }
}
