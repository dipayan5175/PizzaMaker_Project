package pizza;

public class MeatLovers extends PizzaBuilder
{
	public MeatLovers()
	{
		super();
	}

	public void buildPizza()
	{
		super.buildPizza();

		super.addTopping('H');
		super.addTopping('S');
		super.addTopping('P');
	}	
};
