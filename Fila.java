import java.util.Arrays;

public class Fila {
    
    private int[] fila;
    private int head;
    private int tail;
    private int capacidade;
    private int elementos;
    public static final int CAPACIDADE_DEFAULT = 5;

    public Fila() {
        this.fila = new int[CAPACIDADE_DEFAULT];
        this.capacidade = CAPACIDADE_DEFAULT;
        this.head = -1;
        this.tail = -1;
    }

    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.capacidade = capacidade;
        this.head = -1;
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.elementos == 0;
    }

    public boolean isFull() {
        return this.capacidade == this.elementos;
    }

    public int head() {
        return fila[head];
    }

    public int tail() {
        return fila[tail];
    }

    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException();
        }

        int elemento = fila[head];

        if (head == tail) {
            this.head = -1;
            this.tail = -1;
        }

        this.head = (head + 1) % fila.length;
        this.elementos--;

        return elemento;
    }

    public void enqueue(int elemento) {

        if (isFull()) {
            throw new RuntimeException();
        } 
        if (isEmpty()) {
            this.tail +=1;
            this.head +=1;
            fila[tail] = elemento;
        } else {
            this.tail = (tail + 1) % fila.length;
            fila[tail] = elemento;
        }
        this.elementos++;
    }

    public String toString() {
        return Arrays.toString(fila);
    }


}
