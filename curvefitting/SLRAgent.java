package proyects.curvefitting;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class SLRAgent extends Agent {

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");

    addBehaviour(new SLRExecute());
  }

  private class SLRExecute extends OneShotBehaviour {
    SLR slr = new SLR();
    float x = 23;

    public void action() {
      slr.findModel();
      slr.findY(x);
      slr.PrintAnswer(x);
    }

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  }
}