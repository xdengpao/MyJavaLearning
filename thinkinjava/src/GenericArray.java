//generics/GenericArray.java

public class GenericArray<T>{
	private Object[] array;
	/*
	 *功能描述
	 * @author dengpao
	 * @date 2019/4/12
	  * @Param sz
	 * @return
	 */
	public GenericArray(int sz){
		array = new Object[sz];
	}
	/*
	 *功能描述
	 * @author dengpao
	 * @date 2019/4/12
	  * @Param index
	 * @Param item
	 * @return void
	 */
	public void put(int index, T item){
		array[index] = item;
	}
	@SuppressWarnings("unchecked")
	/*
	 *功能描述
	 * @author dengpao
	 * @date 2019/4/12
	  * @Param index
	 * @return T
	 */
	public T get(int index){
		return (T)array[index];
	}
	@SuppressWarnings("unchecked")
	public T[] rep(){
		return (T[])array;//warning: unchar
	}
	 public static void main(String[] args) {
	 	GenericArray<Integer> gai = new GenericArray<>(10);
	 	for(int i = 0;i<10;i++){
	 		gai.put(i,i);
	 	}
	 	for(int i = 0;i<10;i++){
	 		System.out.print(gai.get(i)+" ");
	 	}
	 	System.out.println();
	 	try{
	 		Integer[] ia = gai.rep(); 
	 	}catch(Exception e){
	 		System.out.println(e);
	 	}
		
	}
}/*Output: (Sample)
*///:~
