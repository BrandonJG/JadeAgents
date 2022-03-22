package proyects.curvefitting;

public class SLR {
    DataSet dataSet;
    Model model;
    private double y;

    public SLR() {
        dataSet = new DataSet();
    }

    public void findModel() {
        model = Operations.getModel(dataSet);
    }

    public void findY(float x){
        y = Operations.CalculateY(model, x);
    }

    public void PrintAnswer(float x){
        System.out.println(String.format("y = %.3f + (%.3f)(%.3f)", beta0, beta1, x));
        System.out.println(String.format("y = %.3f", y));
    }
}
