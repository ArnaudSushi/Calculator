import java.util.ArrayList;

class Stack {

	private float result;
	private ArrayList<Float> registers;
	
	public Stack() {
		this.registers = new ArrayList<Float>();
	}
	
	public void printRegisters() {
		System.out.println("Stack : " + this.registers);
	}
	
	public void push(float number) {
		this.registers.add(0, number);
	}
	
	private void checkTwoOperands() throws NullPointerException {
		if (this.registers.size() < 2) throw new NullPointerException(); //todo
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
		} catch (NullPointerException e) { System.out.println("Not enough numbers in the stack to perform addition"); }
	}
	
	public void sub() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, - this.pop() + this.pop());
		} catch (NullPointerException e) { System.out.println("Not enough numbers in the stack to perform substraction"); }
	}
	
	public void mul() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, this.pop() * this.pop());
		} catch (NullPointerException e) { System.out.println("Not enough numbers in the stack to perform multiplication"); }
	}
	public void div() {
		try {
			this.checkTwoOperands(); //Throws exception if less than 2 operands.
			this.registers.add(0, 1/this.pop() * this.pop());
		} catch (NullPointerException e) { System.out.println("Not enough numbers in the stack to perform division"); }
	}
}