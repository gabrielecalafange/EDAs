public class Heap {
    
    private int[] heap;
    private int tail;

    public Heap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1; // a raíz, idx 0 sempre deve ter o maior valor, assim como todo nó pai deve ser maior que os filhos.
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * (index + 1);
    }

    public int parent(int index) {
        return (index -1) / 2;
    }

    public void add(int n) { // a árvore deve ser completa, ou quase, da esquerda para direita
        if (tail >= this.heap.length - 1) {
            resize();
        }

        this.heap[++this.tail] = n;
        int i = tail;
        while (i > 0 && this.heap[parent(i)] < this.heap[i]) { // garante que todo nó seja maior que seus filhos!! propriedade do heap.
            int aux = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = aux;
            i = parent(i);
        }

    }

    private void resize() {
        int[] novoHeap = new int[this.heap.length * 2];

        for (int i = 0; i < this.heap.length; i++) {
            novoHeap[i] = this.heap[i];
        }

        this.heap = novoHeap;
    }

    public int remove() { // o valor removido é sempre o maior, ou seja, a raíz

        if (isEmpty()) {throw new RuntimeException();}

        int element = this.heap[0];
        this.heap[0] = this.heap[tail -=1];
        heapify(0);

        return element;
    }

    private void heapify(int index) {

        if (isLeaf(index) || !isValidIndex(index)) {return;}

        int maior = max(index, left(index), right(index));
        if (maior != index) {
            swap(index, maior);
            heapify(maior);
        }
    }

    private void swap(int index, int maior) {
        int aux = index;
        this.heap[index] = this.heap[maior];
        this.heap[maior] = aux;
    }

    private int max(int i, int l, int r) {

        if (this.heap[i] > this.heap[l]) { 
            if (isValidIndex(r)) {
                if (this.heap[i] < this.heap[r]) {return r;}
            }
            return i;
        }
        else {
            if (isValidIndex(r)) {
                if (this.heap[l] < this.heap[r]) {return r;}
            }
            return l;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= this.tail;
    }

    private boolean isLeaf(int index) {
        return true;
    }

    public void buildHeap(int[] array) {
        this.heap = array;
        this.tail = this.heap.length - 1;
        buildHeap();
    }

    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0; i--) {
            heapify(i);
        }
    }
    
}
