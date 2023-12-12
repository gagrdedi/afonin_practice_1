package exceptions;

import operations.TabulatedFunctionOperationService;

public class InconsistentFunctionException extends RuntimeException{
    public InconsistentFunctionException(String o) {
        super(o);
    }
    public InconsistentFunctionException() {
        super();
    }


}

