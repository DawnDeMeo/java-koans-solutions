package beginner;

import com.sandwich.koan.Koan;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

public class AboutMethodPreference {

    class A {
        public String doStuff(int i) {
            return "int";
        }

        public String doStuff(Integer i) {
            return "Integer";
        }

        public String doStuff(Object i) {
            return "Object";
        }

        public String doStuff(int... i) {
            return "int vararg";
        }
    }

    @Koan
    public void methodPreferenceInt() {
        assertEquals(new A().doStuff(1), "int");
    }

    @Koan
    public void methodPreferenceInteger() {
        assertEquals(new A().doStuff(Integer.valueOf(1)), "Integer");
    }

    @Koan
    public void methodPreferenceLong() {
        long l = 1;
        assertEquals(new A().doStuff(l), "Object");
    }

    @Koan
    public void methodPreferenceBoxedLong() {
        Long l = Long.valueOf(1);
        assertEquals(new A().doStuff(l), "Object");
    }

    @Koan
    public void methodPreferenceDouble() {
        Double l = Double.valueOf(1);
        assertEquals(new A().doStuff(l), "Object");
    }

    @Koan
    public void methodPreferenceMore() {
        // What happens if you change 'Integer' to 'Double' (doesn't compile)
        // Does this explain 'methodPreferenceDouble'? (not really)
        // Think about why this happens? (A Double can't be converted to an int, 
        // but an Integer can, and there are no other method signatures that work
        // for multiple arguments where at least one of the arguments is not an int.)
        assertEquals(new A().doStuff(1, Integer.valueOf(2)), "int vararg");
    }
}
