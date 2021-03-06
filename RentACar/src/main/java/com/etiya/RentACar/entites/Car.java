package com.etiya.RentACar.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "dailyPrice")
    private int dailyPrice;
    

    @Column(name = "description")
    private String description;
   
    @ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand; 
	
	@ManyToOne 
	@JoinColumn(name="color_id")
	private Color color;
	
	@Column(name="min_findeks_score")
	private int minFindeksSCore;
	
	
	@OneToMany(mappedBy = "car")
	private List<Rental> rentals;
	
	@OneToMany(mappedBy = "car")
	private List<Maintenance> maintenances;
	
	@OneToMany(mappedBy = "car")
	private List<CarImage> carImages;
}
