package br.com.mv.mvspring.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 6583517129052956885L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
