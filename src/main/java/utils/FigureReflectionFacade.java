package utils;

import figures.Figure;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Set;

public class FigureReflectionFacade {

    public Class<? extends Figure> getFigureClass(String figureType) throws IllegalArgumentException {
        return this.getFigureClasses().stream()
                .filter(clazz -> clazz.getSimpleName().equalsIgnoreCase(figureType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown figure type: " + figureType));
    }

    public Set<Class<? extends Figure>> getFigureClasses() {
        Reflections reflections = new Reflections("figures");

        // Get all subclasses of your target class
        Set<Class<? extends Figure>> subclasses = reflections.getSubTypesOf(Figure.class);
        subclasses.removeIf(subclass -> Modifier.isAbstract(subclass.getModifiers()));
        return subclasses;
    }

    public Figure getFigure(Class<? extends Figure> figureClass, Double[] params) {
        if (figureClass == null) {
            throw new IllegalArgumentException("Figure class is null");
        }
        for (Constructor<?> c : figureClass.getConstructors()) {
            if (!this.areParamsValid(c.getParameterTypes(), params)) {
                continue;
            }
            try {
                return (Figure) c.newInstance(params);
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to create figure instance", e);
            }
        }
        throw new IllegalArgumentException("No suitable constructor found for figure class: " + figureClass.getSimpleName());
    }

    private boolean areParamsValid(Class<?>[] parameterTypes, Double[] params) {
        if (parameterTypes.length != params.length) {
            return false;
        }
        for (Class<?> parameterType : parameterTypes) {
            if (!parameterType.equals(double.class)) {
                return false;
            }
        }
        return true;
    }

    public int getConstructorArgumentCount(Class<? extends Figure> figureClass) {
        return figureClass.getConstructors()[0].getParameterCount();
    }
}
