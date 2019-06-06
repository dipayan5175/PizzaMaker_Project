package pizza;

public class VeggieLovers extends PizzaBuilder
{
	public VeggieLovers()
	{
		super();
	}

	public void buildPizza()
	{
		super.buildPizza();

		super.addTopping('M');
		super.addTopping('O');
		super.addTopping('G');
	}
};
