package AlertTarget;

import TypewiseAlert.BreachType;

public interface IAlertTargetService {
	void send(BreachType breachType);
}
