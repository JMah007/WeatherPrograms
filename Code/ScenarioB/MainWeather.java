
import java.util.*;

public class MainWeather {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        int inputMeth;

        String city;
        double temp;
        String msgTemp;

        int numLines = 0;
        Weather[] cityData;
        String inputFileName = "temperature.csv";
        

        inputMeth = getInputMeth(input);

        while(inputMeth != 3) //keep displaying menu until quit is chosen
        {
            if(inputMeth == 2) //User chooses to input data via keyboard
            {
                city = getCity(input);
                temp = getTemp(input);
                msgTemp = Weather.tempAnalysis(city, temp);
                System.out.println(msgTemp);
            }
            else //User chooses to input data via a file
            {
                numLines = Weather.countLines(inputFileName);
                cityData = new Weather[numLines];

                Weather.storeFileData(cityData, inputFileName);
                for(int i=0; i<numLines; i++)
                {
                    msgTemp = Weather.tempAnalysis(cityData[i].getCity(), cityData[i].getTemp());
                    System.out.println(msgTemp);
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
                            "\n3. Quite the program" +
                            "\n\n");
        while(invalid)
        {
            try{
            choice = pInput.nextInt();
            Weather.valInputMeth(choice);
            invalid = false;
            }
            catch(IllegalArgumentException iae){
                System.out.println("\nError! Choose either 1 or 2: ");
                pInput.nextLine();
                invalid = true;
            }
            catch(InputMismatchException ime){
                System.out.println("Error! Only enter an integer: ");
                pInput.nextLine();
                invalid = true;
            }
        }
        
        pInput.nextLine(); //collects garbage characters
        return choice;
    }




    //NAME: getCity
	//PURPOSE: asks and determines what city the user wants to select and validates the choice made
	//IMPORTS: pInput (Scanner)
	//EXPORTS: city (String)
	//ASSERTIONS:
		//PRE: pInput is a valid value
		//POST: a valid city name 
	//REMARKS: handles IOException and displays a message
    public static String getCity(Scanner pInput)
    {
        String city = null;
        boolean invalid = true;

        System.out.println("\nThese are the cities available. Choose a city: ");
        System.out.println("\nPerth" +
                            "\nAdelaide" + 
                            "\n\n");

        while(invalid)
        {
        try{
            city = pInput.nextLine();
            Weather.valCity(city);
            invalid = false;
            }
            catch(IllegalArgumentException iae){
                System.out.println("\nError! That City is not available (remember to capitalise first letter): ");
                invalid = true;
            }
        }

        return city;
    }




    //NAME: getTemp
	//PURPOSE: asks user to enter a temperature and makes sure it is valid
	//IMPORTS: pInput (Scanner)
	//EXPORTS: temp (double)
	//ASSERTIONS:
		//PRE: pInput is a valid value
		//POST: temperature is valid 
	//REMARKS: handles IOException and displays a message
    public static double getTemp(Scanner pInput)
    {
        double temp = 0;
        boolean invalid = true;

        System.out.println("Enter a temperature in degrees celcius: ");

        while(invalid)
        {
            try
            {
                temp = pInput.nextDouble();
                invalid = false;
            }
            catch(InputMismatchException ime)
            {
                System.out.println("\nError! Invalid characters given: ");
                pInput.next();
                invalid = true;
            }
        }
        return temp;
    }
}
