
public class OffByN implements CharacterComparator {
    private int Number;

    public void OffByN(int n){
        this.Number = n;
    }

    public boolean equalChars(char x, char y) {
        return (x == y + Number || y == x + Number);
    }


}
