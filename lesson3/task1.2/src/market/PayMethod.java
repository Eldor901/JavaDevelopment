package market;


enum PayMethods{
    Cash,
    Card
}

public class PayMethod {
    private market.PayMethod payMethod;

    public market.PayMethod getCash()
    {
        return  payMethod.getCash();
    }

    public market.PayMethod getCard()
    {
        return payMethod.getCard();
    }
}


