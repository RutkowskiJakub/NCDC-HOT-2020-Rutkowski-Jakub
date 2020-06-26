/**
 * @author Jakub Rutkowski
 * 
 * TO DO:
 */
public class Galaktyka {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        
        Integer NumberOfArguments = args.length;
        boolean IsSizeValid = false;
        boolean IsDirectionValid = false;
        
        if (NumberOfArguments == 1)
        {
            char tmp = args[0].charAt(args[0].length()-1);
            String StartingDirection = String.valueOf(tmp);
            String CurrentDirection = StartingDirection;
            Integer GalacticSize = Integer.parseInt(args[0].substring(0, args[0].length() - 1));
            
            if (GalacticSize >= 1 && GalacticSize <= 10000) IsSizeValid = true;
            if ("W" == StartingDirection.intern() || "E" == StartingDirection.intern() || "N" == StartingDirection.intern() || "S" == StartingDirection.intern()) IsDirectionValid = true;
            
            if (IsDirectionValid == true && IsSizeValid == true)
            {
                Integer HorizontalDirection = 0;
                Integer VerticalDirection = 0;
                String row="";
                
                Integer SpiralLength = 3;

                Integer NumberOfRows=1;
                Integer NumberOfColumns=1;
                Integer HorizontalPointer=0;
                Integer VerticalPointer=0;

                if ("W" == StartingDirection.intern() || "E" == StartingDirection.intern())
                {
                    NumberOfRows = GalacticSize + 3;
                    NumberOfColumns = GalacticSize + 2;
                }
                else if ("N" == StartingDirection.intern() || "S" == StartingDirection.intern())
                {
                    NumberOfRows = GalacticSize + 2;
                    NumberOfColumns = GalacticSize + 3;
                }
                switch(StartingDirection)
                {
                    case "W": 
                        HorizontalDirection = 1;
                        HorizontalPointer = 0;
                        VerticalPointer = 1;
                        break;
                    case "E":
                        HorizontalDirection = -1;
                        HorizontalPointer = NumberOfColumns - 1;
                        VerticalPointer = NumberOfRows - 2;
                        break;
                    case "N":
                        VerticalDirection = 1;
                        HorizontalPointer = NumberOfColumns - 2;
                        VerticalPointer = 0;
                        break;
                    case "S":
                        VerticalDirection = -1;
                        HorizontalPointer = 1;
                        VerticalPointer = NumberOfRows - 1;
                        break;
                }

                char[][] Tablica;
                Tablica = new char[NumberOfRows][NumberOfColumns];
                //row.ensureCapacity(NumberOfColumns);

                for (int i=0; i<GalacticSize-1; i++)
                {
                    SpiralLength = SpiralLength + i + 3;
                }

                int NumberOfDirectionChanges = 0;
                int LengthToDirectionChange = GalacticSize + 1;
                for (int i=0; i<SpiralLength ; i++)
                {
                    LengthToDirectionChange--;
                    if (LengthToDirectionChange == 0)
                    {
                        NumberOfDirectionChanges++;
                        LengthToDirectionChange = GalacticSize + 1 - NumberOfDirectionChanges;
                        switch(CurrentDirection)
                        {
                            case "W": 
                                HorizontalDirection = 0;
                                VerticalDirection = 1;
                                CurrentDirection = "N";
                                break;
                            case "E":
                                HorizontalDirection = 0;
                                VerticalDirection = -1;
                                CurrentDirection = "S";
                                break;
                            case "N":
                                VerticalDirection = 0;
                                HorizontalDirection = -1;
                                CurrentDirection = "E";
                                break;
                            case "S":
                                VerticalDirection = 0;
                                HorizontalDirection = 1;
                                CurrentDirection = "W";
                                break;
                        }  
                    }
                    Tablica[VerticalPointer][HorizontalPointer] = 'n';
                    VerticalPointer=VerticalPointer+VerticalDirection;
                    HorizontalPointer=HorizontalPointer+HorizontalDirection;
                }
                StringBuilder sb = new StringBuilder(NumberOfColumns);
                sb.ensureCapacity(NumberOfColumns);
                //***************WYSWIETLANIE TABLICY************
                for (int i=0; i<NumberOfRows; i++)
                {
                    sb.setLength(0);
                    for (int j=0; j<NumberOfColumns; j++)
                    {
                        if (Tablica[i][j]!='n')
                        {
                            //row=row+'*';
                            sb.append('*');
                        }
                        else
                        {
                            //ow=row+' ';
                            sb.append(' ');
                        }
                    }
                    System.out.println(sb);
                    //row = sb.toString();
                    //System.out.println(row);
                    //row = null;
                    
                }
                System.out.println(SpiralLength);

            }
            else
            {
                System.out.println("klops");
            }
        }
        else
        {
            System.out.println("klops");
        }
    }  
}
