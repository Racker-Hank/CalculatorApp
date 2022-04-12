package mode;

import operation.Fraction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Function {
    public String name;
    public String description;
    public Method method;
    public Object obj;
    public Object[] params;

    public void display() {
    }

    public Fraction calculate() {
        return new Fraction(0);
    }

    public Function() {
    }

    public Function(String name , String description , Object obj , Method method) {
        this.name = name;
        this.description = description;
        this.obj = obj;
        this.method = method;
    }

    public Function(String name , String description , Object obj , Method method , Object[] params) {
        this.name = name;
        this.description = description;
        this.obj = obj;
        this.method = method;
        this.params = params;
    }

    public void doYourThing(Object[] params) {
        try {
            method.invoke(this.obj , params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test(double n , double m) {
        System.out.println(n + m);
    }

    public static void main(String[] args) {
        Function f1 = new Function();
        Class[] paramTypes = { double.class , double.class };
        Method test = null;
        try {
            test = Function.class.getMethod("test" , paramTypes);
            Function f = new Function("test" , "test" , f1 , test);
            f.doYourThing(new Object[] { 10 , 20 });
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
