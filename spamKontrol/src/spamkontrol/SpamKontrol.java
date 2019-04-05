/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spamkontrol;

/**
 *
 * @author impROS
 */
public class SpamKontrol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String strWords = "TOPIC\n" +
"    Windows PowerShell Help System\n" +
"\n" +
"SHORT DESCRIPTION\n" +
"    Displays help about Windows PowerShell cmdlets and concepts. \n" +
"\n" +
"LONG DESCRIPTION\n" +
"    Windows PowerShell Help describes Windows PowerShell cmdlets,\n" +
"    functions, scripts, and modules, and explains concepts, including\n" +
"    the elements of the Windows PowerShell language.\n" +
"\n" +
"    Windows PowerShell does not include help files, but you can read the\n" +
"    help topics online, or use the Update-Help cmdlet to download help files\n" +
"    to your computer and then use the Get-Help cmdlet to display the help\n" +
"    topics at the command line.\n" +
"\n" +
"    You can also use the Update-Help cmdlet to download updated help files\n" +
"    as they are released so that your local help content is never obsolete. \n" +
"\n" +
"    Without help files, Get-Help displays auto-generated help for cmdlets, \n" +
"    functions, and scripts.\n" +
"\n" +
"\n" +
"  ONLINE HELP    \n" +
"    You can find help for Windows PowerShell online in the TechNet Library\n" +
"    beginning at http://go.microsoft.com/fwlink/?LinkID=108518. \n" +
"\n" +
"    To open online help for any cmdlet or function, type:\n" +
"\n" +
"        Get-Help <cmdlet-name> -Online    \n" +
"\n" +
"  UPDATE-HELP\n" +
"    To download and install help files on your computer:\n" +
"\n" +
"       1. Start Windows PowerShell with the \"Run as administrator\" option.\n" +
"       2. Type:\n" +
"\n" +
"          Update-Help\n" +
"\n" +
"    After the help files are installed, you can use the Get-Help cmdlet to\n" +
"    display the help topics. You can also use the Update-Help cmdlet to\n" +
"    download updated help files so that your local help files are always\n" +
"    up-to-date.\n" +
"    \n" +
"    For more information about the Update-Help cmdlet, type:\n" +
"\n" +
"       Get-Help Update-Help -Online\n" +
"\n" +
"    or go to: http://go.microsoft.com/fwlink/?LinkID=210614\n" +
"\n" +
"\n" +
"  GET-HELP\n" +
"    The Get-Help cmdlet displays help at the command line from content in\n" +
"    help files on your computer. Without help files, Get-Help displays basic\n" +
"    help about cmdlets and functions. You can also use Get-Help to display\n" +
"    online help for cmdlets and functions.\n" +
"\n" +
"    To get help for a cmdlet, type:\n" +
"\n" +
"        Get-Help <cmdlet-name>\n" +
"    \n" +
"    To get online help, type:\n" +
"   \n" +
"        Get-Help <cmdlet-name> -Online    \n" +
"\n" +
"    The titles of conceptual topics begin with \"About_\".\n" +
"    To get help for a concept or language element, type:\n" +
"\n" +
"        Get-Help About_<topic-name>\n" +
"\n" +
"    To search for a word or phrase in all help files, type:\n" +
"\n" +
"        Get-Help <search-term>\n" +
"\n" +
"    For more information about the Get-Help cmdlet, type:\n" +
"\n" +
"        Get-Help Get-Help -Online\n" +
"\n" +
"    or go to: http://go.microsoft.com/fwlink/?LinkID=113316\n" +
"\n" +
"\n" +
"  EXAMPLES:\n" +
"      Save-Help cheap click free             : Download help files from the Internet and saves\n" +
"                               them on a file share.\n" +
"      Update-Help            : Downloads and installs help files from the\n" +
"                               Internet or a file share.\n" +
"      Get-Help Get-Process   : Displays help about the Get-Process cmdlet.   \n" +
"      Get-Help Get-Process -Online\n" +
"                             : Opens online help for the Get-Process cmdlet.                            \n" +
"      Help Get-Process       : Displays help about Get-Process one page at a time.\n" +
"      Get-Process -?         : Displays help about the Get-Process cmdlet.      \n" +
"      Get-Help About_Modules : Displays help about Windows PowerShell modules.\n" +
"      Get-Help remoting      : Searches the help topics for the word \"remoting.\"\n" +
"\n" +
"  SEE ALSO:\n" +
"      about_Updatable_Help\n" +
"      Get-Help\n" +
"      Save-Help\n" +
"      Update-Help\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"";
        double spamOran = 5;
        if (strWords.contains("cheap")) {
            spamOran += 35;
        }
        if (strWords.contains("free")) {
            spamOran += 25;
        }
        if (strWords.contains("click")) {
            spamOran += 35;

        }

        System.out.println("Spam olma orani : %" + spamOran);

    }



}
