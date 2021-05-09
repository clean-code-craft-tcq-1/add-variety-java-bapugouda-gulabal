package AlertTarget;

import TypewiseAlert.BreachType;

public class FakeService implements IAlertTargetService {
	String  msg;
	public void send(BreachType breachType) {
        msg = "The temperature is "+breachType.getDisplayName();
  }
	public String getMsg() {
		return msg;
	}

}
