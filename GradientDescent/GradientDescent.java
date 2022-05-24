package proyects.GradientDescent;

public class GradientDescent {
    DataSet dataSet;
    Model model;
    double[] gradients;
    

    public GradientDescent(DataSet ds, Model m){
        dataSet = ds;
        model = m;
        gradients = new double[3];
    }

    public void step(){
        gradients = Operations.FindLossFunctionGradients(dataSet, model);
    }

    public boolean hasConverged(double tolerance){
        double error = gradients[2];
        if(tolerance >= error){
            return true;
        } else {
            model = Operations.fitModel(model, 0.0003, gradients);
            return false;
        }
    }

    public void PrintModel(){
        System.out.printf("B0 = %.3f, and B1 = %.3f", model.getBeta0(), model.getBeta1());
    }
}
