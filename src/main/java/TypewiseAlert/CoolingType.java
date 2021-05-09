package TypewiseAlert;

public enum CoolingType {
    PASSIVE_COOLING(0,35),
    HI_ACTIVE_COOLING(0,45),
    MED_ACTIVE_COOLING(0,40);
	
private int lowerLimit;
private int upperLimit;
	
	private CoolingType(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

	public int getLowerLimit() {
		return lowerLimit;
	}

	public int getUpperLimit() {
		return upperLimit;
	}	
  }