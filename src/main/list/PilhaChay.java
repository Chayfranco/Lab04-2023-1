package list; 

import linked.ListaLigada;  

public class PilhaChay implements Pilha{

    private ListaLigada l;

    @Override
    public boolean isEmpty() {
        return l.buscaIndice(0) == -1;
    }

    @Override
    public void push(int item) {
        l.insereInicio(item);
    }

    @Override
    public int pop() {
       int n = l.buscaIndice(0);
       l.removeInicio();
       return n;
    }

    
}
