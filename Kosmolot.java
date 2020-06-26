import java.lang.Math;

/**
 *
 * 
 * @author Jakub Rutkowski
 */

public class Kosmolot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer RocketSize = Integer.parseInt(args[0]);
        String Armor = args[1];
        boolean RocketSizeValid = true;
        boolean RocketArmorValid = true;
        boolean NumberOfArgumentsIsValid = true;
        String row="";
        
        int NumberOfArguments = args.length;
        if (NumberOfArguments != 2)
        {
            NumberOfArgumentsIsValid = false;
        }
        
        //System.out.println("RocketSize = " + RocketSize + " Armor = " + Armor);
        
        if (RocketSize > 75 || RocketSize < 1) RocketSizeValid = false;
        if ("Y" != Armor.intern() && "N" != Armor.intern()) RocketArmorValid = false;
 
        if (RocketSizeValid == true && RocketArmorValid == true && NumberOfArgumentsIsValid == true)
        {
            Integer NumberOfRows = 2*RocketSize-1;
            Integer NumberOfColumns = RocketSize*RocketSize;
            String[][] Tablica;
            Tablica = new String[NumberOfRows][NumberOfColumns];
            Integer RocketPart = 0;
        
            for (int k=0;k<RocketSize;k++)
            {
                for (int i=0; i<RocketSize; i++)
                {
                    for (int j=0; j<RocketSize; j++)
                    {
                        if(i>=j)
                        {
                            Tablica[i][j+RocketPart] = "*";
                            Tablica[NumberOfRows-1-i][j+RocketPart] = "*";
                        }
                    }

                }
                RocketPart=RocketPart+RocketSize;   
            }

            if ("Y" == Armor.intern())
            {           
                for (int i=0; i<NumberOfRows; i++)
                {
                    Tablica[i][0] = ">";
                    for (int j=1; j<NumberOfColumns-1; j++)
                    {
                        if (Tablica[i][j]=="*" && Tablica[i][j+1]==null)
                        {
                            if (i>NumberOfRows/2)
                            {
                                Tablica[i][j]="/";
                            }
                            else
                            {
                                Tablica[i][j]="\\";
                            }
                        }
                    }
                }
                Tablica[RocketSize-1][NumberOfColumns-1]=">";
            }

            //**************Wyswietlanie tablicy***********************
            for(int i=0; i<NumberOfRows; i++)
            {

                row = "";
                for(int j=0; j<NumberOfColumns; j++)
                {
                    if (Tablica[i][j]==null)
                    {
                        row=row+" ";
                    }
                    else
                    {
                    row=row+Tablica[i][j];
                    }

                }
                System.out.println(row);
            }
        }
        else
        {
            System.out.println("klops");
        }
    }
    
}
