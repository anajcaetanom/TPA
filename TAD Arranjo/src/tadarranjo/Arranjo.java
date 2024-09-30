package tadarranjo;

import java.util.Objects;

public class Arranjo {
    private Integer[] items;
    private int first, last, position;

    // Construtor
    public Arranjo(int maxSize) {
        this.items = new Integer[maxSize];
        this.position = -1;
        this.first = 0;
        this.last = this.first;
    }

    // Métodos //

    public boolean isEmpty() {
        return this.first == this.last;
    }

    public int findIndex (Integer item) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }

        if (item == null) {
            throw new IllegalArgumentException("Invalid object.");
        }

        for (int i = 0; i < this.last; i++) {
            if (Objects.equals(this.items[i], item)) {
                return i;
            }
        }

        return -1;
    }

    public int pesquisar (Integer item) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }

        if (item == null) {
            throw new IllegalArgumentException("Invalid object.");
        }

        for (int i = 0; i < this.last; i++) {
            if (Objects.equals(this.items[i], item)) {
                return this.items[i];
            }
        }

        throw new Exception("Element not found");
    }

    public void inserir (Integer item) throws Exception {
        if (item == null) {
            throw new IllegalArgumentException("Invalid object.");
        }
        if (this.last >= this.items.length) {
            throw new Exception("The list is full.");
        }
        if (this.pesquisar(item) == item) {
            throw new Exception("Object already on the list.");
        }
        this.items[this.last] = item;
        this.last++;
    }

    public void remover (Integer item) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }

        if (item == null) {
            throw new IllegalArgumentException("Invalid object.");
        }

        int index = this.findIndex(item);

        if (index == -1) {
            throw new Exception("Item not found.");
        }

        this.last--;

        for (int j = index; j < this.last - 1; j++) {
            this.items[j] = this.items[j + 1];
        }

        this.items[this.last] = null;

    }

    public int somaParesSimetricos (int k) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }
        int len = this.items.length;
        int sum = this.items[k] + this.items[len - k];

        return sum;
    }

    public static void ordenacaoSelecao (Integer[] items, int tam) {
        for (int i = 1; i < tam; i++) {
            int min = i;
            for (int j = i + 1; j <= tam; j++) {
                if (items[j] < items[min]) {
                    min = j;
                }
            }

            Integer aux = items[min];
            items[min] = items[i];
            items[i] = aux;
        }
    }

}

class Teste {
    public static void main(String[] args) {}
}
