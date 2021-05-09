package TypewiseAlert;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import AlertTarget.FakeService;


@RunWith(Parameterized.class)
public class TypewiseAlertTest 
{
	CoolingType type;
	double tempInC;
	BreachType expectedResult;
	String alertTarget;
	BatteryCharacter batteryCharacter;
	FakeService fakeService;
	TypewiseAlert typewiseAlert;
	String expectedMessage;
	
	@Rule
	  public ExpectedException exceptionRule = ExpectedException.none();

	@Parameterized.Parameters
	public static Collection inputData() {
	      return Arrays.asList(new Object[][]{
	         { CoolingType.MED_ACTIVE_COOLING, 50,BreachType.TOO_HIGH,"Email"  },
	         { CoolingType.HI_ACTIVE_COOLING, 30, BreachType.NORMAL,"Controller" },
	         { CoolingType.PASSIVE_COOLING, -10,BreachType.TOO_LOW,"Console"  },
	         { CoolingType.PASSIVE_COOLING, -10,BreachType.TOO_LOW,"Controller"  }
	      });
	}
	
	public TypewiseAlertTest(CoolingType type, double tempInC,BreachType expectedResult,String alertTarget) {
	      this.type = type;
	      this.tempInC = tempInC;
	      this.expectedResult = expectedResult;
	      this.alertTarget = alertTarget;
	      this.expectedMessage = expectedMessage;
	   }
	
	@Before
    public void setup() { 		
		batteryCharacter = new BatteryCharacter();
    	batteryCharacter.setBrand("Aptiv");
    	batteryCharacter.setCoolingType(type);
		fakeService = new FakeService();
		//typewiseAlert = new TypewiseAlert(new FakeServiceLocator(fakeService));
	}
	
    @Test
    public void infersBreachAsPerLimits()
    {
      
      assertEquals(BreachType.TOO_LOW,TypewiseAlert.inferBreach(12, 20, 30));
    }
    
    @Test
    public void classifyTemperatureBreachAsPerCoolingType()
    {
    	
      assertEquals(expectedResult,TypewiseAlert.classifyTemperatureBreach(type,tempInC));
    }
    
    @Test
    public  void checkAndAlertAsPerAlertTarget() {
    	exceptionRule.expect(NullPointerException.class);
		try {
			
			typewiseAlert.checkAndAlert("Fake",batteryCharacter , tempInC);
			
			assertEquals("The temperature is "+expectedResult.getDisplayName(),fakeService.getMsg());
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
 
}