package jbbellot.ysu.KmapApp;

import java.util.ArrayList;


@SuppressWarnings("ALL")
public class CellArray {
    private final Cell[][] cellArray = new Cell[4][4];
    private final ArrayList<Cell> squares = new ArrayList<>();
    private final ArrayList<Cell> quads = new ArrayList<>();
    private final ArrayList<Cell> doubles = new ArrayList<>();
    private final ArrayList<Cell> singles = new ArrayList<>();



    private Boolean squareFound;

    private String simplifiedExpression = null;


    public void InitializeCells() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {

                cellArray[x][y] = new Cell();

                if (x == 0 || x == 1) {
                    cellArray[x][y].setInputA("A!");
                } else if (x == 2 || x == 3)
                    cellArray[x][y].setInputA("A");

                if (x == 0 || x == 3)
                    cellArray[x][y].setInputB("B!");

                else if (x == 1 || x == 2)
                    cellArray[x][y].setInputB("B");

                if (y == 0 || y == 1) {
                    cellArray[x][y].setInputC("C!");
                } else if (y == 2 || y == 3)
                    cellArray[x][y].setInputC("C");
                if (y == 0 || y == 3)
                    cellArray[x][y].setInputD("D!");

                else if (y == 1 || y == 2)
                    cellArray[x][y].setInputD("D");

            }
        }
    }

    public void changeValue(boolean value, int x, int y) {
        int oneOrZero = 0;
        if (value = true)
            oneOrZero = 1;
        else
            oneOrZero = 0;
        cellArray[x][y].setCellValue(oneOrZero);

    }


    public void findSquares() {
        ArrayList<Cell> squares = new ArrayList<Cell>();

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {

                //reset conditions after each loop
                squares.clear();
                boolean diagonalTrue = false;

                //check initial cell
                if (cellArray[x][y].getCellValue() == 1) {
                    squares.add(cellArray[x][y]);
                }
                //if a one is not found, it is not a square, break;
                else
                    continue;
                //___________________________________________________________
                //check right neighbour
                if (x == 3){
                    if (cellArray[0][y].getCellValue() == 1 ) {                                     //if cell is at right most position check left most position
                        squares.add(cellArray[0][y]);
                    }
                    else continue;                                                                  // if a cell is cell's value != 1, increment the loop
                }else if (cellArray[x + 1][y].getCellValue() == 1) {
                    squares.add(cellArray[x + 1][y]);
                }
                //if a one is not found, it is not a square, break;
                else
                    continue;

                //___________________________________________________________
                //check bottom neighbour
                if (y == 3){
                    if(cellArray[x][0].getCellValue() == 1) {                                      //if cell is at bottom most position check top most position
                        squares.add(cellArray[x][0]);
                    }
                    else continue;
                } else if (cellArray[x][y + 1].getCellValue() == 1) {
                    squares.add(cellArray[x][y + 1]);
                } else
                    continue;

                //___________________________________________________________
                //check diagonal
                if (x == 3 && y < 3) {
                    if (cellArray[0][y + 1].getCellValue() == 1) {
                        squares.add(cellArray[0][y + 1]);
                        diagonalTrue = true;
                    }
                } else if (x < 3 && y == 3) {
                    if (cellArray[x + 1][0].getCellValue() == 1) {
                        squares.add(cellArray[x + 1][0]);
                        diagonalTrue = true;

                    }
                } else if (x == 3 && y == 3) {
                    if (cellArray[0][0].getCellValue() == 1) {
                        squares.add(cellArray[0][0]);
                        diagonalTrue = true;

                    }
                } else if (x < 3 && y < 3) {
                    if (cellArray[x + 1][y + 1].getCellValue() == 1) {
                        squares.add(cellArray[x + 1][y + 1]);
                        diagonalTrue = true;
                    }
                } else continue;

                //Add all cells which are part of a square to the Class square array list
                if ( diagonalTrue && !squares.get(0).getInUse() && !squares.get(1).getInUse() && !squares.get(2).getInUse() && !squares.get(3).getInUse() ) {
                    for (int i = 0; i < squares.size(); i++) {
                        squares.get(i).setInUse(true);
                        this.squares.add(squares.get(i));
                    }

                }
            }
        }
    }


    public void findQuads() {

        //Horizontal Fours
        for (int y = 0; y < 4; y++) {
            if (!cellArray[0][y].getInUse() || !cellArray[1][y].getInUse() || !cellArray[2][y].getInUse() || !cellArray[3][y].getInUse()){
                if (cellArray[0][y].getCellValue() == 1 && cellArray[1][y].getCellValue() == 1 && cellArray[2][y].getCellValue() == 1 && cellArray[3][y].getCellValue() == 1){

                    cellArray[0][y].setInUse(true);
                    cellArray[1][y].setInUse(true);
                    cellArray[2][y].setInUse(true);
                    cellArray[3][y].setInUse(true);

                    this.quads.add(cellArray[0][y]);
                    this.quads.add(cellArray[1][y]);
                    this.quads.add(cellArray[2][y]);
                    this.quads.add(cellArray[3][y]);

                } } }

        //Vertical Fours
        for (int x = 0; x < 4; x++) {
            if (!cellArray[x][0].getInUse() || !cellArray[x][1].getInUse() || !cellArray[x][2].getInUse() || !cellArray[x][3].getInUse()){
                if (cellArray[x][0].getCellValue() == 1 && cellArray[x][1].getCellValue() == 1 && cellArray[x][2].getCellValue() == 1 && cellArray[x][3].getCellValue() == 1){

                   cellArray[x][0].setInUse(true);
                   cellArray[x][1].setInUse(true);
                   cellArray[x][2].setInUse(true);
                   cellArray[x][3].setInUse(true);

                   this.quads.add(cellArray[x][0]);
                   this.quads.add(cellArray[x][1]);
                   this.quads.add(cellArray[x][2]);
                   this.quads.add(cellArray[x][3]);

                } } }
    }

    public void findDoubles(){
        //horizontal doubles
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 3; x++) {
                if (cellArray[x][y].getCellValue() == 1 && cellArray[x+1][y].getCellValue() == 1) {
                    if (!cellArray[x][y].getInUse() || !cellArray[x+1][y].getInUse()){
                        cellArray[x][y].setInUse(true);
                        cellArray[x+1][y].setInUse(true);

                        doubles.add(cellArray[x][y]);
                        doubles.add(cellArray[x+1][y]);
                    } } }
            if (cellArray[3][y].getCellValue() == 1 && cellArray[0][y].getCellValue() == 1 ) {
                if (!cellArray[3][y].getInUse() || !cellArray[0][y].getInUse()) {
                    cellArray[3][y].setInUse(true);
                    cellArray[0][y].setInUse(true);

                    doubles.add(cellArray[3][y]);
                    doubles.add(cellArray[0][y]);
                } } }
        //vertical doubles
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 3; y++) {
                if (cellArray[x][y].getCellValue() == 1 && cellArray[x][y+1].getCellValue() == 1) {
                    if (!cellArray[x][y].getInUse() || !cellArray[x][y+1].getInUse()){
                        cellArray[x][y].setInUse(true);
                        cellArray[x][y+1].setInUse(true);

                        doubles.add(cellArray[x][y]);
                        doubles.add(cellArray[x][y+1]); }
                } }
            if (cellArray[x][3].getCellValue() == 1 && cellArray[x][0].getCellValue() == 1 ) {
                if (!cellArray[x][3].getInUse() || !cellArray[x][0].getInUse()) {
                    cellArray[x][3].setInUse(true);
                    cellArray[x][0].setInUse(true);

                    doubles.add(cellArray[x][3]);
                    doubles.add(cellArray[x][0]);
                } }
        }

    }

    public void findSingles(){          //only functions correctly if all other find functions have already been used.
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (cellArray[x][y].getCellValue() ==1 && !cellArray[x][y].getInUse()) {
                    cellArray[x][y].setInUse(true);
                    singles.add(cellArray[x][y]);
                }
            }
        }
    }





    public void simplifyExpression(GroupType groupType) {

        //If the arraylist being passed has no items then the method does not continue
        if (groupType == GroupType.Square) {
            if (squares.size() < 1) return;
        }
        else if (groupType == GroupType.Quad) {
            if (quads.size() < 1) return;
        }
        else if (groupType == GroupType.Double) {
            if (doubles.size() < 1) return;
        }
        else if (groupType == GroupType.Single) {
            if (singles.size() < 1) return;
        }


        //determine whether a "+" symbol needs to be added to connect separate logical expressions.
        if (simplifiedExpression != null)
            simplifiedExpression += " + ";

        //check inputs, if all values are the same add to string, if different values do not add to string
        //for square expressions only three cells need to be checked as they come in pairs

        if (groupType == GroupType.Square) {
            for (int i = 0; i < squares.size(); i += 4) {
                if (squares.get(i).getInputA().equals(squares.get(i + 1).getInputA()) && squares.get(i).getInputA().equals(squares.get(i + 2).getInputA())) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = squares.get(i).getInputA();
                    else
                        simplifiedExpression += squares.get(i).getInputA();
                }
                if (squares.get(i).getInputB().equals(squares.get(i + 1).getInputB()) && squares.get(i).getInputB().equals(squares.get(i + 2).getInputB())) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = squares.get(i).getInputB();
                    else
                        simplifiedExpression += squares.get(i).getInputB();
                }
                if (squares.get(i).getInputC().equals(squares.get(i + 1).getInputC()) && squares.get(i).getInputC().equals(squares.get(i + 2).getInputC())) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = squares.get(i).getInputC();
                    else
                        simplifiedExpression += squares.get(i).getInputC();
                }
                if (squares.get(i).getInputD().equals(squares.get(i + 1).getInputD()) && squares.get(i).getInputD().equals(squares.get(i + 2).getInputD())) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = squares.get(i).getInputD();
                    else
                        simplifiedExpression += squares.get(i).getInputD();
                }

                //append a plus sign if there are more squares to simplify
                if (i != squares.size() - 4)
                    simplifiedExpression += " + ";
            }
        }
        if (groupType == GroupType.Quad) {
            for (int i = 0; i < quads.size(); i += 4) {
                if (quads.get(i).getInputA().equals(quads.get(i + 1).getInputA()) && quads.get(i).getInputA().equals(quads.get(i + 2).getInputA())) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = quads.get(i).getInputA();
                    else
                        simplifiedExpression += quads.get(i).getInputA();
                }
                if (quads.get(i).getInputB().equals(quads.get(i + 1).getInputB()) && quads.get(i).getInputB().equals(quads.get(i + 2).getInputB())) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = quads.get(i).getInputB();
                    else
                        simplifiedExpression += quads.get(i).getInputB();
                }
                if (quads.get(i).getInputC().equals(quads.get(i + 1).getInputC()) && quads.get(i).getInputC().equals(quads.get(i + 2).getInputC())) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = quads.get(i).getInputC();
                    else
                        simplifiedExpression += quads.get(i).getInputC();
                }
                if (quads.get(i).getInputD().equals(quads.get(i + 1).getInputD()) && quads.get(i).getInputD().equals(quads.get(i + 2).getInputD())) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = quads.get(i).getInputD();
                    else
                        simplifiedExpression += quads.get(i).getInputD();
                }
                //append a plus sign if there are more quads to simplify
                if (i != quads.size() - 4)
                    simplifiedExpression += " + ";
            }
        }
        if (groupType == GroupType.Double) {
            for (int i = 0; i < doubles.size(); i += 2) {
                if (doubles.get(i).getInputA() == doubles.get(i + 1).getInputA()) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = doubles.get(i).getInputA();
                    else
                        simplifiedExpression += doubles.get(i).getInputA();
                }
                if (doubles.get(i).getInputB() == doubles.get(i + 1).getInputB()) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = doubles.get(i).getInputB();
                    else
                        simplifiedExpression += doubles.get(i).getInputB();
                }
                if (doubles.get(i).getInputC() == doubles.get(i + 1).getInputC()) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = doubles.get(i).getInputC();
                    else
                        simplifiedExpression += doubles.get(i).getInputC();
                }
                if (doubles.get(i).getInputD() == doubles.get(i + 1).getInputD()) {
                    if (simplifiedExpression == null)
                        simplifiedExpression = doubles.get(i).getInputD();
                    else
                        simplifiedExpression += doubles.get(i).getInputD();
                }
                //append a plus sign if there are more squares to simplify
                if (i != doubles.size() - 2)
                    simplifiedExpression += " + ";
            }
        }
        if(groupType == GroupType.Single){
            for (int i = 0; i <singles.size(); i++){
                if (simplifiedExpression == null)
                    simplifiedExpression = singles.get(i).logicalExpression();
                else
                    simplifiedExpression += singles.get(i).logicalExpression();

                if (i != singles.size() - 1)
                    simplifiedExpression += " + ";
            }

        }
    }

    public void printCellArray() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                System.out.print(cellArray[x][y].getCellValue());
                System.out.print("    ");
            }
            System.out.println("\n");
        }
    }

    public String returnExpression(){
        //if (simplifiedExpression == null) {
       //     simplifiedExpression = "Please select cells";
       // }
        return simplifiedExpression;
    }

   public void reset() {
        squares.clear();
        quads.clear();
        doubles.clear();
        singles.clear();

        simplifiedExpression = null;

       for (int y = 0; y < 4; y++) {
           for (int x = 0; x < 4; x++) {
               cellArray[x][y].setCellValue(0);
                cellArray[x][y].setInUse(false);
           }
       }
   }



}

