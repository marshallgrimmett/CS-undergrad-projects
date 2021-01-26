/**
 * 
 */

/**
 * @author marshallgrimmett
 *
 */
public class Registers {
	private Register[] registers;
	
	public Registers() {
		this.registers = new Register[16];
	}

	/**
	 * @param index of register
	 * @return register
	 */
	public Register getRegister(int index) {
		return registers[index + 1];
	}

	/**
	 * @param index of register
	 * @param value to set
	 */
	public void setRegister(int index, int value) {
		this.registers[index + 1].setValue(value);
	}

}
