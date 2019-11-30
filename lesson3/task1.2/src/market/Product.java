package market;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


enum EnmProduct
{
    units,
    wieght
}

 class FabricaProducts {

    private Product[] m_all_products  = {new Product("Milk", 2, EnmProduct.units, 32.50, true),
            new Product("Eggs", 10, EnmProduct.units,10.50, true),
            new Product("Sugar", 23.235, EnmProduct.wieght, 30.0, true),
            new Product("Magazie", 5, EnmProduct.units, 23, true),
            new Product("Toys", 12,EnmProduct.units, 150, true),
            new Product("Cigarette", 12, EnmProduct.units, 250, true),
            new Product("Potatoes", 104.8, EnmProduct.units, 25, true)
    };

    public Product[] getAllProducts()
    {
        return m_all_products;
    }

}


public class Product implements  Cloneable {
    private String name;
    private double units;
    private EnmProduct enmProduct;
    private double price;
    private  boolean isChild = true;


    Product() {
    }

    Product(String name, double units, EnmProduct enmProduct, double price, boolean isChild) {
        this.name = name;
        this.units = units;
        this.enmProduct = enmProduct;
        this.price = price;
        this.isChild = isChild;
    }


    public Product[] getAllProducts() {
        FabricaProducts fabricaProducts = new FabricaProducts();
        Product[] m_all_products = fabricaProducts.getAllProducts();
        return m_all_products;
    }

    public Product[] FormProduct() {
        Product product = new Product();
        Integer rndP = new Random().nextInt(product.getAllProducts().length);
        if (rndP < 3) {
            rndP = 3;
        }

        Product[] formed_Products = new Product[rndP];
        ArrayList<Integer> rndRep = new ArrayList<>();

        while (rndRep.size() != formed_Products.length) {
            int rnd = new Random().nextInt(product.getAllProducts().length);

            if (!rndRep.contains(rnd))
                rndRep.add(rnd);
        }


        for (int i = 0; i < formed_Products.length; i++) {
            Product[] products = product.getAllProducts();
            formed_Products[i] = products[rndRep.get(i)];
        }

        return formed_Products;
    }


    public void PrintFormedProductDetails(Product[] products) {
        System.out.println("Products Have been formed:");
        for (Product product : products) {
            System.out.println(product.units + " " + product.name + " " + product.enmProduct);
        }
    }

    public boolean isChild()
    {
        return isChild;
    }


    public String getName() {
        return this.name;
    }

    public double getUnits() {
        return this.units;
    }

    public EnmProduct getMessurment() {
        return this.enmProduct;
    }

    public double getPrice() {
        return this.price;
    }

    public void setUnits(double units)
    {
        this.units = units;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Product clone() throws CloneNotSupportedException{
        return (Product) super.clone();
    }
}
