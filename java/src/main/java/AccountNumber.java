import java.util.Objects;

public class AccountNumber {
    private static final String[][] NUMERALS = new String[][] {
            {       " _  ",
                    "| | ",
                    "|_| ",
                    "    "},
            {       "    ",
                    "  | ",
                    "  | ",
                    "    "},
            {       " _  ",
                    " _| ",
                    "|_  ",
                    "    "},
            {       " _  ",
                    " _| ",
                    " _| ",
                    "    "},
            {       "    ",
                    "|_| ",
                    "  | ",
                    "    "},
            {       " _  ",
                    "|_  ",
                    " _| ",
                    "    "},
            {       " _  ",
                    "|_  ",
                    "|_| ",
                    "    "},
            {       " _  ",
                    "  | ",
                    "  | ",
                    "    "},
            {       " _  ",
                    "|_| ",
                    "|_| ",
                    "    "},
            {       " _  ",
                    "|_| ",
                    " _| ",
                    "    "}};

    final char[] work;


    public AccountNumber() {
        work = "?????????    ".toCharArray();
    }

    // TODO Index out of bounds
    void setCharAt(int pos, char character) {
        work[pos] = character;
    }

    void setNumeralAt(int pos, int numeral) {
        work[pos] = Character.forDigit(numeral, 10);
        // (char) (numeral + (int) '0');
    }

    void setILL() {
        setCharAt(10, 'I');
        setCharAt(11, 'L');
        setCharAt(12, 'L');
    }

    // TODO Create separate class for this
    boolean parse(int pos, String... lines) {
        int parsed = -1;
        for (int i = 0; i < NUMERALS.length; i++) {
            String[] numeral = NUMERALS[i];
            if (numeral[0].equals(lines[0])
                && numeral[1].equals(lines[1])
                && numeral[2].equals(lines[2])
                && numeral[3].equals(lines[3])) {
                parsed = i;
            }
        }

        if (parsed > -1) {
            setNumeralAt(pos, parsed);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return new String(work);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountNumber that = (AccountNumber) o;
        return Objects.equals(toString(), that.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
