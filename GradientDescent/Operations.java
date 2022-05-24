package proyects.GradientDescent;

import java.lang.Math;

public class Operations {

    public static double[] FindLossFunctionGradients(DataSet ds, Model model){
        double idealY, y, b0, b1, sumB0, sumB1, error;
        double n = (double)ds.getDataSetSize();
        double[] gradients = new double[3];
        b0 = model.getBeta0();
        b1 = model.getBeta1();
        error = sumB0 = sumB1 = 0;

        for(int i = 0; i< n; i++){
            y = ds.getYvalueAt(i);
            idealY = b0 + b1*ds.getXvalueAt(i);
            sumB0 += (y - idealY);
            sumB1 += ((y - idealY) * ds.getXvalueAt(i));
            error += Math.pow(y-idealY, 2);
        }

        gradients[0] = ((double)-2/n) * sumB0;
        gradients[1] = ((double)-2/n) * sumB1;
        gradients[2] = error = error / n; //tip value on gradients is error

        return gradients;
    }

    public static Model fitModel(Model oldModel, double learningRate, double[] gradients){
        return new Model(oldModel.getBeta0() - learningRate*gradients[0],
        oldModel.getBeta1() - learningRate*gradients[1]);
    }

}
