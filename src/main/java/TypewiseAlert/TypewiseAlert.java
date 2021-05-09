package TypewiseAlert;

import AlertTarget.IAlertTargetService;

public class TypewiseAlert 
{  
	public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
    
		if(value < lowerLimit) {
        return BreachType.TOO_LOW;
      }
    	else if(value > upperLimit) {
        return BreachType.TOO_HIGH;
      }
      return BreachType.NORMAL;
    }
   
    public  static BreachType classifyTemperatureBreach(
        CoolingType coolingType, double temperatureInC) {
      return inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }
    
    public  void checkAndAlert(
     String alertTarget, BatteryCharacter batteryChar, double temperatureInC) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
     BreachType breachType = classifyTemperatureBreach(
      batteryChar.getCoolingType(), temperatureInC
   );
     
    }
    
    public void alert(IAlertTargetService alertTarget, BreachType breachType) {
    	alertTarget.send(breachType);
   }
   }