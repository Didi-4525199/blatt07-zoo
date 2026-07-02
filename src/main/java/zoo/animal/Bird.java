package zoo.animal;

public sealed interface Bird extends Animal permits Penguin, Owl {
}