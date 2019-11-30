package market;

import java.util.ArrayList;

public class CashDesk {

    private ArrayList<Bill> m_cotumer_cashDesk = new ArrayList<>();


    public ArrayList<Bill> GetCostumerInCashDesk()
    {
        return m_cotumer_cashDesk;
    }


    public void ContumerInCashDesk(Costumer costumer, double total_price) {
        m_cotumer_cashDesk.add(new Bill(costumer, total_price));
    }
}
