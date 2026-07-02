package zoo;

import zoo.animal.Animal;
import zoo.animal.Mammal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Zoo {

    private static final Logger LOGGER = Logger.getLogger(Zoo.class.getName());

    private final List<Enclosure<? extends Animal>> enclosures = new ArrayList<>();

    public void addEnclosure(Enclosure<? extends Animal> enclosure) {
        LOGGER.info("Gehege hinzufügen: " + enclosure.getName());

        enclosures.add(enclosure);

        LOGGER.fine("Anzahl Gehege: " + enclosures.size());
    }

    public List<Enclosure<? extends Animal>> getEnclosures() {
        LOGGER.info("Alle Gehege abrufen");
        return List.copyOf(enclosures);
    }

    public Enclosure<? extends Animal> findEnclosureByName(String name) {
        LOGGER.info("Suche Gehege: " + name);

        Enclosure<? extends Animal> enclosure = enclosures.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (enclosure == null) {
            LOGGER.warning("Gehege nicht gefunden: " + name);
        }

        return enclosure;
    }

    public List<Animal> getAllAnimals() {
        LOGGER.info("Alle Tiere abrufen");

        return enclosures.stream()
                .flatMap(e -> e.getInhabitants().stream())
                .map(a -> (Animal) a)
                .toList();
    }

    public List<Mammal> getAllMammals() {
        LOGGER.info("Alle Säugetiere abrufen");

        return getAllAnimals().stream()
                .filter(Mammal.class::isInstance)
                .map(Mammal.class::cast)
                .toList();
    }

    public List<Animal> getAnimalsByPredicate(Predicate<Animal> predicate) {
        LOGGER.info("Tiere nach Prädikat filtern");

        return getAllAnimals().stream()
                .filter(predicate)
                .toList();
    }

    public Map<Class<?>, Long> countAnimalsByType() {
        LOGGER.info("Tiere nach Typ zählen");

        return getAllAnimals().stream()
                .collect(Collectors.groupingBy(Object::getClass, Collectors.counting()));
    }

    public List<Enclosure<? extends Animal>> getOvercrowdedEnclosures(int maxAnimals) {
        LOGGER.info("Überfüllte Gehege suchen");

        return enclosures.stream()
                .filter(e -> e.getInhabitants().size() > maxAnimals)
                .toList();
    }

    public String summary() {
        LOGGER.info("Zoo-Zusammenfassung erstellen");

        long animals = getAllAnimals().size();
        long mammals = getAllMammals().size();

        return "Zoo mit " + enclosures.size()
                + " Gehegen und "
                + animals
                + " Tieren: "
                + mammals
                + " Mammals";
    }
}