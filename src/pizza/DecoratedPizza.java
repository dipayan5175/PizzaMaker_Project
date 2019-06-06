package pizza;

abstract class DecoratedPizza
{
	private DecoratedPizza next_pizza_item;

	public DecoratedPizza()
	{
		next_pizza_item = null;
	}

	public DecoratedPizza(DecoratedPizza decoratedPizza)
	{
		this.next_pizza_item = decoratedPizza;
	}

	//get the cost from the "next_pizza_item" DecoratedPizza
	public double getCost() 
	{
		//return next_pizza_item.getCost();

		if(next_pizza_item == null){

			return 0.0;
		}
		else{
			return next_pizza_item.getCost();
		}
	}

	//get the state of the "next_pizza_item" DecoratedPizza
	public String toString()
	{

	//	return next_pizza_item.toString();

		if(next_pizza_item == null){
			return "";
		}
		else
		{
			return next_pizza_item.toString();
		}
	}
	
	//get the abbreviation of the "next_pizza_item" DecoratedPizza 
	//(the topping abbreviation is used to obtain the correct pizza image)
	public String getImage()
	{	

		if(next_pizza_item == null){

			return "";
		}
		else{
			return next_pizza_item.getImage();	
		}
	}
};