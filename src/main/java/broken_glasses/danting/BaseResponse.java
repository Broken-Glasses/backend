package broken_glasses.danting;// 파일 경로: src/main/java/com/example/response/BaseResponse.java
import org.springframework.lang.Nullable;

public class BaseResponse<T> {
    private final boolean isSuccess;
    @Nullable
    private final T result;

    public BaseResponse(boolean isSuccess, @Nullable T result) {
        this.isSuccess = isSuccess;
        this.result = result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Nullable
    public T getResult() {
        return result;
    }
}
