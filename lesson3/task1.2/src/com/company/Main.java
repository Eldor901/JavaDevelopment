package com.company;
import market.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Supermarket sup = new Supermarket();
        sup.Open();
        sup.FormProduct();
        sup.FormCostumers();
        sup.CostumerFillBasket();
        sup.inCashDesk();
        sup.SuperMarketClosed();
    }
}
