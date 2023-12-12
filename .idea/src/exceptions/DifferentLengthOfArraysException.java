package exceptions;

public class DifferentLengthOfArraysException extends RuntimeException{
    public DifferentLengthOfArraysException(String o) {
        super(o);
    }
    public DifferentLengthOfArraysException() {
        super();
    }
}
