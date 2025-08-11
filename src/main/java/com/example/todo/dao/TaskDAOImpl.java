package com.example.todo.dao;

import com.example.todo.domain.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Task task) {
        entityManager.persist(task);
    }

    @Override
    public void update(Task task) {
        entityManager.merge(task);
    }

    @Override
    public void delete(int id) {
        Task task = entityManager.find(Task.class, id);
        if (task != null) {
            entityManager.remove(task);
        }
    }

    @Override
    public Task findById(int id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    @Override
    public List<Task> findPaginated(int page, int size) {
        TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM Task t", Task.class);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(t) FROM Task t", Long.class)
                .getSingleResult();
    }

    @Override
    public List<Task> findFiltered(String assignedTo, String sortField, String sortDir, int page, int size) {
        String jpql = "SELECT t FROM Task t WHERE (:assignedTo IS NULL OR t.assignedTo = :assignedTo) " +
                "ORDER BY " + sortField + " " + sortDir;

        return entityManager.createQuery(jpql, Task.class)
                .setParameter("assignedTo", assignedTo == null || assignedTo.isEmpty() ? null : assignedTo)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }
}

