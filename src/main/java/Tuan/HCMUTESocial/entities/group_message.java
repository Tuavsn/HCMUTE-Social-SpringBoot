package Tuan.HCMUTESocial.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "group_message")
public class group_message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private group groupId;
	@ManyToOne
	private user userId;
	private String content;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime createAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public group getGroupId() {
		return groupId;
	}

	public void setGroupId(group groupId) {
		this.groupId = groupId;
	}

	public user getUserId() {
		return userId;
	}

	public void setUserId(user userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public group_message() {
		super();
	}

	public group_message(int id, group groupId, user userId, String content, LocalDateTime createAt) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.userId = userId;
		this.content = content;
		this.createAt = createAt;
	}

}
