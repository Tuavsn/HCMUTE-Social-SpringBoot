package Tuan.HCMUTESocial.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notify")
public class notify {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notifyId;
	@ManyToOne
	private user sourceId;
	@ManyToOne
	private user targetId;
}
