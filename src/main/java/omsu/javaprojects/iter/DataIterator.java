package omsu.javaprojects.iter;

import omsu.javaprojects.models.Data;

import java.util.Iterator;

public class DataIterator implements Iterator<Integer> {
    private int index;
    private Data setOfGroups;

    public DataIterator(Data setOfGroups) {
        index = -1;
        this.setOfGroups = setOfGroups;
    }

    @Override
    public boolean hasNext() {
        int size = 0;
        for (int i = 0; i < setOfGroups.length(); i++) {
            size += setOfGroups.getGroups()[i].length();
        }
        return (index + 1) < size;
    }

    @Override
    public Integer next() {
        index++;
        int currentIndex = index;
        int i = 0;
        for (; i < setOfGroups.length(); i++) {
            if (currentIndex < setOfGroups.getGroups()[i].length()) {
                break;
            }
            currentIndex -= setOfGroups.getGroups()[i].length();
        }
        return setOfGroups.getGroups()[i].getData()[currentIndex];
    }
}
