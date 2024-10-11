public class SubstringChecker implements Checker{
    private final String _pattern;

    static void computeLPSArray(String pattern, int size, int[] lps) {
        int len = 0;
        lps[0] = 0;
        int i = 1;

        while (i < size) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0) {
                    len = lps[len-1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    private boolean kmpSearch(String text){
        int pLen = _pattern.length();
        int tLen = text.length();

        int[] lps = new int[pLen];

        computeLPSArray(_pattern, pLen, lps);
        int i = 0;
        int j = 0;
        while((tLen - i) >= (pLen - j)){
            if(text.charAt(i) == _pattern.charAt(j)){
                j++;
                i++;
            }

            if(j == pLen){
                return true;
            }
            else if(i < tLen && _pattern.charAt(j) != text.charAt(i)){
                if(j != 0) {
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
        }
        return false;
    }

    SubstringChecker(String pattern){
        _pattern = pattern;
    }

    public boolean accept(String text) {
        return kmpSearch(text);
    }
}
