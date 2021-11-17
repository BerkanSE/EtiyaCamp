package ReCapProject.dataAccess.abstracts;

import java.util.List;

public interface DaoRepository<T> {
	void insert(T entity);
	void delete(int id);
	void update(int id, T entity);
	T getById(int id);
	List<T> getAll();
}
