# Orientação Objeto em Java

* **Classe:** Tipo estruturado de informação. Uma classe contêm:
    - ***Atributos:*** Dados, informação, caracteristicas inerentes àquele objeto.
    - ***Métodos:*** São funções, ou operações específicas usadas pela nossa classe.

* ****

## Membros estáticos

## Contrutor
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

| Classes (Referênciados) | Valores (Primitivos)  |
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

## Vetores

# Duvidas
