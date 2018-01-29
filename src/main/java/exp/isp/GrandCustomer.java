package exp.isp;

public class GrandCustomer implements SetCustomer, GetCustomer {

	private Integer id;
	private String name;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
