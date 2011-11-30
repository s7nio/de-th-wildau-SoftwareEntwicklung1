package sne.exercise.sheet5;

/**
 * Was würde von den folgenden Codefragmenten auf dem Bildschirm ausgegeben werden?
 * Begründen Sie!
 * 
 * @author sne
 */
public class Task1 {

    public static void main(String[] foo) {

        a();
        b();
    }

    public static void a() {
        
        // declare and init int array (10 elements with default value)
        int[] a = new int[10];
        
        // set array downward (9..0)
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        
        for (int i = 0; i < 10; i++) {
            // get element of the value of the array (i)
            a[i] = a[a[i]];
        }
        
        // print each element of the array
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }

    public static void b() {
        
        // two array's
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        
        // compares references, not values
        System.out.println(a == b);
        
        // compares values for equality
        //System.out.println(a.equals(b));
    }
}
