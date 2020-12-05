import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
       // person.getClass(); 1 способ вернет объект класс Class
        Class personClass1 = person.getClass();  // 1 способ получения объекта класс Class, аналогично, как person.getClass().
        Class personClass2 = Person.class; //2 способ получения объекта класс Class.
        Class personClass3 = Class.forName("Person");  //3 способ получения объекта класс Class и обрабатываем исключение.
        //вызываем статический метод forName и указываем наш путь к файлу, и у нас он не лежит ни в каком файле просто указываем Person.

        Method[] methods = personClass1.getMethods(); //вернем все методы в этом классе и поместим в масив объектов класса Method.
        for(Method method:methods) {
            System.out.println(method.getName() + ", " + method.getReturnType() + ", " + Arrays.toString(method.getParameterTypes()));
        }  //Выводим имя для каждого метода + выводим его тип возращаемого значения + выводим типы параметров, которые этот метод принимает на вход.
        //Arrays.toString вызываем статический метод. чтобы перевести наш возращемый масив в строку.


       Field[] fields = personClass1.getFields(); //вернем все поля в этом классе.
        for(Field field:fields) {  //getFields(); принимает только публичные поля.
            System.out.println(field.getName() + ", " + field.getType()); //ничего не увидем так наши поля приватные.
        } //выводим имя каждого поля + выводим тип этого поля.


        Field[] fields1 = personClass1.getDeclaredFields();
        for(Field field1:fields1) {
            System.out.println(field1.getName() + ", " + field1.getType());
        } //getDeclaredFields(); нарушает инкапсулиацию и он покажет даже приватны поля

        Annotation[] annotations = personClass1.getAnnotations(); //получим все аннотаци из класса Person.
        for(Annotation annotation:annotations) {
            if (annotation instanceof Author) { //проверяем является ли наш экземпляр аннотации Author
                System.out.println("Yes"); //то выводим сообщение на экран Yes.
            }
        }
    }

}
