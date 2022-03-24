package proyects.MLR;

import java.lang.Math;

import javax.xml.parsers.DocumentBuilder;

public class Operations {

    public static int X1 = 0;
    public static int X2 = 1;
    public static int X1SQUARED = 2;
    public static int X2SQUARED = 3;
    public static int X1X2 = 4;
    public static int Y = 5;
    public static int X1Y = 6;
    public static int X2Y = 7;

    public static Model getModel(DataSet ds){
        double b0, b1, sumX, sumXY, sumY, sumXsquared;
        double[] sums = summations(ds);
        double[] betaValues = determinants(sums, ds.getDataSetSize());
        return new Model(betaValues);
    }

    public static double[] determinants(double[] sums, int n){
        double ds, db0, db1, db2;
        double[] betas = new double[3];
        //ecuation system determinant
        ds = n*sums[X1SQUARED]*sums[X2SQUARED] + 2*(sums[X1]*sums[X2]*sums[X1X2]) -
        Math.pow(sums[X2], 2)*sums[X1SQUARED] - Math.pow(sums[X1], 2)*sums[X2SQUARED] - n*Math.pow(sums[X1X2], 2);
        //b0 matrix determinant
        db0 = sums[Y]*sums[X1SQUARED]*sums[X2SQUARED] + sums[X1]*sums[X1X2]*sums[X2Y] + sums[X2]*sums[X1Y]*sums[X1X2] -
        sums[X2]*sums[X1SQUARED]*sums[X2Y] - sums[X1]*sums[X1Y]*sums[X2SQUARED] - sums[Y]*Math.pow(sums[X1X2], 2);
        //b1 matrix determinant
        db1 = n*sums[X1Y]*sums[X2SQUARED] + sums[Y]*sums[X1X2]*sums[X2] + sums[X2]*sums[X1]*sums[X2Y] -
        Math.pow(sums[X2], 2)*sums[X1Y] - sums[Y]*sums[X1]*sums[X2SQUARED] - n*sums[X1X2]*sums[X2Y];
        //b2 matrix determinant
        db2 = n*sums[X1SQUARED]*sums[X2Y] + sums[X1]*sums[X1Y]*sums[X2] + sums[Y]*sums[X1]*sums[X1X2] -
        sums[Y]*sums[X1SQUARED]*sums[X2] - Math.pow(sums[X1], 2)*sums[X2Y] - n*sums[X1Y]*sums[X1X2];

        betas[0] = db0/ds;
        betas[1] = db1/ds;
        betas[2] = db2/ds;
        return betas;
    }

    public static double[] summations(DataSet ds){
        int n = ds.getDataSetSize();
        int var = ds.getNumberOfVariables();
        double[] x = new double[var];
        double[] sums = new double[9];
        double y;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<var; j++){
                x[j] = ds.getXvalueAt(j, i);
            }
            y = ds.getYvalueAt(i);
            sums[X1] += x[0]; //sumX1
            sums[X2] += x[1]; //sumX2
            sums[X1SQUARED] += Math.pow(x[0], 2); //sumX1^2
            sums[X2SQUARED] += Math.pow(x[1], 2); //sumX2^2
            sums[X1X2] += x[0]*x[1]; //sumX1*X2
            sums[Y] += y; //sumY
            sums[X1Y] += y*x[0]; //sumX1*Y
            sums[X2Y] += y*x[1]; //sumX2*Y
        }
        return sums;
    }

    public static double CalculateY(Model m, double x1, double x2){
        return m.getBetaAt(0) + x1*m.getBetaAt(1) + x2*m.getBetaAt(2);
    }
}
