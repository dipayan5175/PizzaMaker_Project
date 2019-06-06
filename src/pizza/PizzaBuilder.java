package pizza;

public class PizzaBuilder
{
	private Crust crust;
	private DecoratedPizza top;
	private CrustSize size;
	private CrustType type;

	//create a Crust and a Pizza using that Crust based on the 
	//user's specifications (the Pizza is now ready for toppings)
	protected void buildPizza()
	{
		Crust crust = new Crust(size, type);
		Pizza pizza = new Pizza(crust);
		top = pizza;
	}

	//start with a small, thin pizza with no toppings as the default
	public PizzaBuilder()
	{
		this.size = CrustSize.S;
		this.type = CrustType.THIN;
	}

	public void addDiscount()
	{
		if(!(top instanceof PizzaFee))
		{
			PizzaDiscount pd = new PizzaDiscount(top);
			top = pd;
		}
	}

	public void addFee()
	{
		PizzaFee fees = new PizzaFee(top);
		top = fees;
	}

	//returns true if the input was valid ("S" or "small", etc., not case sensitive)
	public boolean setSize(char try_size)
	{
		char c = Character.toLowerCase(try_size);
			

		if(c == 's')
		{
			size = CrustSize.S;
			return true;
		}

		else if(c == 'm')
		{
			size = CrustSize.M;
			return true;
		}

		else if(c == 'l')
		{
			size = CrustSize.L;
			return true;
		}

		return false;
	}

	//("thin", "hand", or "pan", not case sensitive)
	public boolean setCrust(String try_crust)
	{
		String str = try_crust.toLowerCase();
		
		if(str.equals("thin"))
		{
			type = CrustType.THIN;
			return true;
		}

		else if(str.equals("hand"))
		{
			type =  CrustType.HAND;
			return true;
		}

		else if(str.equals("pan"))
		{
			type = CrustType.PAN;
			return true;
		}

		return false;
	}


	//////////////////////////////////////////////////////////////////
	//This is not using PizzaTopping and PizzaToppingFactory classes//
	//////////////////////////////////////////////////////////////////
	//compare the topping abbreviation to topping_char to 
	//determine which topping to add 
	//(using void here is convenient for the PizzaDriver, ignore invalid abbreviations)
	/*
	public void addTopping(char topping_char)
	{
		char c = Character.toLowerCase(topping_char);
		
		if(!(top instanceof PizzaDiscount) && !(top instanceof PizzaFee)) 
		{
			if(c == 'p')
			{
				Pepperoni pepperoni = new Pepperoni(top);
				top = pepperoni;
				return;
			}

			else if(c == 's')
			{
				Sausage sausage = new Sausage(top);
				top = sausage;
				return;
			}

			else if(c == 'o')
			{
				Onions onions = new Onions(top);
				top = onions;
				return;
			}

			else if(c == 'g')
			{
				GreenPeppers greenPeppers = new GreenPeppers(top);
				top = greenPeppers;
				return;
			}

			else if(c == 'm')
			{
				Mushrooms mushrooms = new Mushrooms(top);
				top = mushrooms;
				return;
			}

			else if(c == 'h')
			{
				Ham ham = new Ham(top);
				top = ham;
				return;
			}

			else if(c == 'a')
			{
				Pineapple pineapple = new Pineapple(top);
				top = pineapple;
				return;
			}
		}

	}*/

		public void addTopping(char topping_char)
	{
		char c = Character.toLowerCase(topping_char);
		
		if(!(top instanceof PizzaDiscount) && !(top instanceof PizzaFee)) 
		{
			if(c == 'p')
			{
				top = PizzaToppingFactory.addPepperoni(top);
				return;
			}

			else if(c == 's')
			{
				top = PizzaToppingFactory.addSausage(top);
				return;
			}

			else if(c == 'o')
			{
				top = PizzaToppingFactory.addOnions(top);
				return;
			}

			else if(c == 'g')
			{
				top = PizzaToppingFactory.addGreenPeppers(top);
				return;
			}

			else if(c == 'm')
			{
				top = PizzaToppingFactory.addMushrooms(top);
				return;
			}

			else if(c == 'h')
			{
				top = PizzaToppingFactory.addHam(top);
				return;
			}

			else if(c == 'a')
			{
				top = PizzaToppingFactory.addPineapple(top);
				return;
			}
		}

	}

	//return the final DecoratedPizza and reset to 
	//the default pizza if another pizza is desired
	public DecoratedPizza pizzaDone()
	{
		return this.top;
	}

};