package callable;

import java.util.concurrent.Callable;

public class ComplexMathCallable implements Callable<Double> {
    private ComplexMath cm;
    private int startColumn, endColumn;

    ComplexMathCallable(ComplexMath cm, int startColumn, int endColumn) {
        this.cm = cm;
        this.startColumn = startColumn;
        this.endColumn = endColumn;
    }

    @Override
    public Double call() {
        double result = 0.0;
        for (int column = startColumn; column <= endColumn; column++) {
            result += cm.doComplexMathForColumn(column);
        }
        return result;
    }
}
