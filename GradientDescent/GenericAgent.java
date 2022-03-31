package proyects.GradientDescent;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class GenericAgent extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new MyGenericBehaviour());
    }

    private class GradientDescent extends Behaviour {

        DataSet dataset = new DataSet();
        Model model = new Model(1, -1, 0 - 003);
        
        int epochs = 0;

        public void action() {
            System.out.println("Agent's action method is executed");
            System.out.println(cont);
            epochs += 1;
        }

        public boolean done() {
            if (epochs == 10000)
                return true;
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    } // END of inner class ...Behaviour
}
