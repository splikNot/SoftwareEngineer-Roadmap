# Anotações Java 3

## Data e hora

A [ISO 8601](https://pt.wikipedia.org/wiki/ISO_8601) é uma norma internacional para representação de data e hora emitida pela Organização Internacional para Padronização (International Organization for Standardization, ISO).

```É UMA BOA PRÁTICA ARMAZENAR UTCs PARA EXIBIR EM DIFERENTES REGIÕES```

### Data/hora local
* ```Ano-mês-dia-[hora]``` sem fuso horário.
* Hora opcional
* Usado quando o momento exato não é tão importante


### Data/hora global
* ```Ano-mês-dia-hora``` com fuso horário.
* Usado quando se exige precisão.
* 

### Timezone (fuso)
* *Timestamps* : Representam ponto fixo no tempo, prioritamente em ```UTC```.
* GMT
* UTC

Algumas linguagens usam nomes da região para timezone:
* "US/Pacific"
* "America/Sao_Paulo"

### Classes do pacote ```java.time```

| **Classe** | **Descrição** |
|:----------:|---------------|
|```LocalDate``` | Apenas Data (YYYY-MM-DD). |
|```LocalTime``` | Apenas hora (HH\:mm\:ss). |
|```LocalDateTime``` | Data e hora, sem fuso. |
|```ZoneDateTime``` | Data e hora, com fuso. |
|```Instant``` | Representa o tempo em UTC, útil para *timestamps*. |
|```ZoneId``` | Fuso horário. |


**Sintaxe e Exemplos:**

``` Java
// Obter data e hora

import java.time.*;
import java.time.format.DateTimeFormatter;

LocalDate dataAtual = LocalDate.now(); // 2025-02-05
LocalTime horaAtual = LocalTour.time(); // 14:30:15.123
LocalDateTime dataHoraAtual = LocalDateTime.now(); //  2025-02-05T14:30:15.123


// Trabalhando com fuso:
ZoneId = fusoSP ZoneId.("America/Sao_Paulo");
ZoneDateTime dataHoraSP = ZoneDateTime.now(fusoSP);

// Para listar todos os fusos:
System.out.println(ZoneId.getAvaibleZoneIds());

// Convertendo fusos:
ZoneDateTime agoraSP = ZoneDateTime.now(ZoneId.of("America/Sao_Paulo));
ZoneDateTime agoraNY = agoraSP.withZoneSameInstant(ZoneId.of(America/New_York"));

// Timestamps (Instant);
Instant agora = Instant.now();

// Convertendo entre Instant e ZonedDateTime
ZonedDateTime datahoraSP = agora.atZone(ZoneId.of("America/Sao_Paulo"));

// Formatando Datas e Horas
LocalDateTime agora = LocalDateTime.now();
DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // 05/02/2025 14:30:15
agora.format(formato);

// Convertendo String para Data
String dataStr = "25/12/2025 14:30:15";
// Convertendo para o padrão de saída LocalDateTime #2025-12-25T14:30:15
LocalDateTime dataConvertida = LocalDateTime.parse(dataStr, formato);

// Operações com datas
LocalDate data = LocalDate.now();
LocalDate maisUmaSemana = data.plusWeeks(1); 
LocalDate menosCincoDias = data.minusDays(5);

// Calculando Diferenças de tempo
import java.time.temporal.ChronoUnit;

//Entre Minutos
LocalTime inicio = LocalTime.of(9, 30); //(hora,minutos)
LocalTime fim = LocalTime.of(12, 15);
long = diferencaMinutos = ChronoUnit.MINUTES.between(inicio, fim);

// Entre Datas
LocalDate data1 = LocalDate.of(2023,2,5);
LocalDate data2 = LocalDate.of(2025,2,7);

Period periodo = Period.between(data1,data2);
System.out.println("Diferença: " + periodo.getYears() + "anos, " + periodo.getMonths() + "meses, " + periodo.getDays() + "dias.");
```

## Tipos Enumerados

Serve para representar um conjunto fixo constantes nomeadas. Desta forma melhorando a semântica, deixando o código mais legível, evitando valores inválidos e possuem métodos/atributos próprios.

Por exemplo, um pedido na internet passa pelos processos: ```Aguardar Pagamento``` **-->** ```Processar o pedido``` **-->** ```Despachar``` **-->** ```Entregar```.

Sintaxe dos tipos especiais ```enum```:

``` Java
package entities.enum;

public enum OrderStatus {

// Ciclos do Processo

    PENDING_PAYMENT,
    PROCESSING,
    SHIPPED,
    DELIVERED;
}

```
E então na classe podemos passar os tipos enumerados,

```Java
import entities.enums.OrderStatus;
import java.util.Date;

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

Enums podem conter atributos, construtores e métodos, tornando-os mais versáteis.

``` Java
enum PermissionsLevel {
    ADMIN(3), MODERATOR(2), USER(1);

    private int level;

    PermissionsLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return level;
    }
}

