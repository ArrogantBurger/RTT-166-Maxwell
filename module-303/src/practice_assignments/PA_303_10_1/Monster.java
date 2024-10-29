package practice_assignments.PA_303_10_1;

class FireMonster extends Monster {
    FireMonster(String name) {
        super(name);
    }

    String attack() {
        return "Attack with fire!";
    }
}

class WaterMonster extends Monster {
    WaterMonster(String name) {
        super(name);
    }

    String attack() {
        return "Attack with water!";
    }
}

class StoneMonster extends Monster {
    StoneMonster(String name) {
        super(name);
    }

    String attack() {
        return "Attack with stones!";
    }
}

public class Monster {
    String name;

    Monster(String name) {
        this.name = name;
    }

    String attack() {
        return "Huh? What type of monster am I...";
    }

}
