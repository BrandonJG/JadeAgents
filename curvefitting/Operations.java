package proyects.curvefitting;

import java.lang.Math;

public class Operations {

    public static Model getModel(DataSet ds){
        double b0, b1, sumX, sumXY, sumY, sumXsquared;
        double[] sums = summations(ds);
        sumX = sums[0];
        sumY = sums[1];
        sumXY = sums[2];
        sumXsquared = sums[3];
        b0 = (sumY*sumXsquared - sumX*sumXY) / (n*sumXsquared - Math.pow(sumX, 2));
        b1 = (n*sumXY - sumX*sumY) / (n*sumXsquared - Math.pow(sumX, 2));
        return new Model(b0, b1);
    }

    public static double[] summations(DataSet ds){
        double x, y;
        int n = ds.getDataSetSize();
        double[] sums = {0,0,0,0};
        for(int i = 0; i<n; i++){
            x = ds.getXvalueAt(i);
            y = ds.getYvalueAt(i);
            sums[0] += x; //sumX
            sums[1] += y; //sumY
            sums[2] += (x*y); //sumXY
            sums[3] += Math.pow(x, 2); //sumXsquared
        }
        return sums;
    }

    public static double CalculateY(Model m, double x){
        return m.getBeta0() + m.getBeta1() * x;
    }
}
