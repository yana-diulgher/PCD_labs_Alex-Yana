import java.util.function.Consumer;

/**
 * Условие 1, вариант 7:
 * Суммы чётных чисел попарно, начиная с первого элемента массива.
 */
public class Potok1 implements Runnable {

    private final int[] mas;
    private final Consumer<String> vivod;

    public Potok1(int[] mas, Consumer<String> vivod) {
        this.mas = mas;
        this.vivod = vivod;
    }

    @Override
    public void run() {
        String imya = Thread.currentThread().getName();
        int pervoe = 0;
        boolean estPervoe = false;
        int summa = 0;
        int kolichestvoPar = 0;

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] % 2 == 0) {
                if (!estPervoe) {
                    pervoe = mas[i];
                    estPervoe = true;
                } else {
                    int vtoroe = mas[i];
                    int rezultat = pervoe + vtoroe;
                    summa += rezultat;
                    kolichestvoPar++;

                    vivod.accept(imya + ": Пара " + kolichestvoPar
                            + ": " + pervoe + " + " + vtoroe
                            + " = " + rezultat);

                    estPervoe = false;
                }
            }
        }

        vivod.accept(imya + ": Количество пар: " + kolichestvoPar);
        vivod.accept(imya + ": Общая сумма результатов пар = " + summa);

        if (estPervoe) {
            vivod.accept(imya + ": Не использовано одно чётное число: " + pervoe);
        }

        vivod.accept(imya + ": Работа завершена");
    }
}
