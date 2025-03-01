# Orientação Objeto em Java

* **Classe:** Tipo estruturado de informação. Uma classe contêm:
    - ***Atributos:*** Dados, informação, caracteristicas inerentes àquele objeto.
    - ***Métodos:*** São funções, ou operações específicas usadas pela nossa classe.


## Membros estáticos

## Construtor
Comandos executados no momento da instanciação do objeto. Iniciam os atributos com valores padrões no momento que a classe é chamada ```new```.
Caso um construtor não for especificado, a classe disponibilza o construtor padrão ```Product p = new Product();```

```

```

## Palavra this


## Sobrecarga

## Encapsulamento

## Modificadores de Acesso

## Comportamento na memória

**Tipos de referência:** As classes se comportam na memória como referência, as váriaveis iniciados por tipo de classes não ocupam um espaço sequencial na memória, e sim, usam ponteiros para referenciar ao local *(heap)* de memória.

Variáveis referenciadas podem ser inicializadas, um lugar na memória para apontar, podem ser iniciadas com valor ```null```.

Quando iniciamos um tipo estruturado ```new```, os tipos estruturados (arrays e classes) são atribuídos com seus respectivos elementos neutros.

* Objeto: null
* boolean: false
* int: 0


**Tipos primitivos:** As variáveis que são declaradas com Classes padrão, *primitivas* do Java possuem um valor. Diferente das classes, ela não é uma referência, e sim, espaços literais no *stack* da memória. Os tipos primitivos eu já vi na primeira parte das anotações; byte, char, int, double, etc.

Diferente dos tipos de referência, os tipos primitivos precisam de um valor para ser inicializados.

**Tipos de Referência X Tipos de Primitivos**

| **Classes (Referênciados)** | **Valores (Primitivos)**  |
|:-----------------------:|:---------------------:|
| Vantagem: Recursos da Orientação Objeto. | Vantagem: Mais simples e performático. |
| Variáveis são ponteiros | Variáveis são espaços (caixas) |
| Precisam ser instanciados ```new``` ou apontar para outro objeto existente | Somente precisam ser declarados |
| Pode ser instánciados com um valor ```null``` | Não aceita valor ```null``` |
| Y=X: Assumem a mesma referência, Y aponta para o mesmo local que X. | Y=X: Y assume uma cópia literal do valor de X. |
| Objetos instanciados no *heap* | "Objetos" instanciados no *stack* |
| Objetos não utilizados são desalocados da memória não imediatamente pelo *garbage collector* | "Objetos" são desalocados imediatamente quando seu escopo é finalizado |

## Desalocação de memória

### Desalocação por garbage collector

O **Garbage Collector** é um processo que automatiza o gerenciamento de memória de um programa em execução. Monitora os objetos alocados dinamicamente pelo programa no *heap*, desalocando o que não estiver sendo usado.

```
// Exemplo

Product p1, p2;

p1 = new Product("Notebook", 4500.00, 28);
p2 = new Product("Modem", 300.00, 45);

p1 = p2;

\* p1 passa a referenciar o mesmo local que p2, o local na memória que perdeu a referência será deslocado pelo
garbage collector posteriormente \*
```

### Desalocação por escopo
São váriaveis declaradas em um determinado escopo são descartadas imediatamente ao final do escopo do programa.

```
// Exemplo
void method1() {
    int x = 10;
    if (x > 0) {
        int y = 20;
    }
    System.out.println(x);
}
\* A variável y é desalocada da memória ao final do escopo if. Nem adianta tentar chama-la posteriormente em outro comando do programa \*
```

## Arrays

Os *arrays* possuem apenas um atributo (```length```) e alguns métodos úteis;

| **Método/Atributo** | **Descrição** |
|-----------------------|-----------------|
|```length``` | Retorna o tamanho do array. |
|```Arrays.toString()``` | Converte o array em ```String```. |
|```Arrays.sort()``` | Ordena o array. |
|```Arrays.fill()``` | Preenche o array com um valor. |
|```Arrays.copyOf()``` | Copia um array faz a cópia de um array. |
|```Arrays.equals()```| Compara dois arrays (```bool```).  |
|```Arrays.binarySearch()```| Busca um elemento no array.  |
|```Arrays.asList()``` | Converte um array para ```List```.|

