package solSoft.service;

import solSoft.view.interfaces.NoteAdded;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteService {

    private Map<LocalDate, String> map = new HashMap<>();
    private List<NoteAdded> list = new ArrayList<>();

    private static NoteService instance = null;

    private NoteService() {

    }

    public static NoteService getInstance() {
        if (instance == null) {
            instance = new NoteService();
        }
        return instance;
    }

    public void noteEvent(LocalDate localDate, String text) {
        list.forEach(p -> p.onCreateNote(localDate, text));
    }

    public void addToList(NoteAdded noteAdded) {
        list.add(noteAdded);
    }


    public Map<LocalDate, String> getMap() {
        return map;

    }


}
