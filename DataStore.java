package problemCSV;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DataStore {

	private static final DataStore INSTANCE = new DataStore();

	private Map<String, Set<Employee>> empIdMap;
	private Map<String, Set<Employee>> empNameMap;
	private Map<String, Set<Employee>> empFNameMap;
	private Map<String, Set<Employee>> empLNameMap;
	private Map<String, Set<Employee>> skillMap;

	private DataStore() {
		this.empIdMap = new HashMap<>();
		this.empIdMap = new HashMap<>();
		this.empNameMap = new HashMap<>();
		this.empFNameMap = new HashMap<>();
		this.empLNameMap = new HashMap<>();
		this.skillMap = new HashMap<>();
	}

	public static DataStore getDataStore() {
		return INSTANCE;
	}

	public void insertEmployee(Employee e) {
		if (e == null)
			return;
		addId(e);
		addName(e);
		addSkill(e);
	}

	public Set<Employee> search(String searchStr) {

		Set<Employee> result = new LinkedHashSet<>();
		if (searchStr == null || searchStr.length() == 0)
			return result;
		String[] terms = searchStr.toLowerCase().split(",");
		for (String term : terms) {
			term = term.trim();
			if (empIdMap.get(term) != null) {
				addToResult(result, empIdMap, term);

			}
			if (empNameMap.get(term) != null) {
				addToResult(result, empNameMap, term);

			}
			if (empFNameMap.get(term) != null) {
				addToResult(result, empFNameMap, term);

			}
			if (empLNameMap.get(term) != null) {
				addToResult(result, empLNameMap, term);

			}
			if (skillMap.get(term) != null) {
				addToResult(result, skillMap, term);
			}

		}
		return result;

	}

	private void addToResult(Set<Employee> result, Map<String, Set<Employee>> map, String term) {
		if (result.isEmpty()) {
			result.addAll(map.get(term));
		} else {
			result.retainAll(map.get(term));
		}
	}

	private void addSkill(Employee e) {
		Set<String> skillSet = e.getSkillSet();
		for (String skill : skillSet) {
			if (skillMap.get(skill.toLowerCase()) == null) {
				skillMap.put(skill.toLowerCase(), new HashSet<>());
			}
			skillMap.get(skill.toLowerCase()).add(e);
		}
	}

	private void addName(Employee e) {
		String name = e.getName().toLowerCase();
		if (empNameMap.get(name) == null) {
			empNameMap.put(name, new HashSet<>());
		}
		empNameMap.get(name).add(e);
		String[] f_l_Name = name.split(" ");
		String fName = f_l_Name[0];
		if (empFNameMap.get(fName) == null) {
			empFNameMap.put(fName, new HashSet<>());
		}
		empFNameMap.get(fName).add(e);
		if (f_l_Name.length >= 2) {
			String lName = f_l_Name[f_l_Name.length - 1];
			if (empLNameMap.get(lName) == null) {
				empLNameMap.put(lName, new HashSet<>());
			}
			empLNameMap.get(lName).add(e);
		}

	}

	private void addId(Employee e) {
		String id = e.getId().toLowerCase();
		if (empIdMap.get(id) == null) {
			empIdMap.put(id, new HashSet<>());
		}
		empIdMap.get(id).add(e);
	}

	@Override
	public String toString() {
		return "DataStore [empIdMap=" + empIdMap + ", empNameMap=" + empNameMap + ", empFNameMap=" + empFNameMap
				+ ", empLNameMap=" + empLNameMap + ", skillMap=" + skillMap + "]";
	}

}
