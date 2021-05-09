package AlertTarget;

import TypewiseAlert.BreachType;

public class ControllerService implements IAlertTargetService {
    
    public void send(BreachType breachType) {
      int header = 0xfeed;
      System.out.printf("%d : %s%n", header, breachType.getDisplayName()+"\n");
    }
}