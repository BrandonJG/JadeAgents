package proyects.MLR;

public class DataSet {
    private double[][] xValues = {
        {41.9, 43.4, 43.9, 44.5, 47.3, 47.5, 47.9, 50.2, 52.8, 53.2, 56.7, 57.0, 63.5, 65.3, 71.7, 77, 77.8},
        {29.1, 29.3, 29.5, 29.7, 29.9, 30.3, 30.5, 30.7, 30.8, 30.9, 31.5, 31.7, 31.9, 32, 32.1, 32.5, 32.9}
    };
    private double[] yValues = 
        {251.3, 251.3, 248.3, 267.5, 273, 276.5, 270.3, 274.9, 285, 290, 297, 302.5, 304.5, 309.3, 321.7, 330.7, 349};
    private int dataSetSize;
    private int variablesCount;

    public DataSet(){
        dataSetSize = xValues[0].length;
        variablesCount = xValues.length;
    }

    public double getXvalueAt(int ind, int pos){
        return xValues[ind][pos];
    }

    public double getYvalueAt(int pos){
        return yValues[pos];
    }

    public int getDataSetSize(){
        return dataSetSize;
    }

    public int getNumberOfVariables(){
        return variablesCount;
    }
}
