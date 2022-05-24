package proyects.GradientDescent;

import javax.lang.model.util.ElementScanner6;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class GenericAgent extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new GradDescentExecute());
    }

    private class GradDescentExecute extends Behaviour {

        DataSet dataset = new DataSet();
        Model model = new Model(0, 0);
        GradientDescent gradientDescent = new GradientDescent(dataset, model);
        int epochs = 0;

        public void action() {
            gradientDescent.step();
            epochs++;
        }

        public boolean done() {
            if(epochs == 10000){
                return true;
            } else {
                return gradientDescent.hasConverged(0.5);
            }
        }

        public int onEnd() {
            gradientDescent.PrintModel();
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}
