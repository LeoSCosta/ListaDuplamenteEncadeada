package one.digitalInnovation;

public class ListaDuplamenteEncadeada <T> {
    private NoDuplo<T> primeiroNo; // primeiroNó aponta para o primeiro elemento da lista
    private NoDuplo<T> ultimoNO; // segundoNo é apontado pelo ultmimo elemento da lista
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        primeiroNo = null;
        ultimoNO = null;
        tamanhoLista = 0;
    }
    //_______________________________________________________________________
    public T getConteudoNo(int index){ //Retorna o conteudo a partir de um indice
        return getNo(index).getConteudo();
    }
    //_______________________________________________________________________
    private NoDuplo<T> getNo(int index){ //Retorna um nó a partir de um indice

        NoDuplo<T> aux = primeiroNo;

        for (int i =0;(i<index)&&(aux != null);i++){
            aux = aux.getNoProximo();
        }
        return aux;
    }

    //_______________________________________________________________________
    public void add(T conteudo){ //Adiciona um nó ao final da lista
        NoDuplo<T> novo = new NoDuplo<>(conteudo);
        novo.setNoProximo(null); //O ultimo nó aponta para null
        novo.setNoAnterior(ultimoNO); // Tambem aponta para o antigo ultimo nó da lista
        //Nas lista duplamente encadeadas o nó possui referencia para seu antecessor e sucessor da lista

        if(primeiroNo == null){ //Se o primeiro nó é null significa que a lista está vazia
            primeiroNo = novo; // O nó entao será o primeiro nó
        }
        if(ultimoNO != null){
            ultimoNO.setNoProximo(novo);
        }
        ultimoNO = novo; //O nó adiocionado passa ser o ultimo nó da lista
        tamanhoLista++;
    }
    //_______________________________________________________________________
    public void add(T conteudo, int index){ //Adiciona um nó a partir de um indice
        NoDuplo<T> aux = getNo(index);//aux guarda o nó presente no indice
        NoDuplo<T> novo = new NoDuplo<>(conteudo);
        novo.setNoProximo(aux); //O nó presente no indice passa para o indice seguinte
        //portanto o proximo nó para o novo nó

        if(novo.getNoProximo() != null){ //Se há um nó no indice passado entao:
            novo.setNoAnterior(aux.getNoAnterior());
            novo.getNoProximo().setNoAnterior(novo);
        }else{ //se não há:
            novo.setNoAnterior(ultimoNO);
            ultimoNO = novo; //O novo nó sera adionado ao final da lista
        }

        if(index == 0){ // se o indice é zero entao:
            primeiroNo = novo; // o novo nó se torna o primeiro nó.
        }else{
            novo.getNoAnterior().setNoProximo(novo);
            //se nao o nó antecessor a ele passa a apontar para ele
        }
        tamanhoLista++;

    }

    //_______________________________________________________________________

    public void remove(int index){ // remove um nó da lista a patir de um índice
        if(index == 0){ //Se o indice é zero entao o primeiro nó é removido
            primeiroNo = primeiroNo.getNoProximo(); //o proximo nó ao primeiro se torna o primeiro
            if(primeiroNo != null){ // Verifica se o primeiro nó o unico nó
                primeiroNo.setNoAnterior(null);
                //caso nao seja o novo primeiro nó perde a referencia ao nó anterior
            }
        }else{ //se o indice nao for zero.
            // O nó que será removido será um nó do meio ou do final da lista
            NoDuplo<T> aux = getNo(index);//retorna o nó que será removido
            aux.getNoAnterior().setNoProximo(aux.getNoProximo());
            //seu antecessor passa a ter seu proximo como proximo
            // como era: antecessor -> nó -> proximo
            // como ficou: antecessor -> proximo

            if(aux == ultimoNO){ //caso esse nó seja o ultimo:
                ultimoNO = aux.getNoAnterior(); //o ultimo passar ser o nó antecessor
            }else{
                aux.getNoProximo().setNoAnterior(aux.getNoAnterior());
                //caso nao seja o seu nó proximo passa ser referencia ao antecessor do nó
                //como ficou antecessor <- proximo
            }
        }
        tamanhoLista--;
    }


    //_______________________________________________________________________


    public int size(){ // Retorna o tamanho da lista.
        return tamanhoLista;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        NoDuplo<T> aux = primeiroNo;

        for(int i = 0; i < tamanhoLista; i++){
            str.append("[No{conteudo= ").append(aux.getConteudo()).append("}] ---->");
            aux = aux.getNoProximo();
        }
        str.append("null");
        return str.toString();
    }
}
