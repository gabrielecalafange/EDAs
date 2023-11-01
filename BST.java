public class BST {
    
    private NodeBST root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int element) {

        if (isEmpty()) {

            this.root = new NodeBST(element);

        }

        else {

            NodeBST newNode = new NodeBST(element);

            NodeBST aux = this.root;

            while (aux != null) {

                if (element > aux.value) {

                    if (aux.right == null) {
                        aux.right = newNode;
                        newNode.parent = aux;
                        return; 
                    }
                    aux = aux.right;
                }

                else if (element < aux.value) {

                    if (aux.left == null) {
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    aux = aux.left;
                }

            }
        }
    }

    public NodeBST search (int element) {

        NodeBST aux = this.root;

        while (aux != null) {
            if (element == aux.value) {return aux;}
            if (element > aux.value) {aux = aux.right;}
            if (element < aux.value) {aux = aux.left;}
        }

        return null;
    }

    public NodeBST max() {
        if (isEmpty()) {return null;}

        NodeBST aux = this.root;
        while (aux != null) {
            aux = aux.right;
        }
        return aux;
    }

    public NodeBST min() {
        if (isEmpty()) {return null;}

        NodeBST aux = this.root;
        while (aux != null) {
            aux = aux.left;
        }
        return aux;
    }
}
