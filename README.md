![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-Repository-black?style=for-the-badge&logo=github)
![Status](https://img.shields.io/badge/status-Concluído-brightgreen?style=for-the-badge)

# 📚 Implementação de Filas em Java — Exercícios de Fixação (EDI)

Este repositório contém a resolução de **6 exercícios práticos** sobre Filas desenvolvidos em **Java**, sem utilizar as implementações prontas da linguagem.

O projeto está dividido em dois blocos: **Bloco A** com abordagens estáticas utilizando vetor linear direto, e **Bloco B** com abordagens dinâmicas utilizando nós encadeados FIFO.

---

# 🧠 Objetivo

Aprofundar o entendimento prático sobre a estrutura de dados **Fila (FIFO - First In, First Out)** através da resolução de problemas que envolvem variações e extensões do TAD Fila.

Durante o desenvolvimento foram trabalhados conceitos como:

- Deslocamento imediato em vetores lineares
- Simulação de Fila com estruturas de Pilha (LIFO)
- Output-Restricted Deque (saída dupla)
- Contagem com preservação de estrutura
- Merge de filas dinâmicas ordenadas
- Separação de elementos com múltiplas filas

---

# 🏗️ Estrutura do Projeto

## 📌 Interface (TAD)

Arquivo: `Queue.java`

Define todas as operações obrigatórias que uma fila deve possuir.

Métodos disponíveis:

- `push(T element)` — Insere no fim da fila
- `pop()` — Remove e retorna o elemento do início
- `peek()` — Consulta o início sem remover
- `back()` — Consulta o fim sem remover
- `size()`
- `isEmpty()`
- `clear()`
- `display()`

---

## ⚙️ Implementação Base com Vetor

Arquivo: `ArrayQueue.java`

Implementação da fila utilizando vetor linear com início fixo na posição 0.

Características:

- Uso de Generics (`<T>`)
- Início sempre fixo no índice 0
- Remoção com deslocamento imediato dos elementos
- Capacidade fixa definida na criação

---

## 🔗 Implementação Base com Lista Encadeada

Arquivo: `LinkedQueue.java`

Implementação da fila utilizando nós encadeados com ponteiros `head` e `tail`.

Características:

- Uso de Generics (`<T>`)
- Crescimento dinâmico sem limite pré-definido
- Acesso direto ao início (`head`) e fim (`tail`)
- Classe interna `Node<T>` com campos `element` e `next`

---

## 🧩 Bloco A — Abordagens Estáticas (Vetor Linear Direto)

### Questão 1 — Deslocamento Imediato no Desenfileirar

Arquivo: `Exer01ShiftPop.java`

Estende `ArrayQueue` e sobrescreve o método `pop()` com lógica de deslocamento imediato.

**Lógica:** Ao remover o elemento da posição 0, todos os demais são deslocados uma posição para a esquerda (`items[i-1] = items[i]`). O contador é decrementado e a última posição é limpa. Custo **O(n)** por remoção.

---

### Questão 2 — Fila com Duas Pilhas

Arquivo: `Exer02StackBasedQueue.java`

Implementa o comportamento FIFO utilizando exclusivamente duas instâncias de `ArrayStack` como variáveis internas.

**Lógica:** A pilha `inbox` recebe todos os `push()`. Quando `pop()` ou `peek()` são chamados e `outbox` está vazia, todos os elementos de `inbox` são transferidos para `outbox`, invertendo a ordem e colocando o mais antigo no topo. Custo **O(1) amortizado**.

---

### Questão 3 — Output-Restricted Deque

Arquivo: `Exer03OutputRestrictedDeque.java`

Estende `ArrayQueue` adicionando o método `popBack()`, que remove e retorna o elemento do **final** da fila.

**Lógica:** O último elemento está sempre em `items[count-1]`. Basta salvá-lo, limpar a posição com `null` e decrementar `count`. Sem deslocamento necessário. Custo **O(1)**.

---

## 🧩 Bloco B — Abordagens Dinâmicas (Nós Encadeados FIFO)

### Questão 4 — Contagem de Ocorrências com Estrutura Preservada

Arquivo: `Exer04CountOccurrences.java`

Conta quantas vezes um valor `target` aparece na `LinkedQueue` sem acessar os nós internos e sem alterar a estrutura da fila.

**Lógica:** Uma fila auxiliar recebe os elementos retirados com `pop()` enquanto conta as ocorrências. Ao fim, todos são reinseridos na fila original com `push()`, restaurando a ordem. Custo **O(n)**.

---

### Questão 5 — Junção de Filas Dinâmicas Ordenadas

Arquivo: `Exer05MergeQueues.java`

Recebe duas `LinkedQueue` já ordenadas em ordem crescente e as combina em uma terceira fila também ordenada, esvaziando as originais.

**Lógica:** Algoritmo de merge clássico — compara o `peek()` de cada fila e retira com `pop()` sempre o menor, inserindo-o na fila resultado. Quando uma esvazia, o restante da outra é despejado diretamente. Custo **O(n + m)**.

---

### Questão 6 — Separação Par e Ímpar Dinâmica

Arquivo: `Exer06SplitEvenOdd.java`

Retira todos os elementos de uma `LinkedQueue` e os distribui em duas novas filas: uma com pares e outra com ímpares, preservando a ordem de chegada.

**Lógica:** Esvazia a fila original com `pop()` e para cada elemento verifica `n % 2 == 0`. Pares vão para `evenQueue`, ímpares para `oddQueue`. A ordem FIFO é mantida naturalmente. Custo **O(n)**.

---

## 🧪 Testes

Arquivos:

- `Exer01ShiftPopTest.java`
- `Exer02StackBasedQueueTest.java`
- `Exer03OutputRestrictedDequeTest.java`
- `Exer04CountOccurrencesTest.java`
- `Exer05MergeQueuesTest.java`
- `Exer06SplitEvenOddTest.java`

Responsáveis por validar o funcionamento de cada exercício através de cenários específicos.

Foram realizados testes envolvendo:

- Inserção e remoção de elementos
- Deslocamento correto após remoção
- Comportamento FIFO com duas pilhas
- Remoção pelo fim sem lacunas no vetor
- Contagem sem alterar a estrutura da fila
- Merge ordenado com esvaziamento das originais
- Separação correta de pares e ímpares

---

# ⚙️ Operações Implementadas

### ➕ Inserção

- `push(T element)` — Insere um elemento no final da fila

---

### ➖ Remoção

- `pop()` — Remove e retorna o primeiro elemento da fila
- `popBack()` — Remove e retorna o último elemento da fila *(Q3)*

---

### 🔍 Consulta

- `peek()` — Retorna o primeiro elemento sem removê-lo
- `back()` — Retorna o último elemento sem removê-lo

---

### 📊 Estado da Estrutura

- `size()`
- `isEmpty()`
- `clear()`
- `display()`

---

# 🧠 Conceitos Aplicados

- Estruturas de Dados
- Filas (Queue) — FIFO
- Pilhas (Stack) — LIFO
- Vetor Linear com início fixo
- Output-Restricted Deque
- Listas Encadeadas com `head` e `tail`
- Algoritmo de Merge
- Generics
- Interfaces e TAD
- Programação Orientada a Objetos
- Encapsulamento e Herança

---

# ⚙️ Tecnologias Utilizadas

- Java
- JDK 17+
- IntelliJ IDEA
- Git
- GitHub

---

# 🚀 Possíveis Melhorias Futuras

- Integração com JUnit 5
- Implementação de exceções personalizadas
- Redimensionamento dinâmico na `ArrayQueue`
- Documentação JavaDoc completa
- Criação de iteradores para percorrer as filas

---

# 🎯 Objetivo Acadêmico

Este projeto foi desenvolvido com fins educacionais para a disciplina de **Estrutura de Dados e Informação (EDI)**, consolidando o entendimento sobre filas através da resolução de problemas práticos com variações estáticas e dinâmicas da estrutura.

---

# 👨‍💻 Autor

Carlos Sales
