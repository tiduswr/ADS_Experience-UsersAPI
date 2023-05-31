package tidus.users_control.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class CustomFieldError {
    private String field, message;
}
