
public class test2 {
    public static void main(String[] args) throws Exception{
        //</?\w+((\s+\w+(\s*=\s*(?: ".*?"|'.*?'|[^'">\s]+))?)+\s*|\s*)/?>
        System.out.print("</?\\w+((\\s+\\w+(\\s*=\\s*(?:\".*?\"|\'.*?\'|[^\'\">\\s]+))?)+\\s*|\\s*)/?>");
    }
}
