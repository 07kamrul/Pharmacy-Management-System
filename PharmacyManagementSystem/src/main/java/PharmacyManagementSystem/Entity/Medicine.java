package PharmacyManagementSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	private String manufacturerName;
	private float manufacturerPrice;
	private float sellPrice;

	@ManyToOne
	@JoinColumn(name = "typeId")
	private Type type;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	@OneToOne
	@JoinColumn(name = "imageId")
	private Image image;
}
