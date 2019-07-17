package PharmacyManagementSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kamrul_pharmacy")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String medicineName;
	private String genericeName;
	private String power;
	private String type;
	private String category;
	private String manufacturerName;
	private float manufacturerPrice;
	private float sellPrice;
	private byte[] image;

}
