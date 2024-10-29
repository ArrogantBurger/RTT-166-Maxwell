package test_files.list_inheritance;

import java.util.ArrayList;

public class ArrayToList implements MyList{

    ArrayList<String> arrayToList;

    public ArrayToList() {
        arrayToList = new ArrayList<>();
    }

    public void convert(String[] a) {
        for (int i = 0; i < a.length; i++) {
            arrayToList.add(a[i]);
            System.out.println("I have added the string: " + a[i] + " at the index: " + i);
            /*try {
                arrayToList.add(a[i]);
                System.out.println("I have added the string: " + a[i] + " at the index: " + i);
            } catch (Exception e) {
                throw new InvalidStringException("String at index " + (i + 1) + " is not valid");
            }*/
            //arrayToList.add(a[i]);
            //System.out.println("I have added the string: " + a[i] + " at the index: " + i);
        }
    }

    public void replace(int idx) {
        String name = arrayToList.get(idx);
        arrayToList.set(idx, "");
        System.out.println("I have replaced the string: " + name + " with a null string.");
    }

    public ArrayList<String> compact() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < arrayToList.size(); i++) {
            //String name = arrayToList.get(i);
            if (!arrayToList.get(i).equals("")) {
                result.add(arrayToList.get(i));
                //System.out.println("Removed " + name + " at index: " + i);
            }
        }
        arrayToList = result;
        return arrayToList;
    }

    public void printList(){
        for (int i = 0; i < arrayToList.size(); i++) {
            System.out.println("entry " + i + " " + arrayToList.get(i));
        }
    }

    public static void main(String[] args) throws InvalidStringException {
        ArrayToList test = new ArrayToList();
        try {
            String[] array1 = {"Volvo", "BMW", "Ford", "Mazda", "Chrysler", "Pinto", "Nascar", "Toyota"};
        } catch (Exception e) {
            throw new InvalidStringException("hi");
        }
        String[] array1 = {"Volvo", "BMW", "Ford", "Mazda", "Chrysler", "Pinto", "Nascar", "Toyota"};
        test.convert(array1);
        test.replace(2); // should remove ford
        test.compact();

        test.printList();
    }
}
