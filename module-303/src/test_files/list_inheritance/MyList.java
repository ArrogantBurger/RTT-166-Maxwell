package test_files.list_inheritance;

import java.util.ArrayList;

public interface MyList {
    public void convert(String[] a);
    public void replace (int idx);
    public ArrayList<String> compact();
}
