package net.mainclass.sample;

import methodx.Methodx;

import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserService {

    private final ConcurrentHashMap<String, User> userById = new ConcurrentHashMap<>();

    @Methodx(args = {"id"})
    public User getUser(String id) {
        return userById.get(id);
    }

    @Methodx(args = {"@body"})
    public void putUser(User user) {
        userById.put(user.id, user);
    }

    @Methodx(args = {})
    public Collection<User> getAllUsers() {
        return userById.values();
    }

    public static class User {
        private String id;
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
    }
}
