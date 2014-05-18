

public class SimpleLinkedList{
	
	private int size = 0;
	
	private void incrementSize() {
		size = size + 1;
	}
	
	private class Node {
		Node priv ;
		Node next ;
		Object item ;
		
		public Node(Object e) {
			this.next = null;
			this.priv = null;
			this.item = e;
			if (size == 0) {
				//means the the linked list is empty and this is the first node
			    start = this;
			}	
		}
	}
	
	
	Node start ;
	
	public SimpleLinkedList(){
		
	}
	
	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		
		if (size == 0) {
			//means this is the first node and the node construction will
			//take care of the linking
			new Node(e);
			incrementSize();
		}
		else {
			Node n = new Node(e);
			//find the last node 
			Node tempNode = start;
			for (int i = 1; i < size ; i++) {
				tempNode = tempNode.next ;
			}
			//now tempNode is the last Node
			n.priv = tempNode;
			tempNode.next = n;
			incrementSize();
		}
		
		return false;
	}

	

}
