package proyects.curvefitting;

import java.lang.Math;

public class SLR {
    private double[] xValues = { 23, 26, 30, 34, 43, 48, 52, 57, 58 };
    private double[] yValues = { 651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518 };
    private int n;
    private double sigmaX;
    private double sigmaY;
    private double sigmaXY;
    private double sigmaXsquared;
    private double beta0;
    private double beta1;
    private double y;

    public SLR() {
        n = xValues.length;
        sigmaX = sigmaY = sigmaXY = 0;
        sigmaXsquared = 0;
    }

    public void CalculateSigma() {
        double xActual, yActual;
        for (int i = 0; i < n; i++) {
            xActual = xValues[i];
            yActual = yValues[i];
            sigmaX += xActual;
            sigmaY += yActual;
            sigmaXY += (xActual*yActual);
            sigmaXsquared += Math.pow(xActual, 2);
        }
    }

    public void CalculateBeta(){
            beta0 = (sigmaY*sigmaXsquared - sigmaX*sigmaXY)
                    / (n*sigmaXsquared - Math.pow(sigmaX, 2));
            beta1 = (n*sigmaXY - sigmaX*sigmaY) 
                    / (n*sigmaXsquared - Math.pow(sigmaX, 2));
    }

    public void CalculateY(float x){
        y = beta0 + beta1 * x;
    }

    public void PrintAnswer(float x){
        System.out.println(String.format("y = %.3f + (%.3f)($.3f)", beta0, beta1, x));
        System.out.println(String.format("y = %.3f", y));
    }
}
