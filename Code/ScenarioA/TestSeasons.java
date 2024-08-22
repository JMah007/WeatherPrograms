import java.io.*;
import java.util.Scanner;


public class TestSeasons {

    public static void main(String args[]){

        //BB 
        testAustralia();
        testSpain();
        testJapan();
        testMauritius();
        testSriLanka();
        testFindSeason();
        testCountLines();

        

        //WB
        testCountLines2();
        testGetInputMeth();

    }



    public static void testCountLines()
    {
        //EP

        //Valid file name
        assert 4 == Seasons.countLines("seasonsData.csv") : "Could not process file";
        
        //Invalid file name
        assert 0 == Seasons.countLines("invalidFileName") : "Processed an incorrect file name";
    }
    
    

    public static void testCountLines2()
    {

        //WB

        //Try code works 
        PrintWriter inputFile;
        try {
            inputFile = new PrintWriter("testFile.csv");
            inputFile.println("Australia,January"); 
            inputFile.println("Australia,March");
            inputFile.println("Spain,May");
            inputFile.close();
            
            assert 3 == Seasons.countLines("testFile.csv") : "Didnt count number of lines in file properly";
        
        } catch (FileNotFoundException e) {
            System.out.println("file processing error");
        }


        //Exception is thrown
        try {
            inputFile = new PrintWriter("testFile.csv");
            inputFile.println("Australia,January"); 
            inputFile.println("Australia,March");
            inputFile.println("Spain,May");
            inputFile.close();
            
            assert 0 == Seasons.countLines("invalidFile.csv") : "Didnt count number of lines in file properly";
        
        } catch (FileNotFoundException e) {
            System.out.println("file processing error");
        }
    }


   

    public static void testAustralia()
    {
        //EP

        //January 
        assert "Summer and Birak( Noongar Season)".equals(Seasons.australia("January")) : "January doesnt exist";

        //February
        assert "Summer and Bunuru( Noongar Season)".equals(Seasons.australia("February")): "February doesnt exist";

        //December
        assert "Summer and Birak( Noongar Season)".equals(Seasons.australia("December")): "December doesnt exist";

        //March
        assert "Autumn and Bunuru( Noongar Season)".equals(Seasons.australia("March")): "March doesnt exist";

        //April
        assert "Autumn and Djeran( Noongar Season)".equals(Seasons.australia("April")): "April doesnt exist";

        //May
        assert "Autumn and Djeran( Noongar Season)".equals(Seasons.australia("May")): "May doesnt exist";

        //June
        assert "Winter and Makuru( Noongar Season)".equals(Seasons.australia("June")): "June doesnt exist";

        //July
        assert "Winter and Makuru( Noongar Season)".equals(Seasons.australia("July")): "July doesnt exist";

        //August
        assert "Winter and Dijiba( Noongar Season)".equals(Seasons.australia("August")): "August doesnt exist ";

        //September
        assert "Spring and Dijiba( Noongar Season)".equals(Seasons.australia("September")): "September doesnt exist";

        //October
        assert "Spring and Kambarang( Noongar Season)".equals(Seasons.australia("October")): "October doesnt exist";

        //November
        assert "Spring and Kambarang( Noongar Season)".equals(Seasons.australia("November")): "November doesnt exist";

        //Not a month given
        assert "empty and empty( Noongar Season)".equals(Seasons.australia("test")): "Invalid month didnt didnt match default case";
        
    }




    public static void testSpain()
    {
        //EP

        //January 
        assert "Winter".equals(Seasons.spain("January")) : "January doesnt exist";

        //February
        assert "Winter".equals(Seasons.spain("February")): "February doesnt exist";

        //December
        assert "Winter".equals(Seasons.spain("December")): "December doesnt exist";

        //March
        assert "Spring".equals(Seasons.spain("March")): "March doesnt exist";

        //April
        assert "Spring".equals(Seasons.spain("April")): "April doesnt exist";

        //May
        assert "Spring".equals(Seasons.spain("May")): "May doesnt exist";

        //June
        assert "Summer".equals(Seasons.spain("June")): "June doesnt exist";

        //July
        assert "Summer".equals(Seasons.spain("July")): "July doesnt exist";

        //August
        assert "Summer".equals(Seasons.spain("August")): "August doesnt exist ";

        //September
        assert "Autumn".equals(Seasons.spain("September")): "September doesnt exist";

        //October
        assert "Autumn".equals(Seasons.spain("October")): "October doesnt exist";

        //November
        assert "Autumn".equals(Seasons.spain("November")): "November doesnt exist";

        //Not a month given
        assert "empty".equals(Seasons.spain("test")): "Invalid month didnt didnt match default case";
        
    }
    



