package market;

import java.util.ArrayDeque;

public class Basket {
    private ArrayDeque<Product> m_deqBasket = new ArrayDeque<>();

    public ArrayDeque<Product> getAllBaskets()
    {
        return m_deqBasket;
    }

    public void putIntoBasket(Product m_product)
    {
        m_deqBasket.add(m_product);
    }
}
