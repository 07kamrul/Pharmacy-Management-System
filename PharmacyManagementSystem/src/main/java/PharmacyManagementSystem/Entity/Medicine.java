package PharmacyManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kamrul_pharmacy_medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id", nullable = false)
	private int medicine_id;

    @Column(name = "medicine_name", length = 255, nullable = false)
	private String medicine_name;
    
    @Column(name = "generice_name", length = 255, nullable = false)
    private String generice_name;
    
    @Column(name = "medicine_power", length = 255, nullable = false)
	private String medicine_power;
    
    @Column(name = "manufacturer_name", length = 255, nullable = false)
	private String manufacturer_name;
    
    @Column(name = "column_no", length = 255, nullable = false)
	private String column_no;
    
    @Column(name = "row_no", length = 255, nullable = false)
	private String row_no;
    
    @Column(name = "manufacturer_price", length = 255, nullable = false)
	private float manufacturer_price;
    
    @Column(name = "sell_price", length = 255, nullable = false)
	private float sell_price;

    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = false)
	private byte[] image;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "type_id",nullable=false,foreignKey=@ForeignKey(name="Type_FK"))
	private Type type;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "category_id",nullable=false,foreignKey=@ForeignKey(name="Category_FK"))
	private Category category;
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "imageId") private Image image;
	 */
}