    public static void testJapan()
    {
        //EP

        //January 
        assert "Winter".equals(Seasons.japan("January")) : "January doesnt exist";

        //February
        assert "Winter".equals(Seasons.japan("February")): "February doesnt exist";

        //December
        assert "Winter".equals(Seasons.japan("December")): "December doesnt exist";

        //March
        assert "Spring".equals(Seasons.japan("March")): "March doesnt exist";

        //April
        assert "Spring".equals(Seasons.japan("April")): "April doesnt exist";

        //May
        assert "Spring".equals(Seasons.japan("May")): "May doesnt exist";

        //June
        assert "Summer".equals(Seasons.japan("June")): "June doesnt exist";

        //July
        assert "Summer".equals(Seasons.japan("July")): "July doesnt exist";

        //August
        assert "Summer".equals(Seasons.japan("August")): "August doesnt exist ";

        //September
        assert "Autumn".equals(Seasons.japan("September")): "September doesnt exist";

        //October
        assert "Autumn".equals(Seasons.japan("October")): "October doesnt exist";

        //November
        assert "Autumn".equals(Seasons.japan("November")): "November doesnt exist";

        //Not a month given
        assert "empty".equals(Seasons.japan("test")): "Invalid month didnt didnt match default case";
        
    }



    public static void testMauritius()
    {
        //EP

        //January 
        assert "Summer".equals(Seasons.mauritius("January")) : "January doesnt exist";

        //February
        assert "Summer".equals(Seasons.mauritius("February")) : "February doesnt exist";

        //March
        assert "Summer".equals(Seasons.mauritius("March")) : "March doesnt exist";

        //April
        assert "Summer".equals(Seasons.mauritius("April")) : "April doesnt exist";

        //May
        assert "Autumn".equals(Seasons.mauritius("May")) : "May doesnt exist";

        //June 
        assert "Winter".equals(Seasons.mauritius("June")) : "June doesnt exist";

        //July
        assert "Winter".equals(Seasons.mauritius("July")) : "July doesnt exist";

        //August
        assert "Winter".equals(Seasons.mauritius("August")) : "August doesnt exist";

        //September
        assert "Winter".equals(Seasons.mauritius("September")) : "September doesnt exist";

        //October
        assert "Spring".equals(Seasons.mauritius("October")) : "October doesnt exist";

        //November
        assert "Summer".equals(Seasons.mauritius("November")) : "November doesnt exist";

        //December
        assert "Summer".equals(Seasons.mauritius("December")) : "December doesnt exist";

        //Not a month given
        assert "empty".equals(Seasons.mauritius("test")) : "Invalid month didnt match default case";
    }




    public static void testMalaysia()
    {
        //EP

        //January
        assert "Northeast Monsoon".equals(Seasons.malaysia("January")) : "January doesnt exist";

        //February
        assert "Northeast Monsoon".equals(Seasons.malaysia("February")) : "February doesnt exist";

        //March
        assert "Inter-monsoon".equals(Seasons.malaysia("March")) : "March doesnt exist";

        //April
        assert "Inter-monsoon".equals(Seasons.malaysia("April")) : "April doesnt exist";

        //May
        assert "Southeast Monsoon".equals(Seasons.malaysia("May")) : "May doesnt exist";

        //June
        assert "Southeast Monsoon".equals(Seasons.malaysia("June")) : "June doesnt exist";

        //July
        assert "Southeast Monsoon".equals(Seasons.malaysia("July")) : "July doesnt exist";
        
        //August
        assert "Southeast Monsoon".equals(Seasons.malaysia("August")) : "August doesnt exist";
   
        //September
        assert "Southeast Monsoon".equals(Seasons.malaysia("September")) : "September doesnt exist";

        //October
        assert "Inter-monsoon".equals(Seasons.malaysia("October")) : "October doesnt exist";

        //November
        assert "Inter-monsoon".equals(Seasons.malaysia("November")) : "November doesnt exist";
        
        //December
        assert "Northeast Monsoon".equals(Seasons.malaysia("December")) : "December doesnt exist";

        //Not a month given
        assert "empty".equals(Seasons.malaysia("test")) : "Invalid month didnt match default case";
    }



