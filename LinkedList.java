public class LinkedList {
    
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public int addLast(int node) {

        Node newNode = new Node(node);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }
        this.size += 1;
        return node;
    }

    public int addFirst(int node) {
        
        Node newNode = new Node(node);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
        this.size += 1;
        return node;
    }

    public int add(int index, int node) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(node);

        if (index == 0) {
            return addFirst(node);    
        } else if (index == this.size - 1){
            return addLast(node);
        }
        else {
            Node aux = this.head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();}

            newNode.setNext(aux.getNext());
            aux.setNext(newNode);
            this.size += 1;
        }
        return node;
    }

    public Node getFirst() {
        if (isEmpty()) {return null;}
        return this.head;
    }

    public Node getLast() {
        if (isEmpty()) {return null;}
        return this.tail;
    }

    public Node get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        return aux;
    }
    

    public int indexOf(int nodeValue) {

        Node node = new Node(nodeValue);
        Node aux = this.head;
        int idx = 0;
        while (aux.getNext() != null) {

            if (aux.equals(node)) {
                return idx;
            } else {
                aux = aux.getNext();
                idx += 1;
            }

        }
        return -1;
    }

    public boolean contains(int node) {
        return indexOf(node) != -1;
    }

    public Node removeFirst() {

        if (isEmpty()) {return null;}

        Node out = this.head;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(null);  
        }

        this.size -= 1;
        return out;
    }

    public Node removeLast() {

        if (isEmpty()) {return null;}

        Node out = this.tail;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = tail.getPrev();
            this.tail.setNext(null);
        }

        this.size -= 1;
        return out;
    }

    public Node removeIdx(int index) {

        if (index < 0 || index >= this.size) {throw new IndexOutOfBoundsException();}
        if (index == 0 ) {return removeFirst();}
        if (index == this.size - 1) {return removeLast();}
        
        Node out = this.head;
        for (int i = 0; i < index; i++) {
            out = out.getNext();
        }
        Node newNext = out.getNext();
        Node newPrev = out.getPrev();

        newNext.setPrev(newPrev);
        newPrev.setNext(newNext);
        this.size -= 1;
        return out;
        
    }

    public boolean removeValue(int node) {
        try {
            removeIdx(indexOf(node));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (isEmpty()) {return "lista vazia";}

        String str = "list: ";
        Node aux = this.head;
        for (int i = 0; i < this.size; i++) {
            str += aux.toString() + "|";
            aux = aux.getNext();
        }
        return str;
    }

}
