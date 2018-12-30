package problemCSV;

import java.util.HashSet;
import java.util.Set;

public final class Employee {
	private String id;
	private String name;
	private final Set<String> skillSet;
	
	public Employee(String id, String name) {
		this(id, name, new HashSet<>());
	}
	
	public Employee(String id, String name, Set<String> skillSet) {
		this.id = id;
		this.name = name;
		if(skillSet != null) {
			this.skillSet = skillSet;
		} else {
			this.skillSet = new HashSet<>();
		}
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<String> getSkillSet() {
		return new HashSet<>(skillSet);
	}

	public static Employee newEmployee(String input) {
		// Input can not be null
		if (input == null || input.length() == 0) return null;
		String[] split = input.split(",");
		// there should at least id and name
		if(split.length < 2)
			return null;
		String id = split[0];
		String name = split[1];
		Set<String> skillSet = new HashSet<>();
		for (int i = 2; i < split.length; i++) skillSet.add(split[i]);
		return new Employee(id, name, skillSet);
		
	}
	
	public void addSkill(String skill) {
		if (skill == null || skill.length() == 0) return;
		this.skillSet.add(skill);
	}
	

	@Override
	public String toString() {
		String str = String.format("%s, %s, %s", id, name, skillSet);
		return str;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
