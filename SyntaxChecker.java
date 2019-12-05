import java.util.Arrays;
import java.util.ArrayList;

class SyntaxChecker {
	
	private Stack stack;
	
	public SyntaxChecker(Stack stack) {
		this.stack = stack;
	}
	
	public boolean checkInputs(String line) {
		ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(line.trim().split("\\s+")));
		boolean firstTurn = true;
		try {
			for (String input : inputs) {
				try {
					this.stack.push(Float.parseFloat(input));
				} catch (NumberFormatException e) {
					switch (input) {
						case "+":
							this.stack.add();
							break;
						case "-":
							this.stack.sub();
							break;
						case "*":
							this.stack.mul();
							break;
						case "/":
							this.stack.div();
							break;
						default:
							if (firstTurn && inputs.size() == 1) {
								return new CommandHandler(this.stack).executeCommand(input);
							}
							System.out.println("Non valid computation input \"" + input + "\", ending calculus");
							throw e;
					}
				}
				if (firstTurn) { firstTurn = !firstTurn; }
			}
		} catch (NumberFormatException e) {  }
		this.stack.printRegisters();
		return true;
	}
}