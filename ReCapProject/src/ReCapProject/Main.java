package ReCapProject;

import ReCapProject.business.abstracts.BrandService;
import ReCapProject.business.abstracts.CarService;
import ReCapProject.business.abstracts.ColorService;
import ReCapProject.business.concretes.BrandManager;
import ReCapProject.business.concretes.CarManager;
import ReCapProject.business.concretes.ColorManager;
import ReCapProject.dataAccess.concretes.BrandDao;
import ReCapProject.dataAccess.concretes.CarDao;
import ReCapProject.dataAccess.concretes.ColorDao;
import ReCapProject.entities.concretes.Brand;
import ReCapProject.entities.concretes.Car;
import ReCapProject.entities.concretes.Color;

public class Main {

	public static void main(String[] args) {
		CarService carService = new CarManager(new CarDao());
		//Add:
		carService.add(new Car(1, 1, 1, 2016, 1000, "CARID: 1 Otomatik - Benzinli - 24sa. kullanım"));
		carService.add(new Car(2, 1, 3, 2017, 1100, "CARID: 2 Manuel - Dizel - 24sa. kullanım"));
		carService.add(new Car(3, 2, 1, 2021, 1800, "CARID: 3 Manuel - Benzinli - 24sa. kullanım"));
		carService.add(new Car(4, 2, 2, 2019, 1200, "CARID: 4 Otomatik - Dizel - 24sa. kullanım"));
		carService.add(new Car(5, 3, 1, 2016, 1350, "CARID: 5 Manuel - Dizel - 24sa. kullanım"));
		//Remove:
		//carService.remove(2);
		//Update:
		//carService.update(4, new Car(6, 4, 4, 2020, 2000, "CARID: 6 Otomatik - Dizel - 24sa. kullanım" ));
		//GetById:
		System.out.println(carService.getById(4).getDescription());
		
		for (Car item : carService.getAll().getData()) {
			System.out.println(item.getModelYear() + " " + item.getDescription() + " Daily Price: " + item.getDailyPrice() +"₺");
		}
		
		BrandService brandService = new BrandManager(new BrandDao());
		brandService.add(new Brand(1, "Opel"));
		brandService.add(new Brand(2, "Volkswagen"));
		brandService.add(new Brand(3, "Fiat"));
		brandService.add(new Brand(4, "Mercedes"));
		
		//for (Brand item : brandService.getAll().getData()) {
		//	System.out.println(item.getBrandName());
		//}
		
		ColorService colorService = new ColorManager(new ColorDao());
		colorService.add(new Color(1, "Black"));
		colorService.add(new Color(2, "White"));
		colorService.add(new Color(3, "Red"));
		colorService.add(new Color(4, "Gray"));
		
		//for (Color item : colorService.getAll().getData()) {
		//	System.out.println(item.getColorName());
		//}
		
	}

}