public class Main {
    public static void main(String[] args) {
        PermissionLevel user = PermissionLevel.USER;
        System.out.println("USER LEVEL: " + user.getLevel());
    }
}
```

```Tipos enumerados podem ser passados em argumentos de funções, tipos de listas e como atributos em objetos da mesma forma que fazemos com classes```

### Métodos Dos Tipos Enumerados

| **Método** | **Descrição** |
|:------:|:-----|
| ```values()``` | Retorna um array com todas as constantes em um objeto do tipo *enum*. |
| ```valueOfString(stringName)``` | Converte umas string para o respectivo valor *enum*. |
| ```ordinal()``` | Retorna o índice da constante dentro do *enum* (Começa no zero). |
| ```name()``` | Retorna o nome da constante como String. |
| ```toString()``` | Converte o valor *enum* para string. |
| ```compareTo(typeEnum)``` | Compara duas constantes do *enum*. |
| ```getDeclaringClass``` | Retorna a classe do *enum* a qual a constante pertence. |
| ```clone()``` | Impede a clonagem de um tipo *enum*, isso garante a singularidade.|

## Tipos Abstratos

Classes abstratas são classes que não podem ser instanciadas, elas servem modelo, assim garantindo que todas as caracteristicas de uma classe seja herdada. Em sua implementação, podem ser criados **métodos concretos**, que possuem implementação, e **métodos abstratos**. Esses últimos, por sua vez, precisam ser implementados na classe que os herdará. 

**Resumindo:**

* Classes abstratos são declaradas por ```abstract```
* Não podem ser instanciadas diretamente.
* Podem ter métodos abstratos (sem corpo) e métodos concretos (com corpo).
* São usadas como modelo para outras classes. Criando assim uma estrutura base para classes que compartilham características.
* As classes que a herdam devem implementar seus métodos abstratos.

**Exemplo:**

``` Java
// Classe abstrata
abstract class Animal {
    String nome;

    // Método concreto (com implementação)
    void dormir() {
        System.out.println(nome + " está dormindo.");
    }

    // Método abstrato (sem implementação)
    abstract void fazerSom();
}

// Classe concreta que herda de Animal
class Cachorro extends Animal {
    Cachorro(String nome) {
        this.nome = nome;
    }

