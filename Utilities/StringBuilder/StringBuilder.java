package StringBuilder;

import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.TrustManager;

public class StringBuilder implements Cloneable {

    ArrayList<String> values;

    public StringBuilder() {
        values = new ArrayList<String>();
    }

    public ArrayList<String> getValues() {
        return this.values;
    }

    public void setValues(final ArrayList<String> values) {
        this.values = values;
    }

    public void add(final String w) {
        this.values.add(w);
    }

    public void remove(final String w) {
        if (this.values.indexOf(w) != -1) {
            this.values.remove(w);
        }
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public void add(final int index, final String element) {
        values.add(index, element);
    }

    public void clear() {
        values.clear();
    }

    public Boolean isUnique(String s) {
        if (s == null)
            return true;
        char[] charSet = s.toCharArray();
        HashMap<Character, Integer> domain = new HashMap<Character, Integer>();
        for (char charEl : charSet) {
            if (domain.get(charEl) != null) {
                return false;
            } else {
                domain.put(charEl, 1);
            }
        }
        return true;
    }

    public Boolean isPermutation(String a, String b) {
        if (a == null && b == null)
            return true;
        else if (a == null || b == null)
            return false;

        char[] charSetA = a.toCharArray();
        char[] charSetB = b.toCharArray();
        HashMap<Character, Integer> domainA = new HashMap<Character, Integer>();
        HashMap<Character, Integer> domainB = new HashMap<Character, Integer>();

        for (char charEl : charSetA) {
            if (domainA.get(charEl) != null) {
                domainA.put(charEl, domainA.get(charEl) + 1);
            } else {
                domainA.put(charEl, 1);
            }
        }

        for (char charEl : charSetB) {
            if (domainB.get(charEl) != null) {
                domainB.put(charEl, domainB.get(charEl) + 1);
            } else {
                domainB.put(charEl, 1);
            }
        }

        if (domainA.size() != domainB.size()) {
            // some elements missed in A or B
            return false;
        }

        for (char keyA : domainA.keySet()) {
            if (domainB.containsKey(keyA)) {
                if (domainB.get(keyA) != domainA.get(keyA)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        for (char keyB : domainB.keySet()) {
            if (domainA.containsKey(keyB)) {
                if (domainA.get(keyB) != domainB.get(keyB)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public String changeChar(String s, char x, char y) {
        if (s == null || s == "") {
            return s;
        }
        if (s.indexOf("" + x) != -1) {
            char[] chars = s.toCharArray();
            String output = "";
            for (char charEl : chars) {
                if (charEl == x) {
                    output += "" + y;
                } else {
                    output += "" + charEl;
                }
            }
            return output;
        } else {
            return s;
        }
    }

    public Boolean isReverse(String a, String b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;

        if (a.length() != b.length()) {
            return false;
        }
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();

        int n = ac.length;
        for (int i = 0; i < n; i++) {
            if (ac[i] != bc[n - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public Boolean isPalindrome(String a) {
        if (a == null || a == "") {
            return true;
        } else {
            char[] x = a.toCharArray();
            String reverse = "";
            for (int i = 0; i < x.length; i++) {
                reverse += x[x.length - i - 1];
            }
            
            if (reverse.equals(a)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((values == null) ? 0 : values.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final StringBuilder other = (StringBuilder) obj;
        if (values == null) {
            if (other.values != null)
                return false;
        } else if (!values.equals(other.values))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String output = "";
        for (final String word : this.values) {
            output += word;
        }
        return output;
    }

    @Override
    @SuppressWarnings("all")
    public StringBuilder clone() {
        try {
            StringBuilder cloned = (StringBuilder) super.clone();
            cloned.values = (ArrayList<String>) values.clone();
            return cloned;
        } catch (final CloneNotSupportedException e) {
            return null;
        }
    }

}
