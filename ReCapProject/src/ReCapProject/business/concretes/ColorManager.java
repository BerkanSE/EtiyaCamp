package ReCapProject.business.concretes;

import java.util.List;

import ReCapProject.business.abstracts.ColorService;
import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.ErrorResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.core.utilities.results.SuccessDataResult;
import ReCapProject.core.utilities.results.SuccessResult;
import ReCapProject.dataAccess.abstracts.ColorRepository;
import ReCapProject.entities.concretes.Color;

public class ColorManager implements ColorService{
	
	private ColorRepository colorRepository;
	
	public ColorManager(ColorRepository colorRepository) {
		super();
		this.colorRepository = colorRepository;
	}

	@Override
	public Result add(Color color) {
		this.colorRepository.insert(color);
		return new SuccessResult("Renk eklendi.");
	}

	@Override
	public Result remove(int colorId) {
		int index;
		for (Color item : this.colorRepository.getAll()) {
			if (item.getColorId() == colorId) {
				index = this.colorRepository.getAll().indexOf(item);
				this.colorRepository.delete(index);
				return new SuccessResult("Marka silindi.");
			}
		}
		return new ErrorResult("Renk bulunamadı. Silme işlemi geçersiz!");
	}

	@Override
	public Result update(int colorId, Color color) {
		int index;
		for (Color item : this.colorRepository.getAll()) {
			if (item.getColorId() == colorId) {
				index = this.colorRepository.getAll().indexOf(item);
				this.colorRepository.delete(index);
				return new SuccessResult("Renk güncellendi.");
			}
		}
		return new ErrorResult("Renk bulunamadı. Güncelleme işlemi geçersiz!");
	}

	@Override
	public Color getById(int colorId) {
		return this.colorRepository.getById(colorId);
	}

	@Override
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(this.colorRepository.getAll());
	}

}
