package Tuan.HCMUTESocial.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post_comment")
public class post_comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private post postId;
	@ManyToOne
	private user userId;
	private String content;
	@OneToOne
	private user tag;
	@OneToOne
	private user reply;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public post getPostId() {
		return postId;
	}

	public void setPostId(post postId) {
		this.postId = postId;
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

	public user getTag() {
		return tag;
	}

	public void setTag(user tag) {
		this.tag = tag;
	}

	public user getReply() {
		return reply;
	}

	public void setReply(user reply) {
		this.reply = reply;
	}

	public post_comment() {
		super();
	}

	public post_comment(int id, post postId, user userId, String content, user tag, user reply) {
		super();
		this.id = id;
		this.postId = postId;
		this.userId = userId;
		this.content = content;
		this.tag = tag;
		this.reply = reply;
	}

}
