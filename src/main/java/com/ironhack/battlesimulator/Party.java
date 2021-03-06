package com.ironhack.battlesimulator;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Party {

    private static HashMap<String, Party> mapOfParties = new HashMap<>();
    private ArrayList<Character> members = new ArrayList<>();
    private String party;

    //lists of names for randomly generated characters
    public final static String[] warriorNames = {"Agro", "Aindrea", "Alaois", "Alvar", "Ardeshir", "Ares", "Arluin", "Armel", "Artaxerxes", "Achilles", "Alcibie", "Alexander", "Blair", "Bellatrix", "Boian", "Bhaltair", "Boris", "Baron", "Bandi", "Bogatyr", "Borislav", "Bushi", "Cahal", "Cuauhtemoc", "Clancy", "Cahir", "Cathal", "Cahira", "Chester", "Chien", "Cronos", "Cochise", "Chlothar", "Ctibor", "Clodoveo", "Clovis", "Donnchadh", "Drew", "Duilius", "Dries", "Dreng", "Dieter", "Didi", "Duncan", "Demostrate", "Dalibor", "Earl", "Ernest", "Einar", "Enre", "Eskiminzin", "Ermanno", "Eferhilda", "Eudeyrn", "Erle", "Eibhear", "Einarr", "Finn", "Flamma", "Fenyang", "Flannchadh", "Finian", "Gába", "Gabirel", "Gabriel", "Gedeon", "Gianluigi", "Gundisalv", "Gunnar", "Galtero", "Geraldo", "Gurgintius", "Gunter", "Geronimo", "Herebeorht", "Herb", "Harvey", "Harlin", "Hariric", "Herman", "Harimanna", "Hida", "Hondo", "Hector", "Humbert", "Indra", "Igor", "Ívar", "Ivor", "Ingvarr", "Jari", "Junayd", "Jalmari", "Jabari", "Jelani", "Kane", "Kilián", "Khshayarsha", "Kerbasi", "Kemp", "Kedehern", "Kathel", "Kijani", "Keon", "Kempe", "Luther", "Louise", "Lovisa", "Loyce", "Lutalo", "Luthais", "Luijzika", "Labhaoise", "Laran", "Maia", "Marcello", "Melankomas", "Marcella", "Martin", "Marcus Cassius", "Maximus", "Matilda", "Marco","Murty", "Mordecai","Murchadh","Marta","Martel","Necalli","Naois","Nassor","Neoptolemus","Nolan","Noland","Noisiu","Odysseus","Osiris", "Oliver", "Ojore", "Ormarr", "Ondrej", "Osborne", "Oli", "Patton", "Perseus", "Prahasta", "Pridbor", "Ptolemy", "Reginhard", "Ragnar", "Ra", "Regner", "Rocky", "Ranjeet", "Raiko", "Razmig", "Rinc", "Samurai", "Serilda", "Sinuhe", "Shogun","Sostratus","Straton", "Teutates", "Timur Lenk", "Takeshi", "Thanatos", "Taisto", "Tero", "Takeo", "Thane", "Thorir", "Valeska", "Valtteri", "Vercingetorix", "Valda", "Victoria", "Victorio", "Volundr", "Víghardur", "Vidar", "Volker", "Waneta", "Wigman", "Werner", "Wido", "Weit", "Wally", "Waldhar", "Walt", "Walthari", "Warner", "Xiahou Dun", "Xena", "Xavier", "Xandinho", "Xandra", "Zandra", "Zelda", "Zuberi"};
    public final static String[] wizardNames = {"The Alchemist", "Ancient One", "Ansalom", "Archimago", "Regulus Black", "Sirius Black", "Dallben", "Death Eater", "Cedric Diggory", "Discworld", "Doctor Strange", "Eggplant Wizard", "Enchanters Three", "Seamus Finnigan", "Gandalf", "Gargamel", "Glew", "Gregorovitch", "Harry Potter", "Septimus Heap", "Simon Heap", "Ice King", "Jafar", "Jinnicky", "Red Jinn", "Kaecilius", "Neville Longbottom", "Remus Lupin", "Draco Malfoy", "Merlin", "Rasputin", "Mad-Eye Moody", "Baron Mordo", "Ningauble of the Seven Eyes", "Ot el bruixot", "Marcia Overstrand", "Harry Potter", "Rincewind", "Alex Russo", "Shazam", "Sheelba of the Eyeless Face", "Star Swirl the Bearded", "Stephen Strange", "Tork", "Fred Weasley", "Willow Ufgood", "Wiz 'n'Liz", "The Wizard and the Witch", "The Wizard in the Woods", "The Wizard in Wonderland", "Wizard of Oz", "Wizard's Hall", "The Wonderful", "Wizard of Oz", "Yen Sid", "Zyll"};

    //method to give a party its name
    public Party(String partyName) {
        this.party = partyName;
        mapOfParties.put(partyName, this);
        System.out.println(this.getPartyName() + " enters the battle!");
    }

    //method to add an existing character to a party
    public void addMember(Character member) {
        members.add(member);
        System.out.println(member.getName() + " joined " + this.getPartyName());
    }

    //method to get the complete ArrayList of Characters belonging to the party object
    public ArrayList<Character> getMembers() {
        return this.members;
    }

    public ArrayList<Character> getAliveMembers(){
        ArrayList<Character> memberAlive = new ArrayList<>();
        for( int i = 0; i < members.size(); i++){
            if(members.get(i).isAlive() == true){
                memberAlive.add(members.get(i));
            }
        }
        return memberAlive;
    }

    public Character getRandomMember() {
        Character selectedRandomMember = null;
        Random random = new Random();
        if (!this.getAliveMembers().isEmpty()) {
            selectedRandomMember = this.getAliveMembers().get(random.nextInt(this.getAliveMembers().size()));
        }
        return selectedRandomMember;
    }

    //method to generate a random number of characters within the given boundaries
    public void createRandomMembers () {
        Random random = new Random();
        int partySize = random.nextInt(5)+3;

        //random.nextInt(max - min) + min;
            for (int i = 1; i <= partySize; i++ ) {
                if (random.nextBoolean()) {
                Warrior war1 = new Warrior(getRandomPhysicalCharacteristics(physicalCharacteristics.HP_WARRIOR_MIN, physicalCharacteristics.HP_WARRIOR_MAX),
                        warriorNames[random.nextInt(24)],true, this,
                        getRandomPhysicalCharacteristics(physicalCharacteristics.STAMINA_MIN,physicalCharacteristics.STAMINA_MAX),
                        getRandomPhysicalCharacteristics(physicalCharacteristics.STRENGTH_MIN, physicalCharacteristics.STRENGTH_MAX));
            } else {
                Wizard wiz1 = new Wizard(getRandomPhysicalCharacteristics(physicalCharacteristics.HP_WIZARD_MIN, physicalCharacteristics.HP_WIZARD_MAX),
                        wizardNames[random.nextInt(24)],  true, this,
                        getRandomPhysicalCharacteristics(physicalCharacteristics.MANA_MIN, physicalCharacteristics.MANA_MAX),
                        getRandomPhysicalCharacteristics(physicalCharacteristics.INTELLIGENCE_MIN, physicalCharacteristics.INTELLIGENCE_MAX));
            }
        }
    }

    //method to get random int within boundaries
    private  int getRandomPhysicalCharacteristics(physicalCharacteristics min, physicalCharacteristics max) {
        Random random = new Random();
        return random.nextInt(max.getValue() - min.getValue()) + min.getValue();
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
    }

    public void exportParty() throws Exception {
        String documentInput = "CHARACTER_TYPE; id; name; hp; isAlive; party; stamina/mana; strength/intelligence\n";

        for (Character selected : this.getMembers()) {
            if (selected.getCHARACTER_TYPE() == "com.ironhack.battlesimulator.Warrior") {
                Warrior selectedWarrior = (Warrior) selected;
                documentInput += "Warrior" + ";" + selectedWarrior.getId() + ";" + selectedWarrior.getName() + ";" + selectedWarrior.getHp() + ";" + selectedWarrior.isAlive() + ";" + selectedWarrior.getParty().getPartyName() + ";" + selectedWarrior.getStamina() + ";" + selectedWarrior.getStrength() + "\n";
            } else {
                Wizard selectedWizard = (Wizard) selected;
                documentInput += "Wizard" + ";" + selectedWizard.getId() + ";" + selectedWizard.getName() + ";" + selectedWizard.getHp() + ";" + selectedWizard.isAlive() + ";" + selectedWizard.getParty().getPartyName() + ";" + selectedWizard.getMana() + ";" + selectedWizard.getIntelligence() + "\n";
            }
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.getPartyName() + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.write(documentInput);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fileWriter.close();
            }
        }
        System.out.println(this.getPartyName() + " has been exported to " + this.getPartyName() + ".csv");
    }


    public static void importParty(String fileStorageLocation) throws IOException {
        Path path = null;

        String id;
        int hp;
        String name;
        Boolean isAlive;
        Party party = null;
        String partyName;
        Integer stamina;
        Integer strength;
        Integer mana;
        Integer intelligence;

        Scanner scanner = new Scanner(Path.of(fileStorageLocation));
        StringBuilder result = new StringBuilder();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] columns = line.split(";");
            if (party == null) {
                partyName = columns[5];
                party = new Party(partyName);
            }
            id = columns[1];
            hp = Integer.parseInt(columns[3]);
            name = columns[2];
            isAlive = Boolean.parseBoolean(columns[4]);
            if (columns[0] == "Warrior") {
                stamina = Integer.parseInt(columns[6]);
                strength = Integer.parseInt(columns[7]);
                Warrior importedWarrior = new Warrior(hp,name,isAlive,party,stamina,strength);
            } else {
                mana = Integer.parseInt(columns[6]);
                intelligence = Integer.parseInt(columns[7]);
                Warrior importedWarrior = new Warrior(hp,name,isAlive,party,mana,intelligence);
            }
        }
        mapOfParties.get(party);
        System.out.println(party.getPartyName() + " with all its warriors and wizards has entered the battleground form file.");
    }

    //method to return the name of a party
    public String getPartyName() {
        return party;
    }

    public static HashMap<String, Party> getMapOfParties() {
        return mapOfParties;
    }

    public static void showExistingParties(){
        System.out.println("On the battlefield are ...");
        for (Map.Entry<String, Party> entry : Party.getMapOfParties().entrySet()) {
            System.out.println("... " + entry.getValue().getPartyName());
        }
    }

    public static boolean existsParty(String enteredName) {
        for (Map.Entry<String, Party> entry: Party.getMapOfParties().entrySet()) {
            if (entry.getValue().getPartyName().equals(enteredName)) {
                return true;
            }
        }
        return false;
    }
}