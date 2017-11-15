package pri.xyf.collection.set_map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Dale
 *  继承hashSet(里面SimpleEntry的泛型维护一个键值对)实现一个Map
 * @param <K>
 * @param <V>
 */
public class Set2Map<K, V> extends HashSet<SimpleEntry<K, V>> {
	
	 
	//实现清空所有key-value对的方法
	@Override
	public void clear(){
		super.clear();
	}
	
	
	//判断是否包含某个Key
	public boolean containsKey(K key)
	{
		return super.contains(
				new SimpleEntry<K , V> (key,null));
	}
	
	//判断是否包含某个Value
	public boolean containsValue(Object value)
	{
		for(SimpleEntry<K, V> se:this)
		{
			if(se.getValue().equals(value))
			{
				return true;
			}
		}
		return false;
	}
	
	//根据指定key取出对应的value
	public V get(Object key)
	{
		for(SimpleEntry<K, V> se:this)
		{
			if(se.getKey().equals(key))
			{
				return se.getValue();
			}
		}
		
		return null;
	}
	
	//将指定key-value对放入集合中
	public V put(K key,V value)
	{
		add(new SimpleEntry<K,V>(key,value));
		return value;
	}
	
	//将另一个Map的key-value对放入该Map中
	public void putAll(Map<? extends K,? extends V> m)
	{
		for(K key:m.keySet())
		{
			add(new SimpleEntry<K,V>(key,m.get(key)));
		}
	}
	
	//根据指定key删除指定key-value对
	public V removeEntry(Object key)
	{
		for(Iterator<SimpleEntry<K,V>> it = this.iterator();it.hasNext();)
		{
			SimpleEntry<K, V> en = (SimpleEntry<K, V>)it.next();
			
			if(en.getKey().equals(key))
			{
				V v = en.getValue();
				it.remove();
				return v;
			}
		}
		
		return null;
	}
	
	//获取该Map中包含多少个key-value对
	public int size()
	{
		return super.size();
	}
	
	
	
	public static void main(String args[]){
		Set2Map<String, Integer> scores = new Set2Map<String, Integer>();
		scores.put("语文",90);
		scores.put("数学",89);
		scores.put("英语",91);
		System.out.println(scores);
		
		//访问Map集合里面的keyvalue对
		System.out.println(scores.size());
		scores.removeEntry("数学");
		System.out.println("删除了key为\"数学\"的Entry之后: "+scores);
		//根据key取出value
		System.out.println("语文成绩: "+scores.get("语文"));
		//判断是否包含指定key
		System.out.println("是否包含\"英文\"key :"+scores.containsKey("英文"));
		//判断是否包含指定key
		System.out.println("是否包含\"82\"value :"+scores.containsValue(82));
		scores.clear();
		System.out.println("执行clear()方法之后的集合: "+scores);
	}
}	
