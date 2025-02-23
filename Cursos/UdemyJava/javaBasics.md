# Java

## Variáveis e Tipos Básicos

Em java, o tipo das variáveis devem ser especificadas ao serem declaradas.

*Sintaxe:* ```<tipo> <nome> = <valor inicial>```

Uma váriavel possuí:

    * Tipo;
    * Nome (Identificador);
    * Valor;
    * Endereço de Memória;


### Tipos de Variáveis

**Tipos Primitivos:** Armazenam informação (valores) diretamente na memória.

|  **Tipo** | **Bits** | **Descrição**      |     **Alcance**      |
|:-----:|:----:|:---------------|:----------------:|
| byte  | 8  | Valores Inteiros | -128 a 127       |
| short | 16 | Valores Inteiros | -2¹⁶ a (2¹⁶ - 1) |
| int   | 32 | Valores Inteiros | -2³¹ a (2³¹ - 1) |
| long  | 64 | Valores Inteiros | -2⁶³ a (2⁶³ - 1) |
| float | 32 | Valores Decimais | Precisão simples |
| double| 64 | Valores Decimais | Precisão Dupla   |
| char  | 16 |Caracteres Unicode| utf16 |
|boolean| 1  |Valores Booleanos | ```true``` or ```False```|

**Tipos de Referência:** Armazenam referências a objetos na memória (**Heap Memory**).

|  **Tipo**  | **Exemplo**                 |
|:----------:|:----------------------------|
| Strings    | ```String nome = "Java";``` |
| Arrays     | ```int[] numerical = {1,2,3,4};``` |
| Classes    | ```Person p = new PersonSameOldMistakes();``` |
| Interfaces | ```Runnable r = new showThread();``` |
| Enums      | ```DiaSemana hoje = DiaSemana.SEGUNDA;```|

**Obs:** O valor padrão de cada tipo primitivo de váriaveis são seus respectivos elementos neutros.

**Obs:** Variáveis possuem escopo de acordo com a estrutura que ela seja iniciada.


## Saída de Dados

A formatação dos valores float através das máscaras é semelhante ao que já conheço de python. Sintaxe: ```("%.3f")```


```
System.out.println(outputData); # Possui quebra de linhas no final.
System.out.print(outputData); # Não possuí quebra de linhas no final.
System.out.printf(outputData); # Permite aplicar máscara para números flutuantes

```

### Máscaras

**Especificadores de Tipo**(*Place Holder*)

|  **Máscara** | **Descrição**         | **Exemplo** *(System.out.printf(outputData))*   | **Output**           |
|:--------:|:--------------------------|:-----------------------------------------:|:-----------------|
| ```%d``` | Números inteiros decimais | ```System.out.printf("%d", 37);```        | ```37```         | 
| ```%f``` | Números reais decimais    | ```System.out.printf("%.2f", 3.14159);``` | ```3.14```       | 
| ```%e``` | Notação científica        | ```System.out.printf("%e", 12345.6789);```| ```1.2345678e+04``` | 
| ```%g``` | Notação mais compacta (%e ou %f) |```System.out.printf("%g", 12345.6789);```| ```12345.7``` | 
| ```%c``` | Caractere Unicode         | ```System.out.printf("%c", A);```         | ```A```          | 
| ```%s``` | String                    | ```System.out.printf("%s", "Romeo");```    | ```Romeo```      | 
| ```%b``` | Boolean                   | ```System.out.printf("%b", true);```      | ```true```       | 
| ```%o``` | Inteiro em Octal (2⁸)     | ```System.out.printf("%o", 10);```        | ```12```         | 
| ```%x``` | Inteiro em Hexadecimal    | ```System.out.printf("%x", 255);```       | ```ff```         | 
| ```%n``` | Quebra de linha (*\n*)    | ```System.out.printf("Olá%nMundo");```    | ```Olá``` ```Mundo```| 


**Modificadores de Formato**

