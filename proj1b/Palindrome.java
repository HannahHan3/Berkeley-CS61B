public class Palindrome<T> {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> CharDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            CharDeque.addLast(word.charAt(i));
        }
        return CharDeque;
    }
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque);
    }

    private boolean isPalindromeHelper(Deque<Character> wordDeque) {
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }
        char first = wordDeque.removeFirst();
        char last = wordDeque.removeLast();

        if (first == last) {
            return isPalindromeHelper(wordDeque);
        } else {
            return false;
        }


    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return helper(wordToDeque(word), cc);
    }

    private boolean helper(Deque<Character> rest, CharacterComparator cc) {
        if (rest.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(rest.removeFirst(), rest.removeLast())) {
            return false;
        }
        return helper(rest, cc);
    }



}
