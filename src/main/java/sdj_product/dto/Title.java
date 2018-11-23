package sdj_product.dto;

public class Title {
	private String tno;
	private String tname;
	
	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Title(String tno, String tname) {
		this.tno = tno;
		this.tname = tname;
	}

	public Title(String tno) {
		this.tno = tno;
	}

	@Override
	public String toString() {
		return String.format("Title [tno=%s, tname=%s]", tno, tname);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tno == null) ? 0 : tno.hashCode());
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
		Title other = (Title) obj;
		if (tno == null) {
			if (other.tno != null)
				return false;
		} else if (!tno.equals(other.tno))
			return false;
		return true;
	}
	
}
