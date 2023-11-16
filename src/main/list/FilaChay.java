package list;

import linked.ListaLigada;

public class FilaChay implements Fila{
    private ListaLigada lista;

    @Override
    public void enqueue(int item) {
        lista.insereFim(item);
    }

    @Override
    public int dequeue() {
        int n = lista.buscaIndice(0);
        lista.removeInicio();
        return n;
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();

    }

    @Override
    public int size() {
           return lista.lenght;
    }
    
}
