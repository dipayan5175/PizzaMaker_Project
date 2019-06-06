
package pizza;

public class Crust
{
	private CrustSize crustSize;
	private CrustType crustType;
	
	public Crust(CrustSize size, CrustType type)
	{
		crustSize = size;
		crustType = type;
	}

	public String toString()
	{
		String str = "Your pizza: " + "\r\n"; 
		str += "Size: " + this.getSize() + "\r\n"; 
		str += "Crust: " + this.getCrust() + "\r\n"; 
		str += "Toppings: " + "\r\n";
		return str;
	}

	public String getCrust()
	{
		String type = crustType.toString();
		return type;
	}

	public char getSize()
	{
		String sz = crustSize.toString();
		return sz.charAt(0);
	}

	public double getCost()
	{
		return crustSize.cost() + crustType.cost();
	}

}