    public static void testSriLanka()
    {
        //EP

        //January
        assert "Northeast Monsoon".equals(Seasons.sriLanka("January")) : "January doesnt exist";

        //February
        assert "Northeast Monsoon".equals(Seasons.sriLanka("February")) : "February doesnt exist";

        //March
        assert "Inter-monsoon".equals(Seasons.sriLanka("March")) : "March doesnt exist";

        //April
        assert "Inter-monsoon".equals(Seasons.sriLanka("April")) : "April doesnt exist";

        //May
        assert "Southeast Monsoon".equals(Seasons.sriLanka("May")) : "May doesnt exist";

        //June
        assert "Southeast Monsoon".equals(Seasons.sriLanka("June")) : "June doesnt exist";

        //July
        assert "Southeast Monsoon".equals(Seasons.sriLanka("July")) : "July doesnt exist";
        
        //August
        assert "Southeast Monsoon".equals(Seasons.sriLanka("August")) : "August doesnt exist";
   
        //September
        assert "Southeast Monsoon".equals(Seasons.sriLanka("September")) : "September doesnt exist";

        //October
        assert "Inter-monsoon".equals(Seasons.sriLanka("October")) : "October doesnt exist";

        //November
        assert "Inter-monsoon".equals(Seasons.sriLanka("November")) : "November doesnt exist";
        
        //December
        assert "Northeast Monsoon".equals(Seasons.sriLanka("December")) : "December doesnt exist";

        //Not a month given
        assert "empty".equals(Seasons.sriLanka("test")) : "Invalid month didnt match default case";
    }



    public static void testFindSeason()
    {
        //EP

        //If Australia
        assert "Summer and Birak( Noongar Season)".equals(Seasons.findSeason("Australia", "January")) : "Australia doesnt exist";

        //If Spain
        assert "Winter".equals(Seasons.findSeason("Spain", "February")) : "Spain doesnt exist";

        //If Japan
        assert "Winter".equals(Seasons.findSeason("Japan",  "December")) : "Japan doesnt exist";

        //If Mauritius
        assert "Winter".equals(Seasons.findSeason("Mauritius", "August")) : "Mauritius doesnt exist";

        //If Malaysia
        assert "Inter-monsoon".equals(Seasons.findSeason("Malaysia", "October")) : "Malaysia doesnt exist";

        //If Sri Lanka
        assert "Southeast Monsoon".equals(Seasons.findSeason("Sri Lanka", "September")) : "Sri Lanka doesnt exist";

        //Not a country given
        assert "empty".equals(Seasons.findSeason("asa", "January")) : "Invalid country didnt match default case";
    }



    public static void testGetInputMeth()
    {
        PrintStream originalOut;
        InputStream originalIn;
        ByteArrayOutputStream capOut;
        ByteArrayInputStream testInput;
        Scanner scanner;
        int choice;
        String expectedOutput;

        //WB

        //try code works
        originalOut = System.out;
        originalIn = System.in;
    
        capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));
    
        testInput = new ByteArrayInputStream("1".getBytes());
        System.setIn(testInput);
    
        scanner = new Scanner(System.in);
    
        choice = MainSeasons.getInputMeth(scanner);
    
        expectedOutput = "\nHow do you want to load your data in? Choose one of the options below: \n1. File\n2. Keyboard\n3. Quit the program\n\n";
    
        assert expectedOutput.equals(capOut.toString()) : "This tests if code works fine in try";
    
        tearDownInputTerminal(originalIn);
        tearDownOutputTerminal(originalOut);



 
        //Throws exception
        originalOut = System.out;
        originalIn = System.in;
    
        capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));
    
        testInput = new ByteArrayInputStream("4\n1".getBytes());
        System.setIn(testInput);
    
        scanner = new Scanner(System.in);
    
        choice = MainSeasons.getInputMeth(scanner);
    
        expectedOutput = "\nHow do you want to load your data in? Choose one of the options below: \n1. File\n2. Keyboard\n3. Quit the program\n\n\nError! Choose either 1 or 2: ";
    
        assert expectedOutput.equals(capOut.toString()) : "This tests if exception is thrown";
    
        tearDownInputTerminal(originalIn);
        tearDownOutputTerminal(originalOut);
    }
    


    public static void tearDownInputTerminal(InputStream pOriginalIn){
        System.setIn(pOriginalIn);
    }

    public static void tearDownOutputTerminal(PrintStream pOriginalOut){
        System.setOut(pOriginalOut);
    }
}


