public class Client
{
	public static void main(String[] args)
	{
		System.out.println("\nTest 1\n******************************");
		Flower f1 = new Flower("Rose");
		System.out.println(f1.getFlower());
		
		System.out.println("\nTest 2\n******************************");	
		Cauliflower c1 = new Cauliflower("white");
		System.out.println(c1.getFlower() + " is " + c1.getColor() + ".");
		c1.isEdible();

		System.out.println("\nTest 3\n******************************");
		Iris i1 = new Iris("purple");
		System.out.println(i1.getFlower() + " is " + i1.getColor() + ".");
		i1.isEdible();

		System.out.println();
	}
}
