package proyects.curvefitting;

import java.lang.Math;

public class SLR {
    private double[] xValues = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };
    private double[] yValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
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

    public void Summations() {
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

    public void FindBetaValues(){
            beta0 = (sigmaY*sigmaXsquared - sigmaX*sigmaXY)
                    / (n*sigmaXsquared - Math.pow(sigmaX, 2));
            beta1 = (n*sigmaXY - sigmaX*sigmaY) 
                    / (n*sigmaXsquared - Math.pow(sigmaX, 2));
    }

    public void CalculateY(float x){
        y = beta0 + beta1 * x;
    }

    public void PrintAnswer(float x){
        System.out.println(String.format("y = %.3f + (%.3f)(%.3f)", beta0, beta1, x));
        System.out.println(String.format("y = %.3f", y));
    }
}
