public class Cauliflower extends Flower
{
	private String color;
	
	public Cauliflower()
	{
		super("Cauliflower");
		this.color = "white";
	}

	public Cauliflower(String color)
	{
		super("Cauliflower");
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
		System.out.println("This flower is edible.");
	}
}
