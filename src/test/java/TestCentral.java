import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.JUnitCore;

public class TestCentral {

    public static void main(String[] args) {

        Result res = JUnitCore.runClasses((Tests.class));

        for (Failure fail : res.getFailures()) {
            System.out.println(fail.toString());
        }

    }
}
