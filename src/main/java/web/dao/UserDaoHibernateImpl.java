package web.dao;


import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void editUser(User user) {
        User userToChange = entityManager.find(User.class, user.getId());
        userToChange.setName(user.getName());
        userToChange.setLastName(user.getLastName());
        userToChange.setAge(user.getAge());
        userToChange.setEmail(user.getEmail());
    }
    @Override
    public void removeUser(Long id) {
        entityManager.remove(getUserById(id));
    }
    @Override
    public User getUserById(Long id){
        return entityManager.find(User.class, id);
    }



}
