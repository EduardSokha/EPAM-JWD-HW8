package by.sokhaeduard.eighthhw.entity;

public class Book {

    private Integer id;
    private String title;
    private String authors;
    private Integer numberPages;
    private String typography;

    public Book() {
	}

	public Book(String title, String authors, Integer numberPages, String typography) {
		super();
		this.title = title;
		this.authors = authors;
		this.numberPages = numberPages;
		this.typography = typography;
	}

	public Book(Integer id, String title, String authors, Integer numberPages, String typography) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.numberPages = numberPages;
		this.typography = typography;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public Integer getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(Integer numberPages) {
		this.numberPages = numberPages;
	}

	public String getTypography() {
		return typography;
	}

	public void setTypography(String typography) {
		this.typography = typography;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + ", numberPages=" + numberPages
				+ ", typography=" + typography + "]";
	}
}