

public class SimpleLinkedListTest {
	public static void main(String[] args) {
		SimpleLinkedList<Integer> l = new SimpleLinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        System.out.println("Size : " + l.size());
        System.out.println("Is Empty : " + l.isEmpty());
        
	}
}

