import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList {
    
    private int[] list;
    private int size;
    public static final int CAPACITY_DEFAULT = 5;

    public ArrayList() {
        this.list = new int[CAPACITY_DEFAULT];
    }

    public ArrayList(int capacity) {
        this.list = new int[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean add(int element) {
        checkcapacity(this.size + 1);
        this.list[this.size++] = element;
        return true;
    }

    public void add(int element, int idx) {
        
        if (idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        checkcapacity(this.size + 1);
        shiftRight(idx);
        
        this.list[idx] = element;
        this.size++;
    }

    public void set(int element, int idx) {
        if (idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        this.list[idx] = element;
    }

    private void shiftRight(int idx) {
        for (int i = this.list.length - 1; i > idx; i--) {
            this.list[i] = this.list[i-1];
        }
    }

    private void shiftLeft(int idx) {
        for (int i = idx; i < this.list.length - 1; i++) {
            this.list[i] = this.list[i+1];
        }
    }    

    private void checkcapacity(int newSize) {
        if (newSize > this.list.length) {
            resize(Math.max(this.list.length * 2, newSize));
        }
    }

    private void resize(int newSize) {
        int[] aux = new int[newSize];
        for (int i = 0; i < this.list.length; i++) {
            aux[i] = list[i];
        }
        this.list = aux;
    }

    public int removeIdx(int idx) {
        
        if (idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int element = this.get(idx);
        shiftLeft(idx);
        this.size -= 1;

        return element;
    }

    public boolean removeValue(int element) {

        if (!contains(element)) {
            throw new NoSuchElementException();
        }
        removeIdx(indexOf(element));
        return true;
    }

    public int get(int idx) {
        if (idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.list[idx];
    } 

    public int indexOf(int element) {
        for (int i = 0; i < this.size; i++) {
            if (list[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    public String toString() {
        return Arrays.toString(list);
    }

}
