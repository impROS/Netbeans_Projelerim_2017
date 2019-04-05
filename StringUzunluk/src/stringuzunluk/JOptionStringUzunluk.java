
/*
"aydgnn.merve@gmail.com" <aydgnn.merve@gmail.com>,
"smsk_smsk@hotmail.com" <smsk_smsk@hotmail.com>,
"ozaytunctan@gmail.com" <ozaytunctan@gmail.com>,
"eren.celik.1995@gmail.com" <eren.celik.1995@gmail.com>,
"ozturk.bugra@student.atilim.edu.tr" <ozturk.bugra@student.atilim.edu.tr>,
"duygukaraman00@gmail.com" <duygukaraman00@gmail.com>,
"merveozbayy@gmail.com" <merveozbayy@gmail.com>,
"fatmaakkus95@gmail.com" <fatmaakkus95@gmail.com>,
"ozan.avcular.oa@gmail.com" <ozan.avcular.oa@gmail.com>,
"eylmz058@gmail.com" <eylmz058@gmail.com>,
"orcunn1994@gmail.com" <orcunn1994@gmail.com>,
"akturk041@gmail.com" <akturk041@gmail.com>,
"aysecicekk95@gmail.com" <aysecicekk95@gmail.com>,
"mervecekinnnnn@hotmail.com" <mervecekinnnnn@hotmail.com>,
"melihyayla@gmail.com" <melihyayla@gmail.com>,
"omercelik.ceng@gmail.com" <omercelik.ceng@gmail.com>,
"naciye.saribey@ogr.dpu.edu.tr" <naciye.saribey@ogr.dpu.edu.tr>,
"fatihmayuk1@gmail.com" <fatihmayuk1@gmail.com>,
"burcuidikut@gmail.com" <burcuidikut@gmail.com>,
"atalay.con@metu.edu.tr" <atalay.con@metu.edu.tr>,
"dorukaksoy.metu@gmail.com" <dorukaksoy.metu@gmail.com>,
"orhan36@gmail.com" <orhan36@gmail.com>,
"x.impros.x@gmail.com" <x.impros.x@gmail.com>,
"fatihazar56@hotmail.com" <fatihazar56@hotmail.com>,
"tradem34@hotmail.com" <tradem34@hotmail.com>,
"ozbayfurkan@outlook.com" <ozbayfurkan@outlook.com>,
"byzozhan@gmail.com" <byzozhan@gmail.com>,
"esen675@outlook.com" <esen675@outlook.com>,
"ugur.tunc@bil.omu.edu.tr" <ugur.tunc@bil.omu.edu.tr>,
"elif.uysal@ogrenci.karatay.edu.tr" <elif.uysal@ogrenci.karatay.edu.tr>
 */
package stringuzunluk;

import javax.swing.JOptionPane;

public class JOptionStringUzunluk {

    public static void main(String[] args) {

        String strWord = JOptionPane.showInputDialog("String girin", "impROS");
        int lengthStr = strWord.length();

        
        JOptionPane.showMessageDialog(null, strWord + " Uzunlugu : " + lengthStr, "Kelime Uzunlugu ", JOptionPane.INFORMATION_MESSAGE);
    }

}
