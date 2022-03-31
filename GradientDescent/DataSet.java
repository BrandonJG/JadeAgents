package proyects.GradientDescent;;

public class DataSet {
    private double[] xValues = { 2, 4, 6, 8, 10, 12, 14, 16, 18 };
    private double[] yValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int dataSetSize;

    public DataSet(){
        dataSetSize = xValues.length;
    }

    public double getXvalueAt(int pos){
        return xValues[pos];
    }

    public double getYvalueAt(int pos){
        return yValues[pos];
    }

    public int getDataSetSize(){
        return dataSetSize;
    }
}
