/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Дмитрий Белоус
 */
public class DataBase {

    private File file = new File("data.bin");

    public DataBase() {
    }

    public List<Note> getNotesByDate(Calendar calendar) {
        throw new UnsupportedOperationException();
    }

    public void insert(Note note) {
        throw new UnsupportedOperationException();
    }
}
