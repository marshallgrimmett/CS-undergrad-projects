/**
 * 
 */

/**
 * @author marshallgrimmett
 *
 */
public class Operation {
	protected int opcode;
	protected String operation;
	protected String[] operands;
	protected InstructionFormat format;
	
	public Operation() {
		this.opcode = 0;
		this.operation = "";
		this.operands = null;
		this.format = InstructionFormat.standard;
	}
}
