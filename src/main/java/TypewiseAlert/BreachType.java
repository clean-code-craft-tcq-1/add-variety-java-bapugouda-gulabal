package TypewiseAlert;

public enum BreachType {
    NORMAL("normal"),
    TOO_LOW("too low"),
    TOO_HIGH("too high");
    
private String displayName;
	
	private BreachType(String displayName) {
        this.displayName = displayName;
    }

	public String getDisplayName() {
		return displayName;
	}
  }
