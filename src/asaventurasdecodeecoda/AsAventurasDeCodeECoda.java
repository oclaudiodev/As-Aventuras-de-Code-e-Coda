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

        switch (opcaoInicioJogo){
            case 1:
                jogo(tabuleiroFantasma,tabuleiroDoJogo,input);
                break;
            case 2:
                //Caso o jogador saia do jogo
                System.out.println("Saindo do jogo...");
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
        System.out.println("(2) Sair do jogo");
        int opcao = 0;
        do{
            System.out.println("Digite a opcao");
            opcao = sc.nextInt();
            if(opcao < 1 || opcao > 2){
                System.out.println("Digite uma opcao valida....");
            }
        }while(opcao < 1 || opcao > 2);
        return opcao;
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
    
    //O jogo rodara nessa funcao
    public static void jogo(String[][] mapaFantasma,String[][] mapaJogo,Scanner sc){
        //Todas funcoes do jogo deve ser colocada aqui
        //Decisao do personagem
        String personagem = escolhaDePersonagem(sc);
        //spawn personagem
        spawnJogador(personagem,mapaJogo);
        //listar mapa para o usuario
        listarMapaJogo(mapaJogo);
        //movimentacao do jogador
        acaoDeMovimentar(mapaJogo,mapaFantasma,sc);
    }
}