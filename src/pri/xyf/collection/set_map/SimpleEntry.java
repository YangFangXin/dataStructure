package pri.xyf.collection.set_map;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Dale
 *   把set扩展成map
 *   为了把set扩展成map,可以考虑新增定义一个SimpleEntry类，该类代表一个key-value对。
 *   当set集合的集合元素都是SimpleEntry对象时，该set集合就能被当成Map使用。
 *   
 * @param <K>
 * @param <V>
 */
public class SimpleEntry<K, V> implements Map.Entry<K, V>,Serializable{
	private final K key;
	private V value;
	
	public SimpleEntry(K key,V value) {
		this.key = key;
		this.value = value;
	}
	
	public  SimpleEntry(Map.Entry<? extends K,? extends  V> entry) {
		this.key = entry.getKey();
		this.value = entry.getValue();
	} 
	
	//获取key
	@Override
	public K getKey() {
		return key;
	}
	
	//获取value
	@Override
	public V getValue() {
		return value;
	}
	
	//改变该key-value对的value值
	@Override
	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
	//根据key比较2个SimpleEntry是否相等
	public boolean equal(Object o)
	{
		if(o == this)
		{
			return true;
		}
		if(o.getClass() == SimpleEntry.class)
		{
			SimpleEntry se = (SimpleEntry) o;
			return se.getKey().equals(getKey());
		}
		return false;
	}
	
	//根据key计算hashCode
	public int hashCode()
	{
		return key == null ? 0:key.hashCode();
	}
	
	public String toString(){
		return key + "=" + value;
	}

}
