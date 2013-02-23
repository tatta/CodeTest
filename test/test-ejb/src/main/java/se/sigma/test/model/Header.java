package se.sigma.test.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table
public class Header implements Serializable {

	@Id
	@NotNull
	@Size(min = 1, max = 25, message="Wrong about of characters.")
	private String title;
	
	@OneToMany(mappedBy="header")
	private List<Question> list = new ArrayList<Question>();
	
	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

	public String getTitle() {
		return title;

	}

	public void setTitle(String title) {
		this.title = title;
	}

}
