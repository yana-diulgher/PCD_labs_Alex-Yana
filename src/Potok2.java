import java.util.function.Consumer;
/**
 * Условие 2, вариант 7:
 * Суммы произведений чётных чисел попарно,
 * начиная с последнего элемента массива.
 */
public class Potok2 implements Runnable {

    private final int[] mas;
    private final Consumer<String> vivod;

    public Potok2(int[] mas, Consumer<String> vivod) {
        this.mas = mas;
        this.vivod = vivod;
    }

    @Override
    public void run() {
        String imya = Thread.currentThread().getName();
        int pervoe = 0;
        boolean estPervoe = false;
        int summaProizvedeniy = 0;
        int kolichestvoPar = 0;

        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] % 2 == 0) {
                if (!estPervoe) {
                    pervoe = mas[i];
                    estPervoe = true;
                } else {
                    int vtoroe = mas[i];
                    int proizvedenie = pervoe * vtoroe;
                    summaProizvedeniy += proizvedenie;
                    kolichestvoPar++;

                    vivod.accept(imya + ": Пара " + kolichestvoPar
                            + ": " + pervoe + " * " + vtoroe
                            + " = " + proizvedenie);

                    estPervoe = false;
                }
            }
        }

        vivod.accept(imya + ": Количество пар: " + kolichestvoPar);
        vivod.accept(imya + ": Сумма произведений пар = " + summaProizvedeniy);

        if (estPervoe) {
            vivod.accept(imya + ": Не использовано одно чётное число: " + pervoe);
        }

        vivod.accept(imya + ": Работа завершена");
    }
}
