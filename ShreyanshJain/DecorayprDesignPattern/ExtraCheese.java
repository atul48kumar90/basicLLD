package ShreyanshJain.DecorayprDesignPattern;


public class ExtraCheese extends ToppingDecorator {
    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50.0;
    }
}

class Mushroom extends ToppingDecorator {
    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 40.0;
    }
}

class Jalapeno extends ToppingDecorator {
    public Jalapeno(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Jalapeno";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 35.0;
    }
}
