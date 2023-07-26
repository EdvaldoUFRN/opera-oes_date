import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();
        System.out.println("d01 = " + d01);
        System.out.println("d02 = " + d02);
        System.out.println("d03 = " + d03);

        LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);

        System.out.println("d08 = " + d08);
        //Também posso utilizar o LocalDateTime d11 = LocalDateTime.of(ano, mes, dia, hora, minutos);
        LocalDate d04 = LocalDate.parse("2022-07-20");
        System.out.println("d04 = " + d04.format(fmt1));
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        //ele vai pegar o fuso horário do computador do usuário.
        System.out.println("d06 = " + fmt3.format(d06));

        //Converter Data-hora global para local
        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);

        //Pegar elementos de uma Data
        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 mês = " + d04.getMonthValue());
        System.out.println("d04 ano = " + d04.getYear());
        
        //Operações com Datas
        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeekLocalDate = d04.plusDays(7);
        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
        //tem como fazer o mesmo com LocalDateTime e Instant
        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);
        System.out.println("pastWeekLocalDate = " + pastWeekInstant);
        System.out.println("nextWeekLocalDate = " + nextWeekInstant);

        //Duração entre duas datas horas
        Duration t1 = Duration.between(pastWeekInstant, nextWeekInstant);
        System.out.println("t1 dias = " + t1.toDays()); 
        //O LocalDate apenas, não dá para usar, pois ele não tem os segundos, então eu teria que convertê-lo 
        //para LocalDateTime
        //Para converter tem que fazer o seguinte
        //colocar no Duration.between(pastWeekInstant.atTime(0,0), nextWeekInstant.atTime(0,0));
        //atTime é como se fosse no "tempo"
        //ou colocar apenas .atStartOfDay() que já é isso automaticamente
        //se colocar a data menor menos a maior, vai dar um valor negativo
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Date contractDate = sdf.parse(sc.next());
        System.out.println(contractDate);
        sc.close();
    }
}
