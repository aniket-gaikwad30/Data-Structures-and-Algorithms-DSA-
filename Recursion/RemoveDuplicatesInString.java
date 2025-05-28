public class RemoveDuplicatesInString {

    public static void removeDuplicates(String str, int index, StringBuilder newStr, boolean map[]) {
        if (index == str.length()) {
            System.out.println(newStr);
            return;
        }
            char ch = str.charAt(index);

            if(map[ch-'a']==true){
                removeDuplicates(str, index+1, newStr, map);
            }else{
                map[ch-'a']=true;
                removeDuplicates(str, index + 1, newStr.append(ch), map);
            }
    }

    public static void main(String[] args) {
            String str = "appnnacollage";
            removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
            
    }
}