package PharmacyManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kamrul_pharmacy_category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
	private int category_id;  
	
	@Column(name = "category_name", length = 255, nullable = false)
	private String category_name;
    
	@Column(name = "category_description", length = 255, nullable = false)
	private String category_description;

}
