/**
 * 
 */

/**
 * @author marshallgrimmett
 *
 */
public class Memory {
	private Address head;
	private Address tail;
	
	public Memory() {
		this.head = null;
		this.head = null;
	}

	public void addAddress(Address newAddress) {
		if (this.head == null) {
			this.head = newAddress;
			this.tail = newAddress;
		}
		else {
			this.tail.setNext(newAddress);
			this.tail = newAddress;
		}
	}
}
