public class CharsClass {
    public String[] firstAndLast(String str, int n) {
        if (str == null){
            return null;
        }

        String[] result = new String[2];

        String firstN = str.substring(0, Math.min(n, str.length()));
        String lastN = str.substring(Math.max(0, str.length() - n));

        result[0] = firstN;
        result[1] = lastN;

        return result;
    }
}
