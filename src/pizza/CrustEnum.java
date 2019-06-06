package pizza;

enum CrustSize
{
	S(5.99), M(7.99), L(9.99);

    private double value;
    
    private CrustSize(double val){
        value = val;
    }
    
    public double cost()
    {
        return value;
    }

};

enum CrustType
{
	THIN(0.00), HAND(0.50), PAN(1.00);

    private double value;
    
    private CrustType(double val){
        value = val;
    }
    
    public double cost()
    {
        return value;
    }

};
