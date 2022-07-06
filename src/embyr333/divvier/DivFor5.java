/*
July 2022 small 'organisational' tweaks of project/program formerly named
Divvier_in_GUI, from last version, _im27 (program intermediate 27) 31Dec2015

Changes:
- Renamed the project/program as a whole from Divvier_in_GUI (back) to just Divvier
- Placed the files into a package called  embyr333.divvier 
(with associated package statement at the top of the code for each)
- Changed names of classes and associated files as:
DivvierGUI 		to  DivGUI
Divvier_in_GUI_Launch 	to  DivLaunch
Divvier_of_4_IG		to  DivFor4
Divvier_of_5_IG		to  DivFor5
Divvier_to_11_IG	to  DivFor6to11
Divvier_unlimited_IG	to  DivFor12plus
- Changed comment that inappropriately used the
word/word-part 'set' as/in a noun even when there may be replicates, to 'collection' 

Naming this version with YYMMDD_HHMM timestamp 220706_2316
*/

package embyr333.divvier;

public class DivFor5
{
    public static void process(double a, double b, double c, double d, double e)    
    {    
        // Split the collection of five into two subcollections, exploring all possible combinations
        //     and determine the differences between the sums of each subcollection pair        
        double[] diff = new double[15];
	diff[0] = Math.abs( a - (b + c + d + e) );
	diff[1] = Math.abs( b - (a + c + d + e) );
	diff[2] = Math.abs( c - (a + b + d + e) );
	diff[3] = Math.abs( d - (a + b + c + e) );
	diff[4] = Math.abs( e - (a + b + c + d) );
	diff[5] = Math.abs( (a + b) - (c + d + e) );
	diff[6] = Math.abs( (a + c) - (b + d + e) );
	diff[7] = Math.abs( (a + d) - (b + c + e) );	
	diff[8] = Math.abs( (a + e) - (b + c + d) );
	diff[9] = Math.abs( (b + c) - (a + d + e) );
	diff[10] = Math.abs( (b + d) - (a + c + e) );
	diff[11] = Math.abs( (b + e) - (a + c + d) );
	diff[12] = Math.abs( (c + d) - (a + b + e) );
	diff[13] = Math.abs( (c + e) - (a + b + d) );
	diff[14] = Math.abs( (d + e) - (a + b + c) );       
        
        // Determine the minimum difference
        double minDiff = diff[0];
        for(int i = 1; i < 15; i++)
            if(diff[i] < minDiff)
                minDiff = diff[i];        
        
        // Determine the number of combinations that produce the minimum difference
        int nCom = 0;
        for(int i = 0; i < 15; i++)
            if (diff[i] == minDiff) 
                ++nCom;         
        
        
        DivGUI.getOutputJTextArea().setText(String.format("Smallest difference found: %.1f\n\n", minDiff));     
        
        if (nCom > 1) 
            DivGUI.getOutputJTextArea().append(String.format( "In this case " + nCom + " combinations give the same result...\n"));
        else
            DivGUI.getOutputJTextArea().append(String.format("Corresponding to...\n"));        
        
        
	if (diff[0] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "A (" + a + ") vs. B+C+D+E (" + b + " + " + c + " + " + d + " + " + e + " = " + (b+c+d+e) + ")\n")); 
	        
	if (diff[1] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "B (" + b + ") vs. A+C+D+E (" + a + " + " + c + " + " + d + " + " + e + " = " + (a+c+d+e) + ")\n"));

	if (diff[2] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "C (" + c + ") vs. A+B+D+E (" + a + " + " + b + " + " + d + " + " + e + " = " + (a+b+d+e) + ")\n")); 
        
	if (diff[3] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "D (" + a + ") vs. A+B+C+E (" + a + " + " + b + " + " + c + " + " + e + " = " + (a+b+c+e) + ")\n")); 
        
	if (diff[4] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "E (" + e + ") vs. A+B+C+D (" + a + " + " + b + " + " + c + " + " + d + " = " + (a+b+c+d) + ")\n")); 
        
	if (diff[5] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "A+B (" + a + " + " + b + " = " + (a+b) + ") vs. C+D+E (" + c + " + " + d + " + " + e + " = " + (c+d+e) + ")\n")); 

	if (diff[6] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "A+C (" + a + " + " + c + " = " + (a+c) + ") vs. B+D+E (" + b + " + " + d + " + " + e + " = " + (b+d+e) + ")\n")); 
        
	if (diff[7] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "A+D (" + a + " + " + d + " = " + (a+d) + ") vs. B+C+E (" + b + " + " + c + " + " + e + " = " + (b+c+e) + ")\n")); 
        
	if (diff[8] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "A+E (" + a + " + " + e + " = " + (a+e) + ") vs. B+C+D (" + b + " + " + c + " + " + d + " = " + (b+c+d) + ")\n")); 

	if (diff[9] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "B+C (" + b + " + " + c + " = " + (b+c) + ") vs. A+D+E (" + a + " + " + d + " + " + e + " = " + (a+d+e) + ")\n")); 
        
	if (diff[10] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "B+D (" + b + " + " + d + " = " + (b+d) + ") vs. A+C+E (" + a + " + " + c + " + " + e + " = " + (a+c+e) + ")\n")); 
 
	if (diff[11] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "B+E (" + b + " + " + e + " = " + (b+e) + ") vs. A+C+D (" + a + " + " + c + " + " + d + " = " + (a+c+d) + ")\n")); 
        
	if (diff[12] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "C+D (" + c + " + " + d + " = " + (c+d) + ") vs. A+B+E (" + a + " + " + b + " + " + e + " = " + (a+b+e) + ")\n")); 

	if (diff[13] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "C+E (" + c + " + " + e + " = " + (c+e) + ") vs. A+B+D (" + a + " + " + b + " + " + d + " = " + (a+b+d) + ")\n")); 
          
	if (diff[14] == minDiff) 
            DivGUI.getOutputJTextArea().append(String.format( 
                "D+E (" + d + " + " + e + " = " + (d+e) + ") vs. A+B+C (" + a + " + " + b + " + " + c + " = " + (a+b+c) + ")\n")); 
                
    }
}
