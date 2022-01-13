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

    public T get(int index){
        return getNo(index).getConteudo();
    }

    private NoDuplo<T> getNo(int index){

        NoDuplo<T> aux = primeiroNo;

        for (int i =0;(i<index)&&(aux != null);i++){
            aux = aux.getNoProximo();
        }
        return aux;
    }
    public void add(T conteudo){
        NoDuplo<T> novo = new NoDuplo<>(conteudo);
        novo.setNoProximo(null);
        novo.setNoAnterior(ultimoNO);

        if(primeiroNo == null){
            primeiroNo = novo;
        }
        if(ultimoNO != null){
            ultimoNO.setNoProximo(novo);
        }
        ultimoNO = novo;
        tamanhoLista++;

    }




    public int size(){ // Retorna o tamanho da lista.
        return tamanhoLista;
    }

}
