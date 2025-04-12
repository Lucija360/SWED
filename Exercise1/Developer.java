import java.util.List;

public class Developer {
	
	// attributes
    private String name;
    private int age;
    private String email;
    private List<String> languages;
    private int yearsExperience;

    // constructor
    public Developer(String name, int age, String email, List<String> languages, int yearsExperience) {
        setName(name);
        setAge(age);
        setEmail(email);
        setLanguages(languages);
        setYearsExperience(yearsExperience);
    }

   // Setters
    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty.");
        this.name = name;
    }

    public void setAge(int age) {
        if (age <= 0 || age > 120)
            throw new IllegalArgumentException("Age must be between 1 and 120.");
        this.age = age;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email.");
        this.email = email;
    }

    public void setLanguages(List<String> languages) {
        if (languages == null || languages.isEmpty())
            throw new IllegalArgumentException("Languages list cannot be empty.");
        for (String lang : languages) {
            if (lang == null || lang.trim().isEmpty())
                throw new IllegalArgumentException("Languages must not contain null or empty strings.");
        }
        this.languages = languages;
    }

    public void setYearsExperience(int yearsExperience) {
        if (yearsExperience < 0 || yearsExperience > age - 10)
            throw new IllegalArgumentException("Experience must be realistic for age.");
        this.yearsExperience = yearsExperience;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public List<String> getLanguages() { return languages; }
    public int getYearsExperience() { return yearsExperience; }

    @Override
    public String toString() {
        return "Developer  name='" + name + "', age=" + age + ", email='" + email +
               "', languages=" + languages + ", years of experience = " + yearsExperience + " ";
    }

    public static void main(String[] args) {
        Developer dev = new Developer(
            "Lucija Karan",
            20,
            "Lkaran@daenet.com",
            List.of("C#", "C++", "JavaScript", "Java", "Python", "Kotlin", "SQL"),
            4
        );
        System.out.println(dev);
    }
}
