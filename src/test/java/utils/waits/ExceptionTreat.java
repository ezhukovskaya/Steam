package utils.waits;

public class ExceptionTreat {
    private static ExceptionTreat exceptionTreat;

    /**
     * ожидание + обработка исключения
     */
    public static void getExceptionTimeoutTreat() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
