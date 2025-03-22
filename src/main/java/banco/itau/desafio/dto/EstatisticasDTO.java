package banco.itau.desafio.dto;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import java.util.Locale;
import java.util.DoubleSummaryStatistics;


public class EstatisticasDTO {

    private final long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;

    public EstatisticasDTO(DoubleSummaryStatistics statistics) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##",symbols);

        this.count = statistics.getCount();
        this.sum = Double.parseDouble(df.format(statistics.getSum()));
        this.avg = Double.parseDouble(df.format(statistics.getAverage()));

        // Para retornar 0 ao invés de Infinity nos campos min e max
        if(statistics.getCount() == 0){
            this.min = 0;
            this.max = 0;
        }
        else{
            this.max = Double.parseDouble(df.format(statistics.getMax()));
            this.min = Double.parseDouble(df.format(statistics.getMin()));
        }
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
