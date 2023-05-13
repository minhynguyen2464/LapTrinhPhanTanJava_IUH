
public interface DictionaryInterface {
	public String lookup(String word);
	public String add(String english, String vietnamese);
	public String delete(String deleteWord);
	public String maxWord();
}
