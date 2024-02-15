package Tuan.HCMUTESocial.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "group")
public class group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupId;
	private String title;
	private int status;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime createAt;
}
