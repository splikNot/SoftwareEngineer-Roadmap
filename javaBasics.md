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

|  Tipo | Bits | Descrição      |     Alcance      |
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

|  Tipo      | Exemplo                     |
|:----------:|:----------------------------|
| Strings    | ```String nome = "Java";``` |
| Arrays     | ```int[] numerical = {1,2,3,4};``` |
| Classes    | ```Person p = new PersonSameOldMistakes();``` |
| Interfaces | ```Runnable r = new showThread();``` |
| Enums      | ```DiaSemana hoje = DiaSemana.SEGUNDA;```|

**Obs:** O valor padrão de cada tipo primitivo de váriaveis são seus respectivos elementos neutros.

## Saída de Dados

A formatação dos valores float através das máscaras é semelhante ao que já conheço de python. Sintaxe: ```("%.3f")```


```
System.out.println(outputData) # Possui quebra de linhas no final.
System.out.print(outputData) # Não possuí quebra de linhas no final.
System.out.printf(outputData) # Permite aplicar máscara para números flutuantes

```

### Máscaras

**Especificadores de Tipo**(*Place Holder*)

|  Máscara | Descrição                 | Exemplo (System.out.printf(outputData))   | Output           |
|:--------:|:--------------------------|:-----------------------------------------:|:-----------------|
| ```%d``` | Números inteiros decimais | ```System.out.printf("%d", 37);```        | ```37```         | 
| ```%f``` | Números reais decimais    | ```System.out.printf("%.2f", 3.14159);``` | ```3.14```       | 
| ```%e``` | Notação científica        | ```System.out.printf("%e", 12345.6789);```| ```1.2345678e+04``` | 
| ```%g``` | Notação mais compacta (%e ou %f) |```System.out.printf("%g", 12345.6789);```| ```12345.7``` | 
| ```%c``` | Caractere Unicode         | ```System.out.printf("%c", A);```         | ```A```          | 
| ```%s``` | String                    | ```System.out.printf("%s", "Romeo);```    | ```Romeo```      | 
| ```%b``` | Boolean                   | ```System.out.printf("%b", true);```      | ```true```       | 
| ```%o``` | Inteiro em Octal (2⁸)     | ```System.out.printf("%o", 10);```        | ```12```         | 
| ```%x``` | Inteiro em Hexadecimal    | ```System.out.printf("%x", 255);```       | ```ff```         | 
| ```%n``` | Quebra de linha (*\n*)    | ```System.out.printf("Olá%nMundo");```    | ```Olá``` ```Mundo```| 

**Modificadores de Formato**



# Dúvidas

* Consigo usar a máscara boolean com valor 1 ou 0?
* 












