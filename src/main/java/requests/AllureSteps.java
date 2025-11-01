package requests;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.qameta.allure.internal.shadowed.jackson.databind.SerializationFeature;

public class AllureSteps {

    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public interface ThrowableRunnable<T>  {
        T run() throws Throwable;
    }

    public interface ThrowableVoidRunnable<T>  {
        void run() throws Throwable;
    }

    public static <T> T log(String title, ThrowableRunnable<T> runnable) {
        return Allure.step(title, runnable::run);
    }

    public static <T> void log(String title, ThrowableVoidRunnable<T> runnable) {
        Allure.step(title, () -> {
            runnable.run();
            return null;
        });
    }

    @Attachment(value = "{name}", type = "application/json")
    public static String attachJson(String name, Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            return String.valueOf(object);
        }
    }

    @Attachment(value = "{name}", type = "text/plain")
    public static String attachText(String name, String message) {
        return message;
    }
}