| **Máscara**| **Descrição**                       | **Exemplo** *(System.out.printf(outputData))*|**Output**          |
|:----------:|:------------------------------------|:--------------------------------------------:|:-------------------|
| ```%Xn```  | Largura Mínima (espaços à esquerda) | ```System.out.printf("\|%10s\|", "Java");``` | ```\|    Java\|``` | 
| ```%05d``` | Preenche a largura definida com zeros à esquerda | ```System.out.printf("%05d", 3.14);``` | ```003.14```| 
| ```%-nX``` | Alinhamento à direita        | ```System.out.printf("\|%-10s"\|, "Java");```       | ```\|Java     \|```| 
| ```%.nf``` | Nº de Casas decimais         | ```System.out.printf("%.2f", 12345.6789);```        | ```12345.68```     | 
| ```%,d```  | Separador de Milhares        | ```System.out.printf("%,d", 1000000000);```         | ```1.000.000.000```| 
| ```%+d```  | Sinal Explicito              | ```System.out.printf("%+d", 37);```                 | ```+37```          | 
| ```%#X```  | Adiciona prefixo em octais e hexadecimais | ```System.out.printf("%b", true);```   | ```true```         | 

**Obs:** É possivel juntar diversos modificadores para criar formatos personalizados.

```
// Para usar o separador no padrão americano

import java.util.Locale;
Locale.setDefault(Locale.US);

```

## Entrada de Dados

### Scanner
Em Java, para o usuário realizar um input precisa importar o "Scanner".

```
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
sc.close(); // Necessario para encerrar a classe scanner.
```

Existem várias formas de iniciar o Scanner. Essa variadade é para controlar os tipos de inputs serão atribuídos aos tipos de suas respectivas váriaveis. (Quase todos)

**Sintaxe:**

| **Método**|**Tipo de entrada**                 |
|:----------:|:----------------------------------|
| ```nextInt();```| Inteiro  |
| ```nextDouble();``` | Decimal (*Double*) |
| ```nextFloat();``` | Decimal (*Float*) |
| ```nextBoolean();``` | Booleano  |
| ```next();```  | Input de palavra (Até o primeiro espaço) |
| ```nextLine();```  | Input de uma frase inteira. | 
| ```next().charAt(n)``` | Input um caracter em uma linha de texto |

**Obs**: Ao realizar inputs de qualquer *next* de qualquer tipo, ao pressionar enter, fica uma quebra de linha pendendente no scanner. Que pode ser consumido pelo pelo próximo comando do tipo ```nextLine()```. A solucão é justamente chamar um comando ```nextLine()``` vázio para consumir essa quebra linha.


### BufferedReader


### Console (Aplicações Console)

### Argumentos da Linha de comando

### JOption Pane (Interface Gráfica)


## Funções Matemáticas

### Operadores Matemáticos

| **Operadores**           | **Descrição**                     |
|:--------------------:|:----------------------------------|
| ```+``` | Adição;   |
| ```-``` | Subtração; |
| ```*``` | Multiplicação; |
| ```/``` | Divisão; |
| ```%``` | Módulo (resto da divisão); |

### Operadores de atribuição cumulativa

| **Operadores**       | **Expressão**                     |
|:--------------------:|:----------------------------------|
| ```=```  | ```Atribuição```|
| ```+=``` | ```x = x + 5``` |
| ```-=``` | ```x = x - 5``` |
| ```*=``` | ```x = x * 5``` |
| ```/=``` | ```x = x / 5``` |
| ```%=``` | ```x = x % 5``` |

### Operadores de Incremento e Decremento

| **Operadores**       | **Descrição**   |
|:--------------------:|:----------------|
| ```++x``` | Pré-incremento |
| ```x++``` | Pós-incremento |
| ```--x``` | Pré-decremento |
| ```x--``` | Pós-decremento |




### Funções Básicas

| **Função**           | **Descrição**                     |
|:--------------------:|:----------------------------------|
| ```math.abs(x);```   | Retorna o valor absoluto de x;   |
| ```math.max(a,b);``` | Retorna o maior valor entre as duas entradas; |
| ```math.min(a,b);``` | Retorna o menor valor entre as duas entradas; |
| ```math.sqrt(x);```  | Retorna a raiz quadrada de x; |
| ```math.cbrt(x);```  | Retorna a raiz cúbica de x; |
| ```math.pow(a, b);```| Retorna a potência de ```a^b```; | 
| ```math.exp(x); ```  | Logaritmo natural ```e^x```; |


### Funções de Arredondamento

