package proyects.curvefitting;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class AgentBasedCurveFitting extends Agent {

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");

    // Add the CyclicBehaviour
    addBehaviour(new CyclicBehaviour(this) {
      public void action() {
      }
    });

    addBehaviour(new FourStepBehaviour());
  }

  private class FourStepBehaviour extends Behaviour {
    SLR slr = new SLR();
    float x = 23;
    private int step = 1;

    public void action() {
      switch (step) {
      case 1:
        slr.CalculateSigma();
        break;
      case 2:
        slr.CalculateBeta();
        break;
      case 3:
        slr.CalculateY(x);
        break;
      case 4:
        slr.PrintAnswer(x);
        break;
      }
      step++;
    } 

    public boolean done() {
      return step == 5;
    } 

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  }
}