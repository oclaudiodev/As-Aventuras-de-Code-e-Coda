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
        String[][] tabuleiroFantasma = new String[7][7];
        preencherMatrizFantasma(tabuleiroFantasma);

        while (opcaoInicioJogo != 3) {
            switch (opcaoInicioJogo) {
                case 1:
                    jogo(tabuleiroFantasma, tabuleiroDoJogo, input);
                    opcaoInicioJogo = menuPrincipal(input);
                    break;
                case 2:
                    //instrucoes para o jogo
                    intrucoesDoJogo();
                    opcaoInicioJogo = menuPrincipal(input);
                    break;
                case 3:
                    //sair do jogo
                    System.out.println("Saindo do jogo...");
                    break;
            }
        }
    }

    //Criar a matriz inicial do jogo
    public static void matrizDoMapaDoJogo(String[][] matrizMapa) {
        for (int i = 0; i < matrizMapa.length; i++) {
            for (int j = 0; j < matrizMapa[i].length; j++) {
                matrizMapa[i][j] = "???";
            }
        }
    }

    //criar matriz fantasma do jogo
    public static void preencherMatrizFantasma(String[][] matrizFantasma) {
        //bosses
        matrizFantasma[0][4] = "Varkhul";
        matrizFantasma[1][1] = "Seraphyx";
        matrizFantasma[2][5] = "Drogmar";
        matrizFantasma[3][2] = "Nytheris";
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
        for (int i = 0; i < matrizFantasma.length; i++) {
            for (int j = 0; j < matrizFantasma[i].length; j++) {
                if (matrizFantasma[i][j] == null) {
                    matrizFantasma[i][j] = "[VAZIA]";
                }
            }
        }
    }

    //Menu principal do jogo
    public static int menuPrincipal(Scanner sc) {
        System.out.println("---- Menu Principal ----");
        System.out.println("(1) Iniciar Jogo");
        System.out.println("(2) Instrucoes do jogo");
        System.out.println("(3) Sair do jogo");
        int opcao = 0;
        do {
            System.out.println("Digite a opcao");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer
            if (opcao < 1 || opcao > 3) {
                System.out.println("Digite uma opcao valida....");
            }
        } while (opcao < 1 || opcao > 3);
        return opcao;
    }

    //Instrucoes do jogo
    public static void intrucoesDoJogo() {
        System.out.println("--- Instrucoes do jogo ---");
        System.out.println("O jogador tera como objetivo encontrar e derrotar os 7 bosses no mapa, cada boss ira dropar sua reliquia");
        System.out.println("quando o jogador tiver obtido todas as 7 reliquias ele ira conseguir escapar do labiritinto.");
        System.out.println("Para auxiliar o jogador temos charadas e caixas com itens especiaias no jogo.");
        System.out.println("W/A/S/D e os botoes uados para se movimentar pelo mapa.");
    }

    //Escolha do personagem
    public static String escolhaDePersonagem(Scanner sc) {
        System.out.println("---- Seja muito Bem-Vindo as aventuras de code");
        System.out.println("Por favor escolha seu personagem: \n(1)Code\n(2)Anabelle");
        int opcao_personagem = 0;
        String nomePersonagem = "Code";
        String nomePersonagem2 = "Anabelle";
        do {
            opcao_personagem = sc.nextInt();
            sc.nextLine();
            if (opcao_personagem > 2 || opcao_personagem < 1) {
                System.out.println("Opcao Invalida, Digite uma opcao valida...");
            }
        } while (opcao_personagem < 1 || opcao_personagem > 2);
        String personagemEscolhido = "";
        if (opcao_personagem == 1) {
            personagemEscolhido = nomePersonagem;
        } else if (opcao_personagem == 2) {
            personagemEscolhido = nomePersonagem2;
        }
        System.out.println("Boa sorte em sua jornada " + personagemEscolhido);
        System.out.println("Inicializando o jogo....");
        return personagemEscolhido;
    }

    //aleatorizar Spawn do jogador
    public static void spawnJogador(String nomePersonagem, String[][] matrizJogo) {
        Random aleatorizar = new Random();
        int linha = aleatorizar.nextInt(7);
        matrizJogo[linha][0] = "TU";
    }

    //lista mapa do jogo
    public static void listarMapaJogo(String[][] mapaJogo) {
        for (int i = 0; i < mapaJogo.length; i++) {
            for (int j = 0; j < mapaJogo[i].length; j++) {
                System.out.printf("%-15s", mapaJogo[i][j]);
            }
            System.out.println(" ");
        }
    }

    //essa funcao servira de parametro para a funcao de se movimentar devolvendo a direcao
    public static char receberDirecaoDoJogador(Scanner sc) {
        System.out.println("Digite para onde vai: W/A/S/D");
        char direcao;
        do {
            direcao = sc.next().toLowerCase().charAt(0);
            sc.nextLine();
            if (direcao == 'w' || direcao == 'a' || direcao == 's' || direcao == 'd') {
                //nada
            } else {
                System.out.println("Tecla invalida por favor digite uma direcao correta...");
            }
        } while (direcao != 'w' && direcao != 'a' && direcao != 's' && direcao != 'd');
        return direcao;
    }

    //validar movimentacao e direcao que o jogador ira, para saber se batera na parede por exemplo
    public static int[] validDirecaoJogador(String[][] matrizJogo, char direcao, int coluna, int linha, Scanner sc) {
        int[] direcaoValidada = new int[2];
        if (direcao == 'w') {
            if (linha - 1 < 0) {
                System.out.println("Nao existe nada para la, va explore outro lugar...");
                return validDirecaoJogador(matrizJogo, receberDirecaoDoJogador(sc), coluna, linha, sc);
            } else {
                linha--;
                direcaoValidada[0] = linha;
                direcaoValidada[1] = coluna;
            }
        } else if (direcao == 'a') {
            if (coluna - 1 < 0) {
                System.out.println("Nao existe nada para la, va explore outro lugar...");
                return validDirecaoJogador(matrizJogo, receberDirecaoDoJogador(sc), coluna, linha, sc);
            } else {
                coluna--;
                direcaoValidada[0] = linha;
                direcaoValidada[1] = coluna;
            }
        } else if (direcao == 's') {
            if (linha + 1 >= matrizJogo.length) {
                System.out.println("Nao existe nada para la, va explore outro lugar...");
                return validDirecaoJogador(matrizJogo, receberDirecaoDoJogador(sc), coluna, linha, sc);
            } else {
                linha++;
                direcaoValidada[0] = linha;
                direcaoValidada[1] = coluna;
            }
        } else if (direcao == 'd') {
            if (coluna + 1 >= matrizJogo[0].length) {
                System.out.println("Nao existe nada para la, va explore outro lugar...");
                return validDirecaoJogador(matrizJogo, receberDirecaoDoJogador(sc), coluna, linha, sc);
            } else {
                coluna++;
                direcaoValidada[0] = linha;
                direcaoValidada[1] = coluna;
            }
        }
        return direcaoValidada;
    }

    //Sistema de movimentacao
    public static boolean acaoDeMovimentar(String[][] matrizJogo, String[][] matrizFantasma, int[] statusJogador, String[] bolsaDeReliquia, Scanner sc) {
        char direcaoJogador = receberDirecaoDoJogador(sc);

        for (int i = 0; i < matrizJogo.length; i++) {
            for (int j = 0; j < matrizJogo[i].length; j++) {
                if (matrizJogo[i][j].equals("TU")) {
                    int[] dest = validDirecaoJogador(matrizJogo, direcaoJogador, j, i, sc);
                    int nL = dest[0], nC = dest[1];

                    // Verifica se o destino tem um boss
                    String casaDestino = matrizFantasma[nL][nC];
                    String[] bosses = {"Varkhul", "Seraphyx", "Drogmar", "Nytheris", "Krazenoth", "Velkior", "Azhrael"};
                    boolean ehBoss = false;
                    for (String boss : bosses) {
                        if (boss.equals(casaDestino)) {
                            ehBoss = true;
                            break;
                        }
                    }

                    if (ehBoss) {
                        boolean venceu = trocaInsana(matrizFantasma, matrizJogo, casaDestino, statusJogador);
                        if (!venceu) {
                            return false; // game over
                        }
                        // Adiciona reliquia na bolsa
                        for (int k = 0; k < bolsaDeReliquia.length; k++) {
                            if (bolsaDeReliquia[k].equals("[VAZIO]")) {
                                bolsaDeReliquia[k] = "Reliquia_" + casaDestino;
                                break;
                            }
                        }
                        // Remove boss do mapa fantasma
                        matrizFantasma[nL][nC] = "[BOSS MORTO]";
                    }

                    // Move o jogador
                    matrizJogo[nL][nC] = "TU";
                    matrizJogo[i][j] = matrizFantasma[i][j];
                    listarMapaJogo(matrizJogo);
                    return true;
                }
            }
        }
        return true;
    }

    //criar bolsa de reliquias do jogador
    public static String[] criarBolsaDasReliquias() {
        String[] vetorDaBolsa = new String[7];
        for (int i = 0; i < vetorDaBolsa.length; i++) {
            vetorDaBolsa[i] = "[VAZIO]";
        }
        return vetorDaBolsa;
    }

    //mostrar Bolsa de reliquias para o usuario
    public static void listarBolsaDeReliquias(String[] bolsa) {
        for (int i = 0; i < bolsa.length; i++) {
            System.out.print(bolsa[i]);
        }
        System.out.println(" ");
    }

    //Criar estastisticas do jogador
    public static int[] criarestatisticasDoJogador() {
        Random rdm = new Random();
        System.out.println("--- Criando estatisticas do Jogador ---");
        int vida = rdm.nextInt(32, 55);
        int dano = rdm.nextInt(7, 12);
        int[] statusJogador = {vida, dano};
        return statusJogador;
    }

    //status do jogador
    public static void listarStatusJogador(int[] status) {
        System.out.println("-----------------------------------");
        System.out.println("Vida: " + status[0]);
        System.out.println("Dano: " + status[1]);
    }

    //fundir as reliquias do jogador
    public static boolean fundirReliquias(String[] reliquias) {
        int c = 0;
        boolean valid = true;
        for (int i = 0; i < reliquias.length; i++) {
            if (reliquias[i].equals("[VAZIO]")) {
                c++;
            }
        }
        if (c > 0) {
            System.out.println("Você ainda nao tem todas as reliquias necessarias...");
            System.out.println("Faltam: " + c);
        }
        if (c == 0) {
            System.out.println("Parabens Jogador voce obteve todas as reliquias necessarias para completar o jogo");
            System.out.println("Esperamos que tenha gostado da jornada....");
            valid = false;
        }
        return valid;
    }

    //menu de escolhas do jogadors
    public static int menuDeEscolhasJogador(Scanner sc) {
        System.out.println("---- Menu de escolhas ----");
        System.out.println("1 - Se movimentar");
        System.out.println("2 - ver mapa");
        System.out.println("3 - verificar bolsa se reliquias");
        System.out.println("4 - verificar status do jogador");
        System.out.println("5 - Fundir todas reliquias (Necessario ter as 7)");
        System.out.println("6 - Sair do jogo");
        int opcaoJogador = sc.nextInt();
        sc.nextLine();
        return opcaoJogador;
    }

    public static void esperar(int ms) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
    }

    public static boolean trocaInsana(String[][] matrizFantasma, String[][] matrizJogo, String nomeBoss, int[] statusJogador) {
        Random rdm = new Random();

        // Definindo atributos de cada boss
        int vidaBoss;
        int atkBoss;

        switch (nomeBoss) {
            case "Varkhul":
                vidaBoss = rdm.nextInt(30, 50);
                atkBoss = rdm.nextInt(5, 10);
                break;
            case "Seraphyx":
                vidaBoss = rdm.nextInt(40, 60);
                atkBoss = rdm.nextInt(8, 13);
                break;
            case "Drogmar":
                vidaBoss = rdm.nextInt(50, 70);
                atkBoss = rdm.nextInt(10, 15);
                break;
            case "Nytheris":
                vidaBoss = rdm.nextInt(35, 55);
                atkBoss = rdm.nextInt(12, 18);
                break;
            case "Krazenoth":
                vidaBoss = rdm.nextInt(60, 75);
                atkBoss = rdm.nextInt(10, 14);
                break;
            case "Velkior":
                vidaBoss = rdm.nextInt(55, 80);
                atkBoss = rdm.nextInt(14, 20);
                break;
            case "Azhrael":
                vidaBoss = rdm.nextInt(80, 120);
                atkBoss = rdm.nextInt(18, 28);
                break;
            default:
                vidaBoss = rdm.nextInt(30, 50);
                atkBoss = rdm.nextInt(5, 10);
                break;

        }

        // Stats do jogador 
        int vidaMinha = statusJogador[0];
        int meuAtk = statusJogador[1];

        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("  TROCA INSANA com " + nomeBoss + "!");
        System.out.println("  Nao ha escolhas. Apenas luta.");
        System.out.println("╚══════════════════════════════╝");
        System.out.println("");
        System.out.println("\n--- Atributos do boss ---");
        System.out.println("Boss: " + nomeBoss);
        System.out.println("Vida: " + vidaBoss + " | Ataque: " + atkBoss);
        System.out.println("");
        System.out.println("--- Seus atributos ------");
        System.out.println("Vida: " + vidaMinha + " | Ataque: " + meuAtk);
        System.out.println("-------------------------\n");
        System.out.println("");

        // Condicao especial: boss e mais forte em TUDO
        if (vidaBoss > vidaMinha && atkBoss > meuAtk) {
            System.out.println(">>> O boss e mais forte que voce em tudo!");
            System.out.println(">>> A batalha vai ser dificil...\n");
            System.out.println("");
        }

        // Batalha automatica
        int turno = 1;
        while (vidaMinha > 0 && vidaBoss > 0) {
            System.out.println("-- Turno " + turno + " --");

            int danoJogador = meuAtk + rdm.nextInt(0, 6);
            vidaBoss -= danoJogador;
            System.out.println("Voce causou " + danoJogador + " de dano em " + nomeBoss+ " | Vida restante do boss: " + Math.max(0, vidaBoss));

            esperar(1000);

            if (vidaBoss <= 0) {
                break;
            }

            int danoBoss = atkBoss + rdm.nextInt(0, 5);
            vidaMinha -= danoBoss;
            System.out.println(nomeBoss + " causou " + danoBoss + " de dano em voce"+ " | Sua vida restante: " + Math.max(0, vidaMinha));

            esperar(1000);

            turno++;
            System.out.println();
        }

        // Resultado final
        System.out.println("=== Resultado da Troca Insana ===");
        System.out.println("Boss " + nomeBoss + " terminou com vida: " + Math.max(0, vidaBoss));
        System.out.println("Voce terminou com vida: " + Math.max(0, vidaMinha));

        if (vidaMinha <= 0) {
            System.out.println("Voce foi destruido na Troca Insana...");
            return false; // jogador perdeu
        } else {
            switch (nomeBoss) {
                case "Varkhul":
                    statusJogador[0] = 60;
                    statusJogador[1] += 4;
                    System.out.println(" Bonus: vida restaurada para 60 e +4 de ataque!");
                    break;
                case "Seraphyx":
                    statusJogador[0] = 70;
                    statusJogador[1] += 8;
                    System.out.println(" Bonus: vida restaurada para 70 e +8 de ataque!");
                    break;
                case "Drogmar":
                    statusJogador[0] = 80;
                    statusJogador[1] += 12;
                    System.out.println(" Bonus: vida restaurada para 80 e +12 de ataque!");
                    break;
                case "Nytheris":
                    statusJogador[0] = 90;
                    statusJogador[1] += 16;
                    System.out.println(" Bonus: vida restaurada para 90 e +16 de ataque!");
                    break;
                case "Krazenoth":
                    statusJogador[0] = 100;
                    statusJogador[1] += 20;
                    System.out.println(" Bonus: vida restaurada para 100 e +20 de ataque!");
                    break;
                case "Velkior":
                    statusJogador[0] = 110;
                    statusJogador[1] += 24;
                    System.out.println(" Bonus: vida restaurada para 110 e +24 de ataque!");
                    break;
                case "Azhrael":
                    statusJogador[0] = 120;
                    statusJogador[1] += 28;
                    System.out.println(" Bonus: vida restaurada para 120 e +28 de ataque!");
                    break;
            }

            System.out.println(">> Seus novos stats — Vida: " + statusJogador[0] + " | Ataque: " + statusJogador[1]);
            return true;
        }
    }

    //O jogo rodara nessa funcao
    public static void jogo(String[][] mapaFantasma, String[][] mapaJogo, Scanner sc) {
        //Todas funcoes do jogo deve ser colocada aqui
        //Decisao do personagem
        String personagem = escolhaDePersonagem(sc);

        //spawn personagem
        spawnJogador(personagem, mapaJogo);

        //listar mapa para o usuario
        listarMapaJogo(mapaJogo);

        //criar bolsa de reliquias do jogador
        String[] bolsaDeReliquia = criarBolsaDasReliquias();

        //Criar status do jogador
        int[] statusJogador = criarestatisticasDoJogador();

        //criar bosses do jogo
        //criar charadas
        boolean finalizarJogo = true;
        while (finalizarJogo) {
            int menuDeEscolhas = menuDeEscolhasJogador(sc);
            switch (menuDeEscolhas) {
                case 1:
                    //movimentacao do jogador
                    boolean continua = acaoDeMovimentar(mapaJogo, mapaFantasma, statusJogador, bolsaDeReliquia, sc);
                    if (!continua) {
                        finalizarJogo = false;
                        System.out.println("Fim de jogo...");
                        matrizDoMapaDoJogo(mapaJogo);
                        preencherMatrizFantasma(mapaFantasma);
                    }
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
                    finalizarJogo = fundirReliquias(bolsaDeReliquia);
                    break;
                case 6:
                    finalizarJogo = false;
                    System.out.println("Saindo do jogo...");
                    matrizDoMapaDoJogo(mapaJogo);
                    preencherMatrizFantasma(mapaFantasma);
                    break;
                default:
                    System.out.println("Opcao Invalida...");
            }
        }
    }
}
