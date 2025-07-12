package Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userSecurity {
    @GetMapping("/home")
    public String home(){
        return "Home page";
    }
    @GetMapping("/admin")
    public String secured(){
        return "hello admin";
    }
    @GetMapping("/user")
    public String users(){
        return "hello user";
    }
    
}
