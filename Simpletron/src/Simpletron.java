import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Simpletron {
    // definições das palavvras do computador

    // Tatal máximo de palvras armazenads.
    private static final int  memory = 100;
    //Total  de registradores
   private static final int recorde = 10 ;
    //Le uma palavra do teclado par aumposição d amemoria.
   private static final  int   READ = 10;

    // escreve na tela o que esta na posição da memoria

    private static final  int   WRITE = 20;

    // copia doacumulador para o registrador
    private static final  int    LOAD= 30;

    private static final int     STORE = 40;

    private static final int     ADD   = 50 ;
    private static final  int    SUB = 51;

    private static final int     MULT = 52 ;

    private static final int DIVISION = 53 ;

    private static  final int       MOD = 54 ;
    // finaliador dopriograma
    public static final  int  END = 99;
       //   variaveis de trabalho
    int controle = 0;
    int valorLido;
    int  comando;
    int  [] registrador =new int[recorde];

    int[] memoria= new int[memory];
    int contadorRegistrador=0;
    int contadorMemoria =0;
    int contadorInstrucao = 0;
    int  numeroInstrucao=0;
    int  numeroRegistrador;
    int acumulador ;


    int dataRecorde= 60;
    boolean permissao ;
   // rastrear as linhas do console
    Scanner linhaScan = new Scanner(System.in);
    // formatação de numero de memoria
    String formatacao = "0000";
    DecimalFormat weirdFormatter = new DecimalFormat(formatacao);
//    public final DecimalFormat memoryFormatter = new DecimalFormat(000);
    // Exeecutar o programa
    private  void executor (){
           cabecalhoCodigo();
           System.out.printf("Digite o código  \n\n ");
           copiarCodigo();
           executarCodigo();
           ecreveMemoria();
       }
       private void executarCodigo(){

         while (numeroInstrucao!=99){
           numeroInstrucao = memoria[contadorInstrucao]/100;
           numeroRegistrador = memoria[contadorInstrucao]%100;
            executorInstrucao(numeroInstrucao,numeroRegistrador);
         }

          }

       private void cabecalhoCodigo(){


        System.out.println("********************************************");
        System.out.println("* Computador Simpleton                     *");
        System.out.println("* Autor Ronan Rodrigues                    *");
        System.out.println("* As intruções devem ter  4 digitos        *");
        System.out.println("* Os dois primeiro codigo instrução        *");
        System.out.println("* Os dois ultimos codigo reegistrodor      *") ;
        System.out.println("* Total  de instruções = 100               *") ;
        System.out.println("* Total de  reegistrodor = 10              *") ;
        System.out.println("* Para finalizar o progrma digite 0        *");
        System.out.println("* Read =10                                 *");
        System.out.println("* Write = 20                               *");
        System.out.println("* Load = 30                                *");
        System.out.println("* Store = 40 grava na memoria              *");
        System.out.println("* Store = 50 adiciona                      *");
        System.out.println("* Store = 51 subtrai                       *");
        System.out.println("* Store = 52 Multiplicação                 *");
        System.out.println("* Store = 53 Divisão                       *");
        System.out.println("* Store = 54 Módulo                        *");
        System.out.println("* Sair = 99 finalisar instrucao obrgatorio *");
        System.out.println("********************************************");
       }
    private void ecreveMemoria(){
        System.out.println("MEMORIA PRINCIPAL");

        for (int i=0 ;i<memory ; i+=10) {
            System.out.printf(" %d   ",1+ i / 10);
            for (int j = i; j < i + 10; j++) {
                String escrever = weirdFormatter.format(memoria[j]);
                /* System.out.printf("%d ", memoria[j] ); */
                System.out.printf(" %s  ", escrever);
            }
                System.out.printf("\n");
            }
         contadorInstrucao++;
        }
        // Le o valor do operando no console.
       private void readInstruction()  throws ArithmeticException{
           System.out.println(" ENTRADA  ");
           try {
               acumulador = linhaScan.nextInt();
               contadorInstrucao++;
           } catch(InputMismatchException erro1){
                      System.err.println("INFORME APENAS NÚMERO INTEIROS.");
                      linhaScan.nextInt();
           }
       }

      // Grava o valor do acumulador no registrador
       private void loadRecorde(int numeroRegistrador, int acumulador)

       {

        registrador[numeroRegistrador]= acumulador;
           contadorInstrucao++;
           contadorRegistrador++;
               }


        // Escrreve na tela o valor do registrador
        private void writeRecorde(int numeroRegistrador){
            System.out.println(" SAIDA  ");
            System.out.println(registrador[numeroRegistrador]);
            contadorInstrucao++;

        }
        private void storeRecorde(int numeroRegistrador){
        memoria[dataRecorde]= registrador[numeroRegistrador];
        dataRecorde++;
            contadorInstrucao++;
        }
        private void addInst (){

        acumulador = acumulador + registrador[numeroRegistrador];
            contadorInstrucao++;
          }

          private void subtractInst (){

        acumulador = acumulador - registrador[numeroRegistrador];
              contadorInstrucao++;
    }
        private void  multiplyInst(){

          acumulador  = acumulador * registrador[numeroRegistrador];
            contadorInstrucao++;
    }
          private void division(){
              if(registrador[numeroRegistrador]!=0 ){
                  acumulador = acumulador/ registrador[numeroRegistrador];
              }else{
                  throw new IllegalArgumentException("O DENOMINADOR É NULO ");
              }


              contadorInstrucao++;
          }
          private void moduloIntruction ()
          {


             if (registrador[numeroRegistrador]!=0){

                  acumulador = acumulador % registrador[numeroRegistrador];
                  contadorInstrucao++;

          }  else
              {
                  throw new IllegalArgumentException("O DENOMINADOR É NULO");

              }
          }

          private void endInstruction(){

            if (contadorInstrucao == contadorMemoria-1){
                System.out.println("PROGRAMA FINALIZADO COM SUCESSO");
                System.out.println("TOTAL DE INSTRUÇÕES EXECUTADAS : "+ contadorInstrucao);
                System.out.println("TOTAL DE REGISTRADORES UTILIZADOS: "+ contadorRegistrador);

            }else{
                System.out.println("FALHA NA FINALISAÇÃO");
                System.out.println("TOTAL DE INSTRUÇÕES EXECUTADAS : "+ contadorInstrucao);
                System.out.println("TOTAL DE INSTRUÇÕES armazenads: "+ contadorMemoria);
            }


          }
          private void imprime(){
              System.out.println("intrucao conta" + contadorInstrucao);
              System.out.println("numero ins" + contadorMemoria);
          }




    private  void executorInstrucao (int numeroInstrucao, int numeroRegistrador){



            switch (numeroInstrucao){
            case READ: readInstruction();

              break;
            case WRITE : writeRecorde(numeroRegistrador) ;
               break;
            case LOAD : loadRecorde(numeroRegistrador,acumulador);
                    break ;
             case STORE: storeRecorde(numeroRegistrador);
                break;
            case ADD :
                addInst();
                 break ;

             case SUB : subtractInst(); ;
                 break;
            case MULT : multiplyInst();
                break;
            case DIVISION :  division();
                 break;
                case MOD:  moduloIntruction();
                 break;

            case END: System.out.println("DESLIGANDO O SISTEMA");
                 endInstruction();
                 break;
            default :
                endInstruction();
                break ;
            }

        }
      private void copiarCodigo(){
          valorLido = linhaScan.nextInt();

               while(valorLido!= 0){

                    memoria[contadorMemoria] = valorLido;
                    contadorMemoria++;

                   valorLido = linhaScan.nextInt();
               }
    }



    public static void main(String [] args){
        Simpletron simpletron = new Simpletron();
        simpletron.executor();
    }
}