    // Implementação do método abstrato
    @Override
    void fazerSom() {
        System.out.println(nome + " faz: Au Au!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Animal animal = new Animal();  // ERRO: Não pode instanciar classe abstrata
        Cachorro dog = new Cachorro("Rex");
        
        dog.dormir();   // Método concreto herdado
        dog.fazerSom(); // Método abstrato implementado na subclasse
    }
}

```

### Métodos abstratos

Como mencionado anteriormente, são métodos que não precisam ser implementados. Representam métodos genéricos à qualquer classe que os herdarem.
Métodos abstrados são declarados como:

``` Java
abstract void metodoAbstrato();
```

## Exceções

Exceções são condições de erros ou comportamentos inesperados, interrompendo assim o fluxo de funcionamento do Programa. Em Java, as exceções são objetos herdados da classe ```Throwable```.

Quando uma exceção é lançada, ela é propagada na pilha de chamadas (**stack trace**). a pilha de chamadas é uma estrutura pilha que armazena a camada de execução de um método ou função, por exemplo, um método chamado por uma classe, dentro de outra classe, dentro de uma função principal.

``` Java
public class Exemplo {
    public static void main(String[] args) {
        try {
            int resultado = 10 / 0; // Isso gera ArithmeticException
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: divisão por zero!");
        } finally {
            System.out.println("Este bloco sempre é executado.");
        }
    }
}
```

### Hierarquia de exceções


https://docs.oracle.com/javase/10/docs/api/java/lang/package-tree.html


```
    Throwable
        |
        ---> Error
        |      |
        |      ---> OutOfMemoryError
        |      |
        |      ---> VirtualMachineError
        |
        |
        ---> Exception
                | 
                ---> IOFException    // Erros de entrada ou saída de dados.
                |
                ---> RuntimeException   // Erros que não necessariamente precisam ser tradados (mas geralmente tem sim)
                            |
                            ---> IndexOutOfBoundsException
                            |
                            ---> NullPointerException

```

* A classe Error são problemas onde o programador não tem acesso, como o limite memória e erro na maáquina virtual do compilador.
* A classe Exception são erros gerados pelo programador e problemas em seu código.

[Hierarquia completa e diferentes tipos de exceções](https://docs.oracle.com/javase/10/docs/api/java/lang/package-tree.html).

As exceçoes mais comuns são:

| **Exceção**       | **Descrição**     |
|:-------------------:|:----------------|
| ```ArithmeticException``` | Divisão por zero. |
| ```NullPointerException ``` | Usar algo que é null. |
| ```ArrayIndexOutOfBoundsException``` | Índice inválido em array. |
| ```IOException``` | Erros de entrada/saída (como arquivos).|
| ```FileNotFoundException``` | Arquivo não encontrado. |
| ```NumberFormatException``` | Conversão inválida de String para número. |

### Pilha de chamadas

A call stack (pilha de chamadas) é uma estrutura de dados do tipo LIFO (Last In, First Out) usada pela JVM (Java Virtual Machine) para controlar a execução dos métodos. (by: GPT).

**Exemplo:**

``` Java
public class Main {
    public static void main(String[] args) {
        metodoA();
    }

    static void metodoA() {
        metodoB();
    }

    static void metodoB() {
        System.out.println("Olá da pilha!");
    }
}
```

Na pilha, as chamadas ficariam:

1. ```main()``` é chamado → entra na pilha

2. ```metodoA()``` é chamado por main() → entra na pilha

3. ```metodoB()``` é chamado por metodoA() → entra na pilha

4. ```System.out.println()``` é chamado → entra e sai rapidamente

5. ```metodoB()``` termina → sai da pilha

6. ```metodoA()``` termina → sai da pilha

7. ```main()``` termina → sai da pilha

(Como que  GPT faz setinha?)

Quando ocorre uma exceção, o Java imprime o **rastreamento** da pilha (stack trace) mostrando o caminho dos métodos até o erro:

``` Terminal
Exception in thread "main" java.lang.ArithmeticException: / by zero  
    at Main.metodoB(Main.java:12)  
    at Main.metodoA(Main.java:8)  
    at Main.main(Main.java:4)
```

A pilha de chamadas de possuí um limite de espaços, quando excedida, temos o que conhecemos como ```StackOverflowError```.

**Exemplo:**

``` Java
public class RecursaoInfinita {
    public static void main(String[] args) {
        chamar();
    }

