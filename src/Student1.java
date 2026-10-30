import java.util.function.Consumer;

public class Student1 {

    private final Thread th1;
    private final Thread th2;

    public Student1(int[] mas, Consumer<String> vivod) {
        th1 = new Thread(
                new Potok1(mas, vivod),
                "Александр / Th1"
        );

        th2 = new Thread(
                new Potok2(mas, vivod),
                "Александр / Th2"
        );
    }

    public void start() {
        th1.start();
        th2.start();
    }

    public void waitForFinish() throws InterruptedException {
        th1.join();
        th2.join();
    }
}
