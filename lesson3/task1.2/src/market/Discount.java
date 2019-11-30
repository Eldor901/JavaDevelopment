package market;

public class Discount {
    final double a = 0.2;

    public double DisCountRetired(Double total)
    {
        return (total - total*0.2);
    }

    public double DisCountMoreThanThousand(Double total)
    {
        return (total - total*0.15);
    }
}