    public static void chamar() {
        chamar(); // recursão infinita!
    }
}
```

Desta forma, resultando em:

``` Terminal
Exception in thread "main" java.lang.StackOverflowError
```


### Tratamento de Exceções

**Boas Práticas:**

Exemplo de como um projeto deve ser estruturado para tratar as exceçoes corretamente:

``` Java
// Criando uma classe que herda as exceções

package entities.exceptions;

// Nosso erro herda as exceções
public class WithdrawException extends Exception {

    private static final long serialVersionUID = 1L;

    public WithdrawException(String msg){
        super(msg);
    }
}

```


``` Java
// A lógica de operações que podem ocasionar em uma excessão devem ser tratadas no objeto em questão
// No caso vou ignorar os contrutores, getters e setters de minha classe e mostrar apenas o método que pode chamar a exceção

   public void withdraw(Double amount) throws WithdrawException{

        if (amount > withdrawLimit){
            throw new WithdrawException("Invalid Value: WithDraw limit exceded");
            
        }

        else {
            balance -= amount;
        }
    }


```

``` Java
// Os erros então são tratados dentro do programa principal através dos blocos try-catch;

try {
// Execução normal do programa;
}

catch (WithdrawException e){
            System.out.println("Above withdraw limit: " + e.getMessage());
}
catch (RuntimeException e) {
            System.out.println("Unexpect Value");
}

```




| Bloco | Descrição |
|:------------:|:---------------------------------------|
| ```try``` | Executa um erro que pode ocasionar em um erro.|
| ```catch``` | Trata os erros capturados pelo ```try```. |
| ```finally``` | Executa um comando ao final da execução do programa, independente se encontrar um erro ou não |
| ```throw``` | Lança um erro personalizado ou criado pelo programador. |
| ```throws``` | Declara a um método ou função, qual tipo de erro que pode ser lançado. |


#### Try-Catch

Os blocos ```try-catch``` são a principal forma de tratar as exceções.

* Bloco ```try``` contém o código que representa a execução normal do trecho de um código que pode acarrecar alguma exceção.
* Bloco ```catch``` Contém o código a ser executado caso ocorra uma exceção. O tipo de exceção deve ser especificada para ser tratada (Upcasting é permitido).

**Exemplo:**

``` Java
try {
    int[] numeros = {1, 2, 3};
    System.out.println(numeros[5]);
}
    
catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Índice inválido!");
} 
catch (Exception e) {
    System.out.println("Erro genérico.");
}
```

#### Finally

O comando ```finally``` sempre irá executar o que estiver dentro do bloco no encerramento do programa. Independentemente se ocorreu uma exceção durante sua execução. Ideal para fechar arquivos, conexões,

**Exemplos:**

``` Java
public class ExemploFinally {
    public static void main(String[] args) {
        try {
            int resultado = 10 / 0; // Isso vai gerar uma exceção
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: divisão por zero!");
        } finally {
            System.out.println("Bloco finally executado.");
        }
    }
}
```
Saída:

``` Terminal
Erro: divisão por zero!
Bloco finally executado.
```

``` Java
import java.io.*;

