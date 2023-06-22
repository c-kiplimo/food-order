package com.collicode.foodorderback.model;


import javax.persistence.*;

@Entity
public class Meal {
	
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	public Long id;
 	

	//@ManyToOne
	@OneToOne
	private MealType mealType;
	
	
	
	
//	@JsonIgnore
//	@OneToMany(mappedBy="meal" ,fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//	private List<OrderItem> orders = new ArrayList<OrderItem>();
 	
 	private String name;
 	private int price;
 	
 	@Lob
	//@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
 	
 	private String imageName;
 	//@OneToOne 
	//private Image image;
 	
 	//@Transient
 	//FileSystemResource imageFSR;
 	
 	public Meal() {
 		
 	}

	public Meal(Long id, MealType mealType, String name, int price, String imageName) {
		super();
		this.id = id;
		this.mealType = mealType;
		this.name = name;
		this.price = price;
		this.imageName = imageName;
		//this.image = image;
		//this.imageFSR = imageFSR;
	}

	/*public FileSystemResource getImageFSR() {
		return imageFSR;
	}

	public void setImageFSR(FileSystemResource imageFSR) {
		this.imageFSR = imageFSR;
	} */

	/*public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}*/

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Long getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

//	public List<OrderItem> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<OrderItem> orders) {
//		this.orders = orders;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
 	
 	
 	

}