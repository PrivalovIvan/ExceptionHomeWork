public class IncorrectGenderException extends RuntimeException {

    public IncorrectGenderException() {
        super("Некорректно введен пол");
    }

}