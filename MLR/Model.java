package proyects.MLR;

public class Model {
    private double[] beta;
    
    public Model(double[] b){
        beta = b;
    }

    public double getBetaAt(int ind){
        return beta[ind];
    }
    
}
