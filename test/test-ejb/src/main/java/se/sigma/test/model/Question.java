package se.sigma.test.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table
public class Question implements Serializable{
	
	@OneToMany(mappedBy="question")
	private List<Answer> list = new ArrayList<Answer>();
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	
	@NotNull
	private String statement;
	
	@JoinColumn(name="header")
	@ManyToOne
	@NotNull
	private Header header;
	
	public long getId() {
		return id;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public List<Answer> getList() {
		return list;
	}

	public void setList(List<Answer> list) {
		this.list = list;
	}
	
	
	
}
