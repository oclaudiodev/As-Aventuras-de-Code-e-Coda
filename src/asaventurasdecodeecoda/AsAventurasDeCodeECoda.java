/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asaventurasdecodeecoda;

import java.util.Random;
import java.util.Scanner;

public class AsAventurasDeCodeECoda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcaoInicioJogo = menuPrincipal(input);

        //Matriz do jogo
        String[][] tabuleiroDoJogo = new String[7][7];
        matrizDoMapaDoJogo(tabuleiroDoJogo);

        //matriz fantasma do jogo
        String [][] tabuleiroFantasma = new String[7][7];
        preencherMatrizFantasma(tabuleiroFantasma);

        while(opcaoInicioJogo != 3){
            switch (opcaoInicioJogo){
                case 1:
                    jogo(tabuleiroFantasma,tabuleiroDoJogo,input);
                    opcaoInicioJogo=menuPrincipal(input);
                    break;
                case 2:
                    //instrucoes para o jogo
                    intrucoesDoJogo();
                    opcaoInicioJogo=menuPrincipal(input);
                    break;
                case 3:
                    //sair do jogo
                    System.out.println("Saindo do jogo...");
                    break;
            }
        }
    }

    //Criar a matriz inicial do jogo
    public static void matrizDoMapaDoJogo(String [][] matrizMapa){
        for(int i=0;i<matrizMapa.length;i++){
            for(int j=0;j<matrizMapa[i].length;j++){
                matrizMapa[i][j] = "???";
            }
        }
    }

    //criar matriz fantasma do jogo
    public static void preencherMatrizFantasma(String [][] matrizFantasma){
        //bosses
        matrizFantasma[0][4] ="Varkhul" ;
        matrizFantasma[1][1] ="Seraphyx" ;
        matrizFantasma[2][5] = "Drogmar";
        matrizFantasma[3][2] = "Nytheris" ;
        matrizFantasma[4][4] = "Krazenoth";
        matrizFantasma[5][3] = "Velkior";
        matrizFantasma[6][6] = "Azhrael";

        //charadas tera que criar uma funcao para validar elas e criar
        matrizFantasma[0][6] = "charada1";
        matrizFantasma[1][3] = "charada2";
        matrizFantasma[3][0] = "charada3";
        matrizFantasma[5][5] = "charada4";

        //Caixa especial
        matrizFantasma[3][5] = "CaixaEspecial";
        matrizFantasma[5][0] = "CaixaEspecial2";

        //preenchimento das casas vazias
        for (int i=0;i<matrizFantasma.length;i++){
            for (int j=0;j<matrizFantasma[i].length;j++){
                if(matrizFantasma[i][j] == null){
                    matrizFantasma[i][j] = "[VAZIA]";
                }
            }
        }
    }

    //Menu principal do jogo
    public static int menuPrincipal(Scanner sc){
        System.out.println("---- Menu Principal ----");
        System.out.println("(1) Iniciar Jogo");
        System.out.println("(2) Instrucoes do jogo");
        System.out.println("(3) Sair do jogo");
        int opcao = 0;
        do{
            System.out.println("Digite a opcao");
            opcao = sc.nextInt();
            if(opcao < 1 || opcao > 3){
                System.out.println("Digite uma opcao valida....");
            }
        }while(opcao < 1 || opcao > 3);
        return opcao;
    }

    //Instrucoes do jogo
    public static void intrucoesDoJogo(){
        System.out.println("--- Instrucoes do jogo ---");
        System.out.println("O jogador tera como objetivo encontrar e derrotar os 7 bosses no mapa, cada boss ira dropar sua reliquia");
        System.out.println("quando o jogador tiver obtido todas as 7 reliquias ele ira conseguir escapar do labiritinto.");
        System.out.println("Para auxiliar o jogador temos charadas e caixas com itens especiaias no jogo.");
        System.out.println("W/A/S/D e os botoes uados para se movimentar pelo mapa.");
    }

    //Escolha do personagem
    public static String escolhaDePersonagem(Scanner sc){
        System.out.println("---- Seja muito Bem-Vindo as aventuras de code");
        System.out.println("Por favor escolha seu personagem: \n(1)Code\n(2)Anabelle");
        int opcao_personagem = 0;
        String nomePersonagem = "Code";
        String nomePersonagem2 = "Anabelle";
        do {
            opcao_personagem = sc.nextInt();
            if (opcao_personagem > 2 || opcao_personagem < 1) {
                System.out.println("Opcao Invalida, Digite uma opcao valida...");
            }
        }while(opcao_personagem < 1 || opcao_personagem > 2);
        String personagemEscolhido = "";
        if (opcao_personagem == 1){
            personagemEscolhido = nomePersonagem;
        }
        else if (opcao_personagem==2) {
            personagemEscolhido = nomePersonagem2;
        }
        System.out.println("Boa sorte em sua jornada "+personagemEscolhido);
        System.out.println("Inicializando o jogo....");
        return personagemEscolhido;
    }

    //aleatorizar Spawn do jogador
    public static void spawnJogador(String nomePersonagem,String[][] matrizJogo){
        Random aleatorizar = new Random();
        int linha = aleatorizar.nextInt(7);
        matrizJogo[linha][0] = "⚔⚔⚔";
    }

    //lista mapa do jogo
    public static void  listarMapaJogo(String[][]mapaJogo){
        for (int i=0;i< mapaJogo.length;i++){
            for(int j=0;j<mapaJogo[i].length;j++){
                System.out.printf("%-15s",mapaJogo[i][j]);
            }
            System.out.println(" ");
        }
    }
    //essa funcao servira de parametro para a funcao de se movimentar devolvendo a direcao
    public static char receberDirecaoDoJogador(Scanner sc){
        System.out.println("Digite para onde vai: W/A/S/D");
        char direcao;
        do {
            direcao = sc.next().toLowerCase().charAt(0);
            if (direcao == 'w' || direcao == 'a' || direcao == 's' || direcao == 'd'){
                //nada
            }
            else{
                System.out.println("Tecla invalida por favor digite uma direcao correta...");
            }
        }while(direcao != 'w' && direcao != 'a' && direcao != 's' && direcao != 'd');
        return direcao;
    }

    //validar movimentacao e direcao que o jogador ira, para saber se batera na parede por exemplo
    public static int[] validDirecaoJogador(String[][] matrizJogo, char direcao, int coluna,int linha,Scanner sc){
        int[] direcaoValidada = new int[2];
            if (direcao == 'w') {
                if (linha-1 < 0) {
                    System.out.println("Nao existe nada para la, va explore outro lugar...");
                    return validDirecaoJogador(matrizJogo,receberDirecaoDoJogador(sc),coluna,linha,sc);
                } else {
                    linha--;
                    direcaoValidada[0] = linha;
                    direcaoValidada[1] = coluna;
                }
            } else if (direcao == 'a') {
                if (coluna-1 < 0) {
                    System.out.println("Nao existe nada para la, va explore outro lugar...");
                    return validDirecaoJogador(matrizJogo,receberDirecaoDoJogador(sc),coluna,linha,sc);
                } else {
                    coluna--;
                    direcaoValidada[0] = linha;
                    direcaoValidada[1] = coluna;
                }
            } else if (direcao == 's') {
                if (linha+1 >= matrizJogo.length) {
                    System.out.println("Nao existe nada para la, va explore outro lugar...");
                    return validDirecaoJogador(matrizJogo,receberDirecaoDoJogador(sc),coluna,linha,sc);
                } else {
                    linha++;
                    direcaoValidada[0] = linha;
                    direcaoValidada[1] = coluna;
                }
            } else if (direcao == 'd') {
                if (coluna+1 >= matrizJogo[0].length) {
                    System.out.println("Nao existe nada para la, va explore outro lugar...");
                    return validDirecaoJogador(matrizJogo,receberDirecaoDoJogador(sc),coluna,linha,sc);
                } else {
                    coluna++;
                    direcaoValidada[0] = linha;
                    direcaoValidada[1] = coluna;
                }
            }
        return direcaoValidada;
    }

    //Sistema de movimentacao
    public static void acaoDeMovimentar(String[][] matrizJogo,String[][] matrizFantasma,Scanner sc){
        boolean valid = true;
        char direcaoJogador = receberDirecaoDoJogador(sc);
        int locJogadorLinha,locJogadorColuna;
        while (valid){
            for(int i=0;i<matrizJogo.length;i++){
                for(int j=0;j<matrizJogo[i].length;j++){
                    if(matrizJogo[i][j].equals("⚔⚔⚔")){
                        locJogadorLinha = i;
                        locJogadorColuna = j;
                        int[] locNovaJogador = validDirecaoJogador(matrizJogo,direcaoJogador,locJogadorColuna,locJogadorLinha, sc);
                        String temp = matrizJogo[i][j];
                        matrizJogo[locNovaJogador[0]][locNovaJogador[1]]=temp;
                        matrizJogo[i][j] = matrizFantasma[i][j];
                        listarMapaJogo(matrizJogo);
                        valid = false;
                        break;
                    }
                }
                if (!valid){
                    break;
                }
            }
        }
    }
    //criar bolsa de reliquias do jogador
    public static String[] criarBolsaDasReliquias(){
        String[] vetorDaBolsa = new String[7];
        for (int i=0;i<vetorDaBolsa.length;i++){
            vetorDaBolsa[i] = "[VAZIO]";
        }
        return vetorDaBolsa;
    }

    //mostrar Bolsa de reliquias para o usuario
    public static void listarBolsaDeReliquias(String[] bolsa){
        for (int i=0;i<bolsa.length;i++){
            System.out.print(bolsa[i]);
        }
        System.out.println(" ");
    }
    //Criar estastisticas do jogador
    public static int[] criarestatisticasDoJogador(){
        Random rdm = new Random();
        System.out.println("--- Criando estatisticas do Jogador ---");
        int vida = rdm.nextInt(50,80);
        int dano = rdm.nextInt(10,18);
        int velocidade = rdm.nextInt(1,8);
        int[] statusJogador = {vida,dano,velocidade};
        return statusJogador;
    }
    //status do jogador
    public static void listarStatusJogador(int [] status){
        System.out.println("-----------------------------------");
        System.out.println("Vida: "+status[0]);
        System.out.println("Dano: "+status[1]);
        System.out.println("Velocidade: "+status[2]);
    }

    //fundir as reliquias do jogador
    public static boolean fundirReliquias(String[] reliquias){
        int c = 0;
        boolean valid = true;
        for(int i=0;i<reliquias.length;i++){
            if(reliquias[i].equals("[VAZIO]")){
                c++;
            }
        }
        if(c > 0){
            System.out.println("Você ainda nao tem todas as reliquias necessarias...");
            System.out.println("Faltam: "+c);
        }
        if(c == 0){
            System.out.println("Parabens Jogador voce obteve todas as reliquias necessarias para completar o jogo");
            System.out.println("Esperamos que tenha gostado da jornada....");
            valid = false;
        }
        return valid;
    }

    //menu de escolhas do jogadors
    public static int menuDeEscolhasJogador(Scanner sc){
        System.out.println("---- Menu de escolhas ----");
        System.out.println("1 - Se movimentar");
        System.out.println("2 - ver mapa");
        System.out.println("3 - verificar bolsa se reliquias");
        System.out.println("4 - verificar status do jogador");
        System.out.println("5 - Fundir todas reliquias (Necessario ter as 7)");
        System.out.println("6 - Sair do jogo");
        int opcaoJogador = sc.nextInt();
        return opcaoJogador;
    }

    //O jogo rodara nessa funcao
    public static void jogo(String[][] mapaFantasma,String[][] mapaJogo,Scanner sc){
        //Todas funcoes do jogo deve ser colocada aqui
        //Decisao do personagem
        String personagem = escolhaDePersonagem(sc);

        //spawn personagem
        spawnJogador(personagem,mapaJogo);

        //listar mapa para o usuario
        listarMapaJogo(mapaJogo);

        //criar bolsa de reliquias do jogador
        String [] bolsaDeReliquia = criarBolsaDasReliquias();

        //Criar status do jogador
        int[] statusJogador = criarestatisticasDoJogador();

        //criar bosses do jogo

        //criar charadas

        
        boolean finalizarJogo = true;
        while(finalizarJogo) {
            int menuDeEscolhas = menuDeEscolhasJogador(sc);
            switch (menuDeEscolhas){
                case 1:
                    //movimentacao do jogador
                    acaoDeMovimentar(mapaJogo, mapaFantasma, sc);
                    break;
                case 2:
                    listarMapaJogo(mapaJogo);
                    break;
                case 3:
                    listarBolsaDeReliquias(bolsaDeReliquia);
                    break;
                case 4:
                    listarStatusJogador(statusJogador);
                    break;
                case 5:
                    finalizarJogo=fundirReliquias(bolsaDeReliquia);
                    break;
                case 6:
                    finalizarJogo = false;
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opcao Invalida...");
            }
        }
    }
}