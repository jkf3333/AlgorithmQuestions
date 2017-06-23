package algorithm.maxSerialLen;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**算法说明：
 * 给1个有序的整数数组，判断出最长连续数的长度，并输出连续数
 * 连续的定义：数字与前一个数字相减等于1，例如：3,4是连续；3,5就不是连续
 * 
 * 伸展：判断英文字母中连续的长度：因为英文字符可以转换为数字，因此同样适用
 * 
 * 思路：遍历数组，找出第一个连续的，然后再从该数开始遍历数组，判断改连续的持续长度，通过map进行记录
 * **/

public class SerialLenTest {
	public static void main(String[] args) {
		int arr[]=new int[]{1,3,4,5,6,8,9,11,13,15};
		Map<Integer,Integer> map = getMaxLen(arr);
		for(Entry<Integer,Integer> entry : map.entrySet()){
			print(arr,entry.getKey(),entry.getValue());
		}
	}

	private static Map<Integer, Integer> getMaxLen(int[] arr) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		//遍历数组
		for(int i=1;i<arr.length;i++){
			if((arr[i-1]+1)==arr[i]){
				//arr[i-1]和arr[i]是连续
				int tempIndex=i-1;//保存arr中连续的起始index
				int len = 0;//保存连续长度
				for(int j=i-1;j<arr.length-1;j++){
					//判断arr[i-1]之后有多长的连续数字
					if((arr[j]+1)==arr[j+1]){
						len++;
					}else{
						//不连续：因为数组是有序的，因此可以忽略已经通过j判断的连续
						i=j+1;
						map.put(tempIndex, len+1);
						break;
					}
				}
			}
		}
		return map;
	}
	
	private static void print(int[] arr, Integer index, Integer len) {
		System.out.println("---连续数字如下：--");
		for(int i=index;i<index+len;i++){
			System.out.print("["+i+"]:"+arr[i]+"  ");
		}
		System.out.println();
	}
}
