package repository;

import model.User;
import org.hibernate.jpa.QueryHints;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true )
public class UserRepositoryImp  implements UserRepository{


    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean existsByEmail(String email) {
        List<User> users = em.createNamedQuery(User.BY_EMAIL, User.class)
                .setParameter(1, email)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .getResultList();
        if (users.size()==0) return false; else return true;
    }

    @Override
    public Optional<User> findById(int id) {
        List<User> users = em.createNamedQuery(User.BY_ID, User.class)
                .setParameter(1, id)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .getResultList();
        return  Optional.ofNullable(DataAccessUtils.singleResult(users));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> users = em.createNamedQuery(User.BY_EMAIL, User.class)
                .setParameter(1, email)
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                .getResultList();
            return  Optional.ofNullable(DataAccessUtils.singleResult(users));
    }


    @Override
    @Transactional
    public User save(User user) {
        if (user.getId()==null) {
            em.persist(user);
            em.flush();
            return user;
        } else {
            return em.merge(user);
        }
    }



    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    @Transactional
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
