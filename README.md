# # Técnicas de Programação Avançada

Este repositório contém a implementações desenvolvidas como parte da disciplina **Técnicas de Programação Avançada**.

## Estrutura do Projeto

- **TAD Arranjo**: Contém estrutura de dados que armazena elementos inteiros e oferece diversas operações de manipulação.

### Métodos:
- `inserir(Integer item)`: Insere um item no arranjo. Se o item já existir ou a lista estiver cheia, lança uma exceção.
- `remover(Integer item)`: Remove um item do arranjo. Caso o item não seja encontrado ou o arranjo esteja vazio, uma exceção é lançada.
- `pesquisar(Integer item)`: Pesquisa um item no arranjo e o retorna se for encontrado, ou `null` caso contrário.
- `findIndex(Integer item)`: Retorna o índice de um item no arranjo ou `-1` se o item não for encontrado.
- `ordenacaoSelecao(int tam)`: Ordena os elementos do arranjo utilizando o algoritmo de ordenação por seleção.
- `somaParesSimetricos(int k)`: Calcula a soma dos pares simétricos (elemento na posição `k` somado ao elemento na posição simétrica no final do arranjo).
- `exibir()`: Exibe o conteúdo atual do arranjo no formato de lista.
- `isEmpty()`: Verifica se o arranjo está vazio.
- `getLast()`: Retorna o índice do último elemento inserido no arranjo.
