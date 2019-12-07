import java.util.ArrayList;
import java.util.Collections;

class Stack {

	private ArrayList<Float> registers;
	
	public Stack() {
		this.registers = new ArrayList<Float>();
	}
	
	public void printResult() {
		if (this.registers.size() == 1) {
			System.out.println("Result : " + this.registers.get(0));
		}
	}
	
	public void printRegisters() {
		ArrayList<Float> reverseRegister = new ArrayList<Float>(this.registers);
		Collections.reverse(reverseRegister);
		System.out.println("Stack : " + reverseRegister);
	}
	
	public void push(float number) {
		this.registers.add(0, number);
	}
	
	private void checkTwoOperands() throws IllegalArgumentException {
		if (this.registers.size() < 2) throw new IllegalArgumentException();
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
		} catch (IllegalArgumentException e) {
			System.out.println("Excpecting at least 2 numbers in the stack to perform addition");
			throw e;
		}
	}
	
	public void sub() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, - this.pop() + this.pop());
		} catch (IllegalArgumentException e) {
			System.out.println("Excpecting at least 2 numbers in the stack to perform substraction");
			throw e;
		}
	}
	
	public void mul() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, this.pop() * this.pop());
		} catch (IllegalArgumentException e) {
			System.out.println("Excpecting at least 2 numbers in the stack to perform multiplication");
			throw e;
		}
	}
	public void div() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, 1/this.pop() * this.pop());
		} catch (IllegalArgumentException e) {
			System.out.println("Excpecting at least 2 numbers in the stack to perform division");
			throw e;
		}
	}
}