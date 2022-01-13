package one.digitalInnovation;

public class Main {
    public static void main(String[] args) {

        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();

        lista.add("Primeiro");
        lista.add("Segundo");
        lista.add("Terceiro");
        lista.add("quarto");
        lista.add("quinto");
        System.out.println(lista);

        lista.remove(4);
        lista.add("quinto",3);
        System.out.println(lista);

        System.out.println(lista.getConteudoNo(4));

    }
}