| **Função**           | **Descrição**                     |
|:--------------------:|:----------------------------------|
| ```math.round(x);``` | Arredonda um valor decimal para o número inteiro mais próximo;   |
| ```math.ceil(x);```  | Arredonda para cima; |
| ```math.min(a,b);``` | Arredonda para baixo;|
| ```math.rint(x);```  | Arredonda para o inteiro mais próximo;|

### Funções Trigonómetricas (rad)

| **Função**           | **Descrição**                     |
|:--------------------:|:----------------------------------|
| ```math.sin(x);``` | Função Seno;   |
| ```math.cos(x);```  | Função cosseno; |
| ```math.tan(b);``` | Função tangente;|
| ```math.asin(x);```  | Função arcosseno;|
| ```math.acos(x);``` | arcocosseno;   |
| ```math.atan(x);```  | Função tangente; |
| ```math.toRadians(graus);``` | Converte de graus para radianos;|
| ```math.toDegrees(x);```  | Converte de radianos para graus;|

### Logaritmos

| **Função**           | **Descrição**                     |
|:--------------------:|:----------------------------------|
| ```math.log(x);``` | Logaritmo natural na base e;   |
| ```math.log10(x);```| Retorna a logaritmo na base 10;|

### Gerando números aleatórios

| **Função**           | **Descrição**                     |
|:--------------------:|:----------------------------------|
| ```Math.random();```  | Retorna número infinitesimal aleatório |
| ```(int) (math.random() * (max - min + 1) + min);``` | Gera um número inteiro aleatório entre min e max. |

### Constantes

| **Função**           | **Descrição**                     |
|:--------------------:|:----------------------------------|
| ```Math.Pi```  | 3.14159 |
| ```Math.E```   | 2,71828 |


## Operadores Matemáticos

### Operadores Comparativos

| **Operador**           | **Descrição**                     |
|:--------------------:|:----------------------------------|
| ```>```  | Maior |
| ```<```  | Menor |
|```>=```  | Maior/igual |
|```<=```  | Menor/igual |
|```==```  | Igualdade |
|```!=```  | Diferente |

### Operadores Lógicos

| **Operador**           | **Descrição**                   |
|:--------------------:|:----------------------------------|
| ```&&```  | E |
| ```\|\|```| Ou |
| ```!```    | Negação |

### Operadores bitwise
Realizam operações lógicas básicas bit a bit. (Eletrônica digital).
| **Operador**           | **Descrição**                   |
|:--------------------:|:----------------------------------|
| ```&```  | AND |
| ```\|``` | OR  |
| ```^```  | XOR (OR exclusivo) |

## Estruturas Condicional

### *If's*

**Sintaxe:**

```
if (condição1) {
    comando1;
    comando2;
}
else if (condição2) {
    comando3;
    comando4;

}
else if (condição3) {
    comando5;
    comando6;

}

else {
    comando7;
    comando8;

}

```

### *switch-case*

**Sintaxe:** 

```
switch (expressao) {

case valor1:
    comando1;
    comando2;
    break;

case valor2:
    comando3;
    comando4;
    break;

default:
    comando5;
    comando6;
    break;
}
```

**Exemplo:**

```
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String dia;

        switch (x) {

        case 1:
            dia = "domingo";
            break;

        case 2:
            dia = "segunda";
            break;

        case 3:
            dia = "terca";
            break;

        case 4:
            dia = "quarta";
            break;

        case 5:
            dia = "quinta";
            break;

        case 6:
            dia = "sexta";
            break;

        case 7:
            dia = "sabado";
            break;

        default:
            dia = "valor invalido";
            break;

        }

        System.out.println("Dia da semana: " + dia);
        sc.close();
    }
}
```

### Condição ternária.
Estrutura opcional ao *if-else*, facilita escrever valores e atribui-los a váriaveis com base em uma condição;


**Sintaxe**
```( condição) ? valor_True : valor_False;```

**Exemplo**
``` double desconto = (preco < 20.0) ? preco * 0.1 : preco * 0.05; ```

## Estruturas de repetição

### *while*

Estrutura recomendada quando não se sabe a quantidade de repetições necessárias na estrutura.

**Sintaxe**
``` 
while (condição) {
    comando1;
    comando2;
}

```

**Exemplo**
``` 
while (x != 0){
    int x = sc.nextInt();
}
```

### *for*

