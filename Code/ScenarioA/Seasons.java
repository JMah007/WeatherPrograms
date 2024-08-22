
import java.io.*;

public class Seasons 
{
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
	//PURPOSE: takes a csv file and stores each line of data in a 2D array
	//IMPORTS: pFileName (String), pArray (String[][])
	//EXPORTS: pArray (String[][])
	//ASSERTIONS:
		//PRE: fileName is a valid String
		//POST: returns a 2D array with valid file data
	//REMARKS: handles IOException and displays a message
    public static void storeFileData(String[][] pArray, String pFileName) 
	{
		FileInputStream fileStream = null;
	    InputStreamReader isr;
		BufferedReader bufRdr;
		String line;
		String[] splitLine;
		int projNum = 0;
		
		
		try
		{	//Open file
			fileStream = new FileInputStream(pFileName);
			isr = new InputStreamReader(fileStream);
			bufRdr = new BufferedReader(isr);
			line = bufRdr.readLine();
			while(line != null) //Reads file line by line and stores it
			{
				splitLine = line.split(",");
                pArray[projNum][0] = splitLine[0];
                pArray[projNum][1] = splitLine[1];				
				line = bufRdr.readLine();
				
				projNum++;			
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




    //NAME: valCountry
	//PURPOSE: validates the country the user chooses for the program
	//IMPORTS: pCountry (String)
	//EXPORTS: 
	//ASSERTIONS:
		//PRE: pCountry is a valid value
		//POST: pCountry is a valid country that exists in the program
	//REMARKS: throws IllegalArgumentException.
            //this must be updated for new countries added 
    public static void valCountry(String pCountry)throws IllegalArgumentException
    {
        if((!pCountry.equalsIgnoreCase("Australia")) && (!pCountry.equalsIgnoreCase("Spain")) && 
            (!pCountry.equalsIgnoreCase("Japan")) && (!pCountry.equalsIgnoreCase("Mauritius")) && 
            (!pCountry.equalsIgnoreCase("Malaysia")) && (!pCountry.equalsIgnoreCase("Sri Lanka")))
        {
            throw new IllegalArgumentException();
        } 
    }




    //NAME: valMonth
	//PURPOSE: validates the month the user chooses for the program
	//IMPORTS: pMonth (String)
	//EXPORTS: 
	//ASSERTIONS:
		//PRE: pMonth is a valid value
		//POST: pMonth is a valid month 
	//REMARKS: throws a IllegalArgumentException
    public static void valMonth(String pMonth)
    {
        if((!pMonth.equals("January")) && (!pMonth.equals("February")) && 
            (!pMonth.equals("March")) && (!pMonth.equals("April")) && 
            (!pMonth.equals("May")) && (!pMonth.equals("June")) && 
            (!pMonth.equals("July")) && (!pMonth.equals("August")) &&
            (!pMonth.equals("September")) && (!pMonth.equals("October")) &&
            (!pMonth.equals("November")) && (!pMonth.equals("December")))
        {
            throw new IllegalArgumentException();
        } 
    }




    //NAME: australia
	//PURPOSE: finds season month given is in for Australia
	//IMPORTS: pMonth (String)
	//EXPORTS: season (String)
	//ASSERTIONS:
		//PRE: pMonth is a valid value
		//POST: returns meteorological and noongar season corresponding to month given 
    public static String australia(String pMonth)
    {
        String meteorSeason = null, noonSeason = null, season = null;

        switch(pMonth) //For finding meteorological season
        {
            case "December":
            case "January":
            case "February":
                meteorSeason = "Summer";
                break;
            case "March":
            case "April":
            case "May":
                meteorSeason = "Autumn";
                break;
            case "June":
            case "July":
            case "August":
                meteorSeason = "Winter";
                break;
            case "September":
            case "October":
            case "November":
                meteorSeason = "Spring";
                break;
            default:
                meteorSeason = "empty";
        }

        switch(pMonth) //For finding Noongar season
        {
            case "December":
            case "January":
                noonSeason = "Birak";
                break;
            case "February":
            case "March":
                noonSeason = "Bunuru";
                break;
            case "April":
            case "May":
                noonSeason = "Djeran";
                break;
            case "June":
            case "July":
                noonSeason = "Makuru";
                break;
            case "August":
            case "September":
                noonSeason = "Dijiba";
                break;
            case "October":
            case "November": 
                noonSeason = "Kambarang";
                break;
            default:
                noonSeason = "empty";
                
        }
        season = meteorSeason + " and " + noonSeason + "( Noongar Season)";
        return season;
    }




    //NAME: spain
	//PURPOSE: finds season month given is in for Spain
	//IMPORTS: pMonth (String)
	//EXPORTS: season (String)
	//ASSERTIONS:
		//PRE: pMonth is a valid value
		//POST: returns season corresponding to month given 
    public static String spain(String pMonth)
    {
        String season = null;

        switch(pMonth)
        {
            case "December":
            case "January":
            case "February":
                season = "Winter";
                break;
            case "March":
            case "April":
            case "May":
                season = "Spring";
                break;
            case "June":
            case "July":
            case "August":
                season = "Summer";
                break;
            case "September":
            case "October":
            case "November":
                season = "Autumn";
                break;
            default:
                season = "empty";
        }
        return season;
    }




    //NAME: japan
	//PURPOSE: finds season month given is in for Japan
	//IMPORTS: pMonth (String)
	//EXPORTS: season (String)
	//ASSERTIONS:
		//PRE: pMonth is a valid value
		//POST: returns season corresponding to month given 
    public static String japan(String pMonth)
    {
        String season = null;

        switch(pMonth)
        {
            case "December":
            case "January":
            case "February":
                season = "Winter";
                break;
            case "March":
            case "April":
            case "May":
                season = "Spring";
                break;
            case "June":
            case "July":
            case "August":
                season = "Summer";
                break;
            case "September":
            case "October":
            case "November":
                season = "Autumn";
                break;
            default:
                season = "empty";
        }
        return season;
    }




    //NAME: mauritius
	//PURPOSE: finds season month given is in for Mauritius
	//IMPORTS: pMonth (String)
	//EXPORTS: season (String)
	//ASSERTIONS:
		//PRE: pMonth is a valid value
		//POST: returns season corresponding to month given 
    public static String mauritius(String pMonth)
    {
        String season = null;

        switch(pMonth)
        {
            case "November":
            case "December":
            case "January":
            case "February":
            case "March":
            case "April":
                season = "Summer";
                break;
            case "May":
                season = "Autumn";
                break;
            case "June":
            case "July":
            case "August":
            case "September":
                season = "Winter";
                break;
            case "October":
                season = "Spring";
                break;
            default:
                season = "empty";
        }
        return season;
    }




    //NAME: malaysia
	//PURPOSE: finds season month given is in for Malaysia
	//IMPORTS: pMonth (String)
	//EXPORTS: season (String)
	//ASSERTIONS:
		//PRE: pMonth is a valid value
		//POST: returns season corresponding to month given 
    public static String malaysia(String pMonth)
    {
        String season = null;

        switch(pMonth)
        {
            case "January":
            case "February":
            case "December":
                season = "Northeast Monsoon";
                break;
            case "March":
            case "April":
                season = "Inter-monsoon";
                break;
            case "May":
            case "June":
            case "July":
            case "August":
            case "September":
                season = "Southeast Monsoon";
                break;
            case "October":
            case "November":
                season = "Inter-monsoon";
                break;
            default:
                season = "empty";
        }
        return season;

    }




    //NAME: sriLanka
	//PURPOSE: finds season month given is in for Sri Lanka
	//IMPORTS: pMonth (String)
	//EXPORTS: season (String)
	//ASSERTIONS:
		//PRE: pMonth is a valid value
		//POST: returns season corresponding to month given 
    public static String sriLanka(String pMonth)
    {
        String season = null;

        switch(pMonth)
        {
            case "January":
            case "February":
            case "December":
                season = "Northeast Monsoon";
                break;
            case "March":
            case "April":
                season = "Inter-monsoon";
                break;
            case "May":
            case "June":
            case "July":
            case "August":
            case "September":
                season = "Southeast Monsoon";
                break;
            case "October":
            case "November":
                season = "Inter-monsoon";
                break;
            default:
                season = "empty";
        }
        return season;

    }


    
    //NAME: findSeason
	//PURPOSE: executes search for season based on the country and month given 
	//IMPORTS: pMonth (String), pCountry (String)
	//EXPORTS: season (String)
	//ASSERTIONS:
		//PRE: pMonth and pCountryis a valid value
		//POST: returns season corresponding to month and country given
    //REMARKS: this must be updated for new countries added
    public static String findSeason(String pCountry, String pMonth)
    {
        String season = null;
        switch(pCountry){
            case "Australia":
                season = australia(pMonth);
                break;
            case "Spain":
                season = spain(pMonth);
                break;
            case "Japan":
                season = japan(pMonth);
                break;
            case "Mauritius":
                season = mauritius(pMonth);
                break;
            case "Malaysia":
                season = malaysia(pMonth);
                break;
            case "Sri Lanka":
                season = sriLanka(pMonth);
                break;
            default:
                season = "empty";
        }
        return season;
    }
}
