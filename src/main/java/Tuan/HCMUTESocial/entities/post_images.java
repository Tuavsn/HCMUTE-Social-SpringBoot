package Tuan.HCMUTESocial.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post_images")
public class post_images {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private post postId;
	private String imageUrl;

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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public post_images() {
		super();
	}

	public post_images(int id, post postId, String imageUrl) {
		super();
		this.id = id;
		this.postId = postId;
		this.imageUrl = imageUrl;
	}

}
