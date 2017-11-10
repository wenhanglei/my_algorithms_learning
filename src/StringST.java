/**
 * 字符串符号表api
 * @author Administrator
 *
 */
public class StringST<Value> {
	
	/**
	 * 构造函数
	 */
	public StringST() {
	}
	/**
	 * @param s
	 * @return 返回健为 s的值
	 */
	public Value get(String key) {
		return null;
	}
	/**
	 * 向符号表里添加键值对
	 * @param s
	 * @param v
	 */
	public void put(String key, Value val) {
		
	}
	/**
	 * 删除健为key的键值对
	 * @param key
	 */
	public void delete(String key) {
		
	}
	/**
	 * @param key
	 * @return 该符号表是否包含健为key的键值对
	 */ 
	public boolean contains(String key) {
		return false;
	}
	/**
	 * @return 该符号表是否为空
	 */
	public boolean isEmptry() {
		return false;
	}
	/**
	 * @param s
	 * @return 该字符串在符号表中的最长公共前缀
	 */
	public String longestPrefixOf(String s) {
		return null;
	}
	/**
	 * @param s
	 * @return 符号表中包含前缀s的所有字符串
	 */
	public Iterable<String> keysWithPrefix(String s) {
		return null;
	}
	/**
	 * @param s
	 * @return 返回符号表中与字符串s相匹配的所有字符串
	 */
	public Iterable<String> keysThatMatch(String s) {
		return null;
	}
	/**
	 * @return 符号表中的键值对个数
	 */
	public int size() {
		return 0;
	}
	/**
	 * @return 返回符号表中的所有字符串健
	 */
	public Iterable<String> keys() {
		return null;
	}
}












