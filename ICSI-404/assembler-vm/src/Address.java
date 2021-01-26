/**
 * 
 */

/**
 * @author marshallgrimmett
 *
 */
public class Address {
	private byte value;
	private Address next;
	
	public Address() {
		this.value = 0;
	}

	/**
	 * @return the value
	 */
	public byte getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(byte value) {
		this.value = value;
	}

	/**
	 * @return the next
	 */
	public Address getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Address next) {
		this.next = next;
	}
}
