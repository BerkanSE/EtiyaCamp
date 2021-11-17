package ReCapProject.business.abstracts;

import java.util.List;

import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.entities.concretes.Color;

public interface ColorService {
	Result add(Color color);
	Result remove(int colorId);
	Result update(int colorId, Color color);
	Color getById(int colorId);
	DataResult<List<Color>> getAll();
}
