package day05_junitFramework;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

public class C01_FarewellToMainMethod {

    @Test
    public void test01() {
        System.out.println("Test01 calisti");
    }

    @Test @Ignore
    public void test02() {
        System.out.println("Test02 calisti");

    }

    @Test
    public void test03() {
        System.out.println("Test03 calisti");
    }

}

