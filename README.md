# 🔖 ALUNOS

- [Andrei Rech | 23102140](https://github.com/AndreiRech)  
- [Eduardo Colla De Bastiani | 23106295](https://github.com/eduardo-de-bastiani)

# 📚 INTRODUÇÃO

Programa capaz de encontrar a maior sequência possível de objetos colocáveis um dentro de outro dada três dimenções não identificadas.
> A partir de casos testes, encontrar a **maior sequência** dentro de um grafo

Caso deseje, é de grande ajuda utilizar o [Simulador de Caixas](https://www.inf.pucrs.br/flash/boxes-html/) para entender melhor como funciona a problemática.

# 🛠 PRÉ REQUISITOS

É necessário possuir a linguagem [Java](https://www.java.com/pt-BR/download/) instalada no computador.

Também, a utilização de um **editor de código**, como o [VSCode](https://code.visualstudio.com/) facilita a utilização do programa.

# ⚙ INICIALIZAÇÃO

Dentro do diretório do programa, compile o mesmo utilizando:

```
javac Main.java Box.java Graph.java Digraph.java DFS.java
```

Após isso, execute-o:

```
java Main
```

Caso arquivos .class sejam gerados, é possível excluí-los usando:

*Windows*
```
del *.class
```

*Linux | Mac*
```
rm *.class
```

# O QUE FAZER

**DESENVOLVIMENTO DA SOLUÇÃO**

- [X] Verificar se uma caixa cabe dentro de outra
- [ ] Encontrar o maior caminho entre elas

**FUNÇÕES SUPORTES**

- [X] Leitura do arquivo
- [X] Criação da representação gráfica *.dot é printado após achar o caminho | opcional*
- [X] Temporizar resultados
