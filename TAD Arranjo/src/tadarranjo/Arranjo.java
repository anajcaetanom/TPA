package tadarranjo;

import java.util.Objects;

public class Arranjo {
    private Integer[] items;
    private int first, last;

    // Construtor
    public Arranjo(int maxSize) {
        this.items = new Integer[maxSize];
        this.first = 0;
        this.last = this.first;
    }

    // Métodos //


    public int getLast() {
        return last;
    }

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

    public Integer pesquisar (Integer item) throws Exception {
        if (item == null) {
            throw new IllegalArgumentException("Invalid object.");
        }

        for (int i = 0; i < this.last; i++) {
            if (Objects.equals(this.items[i], item)) {
                return this.items[i];
            }
        }

        return null;
    }

    public void inserir (Integer item) throws Exception {
        if (item == null) {
            throw new IllegalArgumentException("Invalid object.");
        }
        if (this.last == this.items.length) {
            throw new Exception("The list is full.");
        }
        if (Objects.equals(this.pesquisar(item), item)) {
            throw new Exception("Object already on the list.");
        }
        this.items[this.last] = item;
        this.last++;

        this.exibir();
    }

    public void remover (Integer item) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }

        if (item == null) {
            throw new IllegalArgumentException("Invalid object.");
        }

        if (this.findIndex(item) == -1) {
            throw new Exception("Item not found.");
        }

        this.last--;

        for (int j = this.findIndex(item); j < this.last; j++) {
            this.items[j] = this.items[j + 1];
        }

        this.items[this.last] = null;

        this.exibir();
    }

    public void exibir() {
        System.out.print("[");
        for (int i = 0; i < last; i++) {
            System.out.print(items[i]);
            if (i < last - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int somaParesSimetricos (int k) throws Exception {
        if (this.isEmpty()) {
            throw new IllegalStateException("Empty list.");
        }
        if (k < 0 || k >= this.last) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        int sum = this.items[k] + this.items[this.last - 1 - k];

        return sum;
    }

    public void ordenacaoSelecao(int tam) {
        for (int i = 0; i < tam - 1; i++) {
            int min = i;
            for (int j = i + 1; j < tam; j++) {
                if (this.items[j] < this.items[min]) {
                    min = j;
                }
            }

            if (min != i) {
                Integer aux = this.items[min];
                this.items[min] = this.items[i];
                this.items[i] = aux;
            }
        }

        this.exibir();
    }

}

class Teste {
    public static void main(String[] args) throws Exception {
        int maxSize = 7;
        Arranjo arranjo = new Arranjo(maxSize);
        arranjo.inserir(5);
        arranjo.inserir(8);
        arranjo.inserir(7);
        arranjo.inserir(1);
        arranjo.inserir(43);
        arranjo.inserir(4);

        arranjo.remover(43);

        arranjo.ordenacaoSelecao(arranjo.getLast());
        int soma = arranjo.somaParesSimetricos(1);

        System.out.println(soma);
    }
}
