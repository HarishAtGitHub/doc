

public class SimpleLinkedList<ContainerType>{
	
	private int size = 0;
	
	private void incrementSize() {
		size = size + 1;
	}
	
	private class Node {
		Node priv ;
		Node next ;
		ContainerType item ;
		
		public Node(ContainerType e) {
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
		return size;
	}

	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	
	public boolean add(ContainerType e) {
		
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

