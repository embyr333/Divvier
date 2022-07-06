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
- Changed variable names, output wording and comments that inappropriately used 
the word/word-part 'set'/'Set' as/in a noun even when there may be replicates, 
to 'collection'/'Collection' or 'coll/Coll'

Naming this version with YYMMDD_HHMM timestamp 220706_2316
*/

package embyr333.divvier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DivFor6to11
{
    public static void process(ArrayList<Double> arrColl)    
    {
        // Calculate the sum of arrColl elements...
        double sum = 0;
        for(double elm : arrColl)
            sum += elm;        
                
        ArrayList<Double> arrSubColl = new ArrayList<Double>(); // // ArrayList to hold subcollection that gives min diff
    
        ArrayList<Double> arrSubCollR = new ArrayList<Double>(); // ArrayList to hold reciprocal collection to arrSubColl        
                
        
        // Find the two groupings with the smallest difference between them, 
        //     arrSubColl and its reciprocal subcollection, arrSubCollR...
        
        double minDiff, newDiff; // Variables to hold values of smallest and newest difference value
        
        // Initialise minDiff before loop so can begin with newDiff with a value that
        //     will be bigger than any subsequently-calculated actual diff 
        minDiff = sum; 
        
        // note re expressions below calculating differences:
        // arrColl.get(0) * 2 - sum   ...is equivalent to...  arrColl.get(0) - (sum - arrColl.get(0))  ...etc        
                
        // Loop to repeat a randomised finding process based on shuffling arrColl
        // and comparing sum of first elements to that of the rest 
        // I do not know the number of repeats needed for reasonable probability of 
        // sampling all possibilities...may change it, base on expected collection size
        // or code to allow user to input desired number repetitions based on  
        // requirements and available computing resources
        for(int repeat = 0; repeat < 1000; repeat++)
        {    
            // Shuffle arrColl
            shuffleALm(arrColl);        

            newDiff = Math.abs(arrColl.get(0) * 2 - sum ); // First element shuffled array vs the sum of the rest 
            if(newDiff  <  minDiff)
            {
                arrSubColl.clear();
                arrSubColl.add(arrColl.get(0));
                minDiff = newDiff;
            }            

            newDiff = Math.abs(2* (arrColl.get(0) + arrColl.get(1)) - sum ); // First 2 vs sum of rest
            if(newDiff  <  minDiff)
            {
                arrSubColl.clear();
                arrSubColl.add(arrColl.get(0));
                arrSubColl.add(arrColl.get(1));
                minDiff = newDiff;
            }
      
            if(arrColl.size() > 5)
            {    
                newDiff = Math.abs(2* (arrColl.get(0) + arrColl.get(1) + arrColl.get(2)) - sum ); // First 3 vs sum of rest
                if(newDiff  <  minDiff)
                {
                    arrSubColl.clear();
                    arrSubColl.add(arrColl.get(0));
                    arrSubColl.add(arrColl.get(1));
                    arrSubColl.add(arrColl.get(2));
                    minDiff = newDiff;
                }
            }
            
            if(arrColl.size() > 7)
            {    
                newDiff = Math.abs(2* (arrColl.get(0) + arrColl.get(1) + arrColl.get(2) + arrColl.get(3)) - sum ); // First 4 vs sum of rest
                if(newDiff  <  minDiff)
                {
                    arrSubColl.clear();
                    arrSubColl.add(arrColl.get(0));
                    arrSubColl.add(arrColl.get(1));
                    arrSubColl.add(arrColl.get(2));
                    arrSubColl.add(arrColl.get(3));
                    minDiff = newDiff;
                }
            }

            if(arrColl.size() > 9)
            {    
                newDiff = Math.abs(2* (arrColl.get(0) + arrColl.get(1) + arrColl.get(2) + arrColl.get(3) + arrColl.get(4)) - sum ); // First 4 vs sum of rest
                if(newDiff  <  minDiff)
                {
                    arrSubColl.clear();
                    arrSubColl.add(arrColl.get(0));
                    arrSubColl.add(arrColl.get(1));
                    arrSubColl.add(arrColl.get(2));
                    arrSubColl.add(arrColl.get(3));
                    arrSubColl.add(arrColl.get(4));
                    minDiff = newDiff;
                }
            }
        }
        
                
        Collections.sort(arrSubColl); // Arrange in ascending order before sending to GUI, for clearer user interpretation
        
        double arrSubColl_total = 0;
        for(double elm : arrSubColl)
            arrSubColl_total += elm; 
        
        
        // Determine the reciprocal subcollection, arrSubColl:
        // first make a deep copy of arrColl (prefer to preserve arrColl in case want to access later)
        for(int i = 0; i < arrColl.size(); i++)
            arrSubCollR.add(arrColl.get(i));        
        // then remove arrSubColl elements
        for(int i = 0; i < arrSubColl.size(); i++)
            arrSubCollR.remove(arrSubColl.get(i));        
        
        Collections.sort(arrSubCollR); // Arrange in ascending order before sending to GUI, for clearer user interpretation

    
        // Variable to represen whether to print 1st subcollection (arrSubColl) first (choice = 1)
        //     or 2nd subcollection (arrSubCollR) (choice = 2)
        int choice = 1; // (let default be 1)
        
        // Determine the size of the smaller subcollection
        int s = (arrSubColl.size() < arrSubCollR.size() ? arrSubColl.size() : arrSubCollR.size());
        
        for (int i = 0; i < s; i++)
        {
            if(arrSubColl.get(i) < arrSubCollR.get(i)) 
                break;
            else 
                if(arrSubColl.get(i) > arrSubCollR.get(i))
            {
                choice = 2;
                break;
            }                
        }
            
        
        DivGUI.getOutputJTextArea().setText(String.format("Smallest difference found:  %.1f\n\n", minDiff));
        

        DivGUI.getOutputJTextArea().append(String.format("between subcollection           %s\n", 
                choice == 1 ? arrSubColl : arrSubCollR));   
        
        DivGUI.getOutputJTextArea().append(String.format("(totalling  %.1f)\n", 
                choice == 1 ? arrSubColl_total : sum - arrSubColl_total));   
        
        
        DivGUI.getOutputJTextArea().append(String.format("\nand reciprcal subcollection   %s \n", 
                choice == 1 ? arrSubCollR : arrSubColl));   
               
        DivGUI.getOutputJTextArea().append(String.format("(totalling  %.1f)\n\n\n", 
                choice == 1 ? sum - arrSubColl_total : arrSubColl_total));   
        
        
        DivGUI.getOutputJTextArea().append(String.format("There may be other combinations that give the same split\n"
                + "- program in its current form only stores first example it encounters\n"));
        
        DivGUI.getOutputJTextArea().append(String.format("Alogrithms for input collections of >5 numbers use random sampling,\n"
                + "but method for 6-11 numbers, as here, is quite reliable:\n"
                + "test running a collection of 10 numbers 100 times gave same minimum difference each time.\n"));
        
    } // End method process
    
    
    // Method based on my ShuffleAL_2 class; see code comments therin (and in precursor ShuffleAL)
    // Could/should probably try replacing with a shuffle method from the API - just used ny own as I did not know of alternatives at the tme
    public static ArrayList<Double> shuffleALm( ArrayList<Double> arrL )  
    {
        Random rnd = new Random(); 
                
        int indexA = 0;
        
        for(int repeat = 0; repeat < (arrL.size() + rnd.nextInt(2)); repeat++) // see Swop2 for comments re loop body code
        {
            double temp = arrL.get(indexA); 
            arrL.remove(indexA);  
            int indexB = rnd.nextInt(arrL.size());  
            arrL.add(indexA, arrL.get(indexB));
            arrL.remove(indexB < indexA ? indexB : indexB + 1); 
            arrL.add((indexB < indexA ? indexB : indexB + 1), temp); 
            if(indexA < arrL.size() - 1)
                ++indexA;
        }        
        
        return arrL;
        
    } // End method ShuffleALm
    
}

/*
Would be nice to have an estimate of the number of time the outer loop needs to 
run for a given level of confidence that all combinations have been sampled.

If more than one sample subcollection gives the same minimum difference value, only
one is given in the final report per run of the program. (Might be possible to 
'remember' and report all equivalent values/collections at the end as in Divvier_of_4 
and Divvier_of_5 (which have all hard-coded combinations)?)
*/