package hello;

/**
 * Created by grzegorzweznerowicz on 19.04.2016.
 */
public class Company {
    private String symbol;
    private String name;
    private String exchange;

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getExchange() {
        return exchange;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
