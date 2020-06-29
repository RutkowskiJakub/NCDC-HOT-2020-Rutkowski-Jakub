

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jakub Rutkowski
 */
public class Drwal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Integer NumberOfArguments = args.length;
        Integer xStart=0;
        Integer yStart=0;
        Integer Szerokosc=0;
        Integer Wysokosc=0;
        char Kolor='*';
        char[][] Tablica;
        
        
        if (NumberOfArguments != 5)
        {
            System.out.println("klops");
            System.exit(0);
        }

        try{
            xStart = Integer.parseInt(args[0]);
            yStart = Integer.parseInt(args[1]);
            Kolor = args[2].charAt(0);
            Szerokosc = Integer.parseInt(args[3]);
            Wysokosc = Integer.parseInt(args[4]);
        }
        catch (NumberFormatException exception)
        {
            System.out.println("klops");
            System.exit(0);
        }
        if (Szerokosc > 50 || Wysokosc > 50 || xStart > Szerokosc || yStart > Wysokosc)
        {
            System.out.println("klops");
            System.exit(0);
        }
        
        Tablica = new char[Wysokosc][Szerokosc];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer NumberOfRowsInFile = 0;
        Integer NumberOfCharactersInRow = 0;
        String Row;
        /////WPISANIE PLIKU WEJSCIOWEGO DO TABLICY///
        try{
            while ((Row = br.readLine()) != null)
            {
                NumberOfRowsInFile++;
                NumberOfCharactersInRow = Row.length();
                if (NumberOfCharactersInRow > Szerokosc || NumberOfRowsInFile > Wysokosc)
                {
                    System.out.println("klops");
                    System.exit(0);
                }
                for (int i=0; i<Szerokosc; i++)
                {
                    if (i == Row.length()) break;
                    Tablica[NumberOfRowsInFile-1][i] = Row.charAt(i);
                }  
            }
        }
        catch (Exception exception)
        {
            System.out.println("klops");
            System.exit(0);
        }

        /////////////////
        
        koloruj(yStart, xStart, Kolor, Szerokosc, Wysokosc, Tablica);
        
        
        //////////////////WYSWIETLANIE OBRAZKA///////
        String row;
        boolean IsRowBlank = true;
        for(int i=0; i<Wysokosc; i++)
        {
            row = "";
            IsRowBlank = true;
            for(int j=0; j<Szerokosc; j++)
            {
                row=row+Tablica[i][j];
            }
            
            for(int k=0; k<Szerokosc; k++)
            {
                if (Tablica[i][k] != ' ')
                {
                    //System.out.println("TABLICA["+i+"]["+k+"] = " + Tablica[i][k]);
                    IsRowBlank = false;
                }
            }
            if (IsRowBlank==false)
            {
                System.out.println(row);
            }

        }
        
        
    }
    
    private static void koloruj(int xStart, int yStart, char Kolor, int Szerokosc, int Wysokosc, char[][]Tablica)
    {
        if (Tablica[xStart-1][yStart-1] == ' ' && Tablica[xStart-1][yStart-1] != Kolor)
        {
            Tablica[xStart-1][yStart-1] = Kolor;
            
            if (xStart-2 >= 0) 
                if (Tablica[xStart-2][yStart-1] == ' ' && Tablica[xStart-2][yStart-1] != Kolor) koloruj(xStart-1, yStart, Kolor, Szerokosc, Wysokosc, Tablica);
            
            
            if (xStart < Szerokosc) 
                if (Tablica[xStart][yStart-1] == ' ' && Tablica[xStart][yStart-1] != Kolor) koloruj(xStart+1, yStart, Kolor, Szerokosc, Wysokosc, Tablica);
            
            
            if (yStart-2 >= 0) 
                if (Tablica[xStart-1][yStart-2] == ' ' && Tablica[xStart-1][yStart-2] != Kolor) koloruj(xStart, yStart-1, Kolor, Szerokosc, Wysokosc, Tablica);
            
            
            if (yStart < Wysokosc) 
                if (Tablica[xStart-1][yStart] == ' ' && Tablica[xStart-1][yStart] != Kolor) koloruj(xStart, yStart+1, Kolor, Szerokosc, Wysokosc, Tablica);
        }
    }
    
}
