package SpringBoot_REST_Api.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
        //		- Example: `en` - English (Good Morning)
        //		- Example: `nl` - Dutch (Goedemorgen)
        //		- Example: `fr` - French (Bonjour)
        //		- Example: `de` - Deutsch (Guten Morgen)
    }

    // Path Parameters
    // /users/{id}/todos/{id}  => /users/2/todos/200
    // /hello-world/path-variable/{name}
    // /hello-world/path-variable/harshit
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        //returns locale associated with the current thread
        Locale locale = LocaleContextHolder.getLocale();
        /*
        * param1 : code that is used as a key in message.properties
        * param2 : any params you have to replace in your message
        * param3 : default message
        * locale : which locale to use , in our case it will be taken from the request
        * */
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
