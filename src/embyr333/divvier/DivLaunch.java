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

Naming this version with YYMMDD_HHMM timestamp 220706_2316
*/

package embyr333.divvier;

class DivLaunch
{
    public static void main(String[] args) 
    {        
        DivGUI window = new DivGUI();
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE); 
        window.setTitle("Divvier");
        window.setSize(600, 960);
        window.setLocationRelativeTo(null);
        window.setVisible(true);        
    }
} // End class DivLaunch

/*
"To Do" for the program (written in 2015):
-- (Consider any new ideas for improved algorithm to replace Divvier_to_11_IG and Divvier_unlimited_IG)
-- (Maybe at some point make a "web" version (e.g. with JSF)? However until I have a web host 
   that can run it, such a project would be for little more than JSF-coding experience). And/or Android? 
-- (Could add an option to ignore negitive values, if I could envisage or was made aware of
   a scenario in which that would be useful or)
*/
