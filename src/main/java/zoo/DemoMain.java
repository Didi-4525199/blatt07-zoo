package zoo;

import zoo.animal.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoMain {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Zoo.class.getName());
        logger.setLevel(Level.FINE);

        Zoo zoo = new Zoo();

        MammalHouse<Mammal> mammals = new MammalHouse<>("Mammals");
        Aquarium<Fish> aquarium = new Aquarium<>("Aquarium");

        mammals.add(new Monkey("Max"));
        mammals.add(new Lynx("Luna"));

        aquarium.add(new Shark("Bruce"));
        aquarium.add(new Goldfish("Goldie"));

        zoo.addEnclosure(mammals);
        zoo.addEnclosure(aquarium);

        System.out.println(zoo.summary());
    }
}