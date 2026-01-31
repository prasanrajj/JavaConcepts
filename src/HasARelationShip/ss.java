package HasARelationShip;

class Engine {
    void start() {
        System.out.println("Engine started");
    }
}
//ASSOCIATION (HAS-A, no ownership)
class Driver {
    void drive(Car car) {   // Car comes from outside
        System.out.println("Driving car");
    }
}

class Car {
}

//AGGREGATION (HAS-A, weak ownership)
class Team {
    private Player player;   // HAS-A

    Team(Player player) {    // injected from outside
        this.player = player;
    }
}

class Player {
}

//COMPOSITION (HAS-A, strong ownership)
class House {
    private Room room;

    House() {
        this.room = new Room();   // CREATED inside
    }
}

class Room {
}

//TIGHT COUPLING
class Carr {
    private Engine engine = new Engine(); // hard-coded

    void start() {
        engine.start();
    }
}

