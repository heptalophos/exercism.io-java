class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        if (operation != null) {
            switch (operation) {
                case "+": 
                    return calcStr( "+", operand1, operand2, 
                                    operand1 + operand2 );
                case "*": 
                    return calcStr( "*", operand1, operand2, 
                                    operand1 * operand2 );
                case "/":
                    try {
                        return calcStr( "/", operand1, operand2, 
                                        operand1 / operand2 );
                    } catch (ArithmeticException aex) {
                        throw new IllegalOperationException(
                            "Division by zero is not allowed", aex
                        );
                    }
                case "": 
                    throw new IllegalArgumentException(
                        "Operation cannot be empty"
                    );
                default:
                    throw new IllegalOperationException(
                        String.format(
                            "Operation '%s' does not exist", operation
                        )
                    );
            }
        } 
        throw new IllegalArgumentException(
                "Operation cannot be null", null // Haha 😄
        );
    }

    private String calcStr(String binop, int arg1, int arg2, int eval) {
        return String.format("%d %s %d = %d", arg1, binop, arg2, eval);
    }
}
