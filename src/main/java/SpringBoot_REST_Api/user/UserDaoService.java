package SpringBoot_REST_Api.user;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Adam",LocalDate.now().minusYears(30)));
        users.add(new User(2,"Eve",LocalDate.now().minusYears(25)));
        users.add(new User(3,"Jim",LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    //public User save(User user) {

    public User findOne(int id) {
        /* Is id for both users same? */
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        /* taking the list and converting it to stream , applying predicate: from the List<users> find a user whose ID matches */
        return users.stream().filter(predicate).findFirst().get();
    }
}