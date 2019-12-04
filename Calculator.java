import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

class Calculator {
	
	Stack stack;
	BufferedReader buffer;
	
	public Calculator() {
		this.stack = new Stack();
		this.buffer = new BufferedReader(new InputStreamReader(System.in));
	}
	
	private boolean executeCommand(String s) {
		switch (s) {
			case "quit":
				return false;
			default:
		}
		return true;
	}
	
	public void loop() {
		while (true) {
			
			System.out.print("RPN Calculator >");
			
			String line = "";
			try {
				line = this.buffer.readLine();
			} catch (IOException e) {}
			
			ArrayList<String> args = new ArrayList<String>(Arrays.asList(line.split(" ")));
			System.out.println(args);
			
			if (args.size() == 1) {
				if (this.executeCommand(args.get(0)) == false) {
					break;
				}
			}
			if (args.size() > 1) {
				for (String arg : args) {
					this.stack.push(arg);
				}
			}
		}
		return;
	}
}