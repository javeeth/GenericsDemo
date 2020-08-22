package afterGenerics2;

import groovy.transform.ASTTest;

import java.util.ArrayList;
import java.util.List;

public class SampleTest {

    public static <T extends Number> void copy(List<T> dest, List<T> src) {
        dest = src;
    }

    public static void copy1(List<? extends Number> dest, List<? extends Number> src) {
        dest = src;
    }

    public static void copy2(List<?> dest, List<?> src) {
        dest = src;
    }

}

class Test {

    SampleTest sampleTest = new afterGenerics2.SampleTest();


    void test() {
        sampleTest.copy(new ArrayList<Integer>() , new ArrayList<Integer>());
        //sampleTest.copy(new ArrayList<Integer>() , new ArrayList<Long>());

        sampleTest.copy1(new ArrayList<Integer>() , new ArrayList<Long>());

        sampleTest.copy2(new ArrayList<Integer>() , new ArrayList<String>());
    }
}