import java.util.Arrays;

public class BinarySearchSortRecursionStrings {
    public static int binarySearch(String[] words, int left, int right, String word) {

        if ( left > right ) {
            return -1;
        }

        if ( right - left == 1 ) {
            return words[left].equals(word) ? left : -1 ;
        }
        int mid = left + ( right - left ) / 2 ;
        if ( words[mid].equals(word)) {
            return mid;
        }

        if ( word.compareTo(words[mid] ) < 0 ) {
            return binarySearch( words, left, mid - 1 , word) ;
        }

        if ( word.compareTo(words[mid] ) > 0 ) {
            return binarySearch ( words, mid + 1, right, word) ;
        }
        return mid;
    }

    public static void insertionSort( String[] words ) {

        for ( int i = 0; i < words.length; i++ ) {

            String current = words[i];
            int j = i - 1;

            while ( j >= 0 && words[j].compareTo(current) > 0 ) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = current;
        }
    }

    public static void selectionSort( String[] words ) {

        int size = words.length;

        for ( int i = 0; i < size - 1; i++ ) {

            int currentMaximumIndex = i;

            for ( int j = i + 1; j < words.length; j++ ) {
                if (words[currentMaximumIndex].compareTo(words[j]) < 0 ) {
                    currentMaximumIndex = j;
                }
            }
            swap(words, i , currentMaximumIndex);
        }
    }

    public static void swap( String[] words, int index1, int index2 ) {
        String temp = words[index2];
        words[index2] = words[index1];
        words[index1] = temp;

    }
    public static void main(String[] args) {

        String[] words = { "mouse", "cat", "hamster", "dog", "fish", "bird", "lizard", "snake"};
        String word = "dog";

        int left = 0;
        int right = words.length - 1;

        int index = binarySearch(words, left, right, word);
        if (index != -1) {
            System.out.println("Word " + word + " found at index " + index);
        } else {
            System.out.println("Word not found in the array");
        }
        System.out.println("Words in ascending order");
        insertionSort(words);
        System.out.println(Arrays.toString(words));

        System.out.println("Words in descending order");
        selectionSort(words);
        System.out.println(Arrays.toString(words));
    }
}
