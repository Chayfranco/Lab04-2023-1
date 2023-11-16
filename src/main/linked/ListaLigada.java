package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;
    public int lenght;

    public ListaLigada() {

    }

    @Override
    public boolean buscaElemento(int valor) {
        No primeiro = cabeca;
        boolean bool = false;
        if (cabeca == null){
            return bool;
        }
        while(true){
            if (primeiro.getValor() ==  valor){
                    bool = true;
                    return bool;
                }
                else if(primeiro.getProximo() == null){
                    return bool;
                }
                else{
                    No proximo = primeiro.getProximo();
                    primeiro = proximo;
                }
                    
            }     
    }
    
    @Override
    public int buscaIndice(int indice) {
        No no = this.cabeca;
        int i = 0;
        while (no != null && i < indice) {
            no = no.getProximo();
            i++;
        }
        
        if (no != null) {
            return no.getValor(); 
        } else {
            return -1; 
        }
    }
    
    
    
    

   

    @Override
    public int minimo() {
        if(this.cabeca == null){
        System.out.println("não há nó na lista");
        return -1;
        }
        else{
            int minimoAtual = this.cabeca.getValor();
            No atualNo = this.cabeca.getProximo();
            while(atualNo != null){
                int atual = atualNo.getValor();
            if(atual < minimoAtual){
               minimoAtual = atual;
            }
            atualNo = atualNo.getProximo();
            }
        System.out.println(minimoAtual + "é o menor valor da lista");
        return minimoAtual;
        } 
    }
    @Override
    public int maximo() {
       if(this.cabeca == null){
        System.out.println("não há nó na lista");
        return -1;
        }
        else{
            int maximoAtual = this.cabeca.getValor();
            No atualNo = this.cabeca.getProximo();
            while(atualNo != null){
                int atual = atualNo.getValor();
            if(atual > maximoAtual){
                maximoAtual = atual;
            }
            atualNo = atualNo.getProximo();
            }
        System.out.println(maximoAtual + "é o maior valor da lista");
        return maximoAtual;
        }
    }

    @Override
    public int predecessor(int valor) {
        if(cabeca == null){
            return -1;
        } 
        else{
            int anterior = cabeca.getValor();
            No atual = cabeca.getProximo();
            while(atual != null){
                if(atual.getValor() == valor){
                    return anterior;
                }
            anterior = atual.getValor();
            atual = atual.getProximo();
            }
            System.out.println("não encontrado o seu predecessor");
            return -1;
            }
        
        }
    

    @Override
    public int sucessor(int valor) {
       if(cabeca == null){
            return -1;
        } 
        else{
            int anterior = cabeca.getValor();
            No sucessor = cabeca.getProximo();
            while(sucessor != null){
                if(anterior == valor){
                    return sucessor.getValor();
                }
            anterior = sucessor.getValor();
            sucessor = sucessor.getProximo();
            }
            System.out.println("não encontrado o seu predecessor");
            return -1;
            }
        
    }

    @Override
    public void insereElemento(int valor) {
        if(this.cabeca == null){
            this.cabeca = new No(valor);
        }
        else{
            No memoria = this.cabeca;
            while (true) {
                if(memoria.getProximo() == null){
                    No n = new No(valor);
                    memoria.setProximo(n);
                    return;
                }
                else{
                    No proximo = memoria.getProximo();
                    memoria = proximo;
                }
            }
        } 
    }

    @Override
    public void insereElementoPosicao(int valor, int indice) {
        if (indice < 0) {
            System.out.println("Índice fora dos limites da lista");
            return;
        }
        No novoNo = new No(valor);
        if (indice == 0) {
            novoNo.setProximo(this.cabeca);
            this.cabeca = novoNo;
        } else {
            No anterior = this.cabeca;
            int i = 0;
            while (anterior != null && i < indice - 1) {
                anterior = anterior.getProximo();
                i++;
            }
            if (anterior == null) {
                System.out.println("Índice fora dos limites da lista");
                return;
            }
    
            novoNo.setProximo(anterior.getProximo());
            anterior.setProximo(novoNo);
        }
    }
    
    
    

    @Override
    public void insereInicio(int valor) {
        if(this.cabeca == null){
            this.cabeca = new No(valor);
        }
        else{
            No n = new No(valor);
            n.setProximo(this.cabeca);
            cabeca = n;
        }
    }
    @Override
    public void insereFim(int valor) {
        if(this.cabeca == null){
            this.cabeca = new No(valor);
        }
        else{
            No primeiro = this.cabeca;
            while (true) {
                if(primeiro.getProximo() == null){
                    No n = new No(valor);
                    primeiro.setProximo(n);
                    return;
                }
                else{
                    No proximo = primeiro.getProximo();
                    primeiro = proximo;
                }
            }
        } 
        }  

    

    @Override
    public void remove(int valor) {
            if (this.cabeca == null) {
                return;
            }

            if (this.cabeca.getProximo() == null) {
                this.cabeca = null;
                return;
            }
        
            No anterior = this.cabeca;
            No atual = this.cabeca.getProximo();
        
            while (atual.getProximo() != null) {
                anterior = atual;
                atual = atual.getProximo();
            }
            anterior.setProximo(null);
        }
        
    

    @Override
    public void removeIndice(int indice) {
        if (indice < 0) {
            System.out.println("Índice fora dos limites da lista");
            return;
        }
    
        if (indice == 0) {
            // Remover o primeiro elemento
            if (this.cabeca != null) {
                this.cabeca = this.cabeca.getProximo();
            } else {
                System.out.println("A lista está vazia");
            }
        } else {
            No anterior = this.cabeca;
            int i = 0;
            while (anterior != null && i < indice - 1) {
                anterior = anterior.getProximo();
                i++;
            }
    
            if (anterior == null || anterior.getProximo() == null) {
                System.out.println("Índice fora dos limites da lista");
                return;
            }
    
            anterior.setProximo(anterior.getProximo().getProximo());
        }
    }
    

   
    

    @Override
    public void removeInicio() {
        if(this.cabeca != null){
           this.cabeca = cabeca.getProximo();
        }
    }

    @Override
    public void removeFim() {
        if (this.cabeca == null) {
            // Lista vazia, não há o que remover.
            return;
        }
    
        if (this.cabeca.getProximo() == null) {
            // Se houver apenas um nó na lista, tornamos a cabeça nula.
            this.cabeca = null;
            return;
        }
    
        No anterior = this.cabeca;
        No atual = this.cabeca.getProximo();
    
        while (atual.getProximo() != null) {
            anterior = atual;
            atual = atual.getProximo();
        }
    
        // Agora 'atual' é o último nó da lista.
        anterior.setProximo(null);
    }

    public boolean isEmpty() {
        return false;
    }
    
}