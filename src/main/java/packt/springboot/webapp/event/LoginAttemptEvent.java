package packt.springboot.webapp.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginAttemptEvent extends ApplicationEvent {
    private String username;
    private String password;

    public LoginAttemptEvent(Object source, String username, String password) {
        super(source);
        this.username = username;
        this.password = password;
    }
}
