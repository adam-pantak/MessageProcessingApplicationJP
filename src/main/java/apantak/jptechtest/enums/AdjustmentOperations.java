package apantak.jptechtest.enums;

public enum AdjustmentOperations {
	ADD("add"),
	SUBTRACT("subtract"),
	MULTIPLY("multiply");
	
	private String text;

    private AdjustmentOperations(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    
    public static AdjustmentOperations getEnumFromString(String operationStr) {
    	for(AdjustmentOperations operation : AdjustmentOperations.values()) {
    		if(operation.toString().equals(operationStr)) {
    			return operation;
    		}
    	}
    	return null;
    }
}
