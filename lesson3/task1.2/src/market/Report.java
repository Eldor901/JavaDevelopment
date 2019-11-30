package market;

public class Report {

    public void Info(Product[] products, Product[] all_products)
    {

        System.out.println("Left Products: ");
        for (Product product : products) {
            System.out.println(product.getUnits() + " " + product.getName() + " " + product.getMessurment());
        }
        System.out.println("___________________");


        for(int i = 0; i<products.length; i++)
        {
            all_products[i].setUnits(all_products[i].getUnits() - products[i].getUnits());
        }


        System.out.println("Sold Products:");
        for(int i = 0; i<products.length; i++)
        {
            System.out.println(all_products[i].getUnits() + " " + all_products[i].getName() + " " + all_products[i].getMessurment());
        }

    }
}
