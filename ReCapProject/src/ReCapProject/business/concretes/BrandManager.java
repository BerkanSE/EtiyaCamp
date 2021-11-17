package ReCapProject.business.concretes;

import java.util.List;

import ReCapProject.business.abstracts.BrandService;
import ReCapProject.core.utilities.results.DataResult;
import ReCapProject.core.utilities.results.ErrorResult;
import ReCapProject.core.utilities.results.Result;
import ReCapProject.core.utilities.results.SuccessDataResult;
import ReCapProject.core.utilities.results.SuccessResult;
import ReCapProject.dataAccess.abstracts.BrandRepository;
import ReCapProject.entities.concretes.Brand;


public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	
	public BrandManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}

	@Override
	public Result add(Brand brand) {
		this.brandRepository.insert(brand);
		return new SuccessResult("Marka eklendi.");
	}

	@Override
	public Result remove(int brandId) {
		int index;
		for (Brand item : this.brandRepository.getAll()) {
			if (item.getBrandId() == brandId) {
				index = this.brandRepository.getAll().indexOf(item);
				this.brandRepository.delete(index);
				return new SuccessResult("Marka silindi.");
			}
		}
		return new ErrorResult("Marka bulunamadı. Silme işlemi geçersiz!");
	}

	@Override
	public Result update(int brandId, Brand brand) {
		int index;
		for (Brand item : this.brandRepository.getAll()) {
			if (item.getBrandId() == brandId) {
				index = this.brandRepository.getAll().indexOf(item);
				this.brandRepository.delete(index);
				return new SuccessResult("Marka güncellendi.");
			}
		}
		return new ErrorResult("Marka bulunamadı. Güncelleme işlemi geçersiz!");
	}

	@Override
	public Brand getById(int brandId) {
		return this.brandRepository.getById(brandId);
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		return new SuccessDataResult<List<Brand>>(this.brandRepository.getAll());
	}

}
