package proyects.curvefitting;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class AgentBasedCurveFitting extends Agent {

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");

    addBehaviour(new SLRExecute());
  }

  private class SLRExecute extends OneShotBehaviour {
    SLR slr = new SLR();
    float x = 23;

    public void action() {
      slr.Summations();
      slr.FindBetaValues();
      slr.CalculateY(x);
      slr.PrintAnswer(x);
    }

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  }
}