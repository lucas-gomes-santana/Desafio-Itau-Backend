package banco.itau.desafio.dto;

import jakarta.validation.constraints.DecimalMin;

import java.util.DoubleSummaryStatistics;


public class EstatisticasDTO {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public EstatisticasDTO(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();

        // Para não retornar Infinity nos campos min e max
        if(statistics.getCount() == 0){
            this.min = 0;
            this.max = 0;
        }
        else{
            this.max = statistics.getMax();
            this.min = statistics.getMin();
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
