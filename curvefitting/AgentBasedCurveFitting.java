package proyects.curvefitting;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * This example shows the basic usage of JADE behaviours.<br>
 * More in details this agent executes a <code>CyclicBehaviour</code> that shows
 * a printout at each round and a generic behaviour that performs four
 * successive
 * "dummy" operations. The second operation in particular involves adding a
 * <code>OneShotBehaviour</code>. When the generic behaviour completes the
 * agent terminates.
 * 
 * @author Giovanni Caire - TILAB
 */
public class AgentBasedCurveFitting extends Agent {

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");

    // Add the CyclicBehaviour
    addBehaviour(new CyclicBehaviour(this) {
      public void action() {
      }
    });

    // Add the generic behaviour
    addBehaviour(new CurveFitting());
  }

  /**
   * Inner class FourStepBehaviour
   */
  private class CurveFitting extends Behaviour {
    private float[] xValues = { 23, 26, 30, 34, 43, 48, 52, 57, 58 };
    private float[] yValues = { 651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518 };
    private int n = 9;
    private int step = 0;
    private float x, y, b0, b1;
    private boolean xReceived = false;
    ACLMessage msg;

    public void action() {
      if(step<n){
        y = yValues[step];
        x = xValues[step];
        step++;
        System.out.println(String.format("Given advertising = %.3f, and sales = %.3f, on year %d", x, y, step));
        b1 = (step*(x*y)-(x*y)) / (step*(x*x));
        b0 = y - b1*x;
        System.out.println(String.format("----We got B0 = %.3f and B1 = %.3f", b0, b1));
        System.out.println("------------------------------------");
      }
      
      msg = receive();
      if (msg != null){
        try {
          System.out.println("\nAnd given the received value x = " + msg.getContent());
          x = Float.parseFloat(msg.getContent());
          y = b0 + b1*x;
          System.out.println(String.format("With the ecuation y = %.3f + %.3f(%.3f)\n---y = %.3f", b0, b1, x, y));
          xReceived = true;  
        } catch (Exception e) {
          System.out.println("Received data is not a number. Expecting another message...");
          msg = null;
        } 
      }
    }

    public boolean done() {
      return xReceived;
    }

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  } // END of inner class FourStepBehaviour
}