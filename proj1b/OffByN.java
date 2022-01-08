
public class OffByN implements CharacterComparator {

    private int number;

    public OffByN(int n) {
        this.number = n;
    }

    public boolean equalChars(char x, char y) {
        return (x == y + number || y == x + number);
    }
}
