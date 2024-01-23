package Tuan.HCMUTESocial.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

	public int getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(int notifyId) {
		this.notifyId = notifyId;
	}

	public user getSourceId() {
		return sourceId;
	}

	public void setSourceId(user sourceId) {
		this.sourceId = sourceId;
	}

	public user getTargetId() {
		return targetId;
	}

	public void setTargetId(user targetId) {
		this.targetId = targetId;
	}

	public notify() {
		super();
	}

	public notify(int notifyId, user sourceId, user targetId) {
		super();
		this.notifyId = notifyId;
		this.sourceId = sourceId;
		this.targetId = targetId;
	}

}
