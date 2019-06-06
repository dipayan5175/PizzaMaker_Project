package pizza;

public class Hawaiian extends PizzaBuilder
{
	public Hawaiian()
	{
		super();
	}


	public void buildPizza()
	{
		super.buildPizza();


		super.addTopping('H');
		super.addTopping('A');
	}
};
