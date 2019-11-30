package market;

public class Bill {
    private Double bill;
    private Costumer costumer;

    Bill(Costumer costumer, double bill)
    {
        this.bill = bill;
        this.costumer = costumer;
    }

    public Double getBill() {
        return bill;
    }
    public Costumer getCostumer(){
        return costumer;
    }
}
