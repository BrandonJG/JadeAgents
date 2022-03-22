package proyects.curvefitting;

public class Model {
    private double beta0;
    private double beta1;
    
    public Model(double b0, double b1){
        beta0 = b0;
        beta1 = b1;
    }

    public double getBeta0(){
        return beta0;
    }

    public double getBeta1(){
        return beta1;
    }
    
}
