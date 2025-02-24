# Outros tópicos

## Data e hora

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
* 
### Padrão ISO 8601

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

```
// Obter data e hora

import java.time*;
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


























