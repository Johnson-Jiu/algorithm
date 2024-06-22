package algorithm;

/**
 * @author Mr Wrong
 */
public class TestBinary {
    public static void main(String[] args) {
        int[] array = {1,3,4,5,6,8,8,8,11,18};
        System.out.println(searchNum2(8, array));
    }

    private static int searchNum(int num, int[] array){
        int low = 0 , high = array.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if(array[mid] > num){
                high = mid - 1;
            }else if(array[mid] < num){
                low = mid + 1;
            }else{
                if(mid == array.length - 1 || num != array[mid+1]){
                    return mid;
                }
                high = mid + 1;
            }
        }
      return -1;
    }

    private static int searchNum2(int num, int[] array){
        int low = 0 , high = array.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if(array[mid] >= num){
                if(mid == 0 ||  array[mid-1] < num) {
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }else if(array[mid] < num){
                low = mid + 1;
            }
        }
        return -1;
    }

}
