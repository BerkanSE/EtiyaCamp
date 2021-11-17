package ReCapProject.entities.concretes;

public class Car {
	private int carId;
	private int brandId;
	private int colorId;
	private int modelYear;
	private double dailyPrice;
	private String description;
	
	public Car() {
		super();
	}

	public Car(int carId, int brandId, int colorId, int modelYear, double dailyPrice, String description) {
		super();
		this.carId = carId;
		this.brandId = brandId;
		this.colorId = colorId;
		this.modelYear = modelYear;
		this.dailyPrice = dailyPrice;
		this.description = description;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
