import java.util.Arrays;
import java.util.ArrayList;

class SyntaxChecker {
	
	private Stack stack;
	private CommandHandler _commandHandler;
	
	public SyntaxChecker(Stack stack) {
		this.stack = stack;
		this._commandHandler = new CommandHandler(this.stack);
	}
	
	public boolean checkInputs(String line) {
		ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(line.trim().split("\\s+")));
		try {
			for (String token : inputs) {
				try {
					this.stack.push(Float.parseFloat(token));
				} catch (NumberFormatException e) {
					switch (token) {
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
							if (inputs.size() == 1) {
								return this._commandHandler.executeCommand(token);
							}
							System.out.println("Non valid computation input \"" + token + "\", ending calculus");
							throw e;
					}
				}
 			}
		}
		catch (NumberFormatException e) { }
		catch (IllegalArgumentException e) {
			this.stack.printRegisters();
			return true;
		}
		this.stack.printRegisters();
		this.stack.printResult();
		return true;
	}
}