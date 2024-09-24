package ru.netology.springbootrest.repository;

import ru.netology.springbootrest.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    //Шаг 3. Код-метод getUserAuthorities класс UserRepository, который возвращает либо разрешения, либо пустой массив
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals("admin") && password.equals("admin")) {
            return Arrays.asList(Authorities.DELETE, Authorities.READ, Authorities.WRITE);
        } else {
            return Collections.emptyList();
        }
    }
}