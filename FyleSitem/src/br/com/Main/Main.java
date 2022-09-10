package br.com.Main;

import br.com.fylesistem.ListaLigada;
import br.com.listaligada.model.Processo;
import br.com.listaligada.model.Sistema;

public class Main {

        public static void main(String[] args) {
            int posicao =1;
            ListaLigada <Processo> listasprocesso = new ListaLigada<Processo>();
            listasprocesso.inserir(new Processo(345,"root") );
            listasprocesso.inserir(new Processo(3678,"usuario1") );
            listasprocesso.inserir(new Processo(7548,"usuario3") );
            System.out.println("Lista dos adicionados");
            System.out.println(listasprocesso);
           listasprocesso.apagararquivo(new Processo(345,"root"), 345);
            System.out.println("Primeira Retirada");
            System.out.println(listasprocesso);

            listasprocesso.apagararquivo(new Processo(7548,"usuario3"), 7548);
            System.out.println("Segunda Retirada");
            System.out.println(listasprocesso);
            listasprocesso.inserir(new Processo(4566,"usuario4") );


/*
            listasistema.inserir(new Sistema(posicao,"livro1","txt", 1234,null));
            posicao++;
            listasistema.inserir(new Sistema(posicao,"corretor","exec", 6543,null));
            posicao++;
            listasistema.inserir(new Sistema(posicao,"livro2","doc", 3456,null));
            posicao++;
            listasistema.inserir(new Sistema(posicao,"escritor","exec", 9807,null));
            posicao++;
            listasistema.inserir(new Sistema(posicao,"buscador","exec", 1567,null));
            posicao++;
            */

            System.out.println(listasprocesso);

        }


    }

