# Jogo de Adivinhação com Busca Binária

Programa em Java em que o computador sorteia um número secreto entre 1 e 1000 e o descobre usando **busca binária recursiva**, mostrando cada tentativa no terminal.

## Como funciona

A cada tentativa, o programa chuta o ponto médio do intervalo atual:

- **Chute alto:** o número está na metade de baixo, então `fim = chute - 1`.
- **Chute baixo:** o número está na metade de cima, então `inicio = chute + 1`.
- **Chute igual ao secreto:** caso base, a recursão termina.

Como o intervalo cai pela metade a cada passo, qualquer número entre 1 e 1000 é encontrado em no máximo **10 tentativas** (⌈log₂ 1000⌉), contra até 1000 de uma busca linear.

## Como executar

Requer o JDK instalado.

```bash
javac JogoAdivinhacao.java
java JogoAdivinhacao
```

## Exemplo de saída

```
=== JOGO DE ADIVINHAÇÃO ===
Número secreto sorteado no intervalo [1, 1000].

Tentativa 1: chute = 500 -> Muito baixo
Tentativa 2: chute = 750 -> Muito alto
...
Tentativa 8: chute = 613 -> Acertou!
```

## Conceitos praticados

- Recursão (passos recursivos e caso base)
- Busca binária e complexidade O(log n)
- Passagem de contador por referência com array

## Autor

André Angonese, estudante de Sistemas de Informação na UTFPR.