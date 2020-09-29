package HackerRank.MatchGroup;

import java.util.Scanner;

abstract class Cuisine {
    public abstract Cuisine serveFood(String dish);
}

class UnservableCuisineRequestException extends Exception {
    public UnservableCuisineRequestException(String message) {
        super(message);
    }
}

class Chinese extends Cuisine {

    private static final String DISH = "Lamian";

    public String getDish() {
        return DISH;
    }

    @Override
    public Cuisine serveFood(String dish) {
        return null;
    }
}

class Italian extends Cuisine {

    private static final String DISH = "Lasagne";

    public String getDish() {
        return DISH;
    }

    @Override
    public Cuisine serveFood(String dish) {
        return null;
    }
}

class Japanese extends Cuisine {

    private static final String DISH = "Kamameshi";

    public String getDish() {
        return DISH;
    }

    @Override
    public Cuisine serveFood(String dish) {
        return null;
    }
}

class Mexican extends Cuisine {

    private static final String DISH = "Machaca";

    public String getDish() {
        return DISH;
    }

    @Override
    public Cuisine serveFood(String dish) {
        return null;
    }
}

/*
 * Create the FoodFactory class and other required classes here.
 */

class FoodFactory {

    private static final String MESSAGE = "Unservable cuisine %s for dish %s";

    // Singleton pattern
    private static FoodFactory singleton = null;

    private String[] keys;
    private Cuisine[] cuisines;

    private int index;

    // private Map<String, Cuisine> cuisines;

    private FoodFactory() {
        // cuisines = new HashMap<>();
        keys = new String[100];
        cuisines = new Cuisine[100];
        index = 0;
    }

    public static FoodFactory getFactory() {
        if (singleton == null) {
            singleton = new FoodFactory();
        }
        return singleton;
    }

    public void registerCuisine(String cuisineKey, Cuisine cuisine) {
        // cuisines.put(cuisineKey, cuisine);
        keys[index] = cuisineKey;
        cuisines[index] = cuisine;
        index++;
    }

    public Cuisine serveCuisine(String cuisineKey, String dish) throws UnservableCuisineRequestException {
        for (int i = 0; i < index; i++) {
            if (keys[i].equals(cuisineKey)) {
                return cuisines[i];
            }
        }
        throw new UnservableCuisineRequestException(String.format(MESSAGE, cuisineKey, dish));
        // if (cuisines.containsKey(cuisineKey)) {
        //     throw new UnservableCuisineRequestException(String.format(MESSAGE, cuisineKey, dish));
        // }
        // return cuisines.get(cuisineKey);
    }
}

public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final FoodFactory FOOD_FACTORY = FoodFactory.getFactory();

    static {
        FoodFactory.getFactory().registerCuisine("Chinese", new Chinese());
        FoodFactory.getFactory().registerCuisine("Italian", new Italian());
        FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
        FoodFactory.getFactory().registerCuisine("Mexican", new Mexican());
    }

    public static void main(String[] args) {
        int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
        while (totalNumberOfOrders-- > 0) {
            String[] food = INPUT_READER.nextLine().split(" ");
            String cuisine = food[0];
            String dish = food[1];

            try {
                if (FOOD_FACTORY.equals(FoodFactory.getFactory())) {
                    Cuisine servedFood = FOOD_FACTORY.serveCuisine(cuisine, dish);

                    switch (cuisine) {
                        case "Chinese":
                            Chinese chineseDish = (Chinese) servedFood;
                            System.out.println("Serving " + chineseDish.getDish() + "(Chinese)");
                            break;
                        case "Italian":
                            Italian italianDish = (Italian) servedFood;
                            System.out.println("Serving " + italianDish.getDish() + "(Italian)");
                            break;
                        case "Japanese":
                            Japanese japaneseDish = (Japanese) servedFood;
                            System.out.println("Serving " + japaneseDish.getDish() + "(Japanese)");
                            break;
                        case "Mexican":
                            Mexican mexicanDish = (Mexican) servedFood;
                            System.out.println("Serving " + mexicanDish.getDish() + "(Mexican)");
                            break;
                        default:
                            break;
                    }
                }
            } catch (UnservableCuisineRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}