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
				System.out.println("Type \"clear\" to erase all previous calculations.");
				System.out.println("Type \"help\" to see this help.");
				System.out.println("Type \"quit\" to quit.");
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