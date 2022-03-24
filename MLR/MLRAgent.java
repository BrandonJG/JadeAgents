package proyects.MLR;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import java.util.*;

public class MLRAgent extends Agent {
    Scanner input;


    protected void setup() {
        double x1, x2;
        input = new Scanner(System.in);
        System.out.println("Agent " + getLocalName() + " started.");
        System.out.print("Input x1 value: ");
        x1 = input.nextDouble();
        System.out.print("Input x2 value: ");
        x2 = input.nextDouble();
        addBehaviour(new MLRExecute(x1, x2));
    }

    private class MLRExecute extends OneShotBehaviour {
        MLR mlr = new MLR();
        double x1, x2;

        public MLRExecute(double value1, double value2) {
            x1 = value1;
            x2 = value2;
        }

        public void action() {
            mlr.findModel();
            mlr.findY(x1, x2);
            mlr.printAnswer(x1, x2);
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}