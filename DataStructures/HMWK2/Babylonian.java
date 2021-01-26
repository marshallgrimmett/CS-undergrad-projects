// Babylonian.java
// Author: Marshall Grimmett
// Date: 2/26/2017
// Description:
//    This class uses the babylonian method to calculate the square root of a number.
//    The user specifies the value to be calulated and the precision of the output.
// PDMs: num - the value to be calculated
//         accuracy - precision of calculation
// Constructors: Only one non default Constructor
// Methods: sqrt() - has one polymorphic method for verification.

public class Babylonian {
  // private data members
  private float num;
  private int accuracy;

  // Constructors
  public Babylonian(float num, int accuracy) {
    this.num = num;
    this.accuracy = accuracy;
  }

  // Methods

  // Polymorphic definition for square root function
  // Returns a float representing the root of a number
  // Returns -1 otherwise
  public float sqrt() {
    // Check for valid numbers
    if(this.num > 0 && this.accuracy >= 0)
      return sqrt(num / 2, 0);
    else
      return -1;
  }

  // Recursive method for finding the square root of a number using the Babylonian method.
  // Parameters: num = the value to be square rooted
  //             count = the accuracy the user specifies so we do not overflow
  private float sqrt(float num, int count) {
    if(this.num - num * num == 0 || count == this.accuracy)
      return num;
    else {
      count++;
      return sqrt((num + this.num / num) / 2, count);
    }
  }
}
