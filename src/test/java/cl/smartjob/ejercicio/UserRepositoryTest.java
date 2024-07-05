package cl.smartjob.ejercicio;

import cl.smartjob.ejercicio.domain.entities.Phone;
import cl.smartjob.ejercicio.domain.entities.User;
import cl.smartjob.ejercicio.domain.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void should_store_a_user() {
        var now = LocalDateTime.now();
        var user = userRepository.save(new User(null, "jonatan soto", "cjonatansoto@gmail.com", "pass1234", now, now, now, true, null));
        assertThat(user).hasFieldOrPropertyWithValue("name", "jonatan soto");
        assertThat(user).hasFieldOrPropertyWithValue("email", "cjonatansoto@gmail.com");
        assertThat(user).hasFieldOrPropertyWithValue("isActive", true);
    }

    @Test
    public void should_find_all_users() {
        var now = LocalDateTime.now();
        var user001 = userRepository.save(new User(null, "jonatan soto", "cjonatansoto@gmail.com", "pass1234", now, now, now, true, null));
        entityManager.persist(user001);
        var user002 = userRepository.save(new User(null, "felipe soto", "cfelipesoto@gmail.com", "pass1234", now, now, now, true, null));
        entityManager.persist(user002);
        var user003 = userRepository.save(new User(null, "ruben soto", "crubensoto@gmail.com", "pass1234", now, now, now, true, null));
        entityManager.persist(user003);
        Iterable<User> users = userRepository.findAll();
        assertThat(users).hasSize(3).contains(user001, user002, user003);
    }

    @Test
    public void should_delete_user_by_id() {
        var now = LocalDateTime.now();
        var user001 = userRepository.save(new User(null, "jonatan soto", "cjonatansoto@gmail.com", "pass1234", now, now, now, true, null));
        entityManager.persist(user001);
        var user002 = userRepository.save(new User(null, "felipe soto", "cfelipesoto@gmail.com", "pass1234", now, now, now, true, null));
        entityManager.persist(user002);
        var user003 = userRepository.save(new User(null, "ruben soto", "crubensoto@gmail.com", "pass1234", now, now, now, true, null));
        entityManager.persist(user003);
        userRepository.deleteById(user001.getId());
        Iterable<User> users = userRepository.findAll();
        assertThat(users).hasSize(2).contains(user002, user003);
    }

    @Test
    public void should_find_all_user_with_phones() {
        var now = LocalDateTime.now();
        var phones = new ArrayList<Phone>();
        var phone1 = new Phone(null, 9478929, 1, 56, null);
        phones.add(phone1);
        var phone2 = new Phone(null, 9478928, 1, 56, null);
        phones.add(phone2);
        var phone3 = new Phone(null, 9478927, 1, 56, null);
        phones.add(phone3);
        var user001 = userRepository.save(new User(null, "jonatan soto", "cjonatansoto@gmail.com", "pass1234", now, now, now, true, phones.stream().collect(Collectors.toSet())));
        entityManager.persist(user001);
        var user = userRepository.findById(user001.getId());
        Iterable<Phone> phoneSet = user.get().getPhones();
        assertThat(phoneSet).hasSize(3).contains(phone1, phone2, phone3);
    }
}
