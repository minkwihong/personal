package com.ksign.access.tool;

public class KAStringTokenizer {
    String string;
    String delimiter;
    int index;

    public KAStringTokenizer(String str, String del) {
        this.delimiter = del;
        this.string = str;
        index = 0;
    }

    public boolean hasMoreTokens() {
        if (index < string.length()) {
            return true;
        }
        return false;
    }

    public String nextToken() {
        return nextToken(delimiter);
    }

    public int countToken() {
        int count = 0;
        int cntIndex = 0;
        for (int i = cntIndex; i < string.length() - delimiter.length() + 1; i++) {
            String str = string.substring(i, i + delimiter.length());
            if (delimiter.equals(str)) {
                count++;
            } else {
                cntIndex = i + 1;
            }
        }
        return count;
    }

    public String nextToken(String delimiter) {
        this.delimiter = delimiter;
        StringBuffer sb = new StringBuffer();
        if ((string.length() - index) < delimiter.length()) {
            index = string.length();
            return string.substring(index);
        }
        for (int i = index; i < string.length() - delimiter.length() + 1; i++) {
            String str = string.substring(i, i + delimiter.length());
            if (delimiter.equals(str)) {
                index = i + delimiter.length();
                return sb.toString();
            } else {
                index = i + 1;
                sb.append(string.charAt(i));
            }
        }
        for (int i = index; i < string.length(); i++) {
            sb.append(string.charAt(i));
        }
        index = string.length();
        return sb.toString();
    }

    public String[] getTokens() {
        String[] tokens = null;
        int tokenCount = 0, index = 0;

        tokenCount = countToken();
        if (tokenCount == 0) {
            return null;
        } else {
            tokens = new String[tokenCount];

        } while (this.hasMoreTokens()) {
            if (index < tokenCount) {
                tokens[index++] = this.nextToken();
            } else {
                this.nextToken();
            }
        }

        return tokens;
    }

    public static String[] getTokens(String str, String delimiter) {
        KAStringTokenizer st = new KAStringTokenizer(str, delimiter);
        return st.getTokens();
    }

}
