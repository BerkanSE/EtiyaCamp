package ReCapProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ReCapProject.dataAccess.abstracts.ColorRepository;
import ReCapProject.entities.concretes.Color;

public class ColorDao implements ColorRepository{

	List<Color> colors;
	
	public ColorDao() {
		super();
		colors = new ArrayList<Color>();
	}

	@Override
	public void insert(Color color) {
		colors.add(color);
	}

	@Override
	public void delete(int id) {
		colors.remove(id);
	}

	@Override
	public void update(int id, Color color) {
		colors.set(id, color);
	}

	@Override
	public Color getById(int id) {
		return colors.get(id - 1);
	}

	@Override
	public List<Color> getAll() {
		return colors;
	}

}
