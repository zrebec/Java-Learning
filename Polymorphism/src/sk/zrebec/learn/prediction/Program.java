package sk.zrebec.learn.prediction;

import java.time.LocalDate;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {

        NavigableMap<LocalDate, int[]> data = new TreeMap<>();
        data.put(LocalDate.of(2020, 3, 21), new int[] {305120, 12800, 93917, 187});
        data.put(LocalDate.of(2020, 3, 22), new int[] {308900, 13017, 94899, 188});
        data.put(LocalDate.of(2020, 3, 23), new int[] {309900, 13500, 94899, 188});

        Map.Entry<LocalDate, int[]> previous = null;
        for (Map.Entry<LocalDate, int[]> entry : data.entrySet() ) {
            if (previous != null) {
                double deaths = 100 - (((double) previous.getValue()[1] / (double) entry.getValue()[1]) * 100) ;
                System.out.printf("Differences between %s to %s. Death: %.2f%%\n ", previous.getKey().toString(), entry.getKey().toString(), deaths);
            }

            previous = entry;
        }

    }
}


