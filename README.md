# ⚔️ As Aventuras de Code e Coda

> Um RPG de terminal onde você explora um labirinto, enfrenta bosses poderosos e coleta relíquias para escapar — tudo com movimentação em matriz e batalhas automáticas!

---

## 📖 Sobre o Jogo

**As Aventuras de Code e Coda** é um jogo de RPG rodado no terminal, desenvolvido em Java como projeto acadêmico. O jogador explora um mapa em grade 7x7, encontra e derrota 7 bosses épicos, coleta suas relíquias e, ao reunir todas, consegue fundir os artefatos e escapar do labirinto.

O jogo combina mecânicas de:
- 🗺️ **Exploração** em matriz com movimentação WASD
- ⚔️ **Batalhas automáticas** com stats aleatórios
- 🎒 **Sistema de inventário** com bolsa de relíquias
- 🧩 **Casas especiais** com charadas e caixas de itens
- 📈 **Progressão de poder** — cada boss derrotado deixa bônus de vida e ataque

---

## 🗺️ Como Funciona o Mapa

O mapa é uma grade **7 colunas × 7 linhas**, inicialmente oculta (`???`). Conforme o jogador se move, as casas são reveladas. Por baixo existe uma **matriz fantasma** invisível que guarda o conteúdo real de cada posição:

| Tipo de Casa | Descrição |
|---|---|
| `TU` | Posição atual do jogador |
| Boss (ex: `Varkhul`) | Inimigo que bloqueia a casa |
| `charada1~4` | Desafio de raciocínio |
| `CaixaEspecial` | Item especial disponível |
| `[VAZIA]` | Casa sem evento |
| `[BOSS MORTO]` | Boss já derrotado |

---

## 👾 Os 7 Bosses

Cada boss tem vida e ataque gerados aleatoriamente dentro de uma faixa, garantindo que os confrontos fiquem mais difíceis conforme o jogo avança:

| Boss | Dificuldade | Relíquia |
|---|---|---|
| Varkhul | ⭐ | Olhos das Trevas |
| Seraphyx | ⭐⭐ | Pena do Abismo |
| Drogmar | ⭐⭐⭐ | Escudo do Inferno |
| Nytheris | ⭐⭐⭐ | Coração do Vazio |
| Krazenoth | ⭐⭐⭐⭐ | Garra da Ruína |
| Velkior | ⭐⭐⭐⭐ | Coroa Partida |
| Azhrael | ⭐⭐⭐⭐⭐ | Alma Aprisionada |

> Ao vencer cada boss, o jogador recebe bônus de vida e ataque permanentes para a batalha seguinte.

---

## 🎮 Como Jogar

### Pré-requisitos

- Java **JDK 17** ou superior instalado
- Terminal / Prompt de Comando

### Rodando o projeto

```bash
# Clone o repositório
git clone https://github.com/oclaudiodev/As-Aventuras-de-Code-e-Coda.git

# Entre na pasta do projeto
cd as-aventuras-de-code-e-coda

# Compile o arquivo
javac asaventurasdecodeecoda/AsAventurasDeCodeECoda.java

# Execute o jogo
java asaventurasdecodeecoda.AsAventurasDeCodeECoda
```

### Controles

| Tecla | Ação |
|---|---|
| `W` | Mover para cima |
| `S` | Mover para baixo |
| `A` | Mover para a esquerda |
| `D` | Mover para a direita |

### Menu de opções durante o jogo

```
1 - Se movimentar
2 - Ver mapa
3 - Verificar bolsa de relíquias
4 - Verificar status do jogador
5 - Fundir todas as relíquias (requer as 7)
6 - Sair do jogo
```

---

## 🏗️ Estrutura do Código

```
AsAventurasDeCodeECoda.java
│
├── main()                      → Ponto de entrada e loop principal
├── menuPrincipal()             → Exibe e valida o menu inicial
├── jogo()                      → Orquestra toda a partida
│
├── 🗺️ Mapa
│   ├── matrizDoMapaDoJogo()    → Inicializa o mapa visível com "???"
│   ├── preencherMatrizFantasma() → Define posições de bosses, charadas e caixas
│   └── listarMapaJogo()        → Imprime o mapa no terminal
│
├── 🧑 Jogador
│   ├── escolhaDePersonagem()   → Escolha entre Code ou Anabelle
│   ├── spawnJogador()          → Spawn aleatório na coluna 0
│   ├── criarestatisticasDoJogador() → Gera vida e dano aleatórios
│   └── listarStatusJogador()   → Exibe stats atuais
│
├── 🎒 Inventário
│   ├── criarBolsaDasReliquias() → Vetor de 7 slots para relíquias
│   ├── listarBolsaDeReliquias() → Exibe o inventário
│   ├── obterReliquiaDoBoss()   → Retorna a relíquia de cada boss
│   └── fundirReliquias()       → Verifica vitória ao reunir as 7
│
├── ⚔️ Batalha
│   └── trocaInsana()           → Sistema de combate automático por turnos
│
└── 🕹️ Movimentação
    ├── receberDirecaoDoJogador() → Lê e valida entrada WASD
    ├── validDirecaoJogador()    → Verifica limites do mapa
    └── acaoDeMovimentar()       → Move o jogador e dispara eventos da casa
```

---

## 🚀 Funcionalidades Futuras

- [ ] Implementar as charadas com validação de resposta
- [ ] Implementar efeito das caixas especiais
- [ ] Salvar e carregar progresso do jogador
- [ ] Adicionar mais tipos de evento no mapa
- [ ] Interface gráfica (JavaFX ou Swing)

---

## 👥 Equipe

Desenvolvido com dedicação por:

| Nome | GitHub |
|---|---|
| Guilherme de Souza Santos | [@guilherme](https://github.com/santosgui06) |
| José Cláudio de Souza Silva | [@claudio](https://github.com/oclaudiodev) |
| Wellington Izaias Teixeira | [@wellington](https://github.com/WellingtonIzaias) |
| Felipe Garcia Silva | [@felipe](https://github.com/fgx-sys) |

---

## 📚 Contexto Acadêmico

Projeto desenvolvido para a disciplina de **Algoritmos e Programação II** do curso de **Análise e Desenvolvimento de Sistemas (ADS)**.

---
