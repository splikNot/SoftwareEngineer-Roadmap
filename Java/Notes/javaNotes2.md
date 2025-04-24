# Anotações Java 2  - Orientação Objeto

* **Classe:** Tipo estruturado de informação. Uma classe contêm:
    - ***Atributos:*** Dados, informação, caracteristicas inerentes àquele objeto.
    - ***Métodos:*** São funções, ou operações específicas usadas pela nossa classe.


## Membros estáticos

## Construtor
Comandos executados no momento da instanciação do objeto. Iniciam os atributos com valores padrões no momento que a classe é chamada ```new```.
Caso um construtor não for especificado, a classe disponibilza o construtor padrão, que inicia as variáveis com seus valores de referência.  

**Exemplo:**

``` Java

public class Order {

    private Integer id;
    private Date moment;
    private OrderStatus status;

    public Order(Integer id, Date moment, OrderStatus status){
        this.id = id;
        this.moment = moment;
        this.status = status;
    }
}

```

### Comando "this"

O comando this é usado dentro de uma classe para se referir ao objeto atual. Ou seja, à própria instância da classe em que o código está sendo executado. Muito semelhante ao comando ```self``` em python.

**Exemplos:**

1. Diferenciar atributos e parâmetros com o mesmo nome.

``` Java

public class Pessoa {
    String nome;

    public Pessoa(String nome) {
        this.nome = nome;  // 'this.nome' é o atributo, 'nome' é o parâmetro
    }
}

/*Sem o this, o Java usaria o parâmetro nome nas duas pontas da atribuição — o que não mudaria o valor do atributo da classe.*/

```

2. Chamar outro construtor da mesma classe.

``` Java
public class Produto {
    String nome;
    double preco;

    public Produto(String nome) {
        this(nome, 0); // chama o outro construtor
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
```
3. Passar objeto atual como argumento:

``` Java

public class Conta {
    public void mostrar() {
        System.out.println("Essa é a conta: " + this);
    }

    public void comparar(Conta outra) {
        if (this == outra) {
            System.out.println("Mesma conta!");
        }
    }
}

```

4. Chamar métodos dentro da mesma instância:

``` Java

public void iniciar() {
    this.carregar(); // mesma coisa que só chamar carregar(), mas mais explícito
}

```

### Sobrecarga

É a prática de criar vários métodos com o mesmo nome, mas com parâmetros diferentes. Isso permite reutilizar o nome de um método para fazer coisas similares com diferentes tipos de dados. Podemos realizar sobrecarga mudando:

1. O número de parâmetros.
2. Os tipos dos parâmetros.
3. A ordem dos parâmetros

**Não é sobrecarga alterar apenas o tipo de valor retornado em uma operação, isso causa erro de compilação.**

**Exemplo:**

``` Java

// Todos os métodos possuem a mesma assinatura, porém diferentes parâmetros.

public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public double somar(double a, double b) {
        return a + b;
    }

    public int somar(int a, int b, int c) {
        return a + b + c;
    }
}

```

Podemos também realizar a sobrecarga de construtores, que segue a mesma lógica. Queremos usar multiplas formas de iniciar um construtor.

``` Java

public class Pessoa {
    String nome;
    int idade;

    // Construtor 1 - sem parâmetros
    public Pessoa() {
        this.nome = "Desconhecido";
        this.idade = 0;
    }

    // Construtor 2 - só nome
    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = 0;
    }

    // Construtor 3 - nome e idade
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

```

## Encapsulamento

Encapsulamento é uma forma de proteger o seu programa e informação de acessos externos. A ideia central é esconder os detalhes internos de uma classe e controlar o acesso a seus dados. Mantendo suas informações privadas e só serem acessadas através de **getters/setters**

**Exemplo:**

``` Java

public class Pessoa {
    private String nome;  // atributo encapsulado

    // Getter
    public String getNome() {
        return nome;
    }

    // Setter
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
}

```

Suas vantagens são:

1. Segurança: Impede que dados sejam alterados de forma errada.
2. Controle: Você define como os dados podem ser acessados/modificados.
3. Manutenção fácil: Se mudar a lógica interna, o código externo continua funcionando.
4. Reuso e organização: Classes bem definidas e independentes.

## Modificadores de Acesso

Determinam **quem pode acessar o quê** — atributos, métodos, classes etc.

**Tipos de modificadores:**

| **Modificador** | **Escopo** |
|:-:| :- |
|`public` | Qualquer classe, de qualquer lugar. |
| `private` | Somente dentro da própria classe. |
| `protected` | Na mesma classe, no mesmo pacote ou em subclasses (mesmo fora do pacote). |
| (sem nada) (default ou package-private) | Apenas dentro do mesmo pacote. |

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

### Desalocação de memória

