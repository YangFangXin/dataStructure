package pri.xyf.collection.set_map;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dale
 *  测试HashSetTest 
 */
class Name{
	private String first;
	private String last;
	public Name(String first,String last)
	{
		this.first = first;
		this.last = last;
	}
	public boolean equals(Object o){
		if(this == o)
		{
			return true;
		}
		if(o.getClass() == Name.class)
		{
			Name n = (Name) o;
			return n.first.equals(first) && n.last.equals(last);
		}
		return false;
	}
	
	//根据first的值计算hashCode的值
	public int hashCode()
	{
		return first.hashCode();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
public class HashSetTest {

	public static void main(String[] args) {
		Set<Name> s= new HashSet<Name>();
		s.add(new Name("第一顺位","球哥"));
		System.out.println(s.equals(new Name("第一顺位","球哥")));
	}

}
