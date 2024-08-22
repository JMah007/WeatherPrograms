//package Code.ScenarioB;
import java.io.*;

public class Weather 
{

    private String city;
    private double temp;



    //NAME: Weather
	//PURPOSE: default constructor to give field variables default values
	//IMPORTS: 
	//EXPORTS: 
	//ASSERTIONS:
		//PRE: 
		//POST: field variables are initialised
    public Weather(){
        city = "Empty";
        temp = 0.00;
    }



    //NAME: Weather
	//PURPOSE: parameter constructor to give field variables user determined values
	//IMPORTS: pCity (String), pTemp (double)
	//EXPORTS: 
	//ASSERTIONS:
		//PRE: 
		//POST: field variables are initialised
    public Weather(String pCity, double pTemp)
    {
        city = pCity;
        temp = pTemp;

    }



    public String getCity(){
        return city;
    }

    public double getTemp(){
        return temp;
    }

    public void setCity(String pCity){
        city = pCity;
    }

    public void setTemp(double pTemp){
        temp = pTemp;
    }




    //NAME: countLines
	//PURPOSE: takes a csv file and counts the number of lines containing data in the file 
	//IMPORTS: pFileName (String)
	//EXPORTS: numLines (int)
	//ASSERTIONS:
		//PRE: fileName is a valid String
		//POST: gives number of lines with data in the file
	//REMARKS: handles IOException and displays a message
    public static int countLines(String pFileName) 
	{
		FileInputStream fileStream = null;
	    InputStreamReader isr;
		BufferedReader bufRdr;
		String line;
		int numLines= 0;	
		
		try 
		{   //open file 
			fileStream = new FileInputStream(pFileName);
			isr = new InputStreamReader(fileStream);
			bufRdr = new BufferedReader(isr);
			line = bufRdr.readLine();
			while(line != null) 
			{
				numLines++; //count number of lines
				line = bufRdr.readLine();
			}
			fileStream.close();
		}

		//if file cannot be processed
		catch(IOException errorDetails) 
		{
			if(fileStream != null)
			{
				try
				{
					fileStream.close();
				}
				catch(IOException ex2)
				{			
					System.out.println("IO Exception");
					System.out.println("Error in file processiong of " + pFileName);
				}
			}
		}

		return numLines;
	}




    //NAME: storeFileData
	//PURPOSE: takes a csv file and stores each line of data in a object array
	//IMPORTS: pFileName (String), pArray (Weather[])
	//EXPORTS: pArray (Weather[])
	//ASSERTIONS:
		//PRE: fileName is a valid String
		//POST: returns a object array with valid file data
	//REMARKS: handles IOException and displays a message
    public static void storeFileData(Weather[] pArray, String pFileName) 
	{
		FileInputStream fileStream = null;
	    InputStreamReader isr;
		BufferedReader bufRdr;
		String line;
		String[] splitLine;
		int lineNum = 0;
		
		
		try
		{	//Open file
			fileStream = new FileInputStream(pFileName);
			isr = new InputStreamReader(fileStream);
			bufRdr = new BufferedReader(isr);
			line = bufRdr.readLine();
			while(line != null) //Reads file line by line and stores it
			{
				splitLine = line.split(",");
                pArray[lineNum] = new Weather(splitLine[0], Double.parseDouble(splitLine[1]));
                			
				line = bufRdr.readLine();
				
				lineNum++;			
			}
			fileStream.close();
		}
		catch(IOException errorDetails) //if file cannot be processed
		{   
			if(fileStream != null)
			{
				try
				{
					fileStream.close();
				}
				catch(IOException ex2)
				{
					System.out.println("IO Exception");
					System.out.println("Error in file processiong of " + pFileName);
						
				}
			}
		}
    }

    //NAME: valInputMeth
	//PURPOSE: validates the input method the user chooses for the program
	//IMPORTS: pChoice (int)
	//EXPORTS: 
	//ASSERTIONS:
		//PRE: pChoice is a valid value
		//POST: pChoice chosen is one of the options presented
	//REMARKS: throws IllegalArgumentException
    public static void valInputMeth(int pChoice) throws IllegalArgumentException
    {
        int min = 1,  max = 3;
        
        if((pChoice < min) || (pChoice > max))
        {
            throw new IllegalArgumentException();
        } 
    }




    //NAME: valCity
	//PURPOSE: validates the city the user chooses for the program
	//IMPORTS: pCity (String)
	//EXPORTS: 
	//ASSERTIONS:
		//PRE: pCity is a valid value
		//POST: pCity is a valid country that exists in the program
	//REMARKS: throws IllegalArgumentException.
            //this must be updated for new cities added 
    public static void valCity(String pCity)throws IllegalArgumentException
    {
        if((!pCity.equals("Perth")) && (!pCity.equals("Adelaide")))
        {
            throw new IllegalArgumentException();
        } 
    }