#### Desalocação por garbage collector

O **Garbage Collector** é um processo que automatiza o gerenciamento de memória de um programa em execução. Monitora os objetos alocados dinamicamente pelo programa no *heap*, desalocando o que não estiver sendo usado.

``` Java
// Exemplo

Product p1, p2;

p1 = new Product("Notebook", 4500.00, 28);
p2 = new Product("Modem", 300.00, 45);

p1 = p2;

// p1 passa a referenciar o mesmo local que p2, o local na memória que perdeu a referência será deslocado pelo garbage collector posteriormente.
```

#### Desalocação por escopo
São váriaveis declaradas em um determinado escopo são descartadas imediatamente ao final do escopo do programa.

``` Java
// Exemplo
void method1() {
    int x = 10;
    if (x > 0) {
        int y = 20;
    }
    System.out.println(x);
}
// A variável y é desalocada da memória ao final do escopo if. Nem adianta tentar chama-la posteriormente em outro comando do programa.
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

``` Java
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

``` Java
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

``` Java
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

``` Java
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

``` Java
int num = 10;
Integer obj = num;
```

### Unboxing

Processo inverso. Converte do tipo referência para tipo valor;

**Exemplo:**

``` Java
Integer obg = 37;
int num = obj;
```

## Herança

Associação que permite que uma classe herde as caracteristicas, atributos, métodos e comportamentos de outra classe.

```extends``` é a **sintaxe** usada para declarar que uma classe é herdeira de outra.

**Exemplo:**

``` Java
class Animal {
    String nome;

    void emitirSom(){
        System.out.println("O animal faz um som")
    }
}

class Dog extends Animal {
    void swigTail(){
        System.out.println("Balançando o rabo");
    }
}

public class Main {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro();
        dog.nome = "Rex";
        
        System.out.println("Nome: " + dog.nome);
        dog.emitirSom();  // Método herdado da classe Animal
        dog.abanarRabo(); // Método específico da classe Cachorro
    }
}

```

**Definições**

* ```Superclasse``` (Classe Base) / ```Subclassse``` (classe derivada).
* Para uma classe herdar os contrutores presentes na classe pai usamos ```super(atributo1, atributo2, atributo3)```
* Heranç aé uma associação entre classes, e não entre objetos. Ou seja, quando instanciamos, não estamos criando dois objetos. E sim um objeto com os atributos/métodos de ambas as classes.

### Upcasting e Downcasting

**Upcasting:** Quando uma classse filha é atribuída à uma váriável do tipo da mãe/pai.

**Downcasting:** Processo inverso, uma classe do tipo pai é atribuida à uma váriavel do tipo filha.

## Polimorfismo

Polimorfismo permite que a mesma ação (métodos ou funções) tenham diferentes comportamentos.

### Polimorfismo de Sobrescrita

A função/método precisa ser precedida pela declaração ```@Override```, desta forma mantendo a sua assinatura, mas possuindo uma diferente implementação.

**Exemplo:**

``` Java
class Animal {
    void emitirSom() {
        System.out.println("O animal faz um som.");
    }
}

class Gato extends Animal {
    @Override
    void emitirSom() {
        System.out.println("Miau! Miau!");
    }
}

class Cachorro extends Animal {
    @Override
    void emitirSom() {
        System.out.println("Au Au!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal meuAnimal = new Gato(); // Polimorfismo
        meuAnimal.emitirSom(); // Executa a versão do método na classe Gato

        meuAnimal = new Cachorro(); // Agora o mesmo objeto se comporta como um cachorro
        meuAnimal.emitirSom(); // Executa a versão do método na classe Cachorro
    }
}
```
### Polimorfismo de Sobrecarga

Semelhante a sobrecarga de construtores, podemos fazer a sobrecarga de métodos. Desta forma podemos declarar métodos com mesmo nome, mas diferentes parâmetros.

**Exemplo:**

``` Java
class Calculadora {
    int somar(int a, int b) {
        return a + b;
    }

    // Mesma função, mas agora com três parâmetros
    int somar(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        
        System.out.println("Soma de 2 números: " + calc.somar(2, 3));
        System.out.println("Soma de 3 números: " + calc.somar(2, 3, 4));
    }
}
```


### Observações;

* Comando ```final``` na declaração de um método, ou classe, informa que aquela classe e método não podem ser herdados por uma outra classe.

* Comando ```super()``` é usada para chamar a implementação da superclasse. Pode ser usada tanto nos contrutores, para realizar a inicialização dos atributos da superclasse. Quanto podem ser chamandos em métodos, executando os métodos da superclasse.

* Os tipos abstratos podem ser usados para declarar tipos de váriaveis e listas, mas não esquecer. **Não** pode ser declarado como as classes comuns.

! neofetch