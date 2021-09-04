package com.dreamfox.testing;

import com.dreamfox.model.Dream;
import com.dreamfox.model.DreamManager;
import com.dreamfox.model.Tag;
import com.dreamfox.model.TagManager;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //tagTesting1();
        //tagTesting2();
        //addDreams();
    }

    /*
    * Test #1 - Undefined Tags
    * Creates a new dream, passing a null value for the HashSet.
    * Since the HashSet is empty, an undefined tag is added by default
    * */
    public static void tagTesting1() {
        Dream dream1 = new Dream("Dream #1", "some content", null);
        System.out.println(dream1);
    }

    /*
     * Test #2 - Adding Tags
     * Creates a new dream with a null value for the HashSet
     * New tags are added each time to prove that Undefined is gone after the first Tag
     *
     * */
    public static void tagTesting2() {
        Dream dream1 = new Dream("Dream #1", "some content", null);
        System.out.println("Dream with a null HashSet<Tag>:\n" + dream1 + "\n");


        dream1.addTag(new Tag("FILD"));
        System.out.println("After adding FILD:\n" + dream1 + "\n");

        dream1.addTag(new Tag("WILD"));
        System.out.println("After adding WILD:\n" + dream1 + "\n");

        dream1.addTag(new Tag("WBTB"));
        System.out.println("After adding WBTB:\n" + dream1 + "\n");
    }

    /*
     * Test #3 - Adding multiple Dreams to the DreamManager
     * Adds a few dreams to the dream manager, passing different HashSets.
     * The symbol [!] appears, meaning that dreams are unbalanced since they do not have specified a lucid or normal
     * tag yet.
     *
     * Later on, these tags are added to solve the issue.
     *
     * Note: Execution is slept each time a new dream is created since dreams are compared by date
     * and some *fucking* how the second and the third dream are created at the same date and time in milliseconds!!
     * So yeah, twenty minutes of my life wasted, thank god you are reading this and you understand why the
     * Thread.sleep()
     *
     * TL;DR - A human cannot create two dreams in the same millisecond, this bug is runtime only :)
     * */
    public static void addDreams() {
        DreamManager dm = new DreamManager();

        Dream dream1 = new Dream("Dream #1", "some content", null);
        System.out.println(dream1.getCreationDate());
        try {Thread.sleep(500); } catch (Exception e) {}

        Dream dream2 = new Dream("Dream #2", "some random content", new HashSet<>());
        System.out.println(dream2.getCreationDate());
        try {Thread.sleep(500); } catch (Exception e) {}

        HashSet<Tag> tags = new HashSet<Tag>();
        tags.add(new Tag("WILD"));

        Dream dream3 = new Dream("Dream #3", "more shit", tags);
        System.out.println(dream3.getCreationDate());
        try {Thread.sleep(500); } catch (Exception e) {}

        dm.addDream(dream3);
        dm.addDream(dream1);
        dm.addDream(dream2);

        System.out.println(dm + "\n");

        dream1.addTag(TagManager.lucid());
        dream2.addTag(TagManager.normal());
        dream3.addTag(TagManager.lucid());

        System.out.println(dm + "\n");
    }

}
