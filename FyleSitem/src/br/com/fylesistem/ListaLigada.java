package br.com.fylesistem;

import br.com.listaligada.model.Processo;
import br.com.listaligada.repository.ProcessoUC;
import br.com.listaligada.repository.impl.ProcessoImpl;

public class ListaLigada<T> extends ProcessoImpl {
    private No<T> primeirono;
    private No<T> ultimono;
    private int tamanho=0; //tamanho da lista

    public ListaLigada(){
        this.primeirono = primeirono;
        this.ultimono = ultimono;
        this.tamanho = tamanho;

    }
    public boolean eVazia(){
        return this.tamanho ==0;
    }

    public void inserir (T elemento){
        No<T> novono = new No<>(elemento);

        if(eVazia()){
            this.primeirono = novono;
            this.ultimono   = novono;
        }else{
            this.ultimono.setProximo(novono);
            this.ultimono = novono;

        }
        this.tamanho++;

    }


        public void apagararquivo( T elemento, int id_deletado) {
            ListaLigada <Processo> listasprocesso = new ListaLigada<Processo>();
         No<Processo> aux = (No<Processo>) new No<T>(elemento);
             aux = (No<Processo>) primeirono;


         No<T> anterior = null;
            System.out.println("\n"+tamanho);
         while (aux.getProximo()!=null){

                 if(aux.getElemento().getId_processo() == id_deletado)
                 {
                     if (anterior == null){
                         primeirono = (No<T>) aux.getProximo();

                     }
                     else{
                         anterior.setProximo((No<T>)aux.getProximo());
                     }
                     aux.setElemento(null);
                     System.out.println("\n");
                 }
                 anterior = (No<T>) aux;
                 aux =aux.getProximo();

         }

             tamanho--;
            System.out.println("\n"+tamanho);
        }










        @Override
        public String toString() {
            if(eVazia()) {
                return "Lista Vazia";
            }else {
                No<T> noatual = this.primeirono;
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append("File System \n");
                //stringbuilder.append("pos\t arquivo\t\tsize\tmemoria\n");
                stringbuilder.append(noatual.getElemento()!= null ? noatual.getElemento().toString(): "<nulo>");
                // stringbuilder.append("  ");

                while(noatual.getProximo()!=null) {
                    stringbuilder.append(noatual.getProximo().getElemento()!= null ? noatual.getProximo().getElemento().toString(): "<nulo>");
                    //stringbuilder.append(" ");
                    noatual =noatual.getProximo();
                }
                stringbuilder.append("End.");
                return stringbuilder.toString();
            }

        }
}
