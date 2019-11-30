package market;


import java.util.Random;


enum  CostumerCategory{
    Child,
    Adult,
    Retired
}


class  FabricaCostumer{
    Costumer[] m_Create_Costumer = {new Costumer("Costumer ", CostumerCategory.Adult),
            new Costumer("Costumer ", CostumerCategory.Child),
            new Costumer("Costumer ", CostumerCategory.Retired),
            new Costumer("Costumer ", CostumerCategory.Retired),
    };

    public Costumer[] getAllCostumer()
    {
        return m_Create_Costumer;
    }
}



class  Costumer{
   private String costumer;
   private CostumerCategory costumerCategory;
   final  int maxCostumers = 4;

    Costumer()
    {

    }

    Costumer(String costumer,CostumerCategory costumerCategory)
    {
        this.costumer = costumer;
        this.costumerCategory = costumerCategory;
    }

    public Costumer[] getAllCostumer()
    {
        FabricaCostumer costumer = new FabricaCostumer();
        return costumer.getAllCostumer();
    }

    public Costumer[] getFormedCostumer()
    {
        Costumer costumer = new Costumer();
        Integer rndC = new Random().nextInt(costumer.getAllCostumer().length + 3);

        if (rndC < maxCostumers)
        {
            rndC = maxCostumers;
        }

        Costumer[] costumers = new Costumer[rndC];
        Costumer[] all_costumers = costumer.getAllCostumer();

        for(int i = 0; i< costumers.length; i++)
        {
            costumers[i] = all_costumers[new Random().nextInt(costumer.getAllCostumer().length)];
        }

        return costumers;
    }

    public void printFormedCostumer(Costumer[] costumers)
    {
        System.out.println("Costumers In SuperMarket:");
        int i = 1;
        for (Costumer costumer : costumers) {
            System.out.println( i + " " + costumer.costumerCategory + " " + costumer.costumer);
            i++;
        }
    }

    public CostumerCategory getCategory()
    {
        return this.costumerCategory;
    }

    public String getCostumer()
    {
        return this.costumer;
    }
}

