package org.longbox.persistence.stubdatabase;

import java.io.*;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.longbox.businesslogic.exception.EmailDoesNotExistException;
import org.longbox.businesslogic.exception.UserIDDoesNotExistException;
import org.longbox.businesslogic.exception.UserNameDoesNotExistException;
import org.longbox.businesslogic.exception.UsernameOrEmailExistsException;
import org.longbox.domainobjects.dto.UserDto;
import com.google.gson.Gson;
import org.longbox.persistence.dao.UserDao;
import org.longbox.persistence.entity.User;

@Getter
@Setter
@NoArgsConstructor
public class UserStubDb implements UserDao, JsonConvertor {

    private List<UserDto> userStubData;
    private final String ABSOLUTE_FILE_PATH = "src/main/resources/UserStubDb.json";

    @Override
    public User getUserById(long id) throws UserIDDoesNotExistException {
        userStubData = deserializeStubData(ABSOLUTE_FILE_PATH);
        for (UserDto user : userStubData) {
            if (user.getId() == id) {
                User u = new User(user);
                u.setId(user.getId());
                return u;
            }
        }
        throw new UserIDDoesNotExistException();
    }

    @Override
    public User getUserByUserName(String userName) throws UserNameDoesNotExistException {
        userStubData = deserializeStubData(ABSOLUTE_FILE_PATH);
        for (UserDto user : userStubData) {
            if (Objects.equals(user.getUserName(), userName)) {
                User u = new User(user);
                u.setId(user.getId());
                return u;
            }
        }
        throw new UserNameDoesNotExistException();
    }

    @Override
    public User getUserByEmail(String email) throws EmailDoesNotExistException {
        userStubData = deserializeStubData(ABSOLUTE_FILE_PATH);
        for (UserDto user : userStubData) {
            if (Objects.equals(user.getEmail(), email)) {
                User u = new User(user);
                u.setId(user.getId());
                return u;
            }
        }
        throw new EmailDoesNotExistException();
    }

    @Override
    public void saveUser(User user) throws UsernameOrEmailExistsException {
        userStubData = deserializeStubData(ABSOLUTE_FILE_PATH);
        for (UserDto u : userStubData) {
            if (u.getEmail().equals(user.getEmail()) ||
                u.getUserName().equals(user.getUserName())) {
                throw new UsernameOrEmailExistsException();
            }
        }
        userStubData.add(new UserDto(user));
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public boolean modifyUser(User user) {
        return false;
    }

    public void loadUsers() {
        UserDto u1 = new UserDto(
                1,
                "Always_Scheming",
                "John",
                "Smith",
                new Date(1990, 12, 1),
                "email@domain.com",
                "Always_Scheming",
                "Canada",
                0,
                0
        );
        userStubData.add(u1);

        UserDto u2 = new UserDto(
                2,
                "Always_Throwing",
                "Neo",
                "Anderson",
                new Date(1929,1,1),
                "address@provider.ca",
                "Always_Throwing",
                "Indonesia",
                0,
                0
        );
        userStubData.add(u2);

        UserDto u3 = new UserDto(
                3,
                "Phoenix",
                "Stan",
                "Lee",
                new Date(2000,4,31),
                "123fake@nowhere.org",
                "Phoenix",
                "United Kingdom",
                0,
                0
        );
        userStubData.add(u3);
    }

    @Override
    public void serializeStubData() {
        String json = new Gson().toJson(userStubData);
        try (PrintStream out = new PrintStream(new FileOutputStream(ABSOLUTE_FILE_PATH))) {
            out.print(json);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<UserDto> deserializeStubData(String filepath) {
        Type listType = new TypeToken<ArrayList<UserDto>>(){}.getType();
        JsonReader reader = null;

        try {
            reader = new JsonReader(new FileReader(filepath));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return gson.fromJson(reader, listType);
    }
}
