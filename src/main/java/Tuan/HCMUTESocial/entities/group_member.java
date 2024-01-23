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
@Table(name = "group_member")
public class group_member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private group groupId;
	@ManyToOne
	private user userId;
	private String role;
	private int status;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime joinAt;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getJoinAt() {
		return joinAt;
	}

	public void setJoinAt(LocalDateTime joinAt) {
		this.joinAt = joinAt;
	}

	public group_member() {
		super();
	}

	public group_member(int id, group groupId, user userId, String role, int status, LocalDateTime joinAt) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.userId = userId;
		this.role = role;
		this.status = status;
		this.joinAt = joinAt;
	}

}
