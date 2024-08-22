public class TestWeather {

    public static void main(String args[]){

        //BB 
        testCountLines();
        testCompToMornTemp();
        testCompToAfterTemp();
        testTempAnalysis();

    }


    public static void testCountLines()
    {
        //EP

        //Valid file name
        assert 3 == Weather.countLines("temperature.csv") : "Could not process file";
        
        //Invalid file name
        assert 0 == Weather.countLines("invalidFileName") : "Processed an incorrect file name";
    }



    public static void testCompToMornTemp()
    {
        String msg;

        //EP

        //temperature less than morning temp by more than 5
        msg = "\n10.0 is less than Perth mean morning temperature of 18.2 degrees celcius.\n10.0 is 8.2 degrees celcius lower than 18.2";
        assert msg.equals(Weather.compToMornTemp(18.2, 10.0, "Perth")) : "Couldnt process temperature when lower than morning mean temp by more than 5";
        
        //temp less than morning temp by less than 5 
        msg = "\n15.0 is less than Perth mean morning temperature of 18.2 degrees celcius.";
        assert msg.equals(Weather.compToMornTemp(18.2,  15.0, "Perth")) : "Couldnt process temperature when lower than morning mean temp by less than 5";

        //temp more than morning temp by more than 5
        msg = "\n30.0 is more than Perth mean morning temperature of 18.2 degrees celcius.\n30.0 is 11.8 degrees celcius higher than 18.2";
        assert msg.equals(Weather.compToMornTemp(18.2,  30.0, "Perth")) : "Couldnt process temperature when higher than morning mean temp by more than 5";
        
        //temp more than morning temp less than 5
        msg = "\n20.0 is more than Perth mean morning temperature of 18.2 degrees celcius.";
        assert msg.equals(Weather.compToMornTemp(18.2,  20.0, "Perth")) : "Couldnt process temperature when higher than morning mean temp by less than 5";
        
        //temp equal to afternoon temp
        msg = "\n18.2 is equal to Perth mean morning temperature of 18.2 degrees celcius";
        assert msg.equals(Weather.compToMornTemp(18.2, 18.2, "Perth")) : "Couldnt process temperature when equal to morning mean temp";



        //BVA

        //between less than morning temp by 5 and less than morning temp more than 5
        msg = "\n14.2 is less than Perth mean morning temperature of 18.2 degrees celcius.";
        assert msg.equals(Weather.compToMornTemp(18.2, 14.2, "Perth")) : "Given temperature not less than morning mean by less than 5";

        msg = "\n12.2 is less than Perth mean morning temperature of 18.2 degrees celcius.\n12.2 is 6.0 degrees celcius lower than 18.2";
        assert msg.equals(Weather.compToMornTemp(18.2,  12.2, "Perth")) : "Given temperature not less than morning mean by more than 5";

        //between more than morning temp by 5 and more than mornign temp less than 5
        msg = "\n22.2 is more than Perth mean morning temperature of 18.2 degrees celcius.";
        assert msg.equals(Weather.compToMornTemp(18.2, 22.2, "Perth")) : "Given temperature not more than morning mean by less than 5";

        msg = "\n24.2 is more than Perth mean morning temperature of 18.2 degrees celcius.\n24.2 is 6.0 degrees celcius higher than 18.2";
        assert msg.equals(Weather.compToMornTemp(18.2, 24.2, "Perth")) : "Given temperature not more than morning mean by more than 5";
    }



    public static void testCompToAfterTemp()
    {
        String msg;

        //EP

        //temperature less than afternoon temp by more than 5
        msg = "\n10.0 is less than Perth mean afternoon temperature of 23.0 degrees celcius.\n10.0 is 13.0 degrees celcius lower than 23.0";
        assert msg.equals(Weather.compToAfterTemp(23.0, 10.0, "Perth")) : "Couldnt process temperature when lower than afternoon mean temp by more than 5";

        //temp less than afternoon temp by less than 5 
        msg = "\n22.0 is less than Perth mean afternoon temperature of 23.0 degrees celcius.";
        assert msg.equals(Weather.compToAfterTemp(23.0, 22.0, "Perth")) : "Couldnt process temperature when lower than afternoon mean temp by less than 5";

        //temp more than afternoon temp by more than 5
        msg = "\n40.0 is more than Perth mean afternoon temperature of 23.0 degrees celcius.\n40.0 is 17.0 degrees celcius higher than 23.0";
        assert msg.equals(Weather.compToAfterTemp(23.0, 40.0, "Perth")) : "Couldnt process temperature when higher than afternoon mean temp by more than 5";

        //temp more than afternoon temp less than 5
        msg = "\n24.0 is more than Perth mean afternoon temperature of 23.0 degrees celcius.";
        assert msg.equals(Weather.compToAfterTemp(23.0, 24.0, "Perth")) : "Couldnt process temperature when higher than afternoon mean temp by less than 5";

        //temp equal to afternoon temp
        msg = "\n23.0 is equal to Perth mean afternoon temperature of 23.0 degrees celcius";
        assert msg.equals(Weather.compToAfterTemp(23.0, 23.0, "Perth")) : "Couldnt process temperature when equal to afternoon mean temp";



        //BVA

        //between less than afternoon temp by 5 and less than afternoon temp more than 5
        msg = "\n19.0 is less than Perth mean afternoon temperature of 23.0 degrees celcius.";
        assert msg.equals(Weather.compToAfterTemp(23.0, 19.0, "Perth")) : "Given temperature not less than afternoon mean by less than 5";

        msg = "\n17.0 is less than Perth mean afternoon temperature of 23.0 degrees celcius.\n17.0 is 6.0 degrees celcius lower than 23.0";
        assert msg.equals(Weather.compToAfterTemp(23.0,  17.0, "Perth")) : "Given temperature not less than afternoon mean by more than 5";

        //between more than afternoon temp by 5 and more than afternoon temp less than 5
        msg = "\n27.0 is more than Perth mean afternoon temperature of 23.0 degrees celcius.";
        assert msg.equals(Weather.compToAfterTemp(23.0, 27.0, "Perth")) : "Given temperature not more than afternoon mean by less than 5";

        msg = "\n29.0 is more than Perth mean afternoon temperature of 23.0 degrees celcius.\n29.0 is 6.0 degrees celcius higher than 23.0";
        assert msg.equals(Weather.compToAfterTemp(23.0, 29.0, "Perth")) : "Given temperature not more than afternoon mean by more than 5";
    }



    public static void testTempAnalysis()
    {
        String msg;

        //EP
        
        //For perth
        msg = "\n20.0 is more than Perth mean morning temperature of 18.2 degrees celcius.\n20.0 is less than Perth mean afternoon temperature of 23.0 degrees celcius.";
        assert msg.equals(Weather.tempAnalysis("Perth", 20.0)) : "Perth couldnt be processed";

        //Adelaide
        // System.out.println(Weather.tempAnalysis("Adelaide", 18.0));
        msg = "\n18.5 is more than Adelaide mean morning temperature of 16.5 degrees celcius.\n18.5 is less than Adelaide mean afternoon temperature of 21.0 degrees celcius.";
        assert msg.equals(Weather.tempAnalysis("Adelaide", 18.5)) : "Adelaide couldnt be processed";

        //Invalid city
        msg = "empty empty";
        assert msg.equals(Weather.tempAnalysis("invalidCity", 18.5)) : "Invalid city couldnt be processed";

    }
    
}