**Sintaxe**
```
for (inicio; condição; incremento) {
    comando1;
    comando2;
}
```

**Exemplo**
```
for (int i = 3; i > 0; i--); {
    System.out.printf("%d!",i);
}
```

### *do-while*
Estrutura interessante pois garante que os comandos serão executados ao menos uma vez, antes de verificar a condição de repetição.
**Sintaxe**

```
do {
    comando1;
    comando2;
} while(condição);
```

## Manipulação de Strings

### Métodos
Principais métodos da Classe *String*.

| **Método**           | **Descrição**                   |
|:--------------------:|:----------------------------------|
| ```texto.length();```  | Retorna o comprimento da string; |
| ```texto.equals(outraString);``` | Retorna se uma string é EXATAMENTE igual a outra (caso sensitivo);  |
| ```texto.equalsIgnoreCase(outraString);```  | Ignora a diferença de caps do texto na relação de igualdade; |
| ```texto.toUpperCase();``` | Converte texto para maiúsculas; |
| ```texto.toLowerCase();``` | Converte texto para minúsculas; |
| ```texto.chatAt(index); ```| Retorna baseado no index; |
| ```texto.contains("subString"); ``` | Verifica se uma string contêm algum fragmento de texto (output booleano); |
| ```texto.replace("word", "palavra"); ```| Troca as ocorrências de um fragmento de texto por outra string; |
| ```texto.substring(index1, index2); ``` | Recorte parte de uma string; |
| ```texto.split('char');``` | Divide uma string em substrings baseado em algum caractere separador passado no argumento; |
| ```texto.trim();``` | Remove todos os espaços em branco desnecessários; |
| ```palavra.toCharArray();``` | Converte a string em um array (lembrando que a váriavel array deve ser devidamente atribuída); |
| ```String.valueOf(classVariable)``` | Converte outros tipos para string( Não esquecer da devida atribuição de váriavel). |

```
StringBuilder sb = new StringBuilder("Olá");
sb.append(", mundo!");
System.out.println(sb); // "Olá, mundo!"

sb.insert(4, " Java"); 
System.out.println(sb); // "Olá Java, mundo!"

sb.reverse();
System.out.println(sb); // "!odnum ,avaJ álO"
```
## Comentários

Comentários longos
``` 
/* Eu quero ficar perto de tudo que acho certo
Até o dia em que eu mudar de opinião
A minha experiência meu pacto com a ciência
Meu conhecimento é minha distração

Coisas que eu sei
Eu adivinho sem ninguém ter me contado
Coisas que eu sei
O meu rádio relógio mostra o tempo errado (aperte o play)

Eu gosto do meu quarto do meu desarrumado
Ninguém sabe mexer na minha confusão
É o meu ponto de vista não aceito turistas
Meu mundo tá fechado pra visitação

Coisas que eu sei
O medo mora perto das ideias loucas
Coisas que eu sei
Se eu for eu vou assim não vou trocar de roupa (é minha lei)

Eu corto os meus dobrados acerto os meus pecados
Ninguém pergunta mais depois que eu já paguei
Eu vejo o filme em pausas eu imagino casas
Depois eu já nem lembro do que eu desenhei

Coisas que eu sei
Não guardo mais agendas no meu celular
Coisas que eu sei
Eu compro aparelhos que eu não sei usar (eu já comprei)

Às vezes dá preguiça na areia movediça
Quanto mais eu mexo mais afundo em mim
Eu moro num cenário do lado imaginário
Eu entro e saio sempre quando tô afim

Coisas que eu sei
As noites ficam claras no raiar do dia
Coisas que eu sei
São coisas que antes eu somente não sabia

Coisas que eu sei
As noites ficam claras no raiar do dia
Coisas que eu sei
São coisas que antes eu somente não sabia (agora eu sei)

Agora eu sei
Agora eu sei */

```
Comentários curtos

``` // Só sei que nada sei ```

## Funções

Sintaxe da declaração de funções, funções em orientação objeto são chamadas de métodos;

```
public static class (class input1, class input2, class input3) {
//class define do tipo de dados que será retornado no output, e o tipo de dado que será aceito no input)

    Série;
    De;
    Comandos;
    Para;
    Solução;
    Da;
    Tarefa;

    return output;
}

```

