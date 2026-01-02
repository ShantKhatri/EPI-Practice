import java.util.List;

public class DeleteDuplicateFromArray {

    public static int deleteDup(List<Integer> array){
        if(array.isEmpty())
            return 0;
        int writtenIndex = 1;
        for(int i = 1; i < array.size(); ++i){
            if(!array.get(i-1).equals(array.get(i)))
                array.set(writtenIndex++, array.get(i));
        }
        return writtenIndex;
    }

    public static int deleteKeyFromArray(List<Integer> array, int key){
        if (array.isEmpty())
            return 0;
        int writeIndex = 0;
        for (int i = 0; i<array.size()-1; i++){
            if(!array.get(i).equals(key))
                array.set(writeIndex++, array.get(i));
        }
        return writeIndex;
    }

    public static List<Integer> updateArray(List<Integer> array, int key, int count) {
        count = Math.min(2, count);
        if(count == 0 || array.isEmpty())
            return array;
        int index = 0;
        while(count!=0){
            if(array.get(index) == key){
                count--;
            }
            index++;
        }
        if(index == array.size()-1){
            return array;
        }
        int writeIndex = index;
        for(int i=index; i<array.size(); ++i){
            if(!array.get(i).equals(key)){
                array.set(writeIndex++, array.get(i));
            }
        }
        return array;
    }

    public static void main(String[] args) {
        
    }
}
