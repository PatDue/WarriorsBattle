package com.ironhack.battlesimulator;

import java.util.ArrayList;
import java.util.Random;

public class Party {

    private ArrayList<Character> members = new ArrayList<>();
    private String partyName;

    //lists of names for randomly generated characters
    public final static String[] warriorNames = {"Agro", "Aindrea", "Alaois", "Alvar", "Ardeshir", "Ares", "Arluin", "Armel", "Artaxerxes", "Achilles", "Alcibie", "Alexander", "Blair", "Bellatrix", "Boian", "Bhaltair", "Boris", "Baron", "Bandi", "Bogatyr", "Borislav", "Bushi", "Cahal", "Cuauhtemoc", "Clancy", "Cahir", "Cathal", "Cahira", "Chester", "Chien", "Cronos", "Cochise", "Chlothar", "Ctibor", "Clodoveo", "Clovis", "Donnchadh", "Drew", "Duilius", "Dries", "Dreng", "Dieter", "Didi", "Duncan", "Demostrate", "Dalibor", "Earl", "Ernest", "Einar", "Enre", "Eskiminzin", "Ermanno", "Eferhilda", "Eudeyrn", "Erle", "Eibhear", "Einarr", "Finn", "Flamma", "Fenyang", "Flannchadh", "Finian", "Gába", "Gabirel", "Gabriel", "Gedeon", "Gianluigi", "Gundisalv", "Gunnar", "Galtero", "Geraldo", "Gurgintius", "Gunter", "Geronimo", "Herebeorht", "Herb", "Harvey", "Harlin", "Hariric", "Herman", "Harimanna", "Hida", "Hondo", "Hector", "Humbert", "Indra", "Igor", "Ívar", "Ivor", "Ingvarr", "Jari", "Junayd", "Jalmari", "Jabari", "Jelani", "Kane", "Kilián", "Khshayarsha", "Kerbasi", "Kemp", "Kedehern", "Kathel", "Kijani", "Keon", "Kempe", "Luther", "Louise", "Lovisa", "Loyce", "Lutalo", "Luthais", "Luijzika", "Labhaoise"};
    public final static String[] wizardNames = {"The Alchemist", "Ancient One", "Ansalom", "Archimago", "Regulus Black", "Sirius Black", "Dallben", "Death Eater", "Cedric Diggory", "Discworld", "Doctor Strange", "Eggplant Wizard", "Enchanters Three", "Seamus Finnigan", "Gandalf", "Gargamel", "Glew", "Gregorovitch", "Harry Potter", "Septimus Heap", "Simon Heap", "Ice King", "Jafar", "Jinnicky", "Red Jinn", "Kaecilius", "Neville Longbottom", "Remus Lupin", "Draco Malfoy", "Merlin", "Rasputin", "Mad-Eye Moody", "Baron Mordo", "Ningauble of the Seven Eyes", "Ot el bruixot", "Marcia Overstrand", "Harry Potter", "Rincewind", "Alex Russo", "Shazam", "Sheelba of the Eyeless Face", "Star Swirl the Bearded", "Stephen Strange", "Tork", "Fred Weasley", "Willow Ufgood", "Wiz 'n'Liz", "The Wizard and the Witch", "The Wizard in the Woods", "The Wizard in Wonderland", "Wizard of Oz", "Wizard's Hall", "The Wonderful", "Wizard of Oz", "Yen Sid", "Zyll"};

    //method to give a party its name
    public Party(String partyName) {
        this.partyName = partyName;
    }

    //method to add an existing character to a party
    public void addMember(Character member) {
        members.add(member);
    }

    //method to generate a random number of characters within the given boundaries
    public static void createRandom (Party party) {
        Random random = new Random();
        int partySize = random.nextInt(5)+3;

        for (int i = 1; i <= partySize; i++ ) {
            if (random.nextBoolean()) {
                Warrior war1 = new Warrior(5, warriorNames[random.nextInt(24)], random.nextInt(100)+101, true, party, random.nextInt(40)+11, random.nextInt(11)-1);
                party.addMember(war1);
            } else {
                Wizard wiz1 = new Wizard(6, wizardNames[random.nextInt(24)], random.nextInt(100) + 101, true, party, random.nextInt(40) + 11, random.nextInt(51) - 1);
                party.addMember(wiz1);
            }
        }
    }

    //method to show the living or dead characters/members of a party
    public void showMembers(boolean isAlive) {
        if (isAlive) {
            System.out.println("The " + this.getPartyName() + " consists of following members:");
        } else {
            System.out.println("The following members of " + this.getPartyName() + " are on the graveyard:");
        }
        for (Character selected : this.members) {
            if (isAlive) {
                if (selected.isAlive() == true) {
                    System.out.println("Name: " + selected.getName() + ", Health Points: " + selected.getHp());
                }
            } else {
                if (selected.isAlive() == false) {
                    System.err.println("Name: " + selected.getName() + ", Health Points: " + selected.getHp());
                }
            }
        }
        System.out.println();
    }

    //method to return the name of a party
    public String getPartyName() {
        return partyName;
    }

}