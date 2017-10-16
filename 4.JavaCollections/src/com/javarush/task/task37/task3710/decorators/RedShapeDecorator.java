package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

/**
 * Created by USER-PC on 14.10.2017.
 */
public class RedShapeDecorator extends ShapeDecorator {
    private Shape decoratedShape;
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.decoratedShape = decoratedShape;
    }

    /*
    2) Реализуй приватный метод setBorderColor с одним параметром типа Shape.
    Он должен выводить на экран фразу «Setting border color for XXX to red.«,
    где XXX — имя конкретного декорируемого класса (можешь воспользоваться методами getClass().getSimpleName()
    вызванными на объекте полученном в качестве параметра).
    3) Переопредели метод draw, в нем сначала измени цвет отображаемого объекта с помощью метода setBorderColor,
     а потом нарисуй его.
     */
private void setBorderColor(Shape shape){
    String nameClass = shape.getClass().getSimpleName();
    System.out.println(String.format("Setting border color for %s to red.",nameClass));
}

    @Override
    public void draw() {
    setBorderColor(decoratedShape);
    super.draw();
    }
}
