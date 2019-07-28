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
@Table(name = "kamrul_pharmacy_manufacturer")
public class Manufacturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manufacturer_id", nullable = false)
	private int manufacturer_id;

	@Column(name = "manufacturer_name", length = 255, unique = true, nullable = false)
	private String manufacturer_name;

	@Column(name = "manufacturer_phone", length = 255, nullable = false)
	private String manufacturer_phone;

	@Column(name = "manufacturer_location", length = 255, nullable = false)
	private String manufacturer_location;
}
