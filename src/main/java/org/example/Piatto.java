package org.example;

public class Piatto {
    private int id;
    private String descrizione;
    private String name;
    private double price;

    public Piatto(int id, String descrizione, String name, double price) {
        this.id = id;
        this.descrizione = descrizione;
        this.name = name;
        this.price = price;
    }

    public int expensive(Piatto p){
        if(this.price > p.getPrice())
            return 1;
        return 0;
    }

    public static Piatto[] testData(){
        return new Piatto[]{
                new Piatto(1, "lorem pollo", "Risotto alla milanese", 23.99),
                new Piatto(2, "gelato alla granita", "Gelato alla granita", 15.50),
                new Piatto(3, "cono normale", "Gelato", 5),
                new Piatto(4, "lorem aragosta", "Aragosta", 50.99),
                new Piatto(5, "per 27 persone", "Risotto alla cantonese", 30.50),
                new Piatto(6, "l'originale", "pollo", 10.70),
        };
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