public class LeituraArquivo {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("exemplo.txt"));
            String linha = reader.readLine();
            System.out.println("Conteúdo: " + linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Garante fechamento mesmo se der erro
                    System.out.println("Arquivo fechado.");
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }
    }
}
```

#### Throw

O throw é usado para lançar uma exceção específica no momento que você desejar. É como chamar um erro manualmente. Muito útil para validar dados, definir erros de acordo com suas regras de negócio e lançar erros personalizados.

**Exemplo:**

``` Java
public class Teste {
    public static void verificarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Menor de idade não permitido.");
        }
    }

    public static void main(String[] args) {
        verificarIdade(15);
    }
}
```

**Quando criamos um comando que pode gerar uma exceção em nosso código, o compilador nos dá duas opções, tratar essa exceção devidamente, ou propagar essa exceção dentro da função ou método através do comando ```throws ExceptionType```, desta forma, funções e métodos que chamarem esse comando também precisarão tratar ou propagar esse erro. É como se avisassemos ao compilador que este comando pode gerar esse tipo de erro e estamos ciente disso.**



## Trabalhando com arquivos

### Scanner

Para trabalhar com arquivos em Java também usamos o [Scanner](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html). É necessário se atentar com alguns detalhes:

1. A leitura do arquivo pode gerar um erro do tipo [IOException](https://docs.oracle.com/javase/10/docs/api/java/io/IOException.html)
2. Esse erro deve ser devidamente tratado.
3. Se atentar a lógica para fechar o Scanner, uma boa é usar os blocos ```finally```

**Exemplo:**

``` Java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorDeArquivo {
    public static void main(String[] args) {
        try {
            File arquivo = new File("exemplo.txt"); // Caminho do arquivo
            Scanner leitor = new Scanner(arquivo);  // Cria o Scanner usando o arquivo

            while (leitor.hasNextLine()) {          // Verifica se ainda há linha
                String linha = leitor.nextLine();   // Lê a próxima linha
                System.out.println(linha);
            }

            leitor.close(); // Fecha o scanner depois de usar
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            e.printStackTrace();
        }
    }
}

```

**Métodos**

| **Método** | **Descrição** |
|:----------:|:--------------|
| ```hasNext()``` | Verifica se há outro token (palavra, número, etc.) |
| ```hasNextLine()``` | Verifica se há outra linha para ler. |
| ```next()``` | Lê o próximo token (palavra). |
| ```nextLine()``` | Lê a linha inteira. |
| ```nextInt()``` | Lê o próximo token como int. |
| ```nextDouble()``` | Lê o próximo token como double |
| ```useDelimiter(",")``` | Muda o separador padrão (por exemplo, ler números separados por vírgula)


### FileReader e BufferedReader

#### FileReader

O FileReader é uma classe da biblioteca ```java.io``` que lê arquivos de texto de maneira mais baixa nível comparado ao ```Scanner```. Ideal para leitura de caracteres ou pequenos arquivos.

**Exemplo:**

``` Java
import java.io.FileReader;
import java.io.IOException;

