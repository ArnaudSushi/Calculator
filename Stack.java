import java.util.ArrayList;
import java.util.Collections;

class Stack {

	private boolean printResult = false;
	private ArrayList<Float> registers;
	
	public Stack() {
		this.registers = new ArrayList<Float>();
	}
	
	public void printRegisters() {
		ArrayList<Float> reverseRegister = new ArrayList<Float>(this.registers);
		Collections.reverse(reverseRegister);
		if (this.printResult) {
			System.out.println("Result : " + this.registers.get(0));
		}
		System.out.println("Stack : " + reverseRegister);
	}
	
	public void push(float number) {
		this.registers.add(0, number);
		this.printResult = false;
	}
	
	private void checkTwoOperands() throws NullPointerException {
		if (this.registers.size() < 2) throw new NullPointerException();
	}
	
	private float pop() {
		return this.registers.remove(0);
	}
	
	public void clear() {
		this.registers.clear();
		this.printRegisters();
	}
	
	//Operations
	public void add() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, this.pop() + this.pop());
			this.printResult = true;
		} catch (NullPointerException e) { System.out.println("Not enough numbers in the stack to perform addition"); }
	}
	
	public void sub() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, - this.pop() + this.pop());
			this.printResult = true;
		} catch (NullPointerException e) { System.out.println("Not enough numbers in the stack to perform substraction"); }
	}
	
	public void mul() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, this.pop() * this.pop());
			this.printResult = true;
		} catch (NullPointerException e) { System.out.println("Not enough numbers in the stack to perform multiplication"); }
	}
	public void div() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, 1/this.pop() * this.pop());
			this.printResult = true;
		} catch (NullPointerException e) { System.out.println("Not enough numbers in the stack to perform division"); }
	}
}