import java.util.Arrays;

public class Pilha {

    private int[] pilha;
    private int topo;
    public static final int CAPACIDADE_DEFAULT = 10;

    public Pilha() {
        this.pilha = new int[CAPACIDADE_DEFAULT];
        this.topo = -1;
    }

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }        
        return this.pilha[topo];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return topo == pilha.length - 1;
    }

    public void push(int elemento) {
        if (isFull()) {
            throw new RuntimeException();
        }
        this.pilha[++topo] = elemento;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return this.pilha[--this.topo];
    }

    public int size() {
        return pilha.length;
    }

    public String toString() {
        return Arrays.toString(this.pilha);
    }

}


