package AlertTarget;

import TypewiseAlert.BreachType;

public class ConsoleService implements IAlertTargetService {
	   
    public void send(BreachType breachType) {
            System.out.println("The temperature is "+breachType.getDisplayName()+"\n");
      }
}
