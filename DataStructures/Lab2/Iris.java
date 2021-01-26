public class Iris extends Flower
{
	private String color;
	
	public Iris()
	{
		super("Iris");
		this.color = "purple";
	}

	public Iris(String color)
	{
		super("Iris");
		this.color = color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getColor()
	{
		return color;
	}
	
	public void isEdible()
	{
		System.out.println("This flower is not edible.");
	}
}
