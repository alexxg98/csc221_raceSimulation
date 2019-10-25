# Race Simulation
This is a Java project for my CSC 22100 class (Software Design Laboratory). 

### What the project entails:
Write a program which simulates a race between two contenders. The race will continue until there is a winner (or a tie). The race track consists of 100 squares and the first racer to reach or pass the final square (i.e. 100) wins the race. Use the Java secure random number generator class to simulate the movements of the two racers.
- Begin the race by printing a proper message (e.g. On Your Mark, Get Set, Go).
- Start each racer at position 1 (the "starting gate"). If the racer slips before square 1, move it back to square 1 (i.e. no negative positions).
- If both racers land on the same square during the race, print the word IT's A TIE. 
- When there is a winner, stop the race and indicate the winner.
- With each tick of the clock, your program should adjust the position of the racers according to the rules and use the printf method to print the positions of each racer at the end of each iteration. 

## Running the Project
Clone the repository:

```bash
$ git clone https://github.com/alexxg98/csc221_raceSimulation.git
```

cd into the respository:
```bash
$ cd csc221_raceSimulation
```

run the program by:
```bash
$ javac csc221_raceSimulation.java
$ java csc221_raceSimulation
```
