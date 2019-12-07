class CommandHandler {
	
	Stack stack;
	
	public CommandHandler(Stack stack) {
		this.stack = stack;
	}
	
	public boolean executeCommand(String s) {
		switch (s) {
			case "clear":
				System.out.print("\033[H\033[2J");
				System.out.flush();
				this.stack.clear();
				break;
			case "help":
				System.out.println("Please enter an RPN expression or a command: ");
				System.out.println("  RPN expression involves float numbers and the operation +, -, *, / (e.g.: 1.1 -2 +).");
				System.out.println("  A fully evaluated expression will display the result.");
				System.out.println("  Incomplete expression are evaluated and the resulting stack is displayed.");
				System.out.println("  Type \"clear\" to erase all previous calculations and empty the stack.");
				System.out.println("  Type \"help\" to see this help.");
				System.out.println("  Type \"quit\" to quit.");
				break;
			case "quit":
				return false;
			default:
				System.out.println("Unknown command, please type \"help\" to see the existing commands");
				break;
		}
		return true;
	}
}