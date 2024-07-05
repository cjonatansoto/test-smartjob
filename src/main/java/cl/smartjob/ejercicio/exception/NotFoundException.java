package cl.smartjob.ejercicio.exception;

public class NotFoundException extends RuntimeException{

    private static final String ERROR_MESSAGE = "Record no exist in %s";

    public NotFoundException(String table) {
        super(String.format(ERROR_MESSAGE, table));
    }

}
