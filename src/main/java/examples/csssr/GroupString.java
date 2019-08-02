package examples.csssr;

import java.util.*;

public class GroupString {

    private String in;
    private String out;

    private Map<HashCharacter, Set<String>> data;

    public GroupString(String in) {
        this.in = in;
        try {
            if (!validateString())
                throw new ValidationException("Некорректные входные данные: " + in);
            parseString();
            out = format();
            System.out.println(out);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean validateString() {
        if (in == null || in.isEmpty())
            return false;
        if (in.contains("  "))
            return false;
        return in.matches("[А-Яа-я '-]+");
    }

    private void parseString() throws ValidationException {
        data = new TreeMap<HashCharacter, Set<String>>(new ComparatorByKey());
        String[] words = in.split(" ");
        for (String word : words) {
            char first = word.charAt(0);
            if (first >= 'А' && first <= 'Я') {
                String firstStr = word.substring(0, 1).toLowerCase();
                first = firstStr.charAt(0);
            } else if (!(first >= 'а' && first <= 'я'))
                throw new ValidationException("Некорректные входные данные в слове: " + word);
            HashCharacter key = new HashCharacter(first);
            Set<String> values = data.get(key);
            if (values == null)
                values = new TreeSet<String>(new ComparatorByLength());
            values.add(word);
            data.put(key, values);
        }
    }

    private String format() {
        String result = "";
        for (HashCharacter key : data.keySet()) {
            Set<String> values = data.get(key);
            if (values.size() > 1) {
                result += key + "=";
                String valuesStr = "";
                for (String value : values)
                    valuesStr += value + ", ";
                valuesStr = valuesStr.substring(0, valuesStr.length() - 2);
                result += "[" + valuesStr + "], ";
            }
        }
        if (!result.isEmpty())
            result = result.substring(0, result.length() - 2);
        result = "[" + result + "]";
        return result;
    }

    private class HashCharacter {

        private char value;

        private HashCharacter(char value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof HashCharacter))
                return false;
            return value == ((HashCharacter) o).value;
        }

        @Override
        public int hashCode() {
            return value - 'А';
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private class ValidationException extends Throwable {

        private ValidationException(String message) {
            super(message);
        }

    }

    private class ComparatorByKey implements Comparator<HashCharacter> {

        @Override
        public int compare(HashCharacter o1, HashCharacter o2) {
            return o1.value < o2.value ? -1 : o1.value == o2.value ? 0 : 1;
        }
    }

    private class ComparatorByLength implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length())
                return -1;
            if (o1.length() < o2.length())
                return 1;
            Comparator<HashCharacter> characterComparator = new ComparatorByKey();
            for (int i = 0; i < o1.length(); i++) {
                HashCharacter c1 = new HashCharacter(o1.charAt(i));
                HashCharacter c2 = new HashCharacter(o2.charAt(i));
                int res = characterComparator.compare(c1, c2);
                if (res != 0)
                    return res;
            }
            return 0;
        }
    }

}