    //NAME: compToMornTemp
	//PURPOSE: compares a temperature to the mean morning temperature of a city
	//IMPORTS: pCity (String), pTemp (double), pMeanCityTemp (double)
	//EXPORTS: msg (String)
	//ASSERTIONS:
		//PRE: pCity, pMeanCityTemp and pTemp is a valid value
		//POST: returns msg with temperature analysis
    public static String compToMornTemp(double pMeanCityTemp, double pTemp, String pCity)
    {
        double tempDiff, absTempDiff;
        String msg;


        tempDiff = pTemp - pMeanCityTemp;
        absTempDiff = Math.abs(tempDiff);
        

        if(tempDiff < 0.00)
        {
            msg = "\n" + pTemp + " is less than " + pCity +  " mean morning temperature of " + pMeanCityTemp + " degrees celcius.";
            if(absTempDiff > 5.00)
            {
                msg = msg + "\n" + pTemp + " is " + absTempDiff + " degrees celcius lower than " + pMeanCityTemp;
            }
        }
        else
		if(tempDiff > 0.00)
        {
            msg = "\n" + pTemp + " is more than " + pCity + " mean morning temperature of " + pMeanCityTemp + " degrees celcius.";
            if(absTempDiff > 5.00)
            {
                msg = msg + "\n" + pTemp + " is " + absTempDiff + " degrees celcius higher than " + pMeanCityTemp;
            }
        }
		else
		{
			msg = "\n" + pTemp + " is equal to " + pCity + " mean morning temperature of " + pMeanCityTemp + " degrees celcius" ;
		}
        return msg;
    }




    //NAME: compToAfterTemp
	//PURPOSE: compares a temperature to the mean afternoon temperature of a city
	//IMPORTS: pCity (String), pTemp (double), pMeanCityTemp (double)
	//EXPORTS: msg (String)
	//ASSERTIONS:
		//PRE: pCity, pMeanCityTemp and pTemp is a valid value
		//POST: returns msg with temperature analysis
    public static String compToAfterTemp(double pMeanCityTemp, double pTemp, String pCity)
    {
        double tempDiff, absTempDiff;
        String msg;

        
        tempDiff = pTemp - pMeanCityTemp;
        absTempDiff = Math.abs(tempDiff);

        if(tempDiff < 0.00)
        {
            msg = "\n" + pTemp + " is less than " + pCity + " mean afternoon temperature of " + pMeanCityTemp + " degrees celcius.";
            if(absTempDiff > 5.00)
            {
                msg = msg + "\n" + pTemp + " is " + absTempDiff + " degrees celcius lower than " + pMeanCityTemp;
            }
        }
        else
		if(tempDiff > 0.00)
        {
            msg = "\n" + pTemp + " is more than " + pCity  +  " mean afternoon temperature of " + pMeanCityTemp + " degrees celcius.";
            if(absTempDiff > 5.00)
            {
                msg = msg + "\n" + pTemp + " is " + absTempDiff + " degrees celcius higher than " + pMeanCityTemp;
            }
        }
		else
		{
			msg = "\n" + pTemp + " is equal to " + pCity + " mean afternoon temperature of " + pMeanCityTemp + " degrees celcius" ;
		}
        return msg;
    }
       



    //NAME: tempAnalysis
	//PURPOSE: executes search for temperature analysis based on the city given
	//IMPORTS: pCity (String), pTemp (double)
	//EXPORTS: msg (String)
	//ASSERTIONS:
		//PRE: pCity and pTemp is a valid value
		//POST: returns msg with temperature analysis
    //REMARKS: this must be updated for new cities added
    public static String tempAnalysis(String pCity, double pTemp)
    {
		String msg1 = "empty", msg2 = "empty";

		double perthMorn = 18.2, perthAfter = 23.0;
		double adelaideMorn = 16.5, adelaideAfter = 21.0;


        switch(pCity){
            case "Perth":
                msg1 = compToMornTemp(perthMorn, pTemp, pCity);
				msg2 = compToAfterTemp(perthAfter, pTemp, pCity);
                break;
            case "Adelaide":
                msg1 = compToMornTemp(adelaideMorn, pTemp, pCity);
				msg2 = compToAfterTemp(adelaideAfter, pTemp, pCity);
                break;
            default:
                msg1 = "empty";
				msg2 = " empty";
        }
        return msg1 + msg2;
    }
}
