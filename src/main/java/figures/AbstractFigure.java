package figures;

abstract class AbstractFigure implements Figure {
    @Override
    public Figure clone() {
        try {
            return (Figure) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
