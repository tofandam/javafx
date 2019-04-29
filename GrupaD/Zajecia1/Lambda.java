
@FunctionalInterface
interface FunkcjaMatemetyczna{
    double funkcja(double a, double b);

}

@FunctionalInterface
interface FuncMath{
    double funkcja_0(double n);
}

public class Lambda {

    static void dzialanieMatematyczne(double a, double b, FunkcjaMatemetyczna funkcjaMatemetyczna){
        System.out.println(funkcjaMatemetyczna.funkcja(a,b));
    }

    static double potega(double x,FuncMath potega){
        return potega.funkcja_0(x);
    }

    public static void main(String[] args) {

        FunkcjaMatemetyczna dodaj = (a, b)->{return a+b;};
        FunkcjaMatemetyczna pomnoz = (a,b)->a*b;

        FuncMath power2 = n->Math.pow(n,2);

        System.out.println(dodaj.funkcja(10,40));
        System.out.println(pomnoz.funkcja(5,4));

        dzialanieMatematyczne(10,10,(a,b)->{
            return a/b;
        });

        System.out.println("potęga 2: "+power2.funkcja_0(5));

        potega(10,x->Math.pow(x,2));

    }
}
