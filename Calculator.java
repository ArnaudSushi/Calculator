import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Calculator {
	
	private Stack stack;
	private BufferedReader buffer;
	private SyntaxChecker sc;
	
	public Calculator() {
		this.stack = new Stack();
		this.buffer = new BufferedReader(new InputStreamReader(System.in));
		this.sc = new SyntaxChecker(this.stack);
	}
		
	public void loop() {
		while (true) {
			System.out.print("RPN Calculator >");
			
			String input = "";
			try {
				input = this.buffer.readLine();
			} catch (IOException e) {
				//todo
			}
			if (this.sc.checkInputs(input) == false) {
				break;
			}
		}
		return;
	}
}