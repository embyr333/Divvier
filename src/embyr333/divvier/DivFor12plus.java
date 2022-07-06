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
- Changed output wording and comments that inappropriately used the
word/word-part 'set'/'Set' as/in a noun even when there may be replicates, 
to 'collection'/'Collection' or 'coll/Coll'

Naming this version with YYMMDD_HHMM timestamp 220706_2316
*/

package embyr333.divvier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class DivFor12plus
{
    static ArrayList<Double> aSampleBest = new ArrayList<Double>(); // ArrayList to hold sample that gives min diff
    static ArrayList<Double> aSampleBestR = new ArrayList<Double>(); // ArrayList to hold reciprocal collection to aSampleBest    
    static double sumAll; // Sum of aAll (input) elements
    static double minDiff; // Current minimum founfd difference between subcollections
    static double aSampleBest_total;
    static double aSampleBestR_total;

    public static void process(ArrayList<Double> aAll)     
    {
        // As these are now field variables, need to clear between runs of program
        //    (minDiff and aSampleBestR_total are initialised below)
        aSampleBest.clear();
        aSampleBestR.clear();        
        sumAll = 0;
        aSampleBest_total = 0;
        
        Random rnd = new Random();  
        
        // Calculate sum of aAll elements
        for(double elm : aAll)
            sumAll += elm;
        
        ArrayList<Double> aSample = new ArrayList<Double>(); // ArrayList to hold sample of aAll elements
        ArrayList<Double> aRest = new ArrayList<Double>(); // ArrayList to hold the rest of the elements

        // Variable to hold smallest 'difference' value
        // need to initialise before loop so can begin with newDiff (see below), so chose sumAll...
        minDiff = sumAll; // ...which will be bigger than any subsequently-calculated diff 
        double newDiff; // Variable to hold new difference value
        
        // Make copy of aAll called aRest
        for(int i = 0; i < aAll.size(); i++)
            aRest.add(aAll.get(i));
        
        for(int numberSamples = 0; numberSamples < DivGUI.getLoops(); numberSamples++)
        {    
            // Get a random sample (random unique elements, random number of them)
            for(int sampleSize = 0; sampleSize < ( 1 + ( rnd.nextInt(aAll.size() - 1) ) ); sampleSize++)
            {    
                int rndIndex = rnd.nextInt(aRest.size()); // Get random index of aRest
                aSample.add(aRest.get(rndIndex)); // Add random element of aRest to aSample

                aRest.remove(aRest.get(rndIndex)); // Remove equivalent element from aRest
            }

            // Calculate sum of aSample elements, sumSample
            double sumSample = 0;
            for(double elm : aSample)
                sumSample += elm;
            
            // Calculate latest abs value difference betw sumSample & sum remaining elements - Note1 below         
            newDiff = Math.abs(sumSample * 2 - sumAll);

            if(newDiff < minDiff)
            {    
                minDiff = newDiff;

                // Make copy of this aSample called aSampleBest
                aSampleBest.clear(); // Remove the previous best (if any)  
                for(int i = 0; i < aSample.size(); i++)
                    aSampleBest.add(aSample.get(i));
            }    

            // Re-set aSample for the next sample-evaluation run
            aSample.clear();

            // Re-set aRest for the next sample-evaluation run
            aRest.clear();        
            for(int i = 0; i < aAll.size(); i++)
                aRest.add(aAll.get(i));
        }


        // Determine sum of aSampleBest elements 
        for(double elm : aSampleBest)
            aSampleBest_total += elm;
        
        
        // Determine contents of aSampleBestR
        //    first make a deep copy of aAll (prefer to preserve arrColl in case want to access later)
        for(int i = 0; i < aAll.size(); i++)
            aSampleBestR.add(aAll.get(i));   
        //    then remove the contents of aSampleBest
        for(int i = 0; i < aSampleBest.size(); i++)
            aSampleBestR.remove(aSampleBest.get(i)); 
        
        
        // Make variable for sum of aSampleBestR elements, for convenience in furher manupulations
        aSampleBestR_total = sumAll - aSampleBest_total;
        
 
        
        // Ff minDiff != 0, see if could improve by transferring small elements between subcollections
        //    this will be a possibility if there are elements smaller than minDiff
        if(minDiff != 0)
            if(aSampleBest_total > aSampleBestR_total)
            {                    
                fromSB();
                
                if(aSampleBest_total < aSampleBestR_total)
                    fromSBr(); // then call this in case transfer has made aSampleBest smallest
            }    
            else
            {                    
                fromSBr();
                
                if(aSampleBest_total > aSampleBestR_total)
                    fromSB(); // then call this in case transfer has made aSampleBestR smallest
            }                       
        
        
        Collections.sort(aSampleBest); // Arrange in ascending order before sending to GUI, for clearer user interpretation
               
        Collections.sort(aSampleBestR); // Arrange in ascending order before sending to GUI, for clearer user interpretation      
        
        
        // Variable to represent whether to print 1st subcollection (aSampleBest) first (choice = 1)
        //     or 2nd subcollection (aSampleBestR) (choice = 2)
        int choice = 1; // (let default be 1)
        
        // Determine the size of the smaller subcollection
        int s = (aSampleBest.size() < aSampleBestR.size() ? aSampleBest.size() : aSampleBestR.size());
        
        for (int i = 0; i < s; i++)
        {
            if(aSampleBest.get(i) < aSampleBestR.get(i)) 
                break;
            else 
                if(aSampleBest.get(i) > aSampleBestR.get(i))
            {
                choice = 2;
                break;
            }                
        }        
            
        
        DivGUI.getOutputJTextArea().setText(String.format("Smallest difference found: %.1f\n", minDiff));   
                 
        DivGUI.getOutputJTextArea().append(String.format("\nbetween subcollection             %s\n",                 
                choice == 1 ? aSampleBest : aSampleBestR));   
        
        DivGUI.getOutputJTextArea().append(String.format("(totalling %.1f)\n", 
                choice == 1 ? aSampleBest_total : aSampleBestR_total));   
                    
        DivGUI.getOutputJTextArea().append(String.format("\nand reciprocal subcollection   %s \n", 
                choice == 1 ? aSampleBestR : aSampleBest));   
        
        DivGUI.getOutputJTextArea().append(String.format("(totalling %.1f)\n\n\n", 
                choice == 1 ? aSampleBestR_total : aSampleBest_total));   
        
        DivGUI.getOutputJTextArea().append(String.format("There may be other combinations that give the same split\n"
                + "- program in its current form only stores first example it encounters\n"));           
        
        DivGUI.getOutputJTextArea().append(String.format("Alogrithms for input collections of >5 numbers use random sampling.\n"
                + "The method used for >11 numbers, as here, is ~~50%% reliable for a collection of 20 numbers\n"
                + "at default setting (no 'turbo'), but scored 100/100 at the 10x setting\n\n"));   
        
    } // End method process 
    
    
    public static void fromSB() 
    {
        for(int i = 0; i < aSampleBest.size(); i++)
            if(aSampleBest.get(i) < minDiff)
            {    
                aSampleBest_total -= aSampleBest.get(i); // update - this will be true when transferred
                aSampleBestR_total += aSampleBest.get(i); // update - this will be true when transferred
                aSampleBestR.add(aSampleBest.get(i));  
                aSampleBest.remove(i); // (do this after 3 statements above as they depend on element i)
                minDiff = Math.abs(sumAll - aSampleBest_total * 2); // update
                i--; // compensate for the fact that the next element is moved up       
                if(minDiff == 0 || aSampleBest_total < aSampleBestR_total)
                    break;
            }                
    } // End method fromSB
    
    
    public static void fromSBr() 
    {
        for(int i = 0; i < aSampleBestR.size(); i++)
            if(aSampleBestR.get(i) < minDiff)
            {    
                aSampleBest_total += aSampleBestR.get(i); // update - this will be true when transferred
                aSampleBestR_total -= aSampleBestR.get(i); // update - this will be true when transferred
                aSampleBest.add(aSampleBestR.get(i));  
                aSampleBestR.remove(i); // (do this after 3 statements above as they depend on element i)
                minDiff = Math.abs(sumAll - aSampleBest_total * 2); // update
                i--; // compensate for the fact that the next element is moved up
                if(minDiff == 0 || aSampleBestR_total < aSampleBest_total)
                    break;
            }                
    } // End method fromSB 
    
    
} // End class

/*
Note1:  Re calculating 'latest absolute value difference between sumSample
        and sum of remaining elements (sumRest)', i.e. newDiff:
        newDiff = Math.abs(sumSample - sumRest)
        but that would require loop calculation of sumRest (as for sumSample)
        more efficient to just caculate as:  sumAll - sumSample
        so: newDiff =   Math.abs(sumSample - (sumAll - sumSample)
                    =   Math.abs(sumSample * 2 - sumAll) 

Would be nice to have an estimate of the number of time the outer loop needs to 
run for a given level of confidence that all combinations have been sampled.

If more than one sample subcollection gives the same minimum difference value, only
one is given in the final report per run of the program. (Might be possible to 
'remember' and report all equivalent values/collections at the end as in Divvier_of_4 
and Divvier_of_5 (which have all hard-coded combinations)?)

*/