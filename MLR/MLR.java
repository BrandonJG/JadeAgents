package proyects.MLR;

public class MLR {
    DataSet dataSet;
    Model model;
    private double y;

    public MLR() {
        dataSet = new DataSet();
    }

    public void findModel() {
        model = Operations.getModel(dataSet);
    }

    public void findY(double x1, double x2){
        y = Operations.CalculateY(model, x1, x2);
    }

    public void printAnswer(double x1, double x2){
        System.out.println(String.format("y = %.3f + (%.3f)(%.3f) + (%.3f)(%.3f)", 
                            model.getBetaAt(0), model.getBetaAt(1), x1, model.getBetaAt(2), x2));
        System.out.println(String.format("y = %.3f", y));
    }
}
