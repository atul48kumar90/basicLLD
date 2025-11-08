package ShreyanshJain.DecorayprDesignPattern.dpatternpractice;

public class Main {
    public static void main(String[] args) {
        Pizza basicPizza = new Margerita();
        System.out.println(basicPizza.getDescription() + " " + basicPizza.getCost());

        Pizza cheesePizza = new ExtraCheese(basicPizza);
        System.out.println(cheesePizza.getDescription() + " -> ₹" + cheesePizza.getCost());
    }
}
