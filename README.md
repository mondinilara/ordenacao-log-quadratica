# Ordenação Log-Quadrática Garantida

Este projeto implementa o algoritmo **Ordenação Log-Quadrática Garantida**, desenvolvido para um trabalho acadêmico com o objetivo de criar um algoritmo de ordenação que pertença à classe de complexidade temporal **ω(n²)**, sendo o mais eficiente possível dentro dessa classe.

## Descrição

O algoritmo tem como base o **Selection Sort**, escolhido por sua complexidade de **Θ(n²)**. Para elevar o custo para **Θ(n² log n)**, foi adicionado um laço artificial de atraso que realiza **Θ(log n)** operações a cada comparação, garantindo o crescimento assintótico desejado.

Além disso, o algoritmo imprime no console o valor de cada elemento assim que ele é fixado na posição correta durante a ordenação.

## Complexidade

- Melhor caso: Θ(n² log n)
- Caso médio: Θ(n² log n)
- Pior caso: Θ(n² log n)

## Como executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

2. Compile o projeto (Java 8+):
```bash
javac AlgoritmosOrdenacao.java
```

3. Execute o algoritmo:
```bash
java AlgoritmosOrdenacao <arquivo_de_entrada>
```

## ⚠ Notas

- O algoritmo gera um grande volume de saída no console se o array for muito grande. Para testes e visualização dos elementos ordenados, recomenda-se usar arrays com tamanho pequeno (ex.: 20 ou 50 elementos).
- O algoritmo foi desenvolvido para fins acadêmicos e não deve ser usado em aplicações de produção.

## Autores

Desenvolvido por **Lara Mondini Martins** e **Denise Araújo Santos** para o trabalho da disciplina PGC101 — Análise de Algoritmos.