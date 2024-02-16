package task3;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    /*Задача 1:
    Создайте абстрактный класс "Animal" с полями "name" и "age".
    Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
    Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
    Выведите на экран информацию о каждом объекте.
    Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.*/

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Animal[] animals = new Animal[]{
                new Cat(),
                new Dog()
        };

        for (Animal animal : animals) {
            Class<?> clazz = animal.getClass();
            Constructor[] constructors = clazz.getDeclaredConstructors();
            System.out.println(constructors[0]);

            Field[] fields = clazz.getDeclaredFields();
            Arrays.stream(fields).forEach(f -> System.out.println(f));

            Method[] methods = clazz.getDeclaredMethods();
            Arrays.stream(methods).forEach(m -> System.out.println(m.getName()));

            Method method = clazz.getMethod("makeSound");
            method.invoke(animal);

            System.out.println();
        }
    }
}
