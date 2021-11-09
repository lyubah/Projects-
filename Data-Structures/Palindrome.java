public class Palindrome {
    //https://stackoverflow.com/questions/3799130/how-to-iterate-through-a-string


    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> arrDeque = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            arrDeque.addLast(c);
        }
        return arrDeque;
    }


    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        Deque<Character> d = wordToDeque(word);
        Character first = d.removeFirst();
        Character last = d.removeLast();
        while (d.size() >= 1) {
            if (!first.equals(last)) {
                return false;
            }
            first = d.removeFirst();
            last = d.removeLast();
        }

        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        } else if (cc == null) {
            return isPalindrome(word);
        }
        Deque<Character> d = wordToDeque(word);
        Character first = d.removeFirst();
        Character last = d.removeLast();
        while (d.size() >= 1) {
            if (!cc.equalChars(first, last)) {
                return false;
            }
            first = d.removeFirst();
            last = d.removeLast();
        }

        return true;

    }


}
