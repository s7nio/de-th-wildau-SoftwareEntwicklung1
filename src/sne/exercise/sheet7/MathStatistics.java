/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sne.exercise.sheet7;

/**
 * Help methid...
 * 
 * @author sne
 */
public class MathStatistics {

    private double min;
    private double max;
    private double mean;
    private double standardDeviation;
    private double variance;
    private double sumOfSquanres;
    private double sum;
    private int count;

    public MathStatistics() {
        this.min = Double.POSITIVE_INFINITY;
        this.max = Double.NEGATIVE_INFINITY;
    }

    public void update(double value) {
        this.count++;
        if (this.max < value) {
            this.max = value;
        }
        if (this.min > value) {
            this.min = value;
        }
        this.sum += value;
        this.sumOfSquanres += value * value;
        this.mean += (value - this.mean) / this.count;
        this.standardDeviation = Math.sqrt(
                ( (this.count * this.sumOfSquanres) - (this.sum * this.sum) )
                / (this.count * (this.count - 1)));
        this.variance = this.standardDeviation * this.standardDeviation;
    }

    public double getMax() {
        return this.max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return this.min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMean() {
        return this.mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStandardDeviation() {
        return this.standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("max: ");
        stringBuilder.append(this.max);
        stringBuilder.append(System.getProperty("line.separator"));

        stringBuilder.append("min: ");
        stringBuilder.append(this.min);
        stringBuilder.append(System.getProperty("line.separator"));

        stringBuilder.append("sum: ");
        stringBuilder.append(this.sum);
        stringBuilder.append(System.getProperty("line.separator"));

        stringBuilder.append("sum of x²: ");
        stringBuilder.append(this.sumOfSquanres);
        stringBuilder.append(System.getProperty("line.separator"));

        stringBuilder.append("mean: ");
        stringBuilder.append(mean);
        stringBuilder.append(System.getProperty("line.separator"));

        stringBuilder.append("stddev: ");
        stringBuilder.append(this.standardDeviation);
        stringBuilder.append(System.getProperty("line.separator"));

        stringBuilder.append("variance: ");
        stringBuilder.append(this.variance);
        stringBuilder.append(System.getProperty("line.separator"));

        return stringBuilder.toString();
    }
}
