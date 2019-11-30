package market;

import java.sql.Time;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Supermarket {
    Product[] m_products;
    Product[] m_all_products = new  Product[10] ;
    double TotalIncome = 0;
    Costumer[] m_costumers;

    final float closeTime = (float) 1.3;
    final  int startTime =  3;
    final int maxUnits = 4;
    private CashDesk m_cashDesk = new CashDesk();
    double millisInDay = 60*60*1000;

    public  void  Open(){
        Time time = new Time((long)(millisInDay*3));
        millisInDay = millisInDay * startTime;
        System.out.printf(String.valueOf(time) + " ");
        System.out.println("Supermarket products have been formed"
        );
    }

    public void FormProduct() {
        Product product = new Product();
        m_products = product.FormProduct();
        product.PrintFormedProductDetails(m_products);

        for(int i = 0; i< m_products.length; i++)
        {
            try {
                m_all_products[i] = m_products[i].clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    public void FormCostumers()
    {
        Costumer costumer = new Costumer();
        m_costumers = costumer.getFormedCostumer();
        costumer.printFormedCostumer(m_costumers);
    }

    public void CostumerFillBasket()
    {

        Basket basket = new Basket();

        for(int i = 0; i < m_costumers.length; i++)
        {
            Costumer costumer = m_costumers[i];

            for(int j = 0; j < m_products.length ; j++)
            {

                int rndP = new Random().nextInt(m_products.length);
                double rndU = new Random().nextInt(maxUnits);
                rndU++;

                Product basketWithProduct = new Product(m_products[rndP].getName(),
                        rndU, m_products[rndP].getMessurment(), 0, true);


                if (m_products[rndP].getUnits() > rndU)
                {
                    if (costumer.getCategory() == CostumerCategory.Child && !m_products[rndP].isChild())
                    {
                       break;
                    }else
                     {
                        m_products[rndP].setUnits(m_products[rndP].getUnits() - rndU);
                        basketWithProduct.setUnits(rndU);
                        basketWithProduct.setPrice(m_products[rndP].getPrice() * rndU);
                        basket.putIntoBasket(basketWithProduct);
                    }
                }
            }

            String CostumerProduct = "";
            double total_price = 0;


            for (Product basketProduct: basket.getAllBaskets()) {
                CostumerProduct += basketProduct.getName() + " " + basketProduct.getUnits() + " " + basketProduct.getMessurment() + " " + basketProduct.getPrice()+ "\n";
                total_price += basketProduct.getPrice();
            }

            System.out.println(costumer.getCategory() + " Picked Up At" );
            System.out.println(CostumerProduct);
            m_cashDesk.ContumerInCashDesk(costumer, total_price);

        }


        System.out.println("___________________________");
    }

    public void inCashDesk(){
        Discount discount = new Discount();
        final int thousand = 1000;
        for (Bill bill: m_cashDesk.GetCostumerInCashDesk()) {
            int rnd = new Random().nextInt(2);
            PayMethods value = PayMethods.values()[rnd];
            double totalAmount = bill.getBill();
            float rndT = (float) ( Math.random() * 2 + 0.5);
            if (rndT <= 1)
                rndT = (float) 1.1;

            millisInDay = millisInDay * rndT;
            Time time = new Time((long)(millisInDay));
            System.out.printf(String.valueOf(time) + " ");
            System.out.println(bill.getCostumer().getCategory() + " Amount to Pay " + totalAmount);

            if (bill.getCostumer().getCategory() == CostumerCategory.Retired)
            {
                totalAmount =  discount.DisCountRetired(bill.getBill());
                System.out.printf("Recived 20 percent discount ");
            }
            else if (bill.getBill() > thousand)
            {
                totalAmount = discount.DisCountMoreThanThousand(bill.getBill());
                System.out.println("Recived 15 percent discount ");
            }
            System.out.println(bill.getCostumer().getCategory() + " Paid with " + value + " " + totalAmount);
            System.out.println();
            TotalIncome += totalAmount;
        }
        System.out.println("__________________________");
    }


    public void SuperMarketClosed()
    {
        Time time = new Time((long)(millisInDay * closeTime));
        System.out.println(time);
        System.out.println("SuperMarket Closed");
        System.out.println("Total Income Today: "+ TotalIncome);
        Report report = new Report();
        report.Info(m_products, m_all_products);

    }
}
