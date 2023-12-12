package exceptions;

public class ArrayIsNotSortedException extends RuntimeException{
    public ArrayIsNotSortedException(String o) {
        super(o);
    }
    public ArrayIsNotSortedException() {
        super();
    }
}
