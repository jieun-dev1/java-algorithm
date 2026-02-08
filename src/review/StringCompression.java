package review;

//read goes to the end
//writes when read reaches to the end of chars &
//anchor is when the character appears first
//the location of write is the length

class StringCompressionV2 {
    public int compress(char[] chars) {
        int write = 0;
        int anchor = 0; //where a character starts
        int count;

        for (int read=0; read<chars.length; read++) {
            if (read == chars.length - 1 || chars[read] != chars[read+1]) {
                chars[write++] = chars[read];
                count = read - anchor + 1;
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[write++] = c;
                    }
                }
            }
        }
        return write;
    }

    public static void main(String[] args) {
        StringCompressionV2 stringCompression = new StringCompressionV2();
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(stringCompression.   compress(chars));
    }
}
