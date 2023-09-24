class Node {

    int node;
    Node next;
    Node prev;

    
    public int getNode() {
        return node;
    }
    public Node(int node) {
        this.node = node;
        this.next = null;
        this.prev = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + node;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (node != other.node)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "node: " + Integer.toString(this.node);
    }
}
