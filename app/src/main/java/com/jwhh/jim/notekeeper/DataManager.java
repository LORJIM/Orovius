package com.jwhh.jim.notekeeper;

import java.util.ArrayList;
import java.util.List;


public class DataManager {
    private static DataManager ourInstance = null;

    private List<CourseInfo> mCourses = new ArrayList<>();
    private List<NoteInfo> mNotes = new ArrayList<>();

    public static DataManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeCourses();
            ourInstance.initializeExampleNotes();
        }
        return ourInstance;
    }

    public String getCurrentUserName() {
        return "Jim Wilson";
    }

    public String getCurrentUserEmail() {
        return "jimw@jwhh.com";
    }

    public List<NoteInfo> getNotes() {
        return mNotes;
    }

    public int createNewNote() {
        NoteInfo note = new NoteInfo(null, null, null);
        mNotes.add(note);
        return mNotes.size() - 1;
    }

    public int findNote(NoteInfo note) {
        for(int index = 0; index < mNotes.size(); index++) {
            if(note.equals(mNotes.get(index)))
                return index;
        }

        return -1;
    }

    public void removeNote(int index) {
        mNotes.remove(index);
    }

    public List<CourseInfo> getCourses() {
        return mCourses;
    }

    public CourseInfo getCourse(String id) {
        for (CourseInfo course : mCourses) {
            if (id.equals(course.getCourseId()))
                return course;
        }
        return null;
    }

    public List<NoteInfo> getNotes(CourseInfo course) {
        ArrayList<NoteInfo> notes = new ArrayList<>();
        for(NoteInfo note:mNotes) {
            if(course.equals(note.getCourse()))
                notes.add(note);
        }
        return notes;
    }

    public int getNoteCount(CourseInfo course) {
        int count = 0;
        for(NoteInfo note:mNotes) {
            if(course.equals(note.getCourse()))
                count++;
        }
        return count;
    }

    private DataManager() {
    }

    //region Initialization code

    private void initializeCourses() {
        mCourses.add(initializeCourse1());
        mCourses.add(initializeCourse2());
        mCourses.add(initializeCourse3());
        mCourses.add(initializeCourse4());
    }

    public void initializeExampleNotes() {
        final DataManager dm = getInstance();

        CourseInfo course = dm.getCourse("Autoescuela");
        course.getModule("Autoescuela_m01").setComplete(true);
        course.getModule("Autoescuela_m02").setComplete(true);
        course.getModule("Autoescuela_m03").setComplete(true);
        mNotes.add(new NoteInfo(course, "Costes",
                "Me va a tocar pagar mucho dinero"));
        mNotes.add(new NoteInfo(course, "Intentando practicar",
                "La autoescuela no me llama para hacer las prácticas"));

        course = dm.getCourse("Quality");
        course.getModule("Quality_m01").setComplete(true);
        course.getModule("Quality_m02").setComplete(true);
        mNotes.add(new NoteInfo(course, "Miau",
                "NAN YESURIYA!!"));
        mNotes.add(new NoteInfo(course, "Cascos",
                "Puto casco de mierda que se cae a trozos"));

        course = dm.getCourse("Casa");
        course.getModule("Casa_m01").setComplete(true);
        course.getModule("Casa_m02").setComplete(true);
        course.getModule("Casa_m03").setComplete(true);
        course.getModule("Casa_m04").setComplete(true);
        course.getModule("Casa_m05").setComplete(true);
        course.getModule("Casa_m06").setComplete(true);
        course.getModule("Casa_m07").setComplete(true);
        mNotes.add(new NoteInfo(course, "Mosqueado",
                "Mi padre me tiene mosqueado con sus predicciones"));
        mNotes.add(new NoteInfo(course, "Comida de mierda",
                "Para una vez que me la hacen, y casi me muero mientras me la comia"));

        course = dm.getCourse("Juerga");
        course.getModule("Juerga_m01").setComplete(true);
        course.getModule("Juerga_m02").setComplete(true);
        course.getModule("Juerga_m03").setComplete(true);
        mNotes.add(new NoteInfo(course, "Proyect",
                "Impaciente por ir"));
        mNotes.add(new NoteInfo(course, "LOL",
                "(Insertar memes aqui)"));
    }

    private CourseInfo initializeCourse1() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("Autoescuela_m01", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("Autoescuela_m02", "Component activation with intents"));
        modules.add(new ModuleInfo("Autoescuela_m03", "Delegation and Callbacks through PendingIntents"));
        modules.add(new ModuleInfo("Autoescuela_m04", "IntentFilter data tests"));
        modules.add(new ModuleInfo("Autoescuela_m05", "Working with Platform Features Through Intents"));

        return new CourseInfo("Autoescuela", "Autoescuela", modules);
    }

    private CourseInfo initializeCourse2() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("Quality_m01", "Challenges to a responsive user experience"));
        modules.add(new ModuleInfo("Quality_m02", "Implementing long-running operations as a service"));
        modules.add(new ModuleInfo("Quality_m03", "Service lifecycle management"));
        modules.add(new ModuleInfo("Quality_m04", "Interacting with services"));

        return new CourseInfo("Quality", "Quality", modules);
    }

    private CourseInfo initializeCourse3() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("Casa_m01", "Introduction and Setting up Your Environment"));
        modules.add(new ModuleInfo("Casa_m02", "Creating a Simple App"));
        modules.add(new ModuleInfo("Casa_m03", "Variables, Data Types, and Math Operators"));
        modules.add(new ModuleInfo("Casa_m04", "Conditional Logic, Looping, and Arrays"));
        modules.add(new ModuleInfo("Casa_m05", "Representing Complex Types with Classes"));
        modules.add(new ModuleInfo("Casa_m06", "Class Initializers and Constructors"));
        modules.add(new ModuleInfo("Casa_m07", "A Closer Look at Parameters"));
        modules.add(new ModuleInfo("Casa_m08", "Class Inheritance"));
        modules.add(new ModuleInfo("Casa_m09", "More About Data Types"));
        modules.add(new ModuleInfo("Casa_m10", "Exceptions and Error Handling"));
        modules.add(new ModuleInfo("Casa_m11", "Working with Packages"));
        modules.add(new ModuleInfo("Casa_m12", "Creating Abstract Relationships with Interfaces"));
        modules.add(new ModuleInfo("Casa_m13", "Static Members, Nested Types, and Anonymous Classes"));

        return new CourseInfo("Casa", "Casa", modules);
    }

    private CourseInfo initializeCourse4() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("Juerga_m01", "Introduction"));
        modules.add(new ModuleInfo("Juerga_m02", "Input and Output with Streams and Files"));
        modules.add(new ModuleInfo("Juerga_m03", "String Formatting and Regular Expressions"));
        modules.add(new ModuleInfo("Juerga_m04", "Working with Collections"));
        modules.add(new ModuleInfo("Juerga_m05", "Controlling App Execution and Environment"));
        modules.add(new ModuleInfo("Juerga_m06", "Capturing Application Activity with the Java Log System"));
        modules.add(new ModuleInfo("Juerga_m07", "Multithreading and Concurrency"));
        modules.add(new ModuleInfo("Juerga_m08", "Runtime Type Information and Reflection"));
        modules.add(new ModuleInfo("Juerga_m09", "Adding Type Metadata with Annotations"));
        modules.add(new ModuleInfo("Juerga_m10", "Persisting Objects with Serialization"));

        return new CourseInfo("Juerga", "Juerga", modules);
    }
    //endregion

}
