package production;

public enum EFieldState {
	
    CROSS('x'), CIRCLE('o'), EMPTY('_');
    
    private final char symbol;

	private EFieldState(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}
    
    
}
