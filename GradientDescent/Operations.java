package proyects.GradientDescent;

import java.lang.Math;

public class Operations {
    DataSet dSet;
    Model model;
    double error;
    double[] gradients;
    double learningRate;
    
    public Operations(DataSet ds, Model m, double lr){
        dSet = ds;
        model = m;
        gradients = new double[2];
        learningRate = lr;
    }

    public void FindLossFunctionGradients(){
        double x, y, b0, b1, sumB0, sumB1;
        int n = dSet.getDataSetSize();
        b0 = model.getBeta0();
        b1 = model.getBeta1();
        sumB0 = sumB1 = 0;

        for(int i = 0; i< n; i++){
            x = dSet.getXvalueAt(i);
            y = dSet.getYvalueAt(i);
            sumB0 += (y - (b0 + b1*x));
            sumB1 += (y - (b0 + b1*x)) * x;
            error += Math.pow((y - (b0 + b1*x)), 2);
        }

        gradients[0] = (-2/(double)n) * sumB0;
        gradients[1] = (-2/(double)n) * sumB1;
        error = error / (double)n;
    }


    //GET ERROR. VAMOS AQUI
}