### Vetores
Vetores são *arrays* unidimensionais com estrura fixa. Ou seja, seu *tamanho* e *tipo* devem ser declarados na inicialização e são inalteráveis.
Os vetores são um tipo de array e herda seus atributos e métodos.

**Características:**

* Homogêneo (Dados do mesmo tipo);
* Tamanho fixo;
* Ordenados (podem ser acessados por meio índices ```[i]``` );
* Alocada uma única vez, em um único bloco contíguo de memória;

**Sintaxe**

```
// O tipo dos dados do array devem ser declarados na iniciazação
String[] vect = new String[n];

// Generalizando
Class[] vect = new Class[n]
```

### Listas

**Características:**

* Homogênea
* Ordenada
* Listas são classes do tipo ```List```
* Não possuem atributos
* Não possuí tamanho fixo, pode ser inicializada vázia e seus elementos são alocados sob demanda.
* Cada elemento ocupa um nó.
* Acesso sequencial aos elementos (devido a estrutura em nó);

**Sintaxe**
```
import java.util.ArrayList;
import java.util.List;

// Implementação da lista por meio de um array dinâmico
//ArrayList<E>;

List<String>  lista = new ArrayList<>;


// Implemetação de uma lista encadeada
LinkedList<E>;
```


| **Método** | **Descrição** |
|-----------------------|-----------------|
| ```size()``` | Retorna o tamanho da lista. |
| ```add(int index, Class elemento)``` | Adiciona um elemento na posição passada como argumento. |
| ```add(Class elemento)``` | Adiciona um elemento na posição final da lista. |
| ```get(int index)```| Retorna o elemento da posição do índice. |
| ```set(int index, Class elemento``` | Modifica o elemento no indíce correspondente ao índice.  |
| ```remove(int index)``` | Remove o elemento no índice especificado. |
| ```remove(Object elemento)``` | Remove a primeira ocorrência de um elemento específico. |
| ```removeIf(Predicado) ``` | Remove os elementos de uma lista condicionalmente. |
| ```clear() ``` | Remove todos os elementos da lista. |
| ```contains(0bject elemento)``` | Retorna ```true``` se o elemento existir na lista. |
| ```indexOf(obj)``` | Retorna a posição de um elemento na lista. |
| ```lastIndexOf(obj)``` | Retorna a posição da última ocorrência de um elemento na lista |
| ```isEmpty()``` | Retorna ```true``` se a lista estiver vázia. |
| ```stream()``` | Cria um fluxo de dados a partir de coleções como ```List```, ```Set```, ```Map``` |
| ```Collections.sort(List<Class> listName)``` | Ordena a lista em ordem crescente. |
| ```forEach``` | Itera os elementos da listas de forma mais simples. |

```
// Outras operações interessantes:

// Filtra os elementos condicionalmente
List<Integer> result = list.stream().filter(x -> x > 4).collect(Collectors.toList());

//Encontra a primeira ocorrência condicionalmente
Integer result = list.stream().filter(x -> x > 4).findFirst().orElse(null));

//Predicados são funções lambda
```

### Matrizes
Matrizes são arrays bidimensionais. Ou vetores de vetores.
Pela sua construção, matrizes não possuem atributos e métodos próprios. Mas podem ser aplicados à suas linhas todos os métodos disponíveis para
se trabalhar com arrays.

**Características:**

* Homogênea
* Ordenada
* Alocada uma única vez, em um único bloco contíguo de memória;

**Sintaxe**

```
// Matrix NxM
int[][] matrix = new int[n][m];

// Generalizando
Class[][] matrix = new Class[rows][columns];
```

## Wrapper Classes

São classes de tipo referência equivalentes aos respectivos tipos primitivos. Uma das vantagens dessa abordagem é que classes tipo de referência podem receber ```null``` como valor padrão (elemento neutro).

### Boxing

Processo de conversão de um objeto tipo primitivo para um objeto compátivel com sua Wrapper Class.

**Exemplo:**
```
int num = 10;
Integer obj = num;
```

### Unboxing

Processo inverso. Converte do tipo referência para tipo valor;

**Exemplo:**
```
Integer obg = 37;
int num = obj;
```
