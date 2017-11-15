package pri.xyf.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dale
 * java实现顺序表
 */

public class SequenceList<T> {
	
	private final int DEFAULT_SIZE = 16;
	
	//保存数组的长度
	private int capacity;
	
	//定义一个数组用于保存顺序线性表中的元素
	private Object[] elementData;
	
	//保存顺序表中元素的当前个数
	private int size = 0;
	
	//以默认数组长度创建空顺序表
	public SequenceList()
	{
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	
	
	//以一个初始化元素创建数据表
	public SequenceList(T element)
	{
		//调用无参构造方法
		this();
		elementData[0] = element;
		size++;
	}
	
	/**
	 * 以指定的长度的数组来创建顺序线性表
	 * @param element  指定顺序线性表中的第一个元素
	 * @param initSize 指定顺序线性表底层数组的长度
	 * 
	 */
	public SequenceList(T element,int initSize)
	{
		capacity = 1;
		//把capicity设为大于initSize的最小的2的n次方
		while(capacity < initSize)
		{
			//左移一位
			capacity <<= 1;
			
		}
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}
	
	
	/**
	 * 获取顺序线性表的大小
	 * @return
	 */
	public int length()
	{
		return size;
	}
	
	//获取顺序线性表中索引处为i处的元素
	public T get(int i)
	{
		if(i<0||i>size-1)
		{
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		return (T) elementData[i];
	}
	
	//查找顺序线性表中指定元素的索引（遍历数组查找对应元素，效率低）
	public int locate(T element)
	{
		for(int i=0;i<size;i++)
		{
			if(elementData[i]==element)
			{
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * 向顺序线性表的指定位置插入一个元素
	 * 
	 * @param element  指定元素
	 * @param index    指定索引位置
	 */
	public void insert(T element,int index)
	{
		if(index <0 || index >size)
		{
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		ensureCapacity(size+1);
		
		//将指定索引处之后的所有元素向后移动一格
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		
		elementData[index] = element;
		
		size++;
	}
	
	//在顺序线性表的开始处添加一个元素
	public void add(T element)
	{
		insert(element, size);
	}
	
	
	
	//数组扩容
 	/**
 	 * @param minCapacity  数组所需长度
 	 * 
 	 */
 	private void ensureCapacity(int minCapacity) 
 	{
 		//如果数组的原有长度小于所需长度
 		if(minCapacity < capacity)
 		{
 			//不断将capacity *2  直到  capacity > minCapicity
 			while(capacity < minCapacity )
 			{
 				capacity <<=  1;
 			}
 			elementData = Arrays.copyOf(elementData, capacity);
 		}
	}
 	
 	
 	/**
 	 * 
 	 * 删除顺序线性表指定索引处的元素
 	 * 
 	 * @param index  指定索引
 	 * @return
 	 */
 	public T delete(int index)
 	{
 		if(index <0 || index > size -1)
 		{
 			throw new IndexOutOfBoundsException("线性表索引越界");
 		}
 		
 		T oldValue = (T) elementData[index];
 		int numMoved = size - index -1;
 		if(numMoved >0)
 		{
 			System.arraycopy(elementData,index+1,elementData,index,numMoved);
 		}
 		
 		//清空最后一个元素
 		elementData[--size] = null;
 		return oldValue;
 	}
 	
 	/**
 	 * 删除顺序线性表最后一个元素
 	 * @return
 	 */
 	public T remove()
 	{
 		return delete(size-1);
 	}
 	
 	
 	/**
 	 * 判断顺序线性表是否为空表
 	 * @return
 	 */
 	public boolean empty()
 	{
 		return size ==0;
 	}
 	
 	/**
 	 * 清空线性表
 	 */
 	public void clear(){
 		//将底层数组所有元素赋为null
 		Arrays.fill(elementData, null);
 		size = 0;
 	}
 	
 	
 	
 	public String toString()
 	{
 		if(size == 0)
 		{
 			return "[]";
 		}
 		else
 		{
 			StringBuilder sb = new StringBuilder("[");
 			for (int i = 0; i < size; i++) {
				sb.append(elementData[i].toString()+",");
			}
 			int len = sb.length();
 			return sb.delete(len -2 , len).append("]").toString();
 		}
 	}
 	
 	
 	
	public static void main(String[] args) {
		SequenceList<String> list = new SequenceList<String>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		
		//在索引1处插入一个新元素
		list.insert("dddd", 1);
		//输出线性表的元素
		System.out.println(list);
		//删除索引处为2处的元素
		list.delete(2);
		
		System.out.println(list);
		//获取cccc字符串在顺序线性表中
		System.out.println("cccc在顺序线性表中的位置: "+list.locate("cccc"));
	}

}
