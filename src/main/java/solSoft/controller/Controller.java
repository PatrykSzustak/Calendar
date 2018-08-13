package solSoft.controller;

import solSoft.view.interfaces.ChangeDate;
import solSoft.view.interfaces.ChangeView;
import solSoft.view.interfaces.NoteAdded;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Controller {


    private static Controller instance = null;

    private List<ChangeView> viewList = new CopyOnWriteArrayList<>();
    private List<ChangeDate> dateList = new CopyOnWriteArrayList<>();
    private List<NoteAdded> noteList = new ArrayList<>();
    private Map<LocalDate, List<NoteAdded>> map = new HashMap<>();

    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void changeView(ViewMode viewMode) { viewList.forEach(p -> p.onViewChange(viewMode)); }

    public void registerViewChange(ChangeView viewComponent) {
        viewList.add(viewComponent);
    }

    public void changeDate(LocalDate date) { dateList.forEach(p -> p.onDateChange(date)); }

    public void registerDateChange(ChangeDate dateComponent) { dateList.add(dateComponent); }


    public void registerNote(NoteAdded noteAdded) { noteList.add(noteAdded);}

    public void registerNoteInMap(LocalDate localDate, List<NoteAdded> list) {map.put(localDate,list);}

    public void addNote (LocalDate localDate){noteList.forEach(p->p.onCreateNote(localDate));}

    public List<NoteAdded> getNoteList() { return noteList; }

    public Map<LocalDate, List<NoteAdded>> getMap() { return map; }

}
