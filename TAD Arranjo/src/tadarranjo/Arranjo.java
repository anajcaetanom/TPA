package tadarranjo;

public class Arranjo {
    private Object[] items;
    private int first, last, position;

    // Construtor
    public Arranjo(int maxSize) {
        this.items = new Object[maxSize];
        this.position = -1;
        this.first = 0;
        this.last = this.first;
    }

    // Métodos

    public boolean isEmpty() {
        return this.first == this.last;
    }

    public int findIndex (Object item) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }
        if (item == null) {
            throw new IllegalArgumentException("Invalid item.");
        }

        for (int i = 0; i < this.last; i++) {
            if (this.items[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    public Object pesquisar (Object item) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }
        if (item == null) {
            throw new IllegalArgumentException("Invalid item.");
        }
        for (int i = 0; i < this.last; i++) {
            if (this.items[i].equals(item)) {
                return this.items[i];
            }
        }
        return null;
    }

    public void inserir (Object item) throws Exception {
        if (this.last >= this.items.length) {
            throw new Exception("The list is full.");
        } else if (this.pesquisar(item) == item) {
            throw new Exception("Object already on the list.");
        } else {
            this.items[this.last] = item;
            this.last++;
        }
    }

    public Object remover (Object item) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }
        if (item == null) {
            throw new IllegalArgumentException("Invalid item.");
        }

        int index = this.findIndex(item);

        if (index == -1) {
            throw new Exception("Item not found.");
        }

        Object removed_item = this.items[index];

        this.last--;

        for (int j = index; j < this.last; j++) {
            this.items[j] = this.items[j + 1];
        }

        this.items[this.last] = null;

        return removed_item;
    }

    public int somaParesSimetricos (int k) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }



    }
}

class QuickSort {

    private static class LimiteParticoes {
        int i, j;
    }

    private static LimiteParticoes partition(Object[] items, int left, int right) {
        LimiteParticoes lp = new LimiteParticoes();
        lp.i = left;
        lp.j = right;
    }
}

class Teste {
    public static void main(String[] args) {}
}