public class ExemploFileReader {
    public static void main(String[] args) {
        try {
            FileReader leitor = new FileReader("exemplo.txt");

            int caractere;
            while ((caractere = leitor.read()) != -1) { // Lê caractere por caractere
                System.out.print((char) caractere);
            }

            leitor.close(); // Sempre fechar o FileReader!
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
}

```

**Observações:**

1. Trabalha com texto (caracteres)
2. Leitura: Um caractere por vez (read()), não lê uma linha por completo.
3. Exceções: Pode lançar IOException.
4. É necessário sempre fechar o scanner com com ```close()```.
| Indicado para: | Arquivos não muito grandes, textos puros. |

#### BufferedReader**

O BufferedReader é uma classe da ```java.io``` que lê texto de uma entrada de forma eficiente, armazenando um buffer de caracteres. Isso melhora a performance pois reduz o número de acessos ao arquivo. Ou seja, ele **lê em blocos grandes quantidades de dados e vai entregando conforme o solicitado**. Geralmente o ```BufferedReader``` é usado em conjunto com o ```FileReader``` para superara  limitação da leitura de caracter por caracter.

Suas vantagens são: 
1. Muito mais rápido do que ler cada caracter separado, portanto mais eficiente.
2. A leitura pelo ```readLine()``` é mais prática para ler textos.
3. Pode serem usados junto com outros leitores (```InputStreamReader```, ```StringReader```, etc.).

**Exemplo:**

``` Java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploBufferedReader {
    public static void main(String[] args) {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader("exemplo.txt"));

            String linha;
            while ((linha = leitor.readLine()) != null) {  // Lê linha por linha
                System.out.println(linha);
            }

            leitor.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
}
```

**Métodos**

| **Método** | **Descrição** |
|:-: |:--|
| ```read()``` | Lê um caractere por vez (como int). |
| ```readLine()``` | Lê uma linha inteira (até \n) como String. |
| ```ready()``` | Retorna true se o buffer tem dados para serem lidos sem bloqueio. |


**Observaçôes**


1. ```BufferedReader``` Lê dados de forma bufferizada (blocos de dados).
2. Ideal para: Leitura de textos longos.
3. Fechamento |Sempre fechar (ou usar try-with-resources).
4. Performance Mais rápido que FileReader puro.

### Try-with-Resources

É uma forma especial do `try` que **automaticamente fecha** tudo o que você abriu, sem precisar chamar `close()` manualmente. Mantendo assim o código mais limpo e nos prevenindo de esquecer de fechar algum recurso aberto. Garantindo assim uma maior segurança  a bugs do código.
As exceções geradas no código pode ser normalmente tratadas nos blocos `catch()`.

Os recursos que funcionam com esse tipo de try são: 

* `Scanner`
* `BufferedReader`
* `BufferedWriter`
* `FileReader`
* `FileWriter`
* `InputStream`, `OutputStream`
* Conexões de Banco de Dados (`Connection`, `Statement`, `ResultSet`)

**Exemplo:**

``` Java
// Com try comum.

BufferedReader leitor = null;
try {
    leitor = new BufferedReader(new FileReader("exemplo.txt"));
    String linha = leitor.readLine();
    System.out.println(linha);
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        if (leitor != null) {
            leitor.close();  // Tem que fechar manualmente
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

```

``` Java
// Com try with Resources:

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploTryComRecurso {
    public static void main(String[] args) {
        try (BufferedReader leitor = new BufferedReader(new FileReader("exemplo.txt"))) {
            String linha = leitor.readLine();
            System.out.println(linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



### FileWriter e BufferedWriter

**Diferenças:**

| Classe | FileWriter | BufferedWriter |
|:- | :-: | :-: |
| Escrita direta | Sim | Não |
| Usa buffer | Não | Sim |
| Mais rápido | Não | Sim |
| Pode usar newLine() | Não | Sim |
| Indicado para: | Escritas simples | Escritas frequentes ou grandes |


#### FileWriter

Clase usada para criar/adicionar conteúdo de texto em um arquivo. Ele lida tranquilamente com poucas linhas e arquivos pequenos.. Interessante para salvar configs, escrever logs, etc.


**Exemplo:**

``` Java
import java.io.FileWriter;
import java.io.IOException;

public class EscreveComFileWriter {
    public static void main(String[] args) {
        try {
            FileWriter escritor = new FileWriter("saida.txt"); // sobrescreve o arquivo se já existir
            escritor.write("Olá, mundo!\n");
            escritor.write("Escrevendo com FileWriter.");
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

Se quisermos apenas adicionar conteúdo a um arquivo, sem recria-lo. Passamos `true`como segundo argumento da função:

``` Java
FileWriter escritor = new FileWriter("saida.txt", true); // true ativa o modo append
```

#### BufferedWriter

O `BufferedWriter` é um **“wrapper”** que usa um buffer para escrever os dados. Ou seja, em vez de escrever no disco a cada caractere, ele junta tudo e escreve de uma vez só, sendo assim **mais rápido e eficiente**.

**Exemplo:**

``` Java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscreveComBufferedWriter {
    public static void main(String[] args) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("saida.txt", true))) {
            escritor.write("Linha 1 com BufferedWriter\n");
            escritor.write("Linha 2 com BufferedWriter\n");
            escritor.newLine(); // quebra de linha independente do sistema
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

* `write()` escreve texto.
* `newLine()` insere uma **quebra de linha** correta, respeitando o sistema operacional.
* Com `BufferedWriter`, você pode usar o `try-with-resources` pra não esquecer de fechar.


### Manipulando diretórios

A classe `File` em Java é tipo o "canivete suíço" quando se trata de **representar e manipular arquivos e diretórios** no sistema de arquivos. Ela **não** lê nem escreve arquivos diretamente — pra isso usamos `FileReader`, `FileWriter`, `Scanner`, etc. Mas ela serve para **verificar, criar**.


**Exemplo:**

``` Java

package application;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: "); // Entrada do caminho do diretório
        String strPath = sc.nextLine();

        File path = new File(strPath); // Criamos um objeto de referência ao arquivo
        File[] folders = path.listFiles(File::isDirectory); // Criamos uma lista com os caminhos

        System.out.println("FOLDERS:");

        for (File folder : folders) {
            System.out.println(folder);
        }

        File[] files = path.listFiles(File::isFile);

        System.out.println("FILES:");

        for (File file : files) {
            System.out.println(file);
        }

        boolean success = new File(strPath + "\\subdir").mkdir();

        System.out.println("Directory created successfully: " + success);
        sc.close();
    }
}

```

``` Java
// Não cria fisicamente na memória o arquivo ou diretório, apenas a referencia.
File arquivo = new File("caminho/do/arquivo.txt");
File pasta = new File("caminho/da/pasta");
```

**Métodos:**

| **Métodos** | **Descrição** |
|:-: | :- |
| `exists()` | Verifica se o arquivo ou diretório existe. |
| `createNewFile()` | Cria um novo arquivo. |
| `mkdir()` | Cria um diretório. |
| `mkdirs()` | Cria um diretório e todos os diretórios pais que não existam. |
| `delete()` | Apaga o arquivo ou diretório. |
| `length()` | Retorna o tamanho do arquivo (em bytes). |
| `getName()` | Retorna o nome do arquivo. |
| `getPath()` | Retorna o caminho (relativo ou absoluto). |
| `getAbsolutePath()` | Retorna o caminho absoluto. |
| `canRead()` / `canWrite()` / `canExecute()` | Verifica permissões de leitura, escrita e execução. |
| `isFile()` / `isDirectory()` | Verifica se é um arquivo ou diretório. |
| `list()` | Retorna os nomes dos arquivos de um diretório. |
|`renameTo(FileName Local)` | Renomeia ou move o arquivo. | 

#### Aplicações

1. Verificar se um arquivo existe
``` Java
File arq = new File("arquivo.txt");
if (arq.exists()) {
    System.out.println("Arquivo existe!");
}
```

2. Criar um novo arquivo

``` Java
try {
    File novo = new File("novoArquivo.txt");
    if (novo.createNewFile()) {
        System.out.println("Arquivo criado com sucesso!");
    } else {
        System.out.println("Arquivo já existe.");
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

3. Criar diretórios

``` Java
File dir = new File("novaPasta");
if (dir.mkdir()) {
    System.out.println("Diretório criado!");
}
```

4. Listar arquivos de um diretório

``` Java
File pasta = new File(".");
String[] arquivos = pasta.list();
for (String nome : arquivos) {
    System.out.println(nome);
}
```

5. Apagar um arquivo

``` Java
File deletar = new File("teste.txt");
if (deletar.delete()) {
    System.out.println("Arquivo apagado.");
}
```

**Observações:**

* Se usar `delete()` em uma pasta que **não está vazia**, vai falhar. 
* Sempre verifique com `exists()` antes de manipular arquivos.
* Para arquivos **reais**, combine `File` com `BufferedReader`, `BufferedWriter`, `Scanner`, etc.

## Referência

* https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html
* https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
* https://pt.wikipedia.org/wiki/ISO_8601
* https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Enum.html
* https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
* https://docs.oracle.com/javase/10/docs/api/java/lang/package-tree.html
* https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
* https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
* https://docs.oracle.com/javase/10/docs/api/java/io/File.html
* IOException](https://docs.oracle.com/javase/10/docs/api/java/io/IOException.html
* https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
* https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html
* https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
* https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
* https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html
* https://docs.oracle.com/javase/8/docs/api/java/io/File.html

!neofetch