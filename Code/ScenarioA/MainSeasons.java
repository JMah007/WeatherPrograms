
import java.util.*;


public class MainSeasons 
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        int inputMeth;

        String country, month, season;

        int numLines = 0;
        String[][] countryData;
		String inputFileName = "seasonsData.csv";

        
        inputMeth = getInputMeth(input);

        while(inputMeth != 3) //Keep displaying menu until quit is chosen
        {
            if(inputMeth == 2) //User chooses to input data via keyboard
            {
            country = getCountry(input);
            month = getMonth(input);
            season = Seasons.findSeason(country, month);
            System.out.println("\n\nSeason in " + country + " during " + month + " is " + season);
            }
            else //User chooses to input data via a file
            {
                numLines = Seasons.countLines(inputFileName);
                countryData = new String[numLines][2];
            
                Seasons.storeFileData(countryData, inputFileName);
                for(int i=0; i<numLines; i++)
                {
                    season = Seasons.findSeason(countryData[i][0], countryData[i][1]);
                    System.out.println("\n\nSeason in " + countryData[i][0] + " during " + countryData[i][1] + " is " + season);
                }
            }
        inputMeth = getInputMeth(input);
        }
        System.out.println("You quite");
        input.close();
    }



    //NAME: getInputMeth
	//PURPOSE: asks and determines if user wants to import data via file or keyboard input 
             //and validates the choice made
	//IMPORTS: pInput (Scanner)
	//EXPORTS: choice (int)
	//ASSERTIONS:
		//PRE: pInput must be a valid value
		//POST: either 1 is File is selected or 2 if Keyboard is selected
	//REMARKS: handles IllegalArgumentException or InputMismatchException and displays appropriate message
    public static int getInputMeth(Scanner pInput)
    {
        int choice = 0;
        boolean invalid = true;
        

        System.out.println("\nHow do you want to load your data in? Choose one of the options below: ");
        System.out.println("\n1. File" +
                            "\n2. Keyboard" +
                            "\n3. Quit the program" + 
                            "\n\n");
        while(invalid)
        {
            try{
            choice = pInput.nextInt();
            Seasons.valInputMeth(choice);
            invalid = false;
            }
            catch(IllegalArgumentException iae){
                System.out.println("\nError! Choose either 1 or 2: ");
                pInput.nextLine();
                invalid = true;
            }
            catch(InputMismatchException ime){
                System.out.println("\nError! Only enter an integer: ");
                pInput.nextLine();
                invalid = true;
            }
        }
        
        pInput.nextLine(); //collects garbage characters
        return choice;
    }




    //NAME: getCountry
	//PURPOSE: asks and determines what country the user wants to select and validates the choice made
	//IMPORTS: pInput (Scanner)
	//EXPORTS: country (String)
	//ASSERTIONS:
		//PRE: pInput is a valid value
		//POST: a valid country name 
	//REMARKS: handles IOException and displays a message
    public static String getCountry(Scanner pInput)
    {
        String country = null;
        boolean invalid = true;

        System.out.println("\nThese are the countries available. Choose a country: ");
        System.out.println("\nAustralia" + 
                            "\nSpain" + 
                            "\nJapan" + 
                            "\nMauritius" + 
                            "\nMalaysia" + 
                            "\nSri Lanka" + 
                            "\n\n");

        while(invalid){
        try{
            country = pInput.nextLine();
            Seasons.valCountry(country);
            invalid = false;
            }
            catch(IllegalArgumentException iae){
                System.out.println("\nError! That Country is not available (remember to capitalise the first letter): ");
                invalid = true;
            }
            

        }

        return country;
    }


    

    //NAME: getMonth
	//PURPOSE: asks and determines what month the user wants to select and validates the choice made
	//IMPORTS: pInput (Scanner)
	//EXPORTS: month (String)
	//ASSERTIONS:
		//PRE: pInput is a valid value
		//POST: a valid month name 
	//REMARKS: handles IOException and displays a message
    public static String getMonth(Scanner pInput)
    {
        String month = null;
        boolean invalid = true;

        System.out.println("\nEnter month of the year: ");

        while(invalid)
        {
        try{
            month = pInput.nextLine();
            Seasons.valMonth(month);
            invalid = false;
            }
            catch(IllegalArgumentException iae){
                System.out.println("\nError! That month does not exist: ");
                invalid = true;
            }
        }

        return month;
    }


}
