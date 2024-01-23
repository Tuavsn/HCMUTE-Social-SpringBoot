package Tuan.HCMUTESocial.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment_like")
public class comment_like {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private post_comment commentId;
	@ManyToOne
	private user userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public post_comment getCommentId() {
		return commentId;
	}

	public void setCommentId(post_comment commentId) {
		this.commentId = commentId;
	}

	public user getUserId() {
		return userId;
	}

	public void setUserId(user userId) {
		this.userId = userId;
	}

	public comment_like() {
		super();
	}

	public comment_like(int id, post_comment commentId, user userId) {
		super();
		this.id = id;
		this.commentId = commentId;
		this.userId = userId;
	}

}
