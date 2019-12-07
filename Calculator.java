import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Calculator {
	
	private Stack stack;
	private BufferedReader buffer;
	private SyntaxChecker _syntaxChecker;
	
	public Calculator() {
		this.stack = new Stack();
		this.buffer = new BufferedReader(new InputStreamReader(System.in));
		this._syntaxChecker = new SyntaxChecker(this.stack);
	}
		
	public void loop() {
		while (true) {
			System.out.print("RPN Calculator >");
			
			String input = "";
			try {
				input = this.buffer.readLine();
			} catch (IOException e) {
				return; //Exception happens only when the console is closed, nothing to do
			}
			if (this._syntaxChecker.checkInputs(input) == false) {
				break;
			}
		}
		return;
	}
}