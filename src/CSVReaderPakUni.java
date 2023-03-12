import Stack.StacK;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// stack class
 class ArrayStack implements StacK {
    public Object[] a;
    public int size;
    public ArrayStack(int cap) {
        a = new Object[cap];
    }

    // imEmpty Method
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Object peek() {
        if (size == 0) throw new IllegalStateException("Stack empty");

        return a[size - 1]; // because it is arrayed peek mean value take out
    }

    public Object pop() { // delete the element
        if (size == 0) throw new IllegalStateException("Stack empty");
        {
        }
        Object obj = a[--size];
        a[size] = null;
        return obj;
    }
    public void push(Object obj) {
        if (size == a.length)
            resize();
        a[size++] = obj;
    }

    private void resize() {
        Object[] aa = a;
        a = new Object[2 * aa.length];
        System.arraycopy(aa, 0, a, 0, size);
    }

    public int size() {
        return size;
    }

    // top Five Universities
    public void topFive(ArrayStack pub, ArrayStack rank, HashMap map) {
        HashMap<String, paku> mapTable = new HashMap<>();
        mapTable = map;

        int count = 1;
        System.out.println(" Top Five University Based On Publication and Pakistan Ranking ");
        for (int i = size - 1; i >= 0; i--) {
            if (count == 6) {
                break;
            }
            System.out.println(count + ":  publication :" + mapTable.get(pub.a[i]) + "\n Pakistan" + "" + "Ranking:" + mapTable.get(rank.a[i]));
            System.out.println(" ");
            count++;
        }
    }

    // top Twenty Five Universities method
    public void topTwentyFive(ArrayStack pub, ArrayStack rank, HashMap map) {
        HashMap<String, paku> mapTable = new HashMap<>();
        mapTable = map;

        int count = 1;
        System.out.println(" Top Twenty Five University Based On Publication and Pakistan Ranking ");
        for (int i = size - 1; i >= 0; i--) {
            if (count == 26) {
                break;
            }

            System.out.println(count + ":  publication :" + mapTable.get(pub.a[i]) + "\n Pakistan" + "" + "Ranking:" + mapTable.get(rank.a[i]));
            System.out.println(" ");
            count++;
        }
    }
    //  from bottom five
    public void bottomFive(ArrayStack pub, ArrayStack rank, HashMap map) {
        HashMap<String, paku> mapTable = new HashMap<>();
        mapTable = map;
        int count = 100;
        for (int i = 0; i < 5; i++) {
            System.out.println(count + ":  publication :" + mapTable.get(pub.a[i]) + "\n Pakistan" + "" + "Ranking:" + mapTable.get(rank.a[i]));
            System.out.println(" ");
            count--;
        }
    }

    public void percentile(int percen, HashMap map) {
        int pos = (percen * size()-1) / 100;
        System.out.println(map.get(a[pos]));
    }

    public void topPerformance(ArrayStack pub, ArrayStack rank, HashMap map) {

        System.out.println("Top Performance University Details according to the Publications And Pakistan Rank");
        System.out.println("\nPublication: " + map.get(pub.a[size - 1]));
        System.out.println("\nPak Rank:" + map.get(rank.a[size - 1]));
    }

    // worst Performance
    public void worstPerformance(ArrayStack pub, ArrayStack rank, HashMap map) {
        System.out.println("Worst Performance University Details according to the Publications And Pakistan Rank");
        System.out.println("\nPublication: " + map.get(pub.a[0]));
        System.out.println("\nPak Rank:" + map.get(rank.a[0]));
    }
} // stack class end
public class CSVReaderPakUni {
    public static void main(String[] args) {
// four keywords of universities
        String[] array={"ABAU" ,"AWKU" , "AGAK" , "AIRU" , "BAKU" , "BAHZ" , "BAHU" , "BUIT", "BAQU", "BHNU" ,
                "CECO", "CIIT" , "DWET" , "DUHS", "FJMU" , "FJWU" , "FEDU" , "FORC" , "FOUN" , "GIKI" , "GMAL" , "GMUS" ,
                "GCUF" , "GCUL" , "GCWF","HAMD", "HAZR", "HITC" , "INDS" , "INTU" , "INBA" , "IOST" ,
                "IIUI" , "IQRA" , "ICPS" , "IUOB" , "ISRA" , "JSMu" , "JUFW" , "KIET" , "KRIU" , "KHYB" , "KEMU" , "KCFW" ,
                "KUST" , "LCWT" , "LSOE" , "LOMS" , "LUMS" , "MUET" , "MUST" , "MAJU" , "NBAE" , "NDEU" , "NTEX" , "NCES" ,
                "NUML" , "NSAT" , "NEDU" , "PIDE" , "PIAS" , "PMAS" , "PRES" , "QUES" , "QIAU" , "PAMU" , "PIIU" , "SSIT" ,
                "SALU" , "SBBW" , "SZAB" , "SAGU" , "SMIU" , "SSET" , "SIBA" , "UAGF" , "UAGP" , "UAJK" , "UOBL" , "UOCP" ,
                "UOEP" , "UETL" , "UETP" , "UETT" , "UGUJ" , "HARI" , "UHSL" , "KARA" , "LAHR" , "MALK" , "UMTL" , "UPSH" ,
                "USAR" , "USTB" , "USID" , "USWT" , "UOTP" , "UVAS" , "UOWH" , "ZIAD"};

        ArrayStack pub = new ArrayStack(30); // for the pulication
        ArrayStack rank = new ArrayStack(99); // for the pakRank
        String path="C:\\Users\\Fattani Computers\\Desktop\\universities.csv";
        List<paku> uni=readcsv(path);

        int i=0;
        HashMap<String,paku> map = new HashMap<>();

        for (paku b : uni){
            map.put(array[i],b);
            i=i+1;}

        // for copy the publication value
        int[] pubvalue= new int[array.length];
        for (int j=0; j< pubvalue.length; j++) {
            pubvalue[j] = Integer.parseInt(map.get(array[j]).pub);
       }

       // sort the publication value by insertion sort
        for (int j=0; j< pubvalue.length-1; j++){
            int minimum=j;
            for (int k=j+1; k< pubvalue.length; k++){
                if (pubvalue[minimum]>pubvalue[k]){
                    minimum=k;
                }
            }
            int temp=pubvalue[minimum];
            pubvalue[minimum]=pubvalue[j];
            pubvalue[j]=temp;
        }
int[] copy=new int[pubvalue.length];
int count=0;
        for (int z=0; z<= pubvalue.length; z++ ){
            if (count== 100){break;}
            if (z== 100) {z = 0;}
            if (map.get(array[z]).pub.equals(String.valueOf(pubvalue[count]))){
                pub.push(array[z]);
                copy[z]= Integer.parseInt(map.get(array[z]).pub); // I copy  the publication  from the map because in compare I delete one by one valur from map
                map.get(array[z]).pub="null";
                count++;
                z=0;
            }
        }
        for (int m=0; m<copy.length; m++){
            map.get(array[m]).pub= String.valueOf(copy[m]);
        }

        // start the pakRank Algorithm from here
        // for copy the pakistani rank value

        int[] pakRank = new int[array.length];
        for (int j=0; j< pakRank.length; j++) {
            pakRank[j]= Integer.parseInt(map.get(array[j]).pakRank.substring(0,map.get(array[j]).pakRank.indexOf(" ")));

        }

        // then sort the value by insertion sorting
        for (int j=0; j< pakRank.length-1; j++){
            int minimum=j;
            for (int k=j+1; k< pakRank.length; k++){
                if (pakRank[minimum]>pakRank[k]){
                    minimum=k;
                }
            }
            int temp=pakRank[minimum];
            pakRank[minimum]=pakRank[j];
            pakRank[j]=temp;
        }//

        int num=0;
        for (int z=0; z<=pakRank.length; z++ ){
            if (num== 100){break;}
            if (z== 100) {z = 0;}

            if (map.get(array[z]).pakRank.substring(0,map.get(array[z]).pakRank.indexOf(" ")).equals(String.valueOf(pakRank[num]))){
                rank.push(array[z]);
                num++;
                z=0;
            }
        }
        Scanner textIO=new Scanner(System.in);

        while (true) {

            System.out.println("\nMenu:");

            System.out.println("\t\t 1.  For see the Full Information Of University Add a Key value of Universities:");

            System.out.println("\n\t\t 2.  FOr See Top Five Universities based on number of publications and ranking:");

            System.out.println("\n\t\t 3. For see The Top Twenty Five Universities based on number of publications and ranking:");

            System.out.println("\n\t\t 4. For See The Bottom Five Universities based on number of publications and ranking: ");

            System.out.println("\n\t\t 5. For See The 50th percentile universities based on number of publications and ranking .");

            System.out.println("\n\t\t6.  : Best performance of universities on the provincial level :");

            System.out.println("\n\t\t 7. : Worst performance of universities on the provincial level:");

            System.out.println("\n\t\t8.  For Exit:");

            System.out.print("\n\t\tEnter your command: ");

            switch (textIO.nextInt()) {

                case 1:
                    System.out.println("\n\t\t\t\tABAU" + ",AWKU" + ",AGAK" + ",AIRU" + ",BAKU" + ",BAHZ" + ",BAHU" + ",BUIT" + ",BAQU" + ",BHNU" +
                            "\n\t\t\t\tCECO" + ",CIIT" + ",DWET" + ",DUHS" + ",FJMU" + ",FJWU" + ",FEDU" + ",FORC" + ",FOUN" + ",GIKI" + ",GMAL" + ",GMUS" +
                            "\n\t\t\t\tGCUF" + ",GCUL" + ",GCWF" + ",HAMD" + ",HAZR" + ",HITC" + ",INDS" + ",INTU" + ",INBA" + ",IOST" +
                            "\n\t\t\t\tKUST" + ",LCWT" + ",LSOE" + ",LOMS" + ",LUMS" + ",MUET" + ",MUST" + ",MAJU" + ",NBAE" +
                            "\n\t\t\t\tIIUI" + ",IQRA" + ",ICPS" + ",IUOB" + ",ISRA" + ",JSMu" + ",JUFW" + ",KIET" + ",KRIU" + ",KHYB" + ",KEMU" + ",KCFW" + ",NDEU" + ",NTEX" + ",NCES" +
                            "\n\t\t\t\tNUML" + ",NSAT" + ",NEDU" + ",PIDE" + ",PIAS" + ",PMAS" + ",PRES" + ",QUES" + ",QIAU" + ",PAMU" + ",PIIU" + ",SSIT" +
                            "\n\t\t\t\tSALU" + ",SBBW" + ",SZAB" + ",SAGU" + ",SMIU" + ",SSET" + ",SIBA" + ",UAGF" + ",UAGP" + ",UAJK" + ",UOBL" + ",UOCP" +
                            "\n\t\t\t\tUOEP" + ",UETL" + ",UETP" + ",UETT" + ",UGUJ" + ",HARI" + ",UHSL" + ",KARA" + ",LAHR" + ",MALK" + ",UMTL" + ",UPSH" +
                            "\n\t\t\t\tUSAR" + ",USTB" + ",USID" + ",USWT" + ",UOTP" + ",UVAS" + ",UOWH" + ",ZIAD");

                    System.out.println("Enter a Key:");
                    String key = textIO.next();
                    System.out.println(map.get(key));
                    break;

                case 2:
                    rank.topFive(pub, rank, map);
                    break;

                case 3:
                    rank.topTwentyFive(pub, rank, map);
                    break;

                case 4:
                    rank.bottomFive(pub, rank, map);
                    break;

                case 5:
                    rank.percentile(50, map);
                    break;
                case 6:
                    rank.topPerformance(pub, rank, map);
                    break;
                case 7:
                    pub.worstPerformance(pub, rank, map);
                    break;
                case 8:

                    return; // End program by returning from main()

                default:

                    System.out.println(" Illegal command.");

                    break;

            }
        }
        } // main method

    // method jis men data from csv file se objects men save hoti ja rahi hai
    private static  paku createUni(String[] data){

        String name=data[0];
        String wRank=data[1];
        String asiaRank= data[2];
        String pakRank=data[3];
        String loc=data[4];
        String pub=data[5];

        return new paku(name,wRank,asiaRank,pakRank,loc,pub);
    }

   static List<paku>  readcsv(String path){
        List<paku> unis=new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line= br.readLine();
            while (line!=null){
                String[] attributes=line.split(",");

                paku uni=createUni(attributes);
                unis.add(uni);

                line= br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return unis;
    }
}
// pakistan university class
class paku{
    String name,wRank,asiaRank,pakRank,loc,pub;
    paku(String name, String wRank, String asiaRank, String pakRank, String loc, String pub){
        this.name=name;
        this.wRank=wRank;
        this.asiaRank=asiaRank;
        this.pakRank=pakRank;
        this.loc=loc;
        this.pub=pub;
    }
    public String toString(){
        return "Name:"+name+", "+"World Rank:"+wRank+", "+"Asia Rank:"+asiaRank+", "+"Pakistan Rank:"+pakRank+", " +"Location:"+loc+", "+"Publication:"+pub;
    }
} // end here
